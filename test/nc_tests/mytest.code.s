main:
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
prime:
  sw a0,-20(fp)
  sw zero,-24(fp)
  addi t0,zero,1
  sw t0,-36(fp)
  addi t0,zero,2
  sw t0,-28(fp)
  lw t0,-28(fp)
  lw t0,-20(fp)
  bgt t0,t0,.L40
  addi t0,zero,1
  sw t0,-36(fp)
  addi t0,zero,2
  sw t0,-32(fp)
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
.L25:
  lw t0,-32(fp)
  addi t0,t0,1
  sw t0,-32(fp)
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
.L36:
  lw t0,-28(fp)
  addi t0,t0,1
  sw t0,-28(fp)
.L40:
  lw t0,-24(fp)
