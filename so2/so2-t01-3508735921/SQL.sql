CREATE TABLE questionario(
	IdQuestionario SERIAL,
	nome varchar(255),
	numeroDeRespostasAoQuestionario int,
	numPerguntas int,
	PRIMARY KEY(IdQuestionario)
);

CREATE TABLE pergunta(
	IdQuestionario int,
	IdPergunta SERIAL,
	pergunta varchar(255),
	respostaGlobal int,
	PRIMARY KEY(IdPergunta),
	FOREIGN KEY(IdQuestionario) REFERENCES questionario(IdQuestionario) ON DELETE CASCADE
);

CREATE TABLE codigos(
        codigoResposta SERIAL,
        PRIMARY KEY(codigoResposta)
);
