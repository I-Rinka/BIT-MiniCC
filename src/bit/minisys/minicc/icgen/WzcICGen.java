package bit.minisys.minicc.icgen;

import java.io.*;

import bit.minisys.minicc.parser.CLexer;
import bit.minisys.minicc.parser.CParser;

import bit.minisys.minicc.internal.util.MiniCCUtil;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


import java.io.File;
import java.nio.charset.StandardCharsets;

public class WzcICGen implements IMiniCCICGen
{

    @Override
    public String run(String iFile) throws Exception
    {
        //直接从源文件读取
        System.out.println("LLVM-IR Generating..");

        String oFile = MiniCCUtil.removeAllExt(iFile) + ".ll";

        FileInputStream fileInputStream = new FileInputStream(iFile);
        // size 为字串的长度 ，这里一次性读完
        int size = fileInputStream.available();
        byte[] buffer = new byte[size];
        fileInputStream.read(buffer);
        fileInputStream.close();
        String str = new String(buffer, StandardCharsets.UTF_8);

        CharStream input = CharStreams.fromStream(new ByteArrayInputStream(str.getBytes()));

        Lexer lexer = new CLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        CParser parser = new CParser(tokens);

        parser.setErrorHandler(new BailErrorStrategy()); // 设置错误处理
        ParseTree root = parser.compilationUnit();

        WzcLLVMIR listener = new WzcLLVMIR(oFile);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, root);

        System.out.println("LLVM-IR Generated!");

        System.out.println("LLVM-IR Output: " + oFile);
        return oFile;
    }

}
