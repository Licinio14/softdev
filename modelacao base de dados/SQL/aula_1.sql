# crear as tabelas do ex1

Create TABLE TipoMaquina(
	id int AUTO_INCREMENT,
    name varchar(20) not null,
    PRIMARY KEY (id)
);

CREATE TABLE Maquina(
    numero int AUTO_INCREMENT,
    idTipo int not null,
    dataUltimaManut datetime,
    PRIMARY KEY (numero),
    FOREIGN KEY (idTipo) REFERENCES TipoMaquina(id)
);

CREATE TABLE Servico(
	codFatura int AUTO_INCREMENT,
    numMaquina int not null,
    duracao time not null,
    valor numeric(10,2) not null,
    nifCliente varchar(9),
    dataHora datetime DEFAULT NOW(),
    CONSTRAINT PK_SERVICO PRIMARY KEY (codFatura),
    CONSTRAINT FK_SERVICO_NUMMAQUINA FOREIGN KEY (numMaquina) REFERENCES Maquina (numero)
);

// adicionar coluna
ALTER TABLE servico
ADD COLUMN dataFim datetime DEFAULT now()

//alterar o nome da coluna
ALTER TABLE servico
CHANGE dataFim dataTermino datetime DEFAULT now()

//meter mais de uma pk ao alterar table
alter table servico add CONSTRAINT PK_SERVICO PRIMARY KEY (`codFatura`,`numMaquina`)