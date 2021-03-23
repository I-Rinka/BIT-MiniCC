package bit.minisys.minicc.scanner;

import java.util.ArrayList;
import java.util.HashSet;

import bit.minisys.minicc.MiniCCCfg;
import bit.minisys.minicc.internal.util.MiniCCUtil;


enum DFA_STATE {
    DFA_STATE_INITIAL,
    DFA_STATE_ID_0,
    DFA_STATE_ID_1,
    DFA_STATE_KB_O,
    DFA_STATE_KB_C,
    DFA_STATE_P_O,
    DFA_STATE_P_C,
    DFA_STATE_ADD_0,
    DFA_STATE_ADD_1,
    DFA_STATE_SM,

    DFA_STATE_UNKNW
}

public class MyScanner implements IMiniCCScanner {

    private int lIndex = 0;
    private int cIndex = 0;

    private ArrayList<String> srcLines;

    private HashSet<String> keywordSet;

    //todo: add key words here!
    public MyScanner() {
        this.keywordSet = new HashSet<String>();
        this.keywordSet.add("auto");
        this.keywordSet.add("break");
        this.keywordSet.add("case");
        this.keywordSet.add("char");
        this.keywordSet.add("const");
        this.keywordSet.add("continue");
        this.keywordSet.add("default");
        this.keywordSet.add("do");
        this.keywordSet.add("double");
        this.keywordSet.add("else");
        this.keywordSet.add("enum");
        this.keywordSet.add("extern");
        this.keywordSet.add("float");
        this.keywordSet.add("for");

        this.keywordSet.add("∗");
        this.keywordSet.add("if");
        this.keywordSet.add("inline");
        this.keywordSet.add("int");
        this.keywordSet.add("long");
        this.keywordSet.add("register");
        this.keywordSet.add("restrict");
        this.keywordSet.add("return");
        this.keywordSet.add("short");
        this.keywordSet.add("signed");
        this.keywordSet.add("sizeof");
        this.keywordSet.add("static");
        this.keywordSet.add("struct");
        this.keywordSet.add("switch");
        this.keywordSet.add("typedef");
        this.keywordSet.add("union");

        this.keywordSet.add("unsigned");
        this.keywordSet.add("void");
        this.keywordSet.add("volatile");
        this.keywordSet.add("while");
        this.keywordSet.add("_Alignas");
        this.keywordSet.add("_Alignof");
        this.keywordSet.add("_Atomic");
        this.keywordSet.add("_Bool");
        this.keywordSet.add("_Complex");
        this.keywordSet.add("_Generic");
        this.keywordSet.add("_Imaginary");
        this.keywordSet.add("_Noreturn");
        this.keywordSet.add("_Static_assert");
        this.keywordSet.add("_Thread_local");
    }

    char getNextChar() {
        char c = Character.MAX_VALUE;
        while (true) {
            if (lIndex < this.srcLines.size()) {
                String line = this.srcLines.get(lIndex);
                if (cIndex < line.length()) {
                    c = line.charAt(cIndex);
                    cIndex++;
                    break;
                } else {
                    lIndex++;
                    cIndex = 0;
                }
            } else {
                break;
            }
        }
        if (c == '\u001a') {
            c = Character.MAX_VALUE;
        }
        return c;
    }

