
-- youtube Augusto Galego
-- godot, gamemaker

-- crear as tabelas do ex1

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

-- adicionar coluna
-- "DEFAULT now()" -> serve para colucar a data atual no tempo de inserção de dados
ALTER TABLE servico
ADD COLUMN dataFim datetime DEFAULT now()

-- alterar o nome da coluna
ALTER TABLE servico
CHANGE dataFim dataTermino datetime DEFAULT now()

-- meter mais de uma pk ao alterar table
alter table servico add CONSTRAINT PK_SERVICO PRIMARY KEY (`codFatura`,`numMaquina`)


____________________________________________________________________________________________________________________________________________________________________________________________________________________



day 2:


insert into `tipoMaquina` (name) VALUES ('Lavar'),('Secar'),('Lavar/Secar');

insert into `tipoMaquina` (id, name) VALUES (null,'Lavar'),(101,'Secar'),(1001,'Lavar/Secar');

INSERT into `maquina` (idTipo, dataUltimaManut) VALUES (1,'2025-01-24 10:30'),(1,'2025-01-20 14:20'),(2,'2025-02-05 16');

DELETE from `tipoMaquina` where id = 1001;

INSERT into `tipomaquina` VALUES (null, "x")

DELETE FROM tipomaquina WHERE id > 3;

DELETE FROM tipomaquina WHERE id = 4 or id = 101 or id = 1002;

update tipomaquina set id = 7 where id = 3;


-- select's:

select * from servico;

select * from servico limit 2000;

-- numero inicial, numero final
select * from servico limit 50, 150; 

select * from servico WHERE valor <= 10;

SELECT * FROM `servico` WHERE valor > 10 AND valor < 15;

-- inclui os valores
SELECT * FROM `servico` where valor BETWEEN 8.5 and 15

-- nao inclui os valores referidos
SELECT * FROM `servico` WHERE valor not BETWEEN 10 and 15;
SELECT * FROM `servico` WHERE not (valor BETWEEN 10 and 15);

SELECT * FROM `servico` WHERE valor = 8.50 or valor = 10.80;
SELECT * FROM `servico` WHERE valor in (8.50,10.80);

SELECT * FROM `servico` WHERE valor not in (8.50,10.80);

-- para strings
SELECT * FROM `tipomaquina` WHERE nome = 'lava';
SELECT * FROM `tipomaquina` WHERE nome like 'lava';

-- "lava" e pode ter mais coisas para a frente
SELECT * FROM `tipomaquina` WHERE nome like 'lava%';

-- "lav" e qualquer caracter no siteo do "_"
SELECT * FROM `tipomaquina` WHERE nome like 'lav_';

-- da para juntar os dois
SELECT * FROM `tipomaquina` WHERE nome like 'lav_%';

-- nos selects nao interessa acentos ou M - m

-- ordenar desc // asc ja é default
SELECT * FROM `maquina` ORDER by `dataUltimaManut` DESC

-- sem null
SELECT * FROM `maquina` where `dataUltimaManut` is not null ORDER BY `dataUltimaManut` DESC

-- mais de uma ordenação
SELECT * FROM `maquina` where `dataUltimaManut` is not null ORDER BY `dataUltimaManut` DESC, `numero` asc;

SELECT * FROM `maquina` where `dataUltimaManut` BETWEEN '2025-01-01' and '2025-01-31 23:59:59.999' ORDER BY `dataUltimaManut`

-- filtrar datas
SELECT * FROM `maquina` where `dataUltimaManut` < DATE_ADD(CURRENT_DATE(), INTERVAL -30 DAY)

where dataUltimaManut < (NOW() - INTERVAL 30 DAY)

WHERE DATE(dataUltimaManut) <= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)

SELECT * FROM `maquina`
WHERE DATEDIFF(CURDATE(), `dataUltimaManut`) >= 30
order by dataUltimaManut DESC

WHERE `dataUltimaManut` <= DATE_SUB(NOW(), INTERVAL30DAY)

-- retorna o valor de linhas encontradas
SELECT count(*) FROM `maquina` 
-- nao conta os null da coluna
SELECT count( `dataUltimaManut` ) FROM `maquina` 

-- fazer contas entre campos da tabela
SELECT `numero` + `idTipo` FROM maquina

-- da o nome de soma a coluna da tabela
SELECT `numero` + `idTipo` as soma FROM maquina
SELECT `numero` + `idTipo` as 'soma exemplo com espaços' FROM maquina

-- da para mudar o nome das colunas ja existentes na amostra
SELECT numero as 'número',`numero` + `idTipo` as soma FROM maquina

-- para sumar o total de um campo entre 1 mes
SELECT sum(valor) FROM `servico` where `dataHora` BETWEEN '2024-01-01' and '2024-01-31 23:59:59.999';

-- funçoes basicas
SELECT min(valor) FROM `servico`
SELECT max(valor) FROM `servico`
SELECT avg(valor) FROM `servico`

-- para aparecer 2 casa
SELECT format(avg(valor),2) FROM `servico`

-- concatenar o valor com uma string
SELECT concat(format(avg(valor),2), '€') FROM `servico`

-- apenas aparece os valores diferentes
SELECT DISTINCT `valor` FROM `servico`
