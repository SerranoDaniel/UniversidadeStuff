CLASSPATH = build/classes/trabalho
LIBPATH = dist/lib/postgresql.jar
SRC = src/trabalho/*.java
PORT = 9000
ADD = alunos.di.uevora.pt
SERVER = trabalho.ClubeServer
CLIENT = trabalho.ClubeCliente

all:
	javac -d $(CLASSPATH) $(SRC)

server:
	java -classpath $(CLASSPATH):$(LIBPATH) $(SERVER) $(PORT)

client:
	java -classpath $(CLASSPATH) $(CLIENT) $(ADD) $(PORT)

clean:
	rm -rf $(CLASSPATH)/*

