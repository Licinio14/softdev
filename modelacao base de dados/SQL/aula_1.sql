
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


______________________________________________________________________________________________________________________________________________________________________________________________________________________________




day 3:

create table Cliente(
    idCliente int AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50),
    cidade varchar(50),
    codPostal int,
    cc int unique not null
);

CREATE TABLE Venda(
	idVenda int AUTO_INCREMENT PRIMARY KEY,
    idCliente int,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
	data datetime,
    desconto decimal(5,2)
);

Create table Artigo(
	idArtigo int AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50),
    preco decimal(10,2),
    categoria varchar(20)
);

create table LinhaVenda(
	idVenda int,
    FOREIGN KEY (idVenda) REFERENCES Venda(idVenda),
    idArtigo int,
    FOREIGN KEY (idArtigo) REFERENCES Artigo(idArtigo),
    quantidade int,
    PRIMARY KEY (idVenda, idArtigo)
);




insert into Cliente (nome, cidade, codPostal, cc) VALUES
	('Ana', 'Maia', 4567, 123),
    ('Bruno','Porto', 4200, 456),
    ('Miguel', 'Porto', 4200,789),
    ('Maria', 'Maia',4567,234),
    ('Joana','Maia',4567,678);
    
insert into Artigo (nome, preco, categoria) values
	('Martelo', 5.5,'Ferramentas'),
    ('Parafuso', 0.5, 'Ferramentas'),
    ('Prego',0.2,'Ferramentas'),
    ('Lampada',1.5,'Electricidade'),
    ('Tripla',5.5,'Electricidade');

insert into Venda (idCliente, data, desconto) VALUES
	(1,'2021-03-29',0.05),
    (1,'2021-03-31', 0.20),
    (2,'2021-03-29', 0.5),
    (4, '2021-03-29', 0.5);
    
INSERT into LinhaVenda (idVenda, idArtigo, quantidade) VALUES
	(1,1,2),
    (1,3,10),
    (2,2,20),
    (3,3,100),
    (4,1,5);


-- adicionar informacao de outro campo ao campo mostrado (fica na mesma coluna)
SELECT c.nome FROM Cliente c
UNION
SELECT a.nome FROM Artigo a



-- equi joins: usa o and no where

SELECT * from servico, maquina, tipomaquina where servico.numMaquina = maquina.numero and maquina.idTipo = tipomaquina.id
SELECT maquina.numero, tipomaquina.nome, servico.codFatura, servico.valor from servico, maquina, tipomaquina where servico.numMaquina = maquina.numero and maquina.idTipo = tipomaquina.id

SELECT servico.numMaquina, sum(servico.valor) as total, tipomaquina.nome
from servico, tipomaquina, maquina
WHERE servico.numMaquina = maquina.numero and maquina.idTipo = tipomaquina.id
GROUP by servico.numMaquina
ORDER by total desc
    --dar "nome" as tabelas para escrever menos
SELECT s.numMaquina, sum(s.valor) as total, t.nome
from servico s, tipomaquina t, maquina m
WHERE s.numMaquina = m.numero and m.idTipo = t.id and m.numero = 102
GROUP by s.numMaquina
ORDER by total desc

-- INNER JOIN tabela ON campo = tabela.campo

SELECT *
FROM maquina m
INNER JOIN tipomaquina tm
ON m.idTipo = tm.id
    -- pode-se escrever apenas JOIN sem o INNER
SELECT s.numMaquina, sum(s.valor) as total, t.nome
from servico s
INNER JOIN maquina m
on s.numMaquina = m.numero
INNER JOIN tipomaquina t
ON m.idTipo = t.id 
WHERE m.numero = 102
GROUP by s.numMaquina
ORDER by total desc


-- Full Join -> apresenta todos os dados, mesmo com null e sem relações

-- left join -> mostra os que nao tem relação da tabela maquina com a tipomaquina
SELECT *
FROM maquina m
left JOIN tipomaquina tm
ON m.idTipo = tm.id

    -- mostra apenas as que nao tem relação da tabema maquina com a outra
SELECT *
FROM maquina m
left JOIN tipomaquina tm
ON m.idTipo = tm.id
WHERE m.id = null







____________________________________________________________________________________________________________________________________________________________________________________________________________________


ex 1:

CREATE TABLE Seccao(
	numSec int,
    nome varchar(50) not null,
    cidade varchar(20) not null,
    CONSTRAINT PK_SECCAO PRIMARY KEY (numSec)
);

CREATE TABLE Empregado(
	numEmp int,
    nome varchar(50) not null,
    numSeccao int not null,
    posto varchar(20) not null,
    chefe int null,
    salario numeric(8,2) not null,
    comissao INT not null,
    CONSTRAINT PK_EMPREGADO PRIMARY KEY (numEmp),
    CONSTRAINT FK_SECCAO_NUMSECCAO FOREIGN KEY (numSeccao) REFERENCES Seccao (numSec)
);

ALTER TABLE empregado
MODIFY numEmp int AUTO_INCREMENT;

-- para o auto incremente começar em 10
-- ALTER TABLE seccao AUTO_INCREMENT = 10;

INSERT INTO seccao (numsec, nome, cidade) VALUES
	(10,'Fabrico','Porto'),
    (20,'Comercial','Porto'),
    (30,'Marketing','Braga'),
    (40,'Planeamento','Guimarães'),
    (50,'Administração','Porto'),
    (60,'Informática','Braga'),
    (70,'Recursos Humanos', 'Guimarães');


INSERT INTO empregado (nome, numseccao, posto, chefe, salario, comissao) VALUES
	('Ana',10,'Programador',3,3000,10),
    ('Nuno',70,'Engenheiro',1,1500,40),
    ('Álvaro',50,'Administrador',null,2500,0),
    ('António',10,'Engenheiro',3,1450,20),
    ('Susana',20,'Administrador',null,2750,30),
    ('Cláudio',60,'Vendedor',4,1000,50);


/* respostas:
4
    a: mostra o nome e a cidade da seccao numero 70
    b: mostra o posto, salario e comissao do empregado que tem a comisao maior que o salario
    c: mostra o nome das seccoes da cidade do Porto
    d: mostra o nome, salario e comissao do empregado com o salario igual a 2000 ou superior ou igual a 20x a comissao dele
    e: mostra todos os postos diferentes existentes na tabela empregado
    f: mostra o nome, posto e salario onde a seccao é diferente de 70 e ordena por ordem descendente o posto e depois o salario
    g: mostra o nome do empregado onde a seccao dele nao pertence ao resultado de seccoes pertencentes ao porto
    h: mostra o nome dos empregados começados e acabados em 'a'
    i: mostra o nome, salario do empregado e o nome, salario do chefe dele quando o salario do chefe é menor que o do empregado
    j: mostra o nome dos empregados que nao estao na seccao 10, mas tem o mesmo posto dos que estao na seccao 10 
    k: 

*/