.data
blank : .asciz " "
_4sc : .asciz "after bubble sort:\n"
_2sc : .asciz "before bubble sort:\n"
_1sc : .asciz "please input ten int number for bubble sort:\n"
_3sc : .asciz "\n"
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
main:
	addi vsp, vsp, -364
	la x5, _1sc
	sw x5, s0, -68
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x5, 0
	jal ra, Mars_PrintStr
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	li x5, 0
	addi x6, x5, 0
	sw x6, s0, -44
	sw x5, s0, -72
_1LoopCheckLabel:
	li x5, 10
	lw x6, s0, -44
	slt x7, x6, x5
	addi x18, x7, 0
	sw x7, s0, -76
	sw x18, s0, -80
	sw x6, s0, -44
	sw x5, s0, -84
	beq x18, x0, _1LoopEndLabel
	li x5, 0
	lw x6, s0, -44
	add x5, x5, x6
	addi x5, 4
	mul x5, x5, x5
	li x7, 0
	add x5, x5, x7
	sw x6, s0, -44
	sw x7, s0, -88
	sw x5, s0, -92
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	jal ra, Mars_GetInt
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	addi x5, x10, 0
	lw x6, s0, -92
	sub x5, s0, x6
	addi x5, x5, -4
	sw x5, x5, 0
	sw x6, s0, -92
	sw x5, s0, -96
_1LoopStepLabel:
	lw x5, s0, -44
	addi x6, x5, 0
	li x7, 1
	add x5, x5, x7
	sw x7, s0, -100
	sw x6, s0, -104
	sw x5, s0, -44
	beq x0, x0, _1LoopCheckLabel
_1LoopEndLabel:
	la x5, _2sc
	sw x5, s0, -108
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x5, 0
	jal ra, Mars_PrintStr
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	li x5, 0
	addi x6, x5, 0
	sw x6, s0, -48
	sw x5, s0, -112
_2LoopCheckLabel:
	li x5, 10
	lw x6, s0, -48
	slt x7, x6, x5
	addi x18, x7, 0
	sw x6, s0, -48
	sw x5, s0, -116
	sw x18, s0, -120
	sw x7, s0, -124
	beq x18, x0, _2LoopEndLabel
	li x5, 0
	lw x6, s0, -48
	add x5, x5, x6
	addi x5, 4
	mul x5, x5, x5
	li x7, 0
	add x5, x5, x7
	sub x5, s0, x5
	addi x5, x5, -4
	lw x5, x5, 0
	sw x6, s0, -48
	sw x7, s0, -128
	sw x5, s0, -132
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x5, 0
	jal ra, Mars_PrintInt
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
_2LoopStepLabel:
	lw x5, s0, -48
	addi x6, x5, 0
	li x7, 1
	add x5, x5, x7
	sw x5, s0, -48
	sw x7, s0, -136
	sw x6, s0, -140
	beq x0, x0, _2LoopCheckLabel
_2LoopEndLabel:
	la x5, _3sc
	sw x5, s0, -144
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x5, 0
	jal ra, Mars_PrintStr
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	li x5, 0
	addi x6, x5, 0
	sw x6, s0, -52
	sw x5, s0, -148
_3LoopCheckLabel:
	li x5, 10
	lw x6, s0, -52
	slt x7, x6, x5
	addi x18, x7, 0
	sw x18, s0, -152
	sw x6, s0, -52
	sw x5, s0, -156
	sw x7, s0, -160
	beq x18, x0, _3LoopEndLabel
	li x5, 0
	addi x6, x5, 0
	sw x5, s0, -164
	sw x6, s0, -56
