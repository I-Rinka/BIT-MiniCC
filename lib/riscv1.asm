.globl main
.data 
hello:
.asciz "hello world!\n"
nihao:
.asciz	"你好世界!\n"

.text 

printStr:
	li a7,4
	ecall
	ret

main:
	la a0,hello #地址加载
	call printStr
	la a0,nihao
	call printStr
	
	li a0,0
	li a7,93
	ecall




	
