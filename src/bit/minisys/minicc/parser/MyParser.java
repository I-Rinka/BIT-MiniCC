package bit.minisys.minicc.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.WebSocket.Listener;
import java.nio.charset.StandardCharsets;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import bit.minisys.minicc.MiniCCCfg;
import bit.minisys.minicc.internal.util.MiniCCUtil;

import javax.swing.event.CaretListener;

public class MyParser implements IMiniCCParser {
    //类里面搞个全局变量一样的东西来方便GAJS访问语法树
    String code_source;
    private String GetAstJsonString(String file_path) throws IOException {
        
        FileInputStream fileInputStream = new FileInputStream(file_path);
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
        // Lexer lexer = new CLexer(input);
        // TokenStream tokens = new CommonTokenStream(lexer);
        // DemoParser parser = new DemoParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy()); // 设置错误处理
        ParseTree root = parser.compilationUnit(); 

        MyListener listener = new MyListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, root);
        String out = listener.ast_json;
        return out;
    }
    public String run(String iFile) throws Exception {
        System.out.println("Parsering...");
        String ast_json_file = MiniCCUtil.removeAllExt(iFile) + MiniCCCfg.MINICC_PARSER_OUTPUT_EXT;
        
        // 显示语法树的功能砍掉

        // 往ast_json里面写东西 就不用json了，直接字符串走起

        FileOutputStream fileOutputStream=new FileOutputStream(ast_json_file);
        fileOutputStream.write(this.GetAstJsonString(iFile).getBytes());
        fileOutputStream.close();

        // 把下一个ast.json的名字给return了
        return ast_json_file;
    }
}
