package bit.minisys.minicc.ncgen;

import bit.minisys.minicc.MiniCCCfg;
import bit.minisys.minicc.internal.util.MiniCCUtil;

public class ExampleCodeGen implements IMiniCCCodeGen
{

	public ExampleCodeGen()
	{

	}

	@Override
	public String run(String iFile, MiniCCCfg cfg) throws Exception
	{
		String oFile = MiniCCUtil.remove2Ext(iFile) + MiniCCCfg.MINICC_CODEGEN_OUTPUT_EXT;

		if (cfg.target.equals("mips"))
		{
			// TODO:
		} else if (cfg.target.equals("riscv"))
		{
			// TODO:
		} else if (cfg.target.equals("x86"))
		{
			// TODO:
		}

		System.out.println("7. Target code generation finished!");

		return oFile;
	}
}
