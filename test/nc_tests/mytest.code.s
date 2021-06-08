main:
  addi sp,sp,-4
  sw ra,8(sp)
  sw fp,4(sp)
  addi fp,sp,8
  mv a0,t0
  call Mars_PrintStr
  call Mars_GetInt
  sw a0,-12(fp)
  lw t0,-12(fp)
  mv a0,t0
  call prime
  sw a0,-16(fp)
  mv a0,t0
  call Mars_PrintStr
  lw t0,-16(fp)
  mv a0,t0
  call Mars_PrintInt
  lw ra,8(sp)
  lw fp,4(sp)
  addi sp,sp,12
  addi a7,zero,10
  ecall

prime:
  addi sp,sp,-16
  sw ra,20(sp)
  sw fp,16(sp)
  addi fp,sp,20
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
  mul t0,t0,t1
  lw t1,-20(fp)
  bgt t0,t1,.L29
  lw t0,-20(fp)
  lw t1,-24(fp)
  rem t0,t0,t1
  bne t0,zero,.L25
  sw zero,-28(fp)
  jal x0,.L29
.L25:
  lw t0,-24(fp)
  addi t0,t0,1
  sw t0,-24(fp)
  jal x0,.L12
.L29:
  lw t0,-28(fp)
  addi t1,zero,1
  bne t0,t1,.L36
  lw t0,-16(fp)
  addi t0,t0,1
  sw t0,-16(fp)
  lw t0,-20(fp)
  mv a0,t0
  call Mars_PrintInt
.L36:
  lw t0,-20(fp)
  addi t0,t0,1
  sw t0,-20(fp)
  jal x0,.L7
.L40:
  lw t0,-16(fp)
  lw ra,20(sp)
  lw fp,16(sp)
  addi sp,sp,24
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
  ret
