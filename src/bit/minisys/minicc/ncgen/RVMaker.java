package bit.minisys.minicc.ncgen;

import bit.minisys.minicc.ncgen.BasicBlockInfo.FunctionContent;
import bit.minisys.minicc.ncgen.BasicBlockInfo.WzcIRScanner;
import bit.minisys.minicc.ncgen.IRInstruction.IR_instruction;

import java.util.LinkedList;

public class RVMaker implements WzcTargetMaker
{
    LinkedList<FunctionContent> Functions;
    String Output = "";
    LinkedList<IR_instruction> header;
    LinkedList<String> FuncCode;

    public RVMaker(LinkedList<FunctionContent> Functions, LinkedList<IR_instruction> dec)
    {
        this.Functions = Functions;
        this.header = dec;
        this.FuncCode = new LinkedList<>();
        Run();
    }

    void Run()
    {
        for (FunctionContent content :
                Functions)
        {
            String RV_CODE = ContentHandler(content);

            if (content.name.equals("main"))
            {
                FuncCode.push(RV_CODE);
            }
            else
            {
                FuncCode.add(RV_CODE);
            }
        }
    }

    String ContentHandler(FunctionContent functionContent)//todo: FunctionContent的类型
    {
        WzcIRScanner func_info = new WzcIRScanner(functionContent.GetFunctionInstruction());
        func_info.ScanInfo();

        return "";
    }

    /*
     * 使用WzcIRScanner扫描一个函数内的信息，得到一些必要的寄存器表等
     *
     * */
    @Override
    public String GetCodeHeader(LinkedList<IR_instruction> declaration)
    {
        return null;
    }

    @Override
    public String GetTargetCode()
    {
        //这里把字符串输出搞定

        //在这里应该加上一个返回的GetCodeHeader
        return Output;
        //这里还要把库函数的函数体写上去
    }
}