    private boolean isAlpha(char c) {
        return Character.isAlphabetic(c);
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private boolean isAlphaOrDigit(char c) {
        return Character.isLetterOrDigit(c);
    }

    private String genToken(int num, String lexme, String type) {
        return genToken(num, lexme, type, this.cIndex - 1, this.lIndex);
    }

    private String genToken2(int num, String lexme, String type) {
        return genToken(num, lexme, type, this.cIndex - 2, this.lIndex);
    }

    //token:[@9,41:42='10',<IntegerConstant>,5:2]
    //[@token_number,start:end='word',<type>,line_number:col_num(ignore start up white pace)]
    private String genToken(int num, String lexme, String type, int cIndex, int lIndex) {
        String strToken = "";

        strToken += "[@" + num + "," + (cIndex - lexme.length() + 1) + ":" + cIndex;
        strToken += "='" + lexme + "',<" + type + ">," + (lIndex + 1) + ":" + (cIndex - lexme.length() + 1) + "]\n";

        return strToken;
    }

    @Override
    public String run(String iFile) throws Exception {

        System.out.println("Scanning...");
        String strTokens = "";
        int iTknNum = 0;

        this.srcLines = MiniCCUtil.readFile(iFile);

        DFA_STATE state = DFA_STATE.DFA_STATE_INITIAL;        //FA state
        String lexme = "";        //token lexme
        char c = ' ';        //next char
        boolean keep = false;    //keep current char
        boolean end = false;

        while (!end) {                //scanning loop
            if (!keep) {
                c = getNextChar();
            }

            keep = false;

            switch (state) {
                case DFA_STATE_INITIAL:
                    lexme = "";

                    //todo: add number support
                    if (isAlphaOrDigit(c)) {
                        state = DFA_STATE.DFA_STATE_ID_0;
                        lexme = lexme + c;
                    } else if (c == '+') {
                        state = DFA_STATE.DFA_STATE_ADD_0;
                        lexme = lexme + c;
                    } else if (c == '-') {
                        strTokens += genToken(iTknNum, "-", "'-'");
                        iTknNum++;
                        state = DFA_STATE.DFA_STATE_INITIAL;
                    } else if (c == '{') {
                        strTokens += genToken(iTknNum, "{", "'{'");
                        iTknNum++;
                        state = DFA_STATE.DFA_STATE_INITIAL;
                    } else if (c == '}') {
                        strTokens += genToken(iTknNum, "}", "'}'");
                        iTknNum++;
                        state = DFA_STATE.DFA_STATE_INITIAL;
                    } else if (c == '(') {
                        strTokens += genToken(iTknNum, "(", "'('");
                        iTknNum++;
                        state = DFA_STATE.DFA_STATE_INITIAL;
                    } else if (c == ')') {
                        strTokens += genToken(iTknNum, ")", "')'");
                        iTknNum++;
                        state = DFA_STATE.DFA_STATE_INITIAL;
                    } else if (c == ';') {
                        strTokens += genToken(iTknNum, ";", "';'");
                        iTknNum++;
                        state = DFA_STATE.DFA_STATE_INITIAL;
                    } else if (c == ',') {
                        strTokens += genToken(iTknNum, ",", "','");
                        iTknNum++;
                        state = DFA_STATE.DFA_STATE_INITIAL;
                    } else if (Character.isSpace(c)) {

                    } else if (c == Character.MAX_VALUE) {
                        cIndex = 5;
                        strTokens += genToken(iTknNum, "<EOF>", "EOF");
                        end = true;
                    }
                    break;
                case DFA_STATE_ADD_0:
                    if (c == '+') {
                        //TODO:++
                    } else {
                        strTokens += genToken2(iTknNum, "+", "'+'");
                        iTknNum++;
                        state = DFA_STATE.DFA_STATE_INITIAL;
                        keep = true;
                    }
                    state = DFA_STATE.DFA_STATE_INITIAL;
                    break;
                case DFA_STATE_ID_0:
                    // TODO: judge c; then use number/./
                    if (isAlphaOrDigit(c)) {
                        lexme = lexme + c;
                    } else {
                        if (this.keywordSet.contains(lexme)) {
                            //key word have done here
                            strTokens += genToken2(iTknNum, lexme, "'" + lexme + "'");
                        } else {
                            //and the whole char have stored in the lexme, just scan it and indentify whether this is string/const
                            //todo:scan the leme and modify the "Identifier to the true type"
                            strTokens += genToken2(iTknNum, lexme, "Identifier");
                        }
                        iTknNum++;
                        state = DFA_STATE.DFA_STATE_INITIAL;
                        keep = true;
                    }
                    break;
                default:
                    System.out.println("[ERROR]Scanner:line " + lIndex + ", column=" + cIndex + ", unreachable state!");
                    break;
            }
        }


        String oFile = MiniCCUtil.removeAllExt(iFile) + MiniCCCfg.MINICC_SCANNER_OUTPUT_EXT;
        MiniCCUtil.createAndWriteFile(oFile, strTokens);

        return oFile;
    }

}