_4LoopCheckLabel:
	li x5, 10
	lw x6, s0, -52
	sub x7, x5, x6
	addi x18, x7, 0
	li x19, 1
	sub x20, x18, x19
	addi x21, x20, 0
	lw x22, s0, -56
	slt x23, x22, x21
	addi x24, x23, 0
	sw x18, s0, -168
	sw x20, s0, -172
	sw x7, s0, -176
	sw x21, s0, -180
	sw x24, s0, -184
	sw x19, s0, -188
	sw x6, s0, -52
	sw x23, s0, -192
	sw x5, s0, -196
	sw x22, s0, -56
	beq x24, x0, _4LoopEndLabel
	li x5, 0
	lw x6, s0, -56
	add x5, x5, x6
	addi x5, 4
	mul x5, x5, x5
	li x7, 0
	add x5, x5, x7
	sub x5, s0, x5
	addi x5, x5, -4
	lw x5, x5, 0
	li x18, 1
	add x19, x6, x18
	addi x20, x19, 0
	li x21, 0
	add x21, x21, x20
	addi x21, 4
	mul x21, x21, x21
	li x22, 0
	add x21, x21, x22
	sub x21, s0, x21
	addi x21, x21, -4
	lw x21, x21, 0
	slt x23, $21, $5
	addi x24, x23, 0
	sw x24, s0, -200
	sw x21, s0, -204
	sw x5, s0, -208
	sw x6, s0, -56
	sw x7, s0, -212
	sw x19, s0, -216
	sw x22, s0, -220
	sw x20, s0, -224
	sw x23, s0, -228
	sw x18, s0, -232
	beq x24, x0, _1otherwise1
	li x5, 0
	lw x6, s0, -56
	add x5, x5, x6
	addi x5, 4
	mul x5, x5, x5
	li x7, 0
	add x5, x5, x7
	sub x5, s0, x5
	addi x5, x5, -4
	lw x5, x5, 0
	addi x18, x5, 0
	li x19, 0
	add x19, x19, x6
	addi x19, 4
	mul x19, x19, x19
	li x20, 0
	add x19, x19, x20
	li x21, 1
	add x22, x6, x21
	addi x23, x22, 0
	li x24, 0
	add x24, x24, x23
	addi x24, 4
	mul x24, x24, x24
	li x25, 0
	add x24, x24, x25
	sub x24, s0, x24
	addi x24, x24, -4
	lw x24, x24, 0
	sub x24, s0, x19
	addi x24, x24, -4
	sw x24, x24, 0
	li x26, 1
	add x27, x6, x26
	addi x28, x27, 0
	li x29, 0
	add x29, x29, x28
	addi x29, 4
	mul x29, x29, x29
	li x30, 0
	add x29, x29, x30
	sub x18, s0, x29
	addi x18, x18, -4
	sw x18, x18, 0
	sw x29, s0, -236
	sw x28, s0, -240
	sw x18, s0, -60
	sw x7, s0, -244
	sw x20, s0, -248
	sw x30, s0, -252
	sw x19, s0, -256
	sw x5, s0, -260
	sw x23, s0, -264
	sw x25, s0, -268
	sw x27, s0, -272
	sw x24, s0, -276
	sw x21, s0, -280
	sw x22, s0, -284
	sw x6, s0, -56
	sw x26, s0, -288
	beq x0, x0, _1endif
_1otherwise1:
_1endif:
_4LoopStepLabel:
	lw x5, s0, -56
	addi x6, x5, 0
	li x7, 1
	add x5, x5, x7
	sw x6, s0, -292
	sw x7, s0, -296
	sw x5, s0, -56
	beq x0, x0, _4LoopCheckLabel
_4LoopEndLabel:
_3LoopStepLabel:
	lw x5, s0, -52
	addi x6, x5, 0
	li x7, 1
	add x5, x5, x7
	sw x7, s0, -300
	sw x5, s0, -52
	sw x6, s0, -304
	beq x0, x0, _3LoopCheckLabel
_3LoopEndLabel:
	la x5, _4sc
	sw x5, s0, -308
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x5, 0
	jal ra, Mars_PrintStr
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
	li x5, 0
	addi x6, x5, 0
	sw x5, s0, -312
	sw x6, s0, -64
_5LoopCheckLabel:
	li x5, 10
	lw x6, s0, -64
	slt x7, x6, x5
	addi x18, x7, 0
	sw x7, s0, -316
	sw x5, s0, -320
	sw x18, s0, -324
	sw x6, s0, -64
	beq x18, x0, _5LoopEndLabel
	li x5, 0
	lw x6, s0, -64
	add x5, x5, x6
	addi x5, 4
	mul x5, x5, x5
	li x7, 0
	add x5, x5, x7
	sub x5, s0, x5
	addi x5, x5, -4
	lw x5, x5, 0
	sw x5, s0, -328
	sw x6, s0, -64
	sw x7, s0, -332
	addi vsp, vsp, -4
	sw s0, vsp, 0
	addi s0, vsp, 0
	sw ra, vsp, 20
	addi x10, x5, 0
	jal ra, Mars_PrintInt
	lw ra, vsp, 20
	lw s0, vsp, 0
	addi vsp, vsp, 4
_5LoopStepLabel:
	lw x5, s0, -64
	addi x6, x5, 0
	li x7, 1
	add x5, x5, x7
	sw x5, s0, -64
	sw x7, s0, -336
	sw x6, s0, -340
	beq x0, x0, _5LoopCheckLabel
_5LoopEndLabel:
	li x5, 0
	sw x5, s0, -344
	addi x10, x5, 0
	addi vsp, s0, 0
	ret
