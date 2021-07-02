.data
.str.0: .asciz "Please input a number:\n"
.str.1: .asciz "This number's fibonacci value is :\n"
.text
main:
  addi sp,sp,-20
  sw ra,16(sp)
  sw fp,12(sp)
  addi fp,sp,20
  la a0,.str.0
  mv a0,a0
  call Mars_PrintStr
  call Mars_GetInt
  sw a0,-12(fp)
  lw t0,-12(fp)
  mv a0,t0
  call fibonacci
  sw a0,-16(fp)
  la a0,.str.1
  mv a0,a0
  call Mars_PrintStr
  lw t1,-16(fp)
  mv a0,t1
  call Mars_PrintInt
  lw fp,12(sp)
  lw ra,16(sp)
  addi sp,sp,20
  mv a0,zero
  addi a7,zero,10
  ecall

fibonacci:
  addi sp,sp,-24
  sw ra,20(sp)
  sw fp,16(sp)
  addi fp,sp,24
  sw a0,-12(fp)
  lw t0,-12(fp)
  addi t1,zero,1
  bge t0,t1,.L7
  sw zero,-16(fp)
  jal x0,.L20
.L7:
  lw t0,-12(fp)
  addi t1,zero,2
  bgt t0,t1,.L11
  addi t0,zero,1
  sw t0,-16(fp)
  jal x0,.L19
.L11:
  lw t0,-12(fp)
  addi t1,t0,-1
  mv a0,t1
  call fibonacci
  lw t2,-12(fp)
  addi t3,t2,-2
  sw a0,-24(fp)
  mv a0,t3
  call fibonacci
  lw t4,-24(fp)
  lw t4,-24(fp)
  add t5,t4,a0
  sw t5,-16(fp)
.L19:
.L20:
  lw t0,-16(fp)
  lw fp,16(sp)
  lw ra,20(sp)
  addi sp,sp,24
  mv a0,t0
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
  li a7,11
  li a0,10
  ecall
  ret
