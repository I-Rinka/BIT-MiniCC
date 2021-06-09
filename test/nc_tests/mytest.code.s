main:
  addi sp,sp,-12
  sw ra,8(sp)
  sw fp,4(sp)
  addi fp,sp,8
  mv a0,t0
  call Mars_PrintStr
  call Mars_GetInt
  sw a0,-12(fp)
  lw t1,-12(fp)
  mv a0,t1
  call fibonacci
  sw a0,-16(fp)
  mv a0,t2
  call Mars_PrintStr
  lw t3,-16(fp)
  mv a0,t3
  call Mars_PrintInt
  lw ra,8(sp)
  lw fp,4(sp)
  addi sp,sp,12
  mv a0,zero
  addi a7,zero,10
  ecall

fibonacci:
  addi sp,sp,-16
  sw ra,12(sp)
  sw fp,8(sp)
  addi fp,sp,12
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
  sw a0,-12(fp)
  mv a0,t3
  call fibonacci
  lw t4,-12(fp)
  sw t4,-12(fp)
  add t5,t4,a0
  sw t5,-16(fp)
.L19:
.L20:
  lw t0,-16(fp)
  lw ra,12(sp)
  lw fp,8(sp)
  addi sp,sp,16
  mv a0,t0
  ret

Mars_PrintStr:
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
