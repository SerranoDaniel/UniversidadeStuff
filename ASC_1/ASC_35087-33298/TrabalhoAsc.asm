.data
		#nome do ficheiro de imagem,que neste caso está na mesma diretoria
	img: .asciiz "lena512color.rgb"
	 
		#nome do ficheiro devolvido pelo programa
	imgSaida: .asciiz "lenaFinal	.GRAY"
	
		
		#Buffer para alugar espaço para a imagem rgb
	BufferRGB: .space 786432
		#Buffer para alugar espaço para a imagem gray
	BufferGray: .space 262144
		#Buffer para a função convolution q contem a imagem e sober horizontal
	BufferConvulHori: .space 262144
		#Buffer para a função convolution q e sobel vertical
	BufferConvulVert: .space 262144
		#Buffer com a matriz Sobel Horizontal
	BufferMatrizSobelHori: .byte 1, 0, -1, 2, 0, -2, 1, 0, -1
		#Buffer com a matri Sobel Vertical
	BufferMatrizSobelVert: .byte 1, 2, 1, 0, 0, 0, -1, -2, -1
		#Buffer que contem a imagem final ou seja do contour
	BufferContour: .space 262144
		

.text

main:
	#Leitura da imagem, passando como argumento o a0 para a funcao "read_rgb_image"
	la $a0, img
	jal read_rgb_image
	nop
	
	#Pssagem de argumento o buffer da imagem rgb e onde vai ser colocada a imagem em Gray para a funcao que converte a imagem de rgb para gray
	la $a0, BufferRGB
	la $a1, BufferGray
	jal rgb_to_gray
	nop 
	
	#Envia a imagem em Gray para ser aplicado o sobel horizontal
	la $a0, BufferGray
	la $a1, BufferMatrizSobelHori
	la $a2, BufferConvulHori
	jal convolution
	nop
	
	#Envia a imagem em Gray para ser aplicado o sobel horizontal
	la $a0, BufferGray
	la $a1, BufferMatrizSobelVert
	la $a2, BufferConvulVert
	jal convolution
	nop
	
	#Envia tanto a imagem afetada pelo Sobel Horizontal como a Vertical para serem aplicados os contronos
	la $a0, BufferConvulHori
	la $a1, BufferConvulVert
	la $a2, BufferContour
	jal contour
	nop	
	
	#Função para criar o ficheiro Gray, sendo que sao passados como argumentos o nome do ficheiro, o endereço da imagem a ser criada e o tamanho
	la $a0, imgSaida
	la $a1,	BufferContour
	li $a2, 262144
	jal write_to_gray
	nop	
	
	beq $zero,$zero,END
	nop
	
	
read_rgb_image:
	#Abrir o ficheiro para leitura
	li $a1, 0
	li $a2, 0
	li $v0, 13
	syscall
	
	#Abrir o ficheiro para escrita
	move $a0, $v0
	la $a1, BufferRGB
	li $a2, 786432
	li $v0, 14
	syscall
	
	
	#Fechar ficheiro
	li $v0, 16
	syscall
	
	#De volta ao main
	jr $ra
	nop
	
	
rgb_to_gray:
	#Guardar na pilha o ra da funcao para q depois seja possivel ir para o "loop"
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	#t4 vai ter o valor do endereço final da imagem rgb que sera usado para a terminação do loopgray
	move $t4, $a0
	addi $t4, $t4, 786432	
	#Salta para o loop
	jal loopgray
	nop
	#Pilha
	lw $ra,0($sp)
	addi $sp,$sp, 4
	#De volta para o main
	jr $ra
	nop
	
	
	loopgray:
	#Este loop vai buscar os bytes em rgb e vai multiplica-los respetivamente por 30, 59 e 11 e mais tarde a soma destes valores dividida por 100 será colocada no espaço "alugardo
	#para a imagem em cinzentos (BufferGray)
	#Converção do red
	lbu $t0, 0($a0) 
	mul $t0, $t0, 30
	
	#Converção do green
	lbu $t1, 1($a0)
	mul $t1, $t1, 59

	#Converção do blue
	lbu $t2, 2($a0)
	mul $t2, $t2, 11
	
	#soma das bytes convertidos a gray e guardar byte a byte no Buffergray (a1)
	add $t3, $t0, $t1
	add $t3, $t3, $t2
	div $t3, $t3, 100
	sb $t3, 0($a1)
	
	#Incremetar os buffers, sendo que o a0 tem de ser de 3 em 3
	addi $a1, $a1, 1
	addi $a0, $a0, 3
	
	#Caso o a0 chegue ao endereço final ja esta tudo convertido e termina o loop
	bne $t4, $a0, loopgray
	nop
	
	#end loop
	jr $ra
	nop


write_to_gray:
	#Estes argumentos serão utilizados na abertura do ficheiro, logo têm de ser movidos
	move $t0, $a1
	move $t1, $a2
	
	#Abertura do ficheiro	
	li $a1, 1
	li $a2, 0
	li $v0, 13
	syscall
	
	#Escrever no ficheiro
	move $a0, $v0
	move $a1, $t0
	move $a2, $t1
	li $v0, 15
	syscall
	
	#Fechar ficheiro
	move $a0, $v0
	li $v0, 16
	syscall
	
	jr $ra
	nop

