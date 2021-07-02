.data
.str.0: .asciz "please input ten int number for bubble sort:\n"
.str.1: .asciz "before bubble sort:\n"
.str.2: .asciz "\n"
.str.3: .asciz "after bubble sort:\n"
.text
main:
  addi sp,sp,-76
  sw ra,72(sp)
  sw fp,68(sp)
  addi fp,sp,76
  la a0,.str.0
  mv a0,a0
  call Mars_PrintStr
  sw zero,-52(fp)
.L4:
  lw t0,-52(fp)
  addi t1,zero,10
  bge t0,t1,.L14
  lw t0,-52(fp)
  add t0,t0,t0
  add t0,t0,t0
  add t1,fp,t0
  call Mars_GetInt
  sw a0,-48(t1)
  lw t0,-52(fp)
  addi t1,t0,1
  sw t1,-52(fp)
  jal x0,.L4
.L14:
  la a0,.str.1
  mv a0,a0
  call Mars_PrintStr
  sw zero,-56(fp)
.L17:
  lw t0,-56(fp)
  addi t1,zero,10
  bge t0,t1,.L26
  lw t0,-56(fp)
  add t0,t0,t0
  add t0,t0,t0
  add t1,fp,t0
  lw t2,-48(t1)
  mv a0,t2
  call Mars_PrintInt
  lw t0,-56(fp)
  addi t2,t0,1
  sw t2,-56(fp)
  jal x0,.L17
.L26:
  la a0,.str.2
  mv a0,a0
  call Mars_PrintStr
  sw zero,-60(fp)
.L29:
  lw t0,-60(fp)
  addi t2,zero,10
  bge t0,t2,.L68
  sw zero,-64(fp)
.L34:
  lw t0,-64(fp)
  lw t2,-60(fp)
  addi t4,zero,10
  sub t3,t4,t2
  addi t4,t3,-1
  bge t0,t4,.L64
  lw t0,-64(fp)
  add t0,t0,t0
  add t0,t0,t0
  add t2,fp,t0
  lw t3,-64(fp)
  addi t4,t3,1
  add t4,t4,t4
  add t4,t4,t4
  add t5,fp,t4
  lw t6,-48(t2)
  lw a7,-48(t5)
  ble t6,a7,.L60
  lw t0,-64(fp)
  add t0,t0,t0
  add t0,t0,t0
  add t3,fp,t0
  lw t4,-48(t3)
  sw t4,-68(fp)
  lw t6,-64(fp)
  add t6,t6,t6
  add t6,t6,t6
  add a7,fp,t6
  lw a6,-64(fp)
  addi a5,a6,1
  add a5,a5,a5
  add a5,a5,a5
  add a4,fp,a5
  lw a3,-48(a4)
  sw a3,-48(a7)
  lw a2,-64(fp)
  addi a1,a2,1
  add a1,a1,a1
  add a1,a1,a1
  add t1,fp,a1
  lw t2,-68(fp)
  sw t2,-48(t1)
.L60:
  lw t0,-64(fp)
  addi t1,t0,1
  sw t1,-64(fp)
  jal x0,.L34
.L64:
  lw t0,-60(fp)
  addi t1,t0,1
  sw t1,-60(fp)
  jal x0,.L29
.L68:
  la a0,.str.3
  mv a0,a0
  call Mars_PrintStr
  sw zero,-72(fp)
.L71:
  lw t0,-72(fp)
  addi t1,zero,10
  bge t0,t1,.L80
  lw t0,-72(fp)
  add t0,t0,t0
  add t0,t0,t0
  add t1,fp,t0
  lw t2,-48(t1)
  mv a0,t2
  call Mars_PrintInt
  lw t0,-72(fp)
  addi t2,t0,1
  sw t2,-72(fp)
  jal x0,.L71
.L80:
  lw fp,68(sp)
  lw ra,72(sp)
  addi sp,sp,76
  mv a0,zero
  addi a7,zero,10
  ecall

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
