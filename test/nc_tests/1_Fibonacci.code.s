.data
blank : .asciz " "
_1sc : .asciz "Please input a number:\n"
_2sc : .asciz "This number's fibonacci value is :\n"
.text
__init:
	li vsp, 0x80000000
	addi s0, vsp, 0
	li gp, 0x10010000
	jal ra, main
	li vsp, 10
	syscall
Mars_PrintInt:
	addi s1, vsp, 0
	addi tp, a0, 0
	li vsp, 1
	syscall
	la tp, blank
	li vsp, 4
	syscall
	addi vsp, s1, 0
	ret
Mars_GetInt:
	addi s1, vsp, 0
	li vsp, 5
	syscall
	addi x10, vsp, 0
	addi vsp, s1, 0
	ret
Mars_PrintStr:
	addi s1, vsp, 0
	addi tp, a0, 0
	li vsp, 4
	syscall
	addi vsp, s1, 0
	ret
fibonacci:
	addi vsp, vsp, -100
	addi x5, x10, 0
	li x6, 1
	slt x7, x5, x6
	addi x18, x7, 0
	sw x5, s0, -4
	sw x7, s0, -12
	sw x18, s0, -16
	sw x6, s0, -20
	beq x18, x0, _1otherwise1
	li x5, 0
	addi x6, x5, 0
	sw x6, s0, -8
	sw x5, s0, -24
	beq x0, x0, _1endif
_1otherwise1:
	li x5, 2
	lw x6, s0, -4
	sub x7, x6, x5
	slti x7, x7, 1
	addi x18, x7, 0
	sw x18, s0, -28
	sw x6, s0, -4
	sw x5, s0, -32
	sw x7, s0, -36
	beq x18, x0, _1otherwise2
	li x5, 1
	addi x6, x5, 0
	sw x6, s0, -8
	sw x5, s0, -40
	beq x0, x0, _1endif
_1otherwise2:
	li x5, 1
	lw x6, s0, -4
	sub x7, x6, x5
	addi x18, x7, 0
	sw x18, s0, -44
	sw x5, s0, -48
	sw x7, s0, -52
	sw x6, s0, -4
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x18, 0
	jal ra, fibonacci
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	addi x5, x10, 0
	li x6, 2
	lw x7, s0, -4
	sub x18, x7, x6
	addi x19, x18, 0
	sw x18, s0, -56
	sw x5, s0, -60
	sw x7, s0, -4
	sw x6, s0, -64
	sw x19, s0, -68
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x19, 0
	jal ra, fibonacci
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	addi x5, x10, 0
	lw x6, s0, -60
	add x7, x6, x5
	addi x18, x7, 0
	addi x19, x18, 0
	sw x19, s0, -8
	sw x6, s0, -60
	sw x7, s0, -72
	sw x18, s0, -76
	sw x5, s0, -80
_1endif:
	lw x5, s0, -8
	sw x5, s0, -8
	addi x10, x5, 0
	addi vsp, s0, 0
	ret
main:
	addi vsp, vsp, -48
	la x5, _1sc
	sw x5, s0, -12
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x5, 0
	jal ra, Mars_PrintStr
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	jal ra, Mars_GetInt
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	addi x5, x10, 0
	addi x6, x5, 0
	sw x5, s0, -16
	sw x6, s0, -4
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x6, 0
	jal ra, fibonacci
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	addi x5, x10, 0
	addi x6, x5, 0
	la x7, _2sc
	sw x7, s0, -20
	sw x5, s0, -24
	sw x6, s0, -8
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x7, 0
	jal ra, Mars_PrintStr
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	lw x5, s0, -8
	sw x5, s0, -8
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x5, 0
	jal ra, Mars_PrintInt
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	li x5, 0
	sw x5, s0, -28
	addi x10, x5, 0
	addi vsp, s0, 0
	ret
