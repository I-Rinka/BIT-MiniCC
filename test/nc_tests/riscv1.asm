.data
str1: .asciz "Please input a number:\n"
str2: .asciz "This number's fibonacci value is :\n"

.text

main:
    la a0,str1
    call Mars_PrintStr
    call Mars_GetInt
    call fibonacci
    mv s0,a0
    la a0,str2
    call Mars_PrintStr
    mv a0,s0
    call Mars_PrintInt
    li a7,10
    ecall

fibonacci:
	# 栈帧的初始化语句在最后才生成。
    addi sp,sp,-24 # 比如-28只有在得知 %14: -24(fp) 这一语句的最大栈偏移为24后，才能将28=24+4得出
    sw ra,20(sp)
    sw s0,16(sp) #如果有需要的话，这里也会保存各种功能参数
    addi s0,sp,24


    sw a0,-12(fp)
    lw t0,-12(fp) # %4: t0
    li t1,1 # 加载立即数,1:t1
    bge t0,t1,label_7


    sw x0,-16(fp)
    jal x0,label_20 #无条件跳转

    label_7:
    lw t0,-12(fp) # %8: t0
    li t1,2
    bgt t0,t1,label_11


    li t0,1
    sw t0,-16(fp)
    j label_19

    label_11:
    lw t0,-12(fp) # %12:t0
    addi t0,t0,-1 # %12在使用前已释放

    addi a0,t0,0 # mov a0,t0 函数传参
    call fibonacci # 同时释放%13，%14: a0

    lw t0,-12(fp) # %15: t0
    addi t1,t0,-2 # %16: t1

    # 破坏性操作，保存a0, %15:t0已被释放
    sw a0,-20(fp) # %14: -20(fp)

    addi a0,t1,0
    call fibonacci # %17 :a0

    # %14现在符号表对应的标记是一个地址，需要值加载
    lw t0, -20(fp)
    add t0, t0, a0 # 同时释放14, %18: t0
    sw t0,-16(fp)
    j label_19

    label_19:
    j label_20 # 来自LLVM代码的冗余

    label_20:
    #返回值，直接加载到a0
    lw a0,-16(fp)

    # 恢复堆栈

    lw ra,20(sp)
    lw s0,16(sp)
    addi sp,sp,24
    ret


Mars_PrintStr:
    li a7,4
	ecall
	ret

Mars_GetInt:
    li a7,5
    ecall
    ret

Mars_PrintInt:
    li a7,1
    ecall
    ret