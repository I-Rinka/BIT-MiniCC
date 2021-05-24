package bit.minisys.minicc.icgen;

import bit.minisys.minicc.internal.util.MiniCCUtil;
import bit.minisys.minicc.parser.WzcListenr;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Queue;

public class WzcLLVMIR extends WzcListenr
{
    private String OpenFile;
    public String target_data_layout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128";
    public String target_triple = "x86_64-pc-linux-gnu";

    private Queue<IRInstruction> InsBuffer; //存放一个函数中要输出的所有指令，函数节点退栈时输出。

    //如何表示符号表？使用栈？ 变量符号表：1.全局变量 2.函数变量   变量需要记录的：1.符号名 2.符号地址（虚拟寄存器）


    void WriteIRHeader()
    {
        String cFile = MiniCCUtil.removeAllExt(OpenFile) + ".c";
        String header = "source_filename = " + "\"" + cFile + "\"\n" +
                "target datalayout = \"" + target_data_layout + "\"\n" +
                "target triple = \"" + target_triple + "\"\n";

        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(OpenFile, false);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            fileOutputStream.write(header.getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            fileOutputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    WzcLLVMIR(String oFileName) throws IOException
    {
        OpenFile = oFileName;
        WriteIRHeader();

        WriteLine(new IRInstruction("%0", "shl", "i32", "%1", "%2"));
        WriteLine(new IRInstruction(null, "store", "i32", "%1", "i32* %3"));
    }

    private void WriteLine(Object obj)
    {
        this.WriteLine(obj.toString());
    }

    private void WriteLine(String OutputStr)
    {
        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(OpenFile, true);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            fileOutputStream.write(OutputStr.getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            fileOutputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}

class IRInstruction
{
    public String dest_var = null;

    public String instruction = null;
    public String instruction_type = null;

    public String src_var1 = null;
    public String src_var2 = null;

    IRInstruction(String dest, String instruction, String instruction_type, String src1, String src2)
    {
        this.dest_var = dest;
        this.instruction = instruction;
        this.instruction_type = instruction_type;
        this.src_var1 = src1;
        this.src_var2 = src2;
    }

    @Override
    public String toString()
    {
        String Out = "";
        if (dest_var != null)
        {
            Out = dest_var + " = ";
        }
        Out = Out + instruction + " " + instruction_type;
        if (src_var1 != null)
        {
            Out = Out + " " + src_var1;
        }
        if (src_var2 != null)
        {
            Out = Out + ", " + src_var2;
        }
        return Out + "\n";
    }
}