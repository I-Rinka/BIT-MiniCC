# BIT-MiniCC

© 版权所有 2021 王梓丞

基于Java和antlr的C语言2遍编译器。通过antlr进行词法和语法分析，利用ast节点生成中间代码并在退出函数前将其解析为目标平台代码。

**注意：本人为18级编译原理课程最高分。课程老师已知道本人代码开源，课程会有查重算法。可以借鉴思想，但请勿过度抄袭。**

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
