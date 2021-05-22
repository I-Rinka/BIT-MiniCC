# BIT-MiniCC

© 版权所有 2021 王梓丞

请勿抄袭以及过度借鉴，不然实验0蛋

BIT Mini C Compiler is a C compiler framework in Java for teaching.

源代码是闭源的，而我们作业的内容是将闭源的部分使用自己的接口实现。

# Building & Running
## Requirements
* JDK 1.8 or higher
* Eclipse Mars

## Building & Running
1. Import the project into Eclipse
2. Set the input source file
3. run as Java applications from class BitMiniCC

# Supported targets
1. x86
2. MIPS
3. RISC-V
4. ARM (coming soon)

# Lab. projects
1. Lexical Analysis: input(C code), output(tokens in JSON)
2. Syntactic Analysis: input(tokens in JSON), output(AST in JSON)
3. Semantic Analysis: input(AST in JSON), output(errors)
4. IR Generation: input(AST in JSON), output(IR)
5. Target Code Generation: input(AST in JSON), output(x86/MIPS/RISC-V assembly)

# Correspondence
* Weixing Ji (jwx@bit.edu.cn) 

# Contributor
* 2021: Rinka Wang (Me)
* 2020: Hang Li
* 2019: Chensheng Yu, Yueyan Zhao
* 2017: Yu Hao
* 2016: Shuofu Ning
* 2015: YiFan Wu
