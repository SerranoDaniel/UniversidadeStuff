/*criação da tabela dos campos*/
DROP TABLE IF EXISTS Campos CASCADE;
CREATE TABLE Campos(

	NomeCampo VARCHAR(15) Primary Key 

	Custo INTEGER

	);

/*criação da tabela das reservas*/
DROP TABLE IF EXISTS Reservas CASCADE;
CREATE TABLE Reservas(
	IdReserva Serial Primary Key,

	Utilizador VARCHAR(15),

	Telemovel INTEGER,

	NomeCampo VARCHAR(15),

	DI TIMESTAMP,

	DF TIMESTAMP,

	Pagamento decimal,

	NumUtilizadores INTEGER,

	FOREIGN KEY (NomeCampo) REFERENCES Campos(NomeCampo)

	);

/*insert na tabela dos campos*/
INSERT INTO Campos VALUES ('Tenis1', 15);
INSERT INTO Campos VALUES ('Futsal1',30);
INSERT INTO Campos VALUES ('Padel1', 10);
INSERT INTO Campos VALUES ('Padel2', 10);
INSERT INTO Campos VALUES ('Tenis2', 15);
INSERT INTO Campos VALUES ('Futsal2',30);

/*insert na tabela das reservas*/
INSERT INTO Reservas(Utilizador,Telemovel,NomeCampo,DI,DF,Pagemento,NumUtilizadores) VALUES ('Asdrubal', 9999999,'Tenis1','2016-1-2 8:32:00','2016-1-2 8:50:00' ,15,2);






