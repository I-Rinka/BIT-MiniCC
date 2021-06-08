main:
  addi sp,sp,-16
  sw ra,12(sp)
  sw fp,8(sp)
  addi fp,sp,16
  mv a0,t0
  call Mars_PrintStr
  call Mars_GetInt
  sw a0,-8(fp)
  lw t1,-8(fp)
  mv a0,t1
  call prime
  sw a0,-12(fp)
  mv a0,t1
  call Mars_PrintStr
  lw t2,-12(fp)
  mv a0,t2
  call Mars_PrintInt
  lw ra,12(sp)
  lw fp,8(sp)
  addi sp,sp,16
  ret

prime:
  addi sp,sp,-40
  sw ra,36(sp)
  sw fp,32(sp)
  addi fp,sp,40
  sw a0,-20(fp)
  sw zero,-24(fp)
  addi t0,zero,1
  sw t0,-36(fp)
  addi t0,zero,2
  sw t0,-28(fp)
  jal x0,.L7
.L7:
  lw t0,-28(fp)
  lw t0,-20(fp)
  bgt t0,t0,.L40
  addi t0,zero,1
  sw t0,-36(fp)
  addi t0,zero,2
  sw t0,-32(fp)
  jal x0,.L12
.L12:
  lw t0,-32(fp)
  lw t0,-32(fp)
  mul t0,t0,t0
  lw t0,-28(fp)
  bgt t0,t0,.L29
  lw t0,-28(fp)
  lw t0,-32(fp)
  rem t0,t0,t0
  bne t0,zero,.L25
  sw zero,-36(fp)
  jal x0,.L29
.L25:
  jal x0,.L26
.L26:
  lw t0,-32(fp)
  addi t0,t0,1
  sw t0,-32(fp)
  jal x0,.L12
.L29:
  lw t0,-36(fp)
  addi t0,zero,1
  bne t0,t0,.L36
  lw t0,-24(fp)
  addi t0,t0,1
  sw t0,-24(fp)
  lw t0,-28(fp)
  mv a0,t0
  call Mars_PrintInt
  jal x0,.L36
.L36:
  jal x0,.L37
.L37:
  lw t0,-28(fp)
  addi t0,t0,1
  sw t0,-28(fp)
  jal x0,.L7
.L40:
  lw t0,-24(fp)
  lw ra,36(sp)
  lw fp,32(sp)
  addi sp,sp,40
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
