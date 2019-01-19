CC = gcc
CFLAGS = -g
OUTFILE = out
LIBS =-lm


all: clean run-1 clean-pdf

compile: parser.c lexer.c yalang.o latex.o
	$(CC) $(CFLAGS) parser.c lexer.c yalang.o latex.o -o $(OUTFILE) $(LIBS)

latex.o: latex.h latex.c
	gcc $(CFLAGS) -c latex.c

yalang.o: yalang.h yalang.c
	gcc $(CFLAGS) -c yalang.c

run-1: compile
	./$(OUTFILE) < 	example1.ya

run-2: compile
	./$(OUTFILE) < example2.ya

run-6: compile
	./$(OUTFILE) < example6.ya

parser.c: yalang.y
		bison -y -v -d $^ -o $@

lexer.c: yalang.lex
		flex -o $@ $^

apt:
	pdflatex apt.tex

clean:
		rm -rf parser.c lexer.c parser.h parser.output latex.o yalang.o
		rm -f out apt.pdf

clean-pdf: PDF
	rm -f *.aux
	rm -f *.log
	rm -f *.tex
	rm -f *.dvi
	rm -f *.ps


apt.dvi: apt.tex
		latex apt.tex

apt.ps: apt.dvi
		dvips -Ppdf -G0 apt.dvi

PDF: apt.ps
		ps2pdf apt.ps