.data
.str.0: .asciz "Please input a number:\n"
.str.1: .asciz "The number of prime numbers within n is:\n"
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
  call prime
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

prime:
  addi sp,sp,-32
  sw ra,28(sp)
  sw fp,24(sp)
  addi fp,sp,32
  sw a0,-12(fp)
  sw zero,-16(fp)
  addi t0,zero,1
  sw t0,-28(fp)
  addi t0,zero,2
  sw t0,-20(fp)
.L7:
  lw t0,-20(fp)
  lw t1,-12(fp)
  bgt t0,t1,.L40
  addi t0,zero,1
  sw t0,-28(fp)
  addi t0,zero,2
  sw t0,-24(fp)
.L12:
  lw t0,-24(fp)
  lw t1,-24(fp)
  mul t2,t0,t1
  lw t3,-20(fp)
  bgt t2,t3,.L29
  lw t0,-20(fp)
  lw t1,-24(fp)
  rem t2,t0,t1
  bne t2,zero,.L25
  sw zero,-28(fp)
  jal x0,.L29
.L25:
  lw t0,-24(fp)
  addi t1,t0,1
  sw t1,-24(fp)
  jal x0,.L12
.L29:
  lw t0,-28(fp)
  addi t1,zero,1
  bne t0,t1,.L36
  lw t0,-16(fp)
  addi t1,t0,1
  sw t1,-16(fp)
  lw t2,-20(fp)
  mv a0,t2
  call Mars_PrintInt
.L36:
  lw t0,-20(fp)
  addi t1,t0,1
  sw t1,-20(fp)
  jal x0,.L7
.L40:
  lw t0,-16(fp)
  lw fp,24(sp)
  lw ra,28(sp)
  addi sp,sp,32
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