convolution:
	#adicionar ao a0 513 para que começe a aplicar o sobel dentro de margens ou seja na segunda linha e na sgunda coluna
	addi $a0, $a0, 513
	#inicializar o t3 para guardar os valores a serem adicionados ao buffer com o sobel
	add $t3, $zero, $zero
	#Valor da posição da primeira margem (neste caso da segunda linha) que mais tarde será incrementado para manter a mesma coluna mas na linha abaixo
	addi $t4, $a0, 1023
	#Valor da ultima posição dentro de margens para que o loop do sobel termine
	addi $t5, $a0, 261631
	#Adiciona se tambem 513 ao Buffer on serao guardados os valores para serem guardados na posição certa
	addi $a2, $a2, 513
	
	sobel:
	#inicio do loop
	#coloca em t1 o primeiro valor da matriz sobel e em t0 a posicao respetiva em da imagem em Gray em ralacao à matriz sobel, ou seja neste caso o canto superior esquerdo 
	#e faz a multiplicacao entre estes e adiciona em t3
	lb $t1, 0($a1)			#Faz o mesmo 9 vezes (ou seja os valores que estao na matriz sobel)
	lbu $t0, -513($a0)
	mul $t2, $t1, $t0
	add $t3, $t3, $t2
	
	lb $t1, 1($a1)
	lbu $t0, -512($a0)
	mul $t2, $t1, $t0
	add $t3, $t3, $t2
	
	lb $t1, 2($a1)
	lbu $t0, -511($a0)
	mul $t2, $t1, $t0
	add $t3, $t3, $t2
	
	lb $t1, 3($a1)
	lbu $t0, -1($a0)
	mul $t2, $t1, $t0
	add $t3, $t3, $t2
	
	lb $t1, 4($a1)
	lbu $t0, 0($a0)
	mul $t2, $t1, $t0
	add $t3, $t3, $t2
	
	lb $t1, 5($a1)
	lbu $t0, 1($a0)
	mul $t2, $t1, $t0
	add $t3, $t3, $t2
	
	lb $t1, 6($a1)
	lbu $t0, 511($a0)
	mul $t2, $t1, $t0
	add $t3, $t3, $t2
	
	lb $t1, 7($a1)
	lbu $t0, 512($a0)
	mul $t2, $t1, $t0
	add $t3, $t3, $t2
	
	lb $t1, 8($a1)
	lbu $t0, 513($a0)
	mul $t2, $t1, $t0
	add $t3, $t3, $t2
	
	#Estes pontos sao pedidos no contour mas foram utilizados aqui pois torna mais pequeno e pratico o codigo
	#o abse server para colocares os valores em absoluto no BUffer
	abs $t3, $t3
	div $t3, $t3, 4	
	#Store dos bytes convertidos a Sobel no Buffer respetivo
	sb $t3, 0($a2)
	#Incrementação dos buffer para que possam ser corridas todas as opções
	addi $a0, $a0, 1
	addi $a2, $a2, 1
	#Caso a posição atinga um posição de margem
	beq $a0, $t4, margem
	nop
	#Volta para o loop ate ser atinginda a ultima posição que neste caso está colocada em t5
	blt $a0, $t5, sobel
	nop
	#De volta para o main
	jr $ra				
	nop	
	
	
	margem:		
	#Função que adiciona 2 valores tanto a a0 como a a2 pois sao os valores necessários para que atingindo uma margem, troquem de linha e avançem ainda mais uma posicao para sair da margem esquerda
	addi $a0, $a0, 2
	addi $a2, $a2, 2
	#Adicionar ao controlador de margem
	addi $t4, $t4, 512
	#Volta para o loop ate ser atinginda a ultima posição que neste caso está colocada em t5
	blt $a0, $t5, sobel
	nop
	#De volta para o main
	jr $ra				
	nop
	
contour:
	#Pilha
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	#adicionado ao t3 a ultima posição para que possa servir de controlo apra terminar o loop "contornos"
	addi $t3, $zero, 262144
	#t4 sera o contador
	addi $t4, $zero, 1
	#Utilizado numa subtração explicada no codigo
	addi $t5, $zero, 255
	#Salta para o loop
	jal contornos
	nop	
	#Pilha
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	#De volta ao main
	jr $ra
	nop
	
	
	contornos:
		#Coloca em $t0 e $t1 os valores das imagem com sobl	
		lbu $t0, 0($a0)
		lbu $t1, 0($a1)
		#Adiciona os valores dos bytes destas imagens e divide por 2
		#A subtração serve para que as cores obtidas nao sejam tao escuras
		add $t2, $t1, $t0
		div $t2, $t2, 2
		sub $t2, $t5, $t2		
		#Faz "store" no buffer que ira conter a imagem final
		sb $t2, 0($a2)		
		#Incrementação para serem corridas todas as posicoes
		#Senod que o $t4 servira de contadore para controlar a ultima posicao
		addi $a2, $a2, 1
		addi $a0, $a0, 1
		addi $a1, $a1, 1
		addi $t4, $t4, 1
		#VOlta para o loop ate o t4 ser igual a 262144
		bne $t4, $t3, contornos
		nop
		#de volta a contour
		jr $ra
		nop
		
END:
#FIM!

	
