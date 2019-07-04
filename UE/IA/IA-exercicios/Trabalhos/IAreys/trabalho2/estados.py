def main():
	dominio = "[1,2,3,4,5,6,7,8,9]"

	for i in range(9):
		for j in range(9):
			print("v(c("+str(i+1)+","+str(j+1)+"),"+dominio+",_)," )

main()