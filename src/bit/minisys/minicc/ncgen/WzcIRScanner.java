package bit.minisys.minicc.ncgen;

import bit.minisys.minicc.icgen.internal.IRBuilder;
import bit.minisys.minicc.ncgen.IRInstruction.IR_branch;
import bit.minisys.minicc.ncgen.IRInstruction.IR_instruction;
import bit.minisys.minicc.ncgen.IRInstruction.IR_tag;
import bit.minisys.minicc.pp.internal.H;

import java.util.HashMap;
import java.util.LinkedList;

public class WzcIRScanner
{
    LinkedList<BasicBlock> BasicBlocks;
    //tag到basicBlock的映射表
    HashMap<String, BasicBlock> tagToBasicBlock;

    public WzcIRScanner(LinkedList<IR_instruction> function_ins)
    {
        tagToBasicBlock = new HashMap<>();
        BasicBlocks = new LinkedList<>();
        BasicBlocks.add(new BasicBlock());
        tagToBasicBlock.put("0", BasicBlocks.getLast());
        BasicBlocks.getLast().tag = "0";

        for (IR_instruction instruct :
                function_ins)
        {
            if (instruct instanceof IR_tag)
            {
                BasicBlocks.add(new BasicBlock());
                BasicBlocks.getLast().tag = ((IR_tag) instruct).target_label;
                tagToBasicBlock.put(BasicBlocks.getLast().tag, BasicBlocks.getLast());
            }
            else if (instruct instanceof IR_branch)
            {
                //出边
                IR_branch branch = (IR_branch) instruct;
                if (branch.is_conditional)
                {
                    BasicBlocks.getLast().out_edge.add(branch.false_dest.substring(1));
                    BasicBlocks.getLast().out_edge.add(branch.true_dest.substring(1));
                }
                else
                {
                    BasicBlocks.getLast().out_edge.add(branch.dest.substring(1));
                }
                BasicBlocks.getLast().DAGS.add(instruct);
            }
            else
            {
                BasicBlocks.getLast().DAGS.add(instruct);
            }
        }

        for (BasicBlock basicBlock : BasicBlocks)
        {
            for (String tag : basicBlock.out_edge)
            {
                tagToBasicBlock.get(tag).in_edge.add(basicBlock.tag);
            }
            for (IR_instruction instruction : basicBlock.DAGS)
            {

            }
        }

    }

    public void LiveVarScan()
    {

    }
}
