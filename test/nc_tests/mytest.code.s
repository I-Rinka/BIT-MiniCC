
main:
t0t0
sw t0,-12(fp)
t0t0
sw t0,-16(fp)
li a7,10
ecall

prime:
sw null,-12(fp)
li t0,0
sw t0,-16(fp)
li t0,1
sw t0,-28(fp)
li t0,2
sw t0,-20(fp)
jal x0,.L7
.L7:
bgt null,null,.L40
.L11:
li t0,1
sw t0,-28(fp)
li t0,2
sw t0,-24(fp)
jal x0,.L12
.L12:
mul t0,null,null
bgt null,null,.L29
.L18:
null t0,null,null
null t0,null,.L25
.L23:
li t0,0
sw t0,-28(fp)
jal x0,.L29
.L25:
jal x0,.L26
.L26:
addi t0,null,1
sw t0,-24(fp)
jal x0,.L12
.L29:
null null,null,.L36
.L32:
addi t0,null,1
sw t0,-16(fp)
jal x0,.L36
.L36:
jal x0,.L37
.L37:
addi t0,null,1
sw t0,-20(fp)
jal x0,.L7
.L40:
提升栈帧ret