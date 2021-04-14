package bit.minisys.minicc.parser;

import java.io.File;
import java.io.FileOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.python.antlr.PythonParser.return_stmt_return;

import bit.minisys.minicc.MiniCCCfg;
import bit.minisys.minicc.internal.util.MiniCCUtil;

public class MyParser implements IMiniCCParser {
    //类里面搞个全局变量一样的东西来方便GAJS访问

    private String GetAstJsonString() {
        return "hello";
    }
    public String run(String iFile) throws Exception {
        System.out.println("Parser");
        System.out.println(iFile);
        String ast_json_file = MiniCCUtil.removeAllExt(iFile) + MiniCCCfg.MINICC_PARSER_OUTPUT_EXT;

        // 显示语法树的功能砍掉

        // 往ast_json里面写东西 就不用json了，直接字符串走起

        FileOutputStream fileOutputStream=new FileOutputStream(ast_json_file);
        fileOutputStream.write(this.GetAstJsonString().getBytes());
        fileOutputStream.close();

        // 把下一个ast.json的名字给return了
        return ast_json_file;
    }
}
