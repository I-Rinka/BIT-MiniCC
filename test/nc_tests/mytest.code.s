main:
  addi sp,sp,-12
  sw ra,8(sp)
  sw fp,4(sp)
  addi fp,sp,12
  addi t0,zero,100
  mv a0,t0
  call perfectNumber
  lw fp,4(sp)
  lw ra,8(sp)
  addi sp,sp,12
  mv a0,zero
  addi a7,zero,10
  ecall

perfectNumber:
  addi sp,sp,-356
  sw ra,352(sp)
  sw fp,348(sp)
  addi fp,sp,356
  sw a0,-12(fp)
  sw zero,-352(fp)
  addi t0,zero,2
  sw t0,-340(fp)
.L9:
  lw t0,-340(fp)
  lw t1,-12(fp)
  bge t0,t1,.L49
  sw zero,-344(fp)
  lw t0,-340(fp)
  sw t0,-348(fp)
  addi t1,zero,1
  sw t1,-336(fp)
.L15:
  lw t0,-336(fp)
  lw t1,-340(fp)
  addi t2,t1,2
  addi t3,t2,1
  bge t0,t3,.L38
  lw t0,-340(fp)
  lw t1,-336(fp)
  rem t2,t0,t1
  bne t2,zero,.L34
  lw t0,-344(fp)
  addi t1,t0,1
  sw t1,-344(fp)
  add t1,t1,t1
  add t1,t1,t1
  add t2,fp,t1
  lw t3,-336(fp)
  sw t3,-332(t2)
  lw t4,-336(fp)
  lw t5,-348(fp)
  sub t6,t5,t4
  sw t6,-348(fp)
.L34:
  lw t0,-336(fp)
  addi t1,t0,1
  sw t1,-336(fp)
  jal x0,.L15
.L38:
  lw t0,-348(fp)
  bne zero,t0,.L45
  lw t0,-340(fp)
  mv a0,t0
  call Mars_PrintInt
  lw t1,-352(fp)
  addi t2,t1,1
  sw t2,-352(fp)
.L45:
  lw t0,-340(fp)
  addi t1,t0,1
  sw t1,-340(fp)
  jal x0,.L9
.L49:
  lw t0,-352(fp)
  mv a0,t0
  call Mars_PrintInt
  lw fp,348(sp)
  lw ra,352(sp)
  addi sp,sp,356
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
