
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

Alter TABLE empregado ADD CONSTRAINT FK_FOREIGN_EMPREGADO FOREIGN KEY (chefe) REFERENCES empregado (numEmp);


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
    k: mostra o nome do empregado e do chefe onde o salario do empregado for superior ou igual a 2 vezes o do chefe
    l: mostra a informação do empregados que estao nos postos 20, 30 e 40
    m: mostra o nome da secção e a cidade, onde tem empregados na base de dados
    n: mostra a soma do salario do empregado vezes 14 mais 0.5 do salario vezes 12 onde o posto do empregado é Engenheiro, ou programagor
    o: mostra a quantidade de empregados agrupado por secção com o nome da coluna num_emp
    p: mostra a soma do salario, com o nome salario_tot, agrupado por secção
    q: mostra o posto e a contagem de empregados, com o nome num_emp, agrupado por postos
    r: mostra o posto e a media de salario agrupado por posto com o nome num_emp
    s: mostra o posto e o salario maximo encontrado em cada posto, com o nome max_salario
    t: mostra os postos e a contagem de empregados, com o nome num_emp, agrupado por posto onde tenha mais de um empregados
    u: mostra o posto e a media de salario dos empregados, agrupados por posto que tenha mais de 1 empregado


*/


ex5:

CREATE TABLE Cliente (
	id int AUTO_INCREMENT,
    nome varchar(50) not null,
    morada varchar(250),
    estado bit,
    CONSTRAINT PK_CLIENTE PRIMARY KEY (id)
);

CREATE TABLE Produto (
	id int AUTO_INCREMENT,
    descricao varchar(100) not null,
    preco numeric(10,2),
    CONSTRAINT PK_PRODUTO PRIMARY KEY (id)
);

CREATE TABLE Venda (
  	prod int,
  	idCliente int,
    `data` datetime,
    qtd int,
    CONSTRAINT PK_VENDA PRIMARY KEY (prod, idCliente,`data`),
    CONSTRAINT PK_FOREIGN_CLIENTE FOREIGN KEY (idCliente) REFERENCES Cliente (id),
    CONSTRAINT PK_FOREIGN_PRODUTO FOREIGN KEY (prod) REFERENCES Produto (id)
);

INSERT INTO cliente (nome, morada, estado) VALUES ('Helena Monteiro','Perafita-Freixieiro',1),('Raul Simas','Palmela',0);

INSERT INTO Produto (descricao, preco) VALUES ('Rato Logitec XPTO 1',10),('Monitor Sony Vaio XPTO',120);

INSERT INTO Venda (idCliente, prod, qtd, data) VALUES (1,1,1,'2012-04-05'),(2,1,5,'2012-04-05');

UPDATE venda SET qtd = 10 where idCliente = 2;

UPDATE cliente SET morada = 'Porto' where nome like 'Raul%';

UPDATE produto set preco = 100 where id = 2;

SELECT c.nome, v.prod, v.qtd, v.data FROM venda v INNER JOIN cliente c ON v.idCliente = c.id where c.nome like 'Raul Simas';

SELECT c.nome, v.prod, v.qtd, v.data FROM venda v INNER JOIN cliente c ON v.idCliente = c.id where c.nome like 'H%';

SELECT c.nome, COUNT(v.prod) FROM venda v INNER JOIN cliente c ON v.idCliente = c.id where c.nome like 'Raul Simas';

select c.nome from cliente c LEFT JOIN venda v on c.id = v.idCliente where v.idCliente is null;

select v.`data`, sum(p.preco * v.qtd) as vendaDiaria From venda v INNER JOIN produto p on v.prod = p.id GROUP BY v.`data`;



____________________________________________________________________________________________________________________________________________________________________________________________________________________

ex6:

use DATABASE licinio_encomendas;

CREATE TABLE Cliente (
	codCliente int not null AUTO_INCREMENT,
    nome varchar(50) NOT null,
    morada varchar(100) not null,
    telef varchar(20),
    CONSTRAINT PK_CLIENTE PRIMARY KEY (codCliente)
);

CREATE TABLE Produto (
	codProduto int not null AUTO_INCREMENT,
    descricao varchar(250) not null,
    preco decimal(10,8) not null,
    obs varchar(100),
    CONSTRAINT PK_PRODUTO PRIMARY KEY (codProduto)
);

Alter TABLE produto MODIFY preco decimal(10,2)

CREATE TABLE Encomenda (
	codEncomenda int not null AUTO_INCREMENT,
    codCliente int not null,
    `data` date,
    CONSTRAINT PK_ENCOMENDA PRIMARY KEY (codEncomenda),
    CONSTRAINT PK_FOREIGN_CLIENTE FOREIGN KEY (codCliente) REFERENCES Cliente (codCliente)
);

CREATE TABLE LinhaEncomenda (
	codEncomenda int not null,
    codProduto int not null,
    quantidade int not null,
    desconto int,
    CONSTRAINT PK_LINHAENCOMENDA PRIMARY KEY (codEncomenda, codProduto),
    CONSTRAINT FK_LINHAENCOMENDA_CODPRODUTO FOREIGN KEY (codProduto) REFERENCES produto (codProduto),
    CONSTRAINT FK_LINHAENCOMENDA_CODENCOMENDA FOREIGN KEY (codEncomenda) REFERENCES Encomenda (codEncomenda)
);

INSERT INTO cliente (nome, morada, telef) VALUES
('Licinio', 'Rua da esquina','123456789'),
('Fabio', 'Rua da outra esquina', '123456789'),
('Maria', 'Rua da esquina da outra esquina', '123456789');

INSERT INTO produto (descricao, preco) VALUES
('Portatil', 1999.99),
('teclado',99.95),
('monitor',149.99);

INSERT INTO encomenda (codCliente,`data`) VALUES
(1,'2024-12-20'),
(1,'2024-06-01'),
(2,'2024-09-09');

INSERT INTO linhaencomenda (codEncomenda,codProduto,quantidade) VALUES
(1,4,25),
(1,5,25),
(2,6,1);

SELECT * from cliente WHERE morada like 'rua da e%' ORDER BY nome;

SELECT * from produto where descricao like 'martelo' order by preco

SELECT DISTINCT(e.`data`) from encomenda e INNER JOIN cliente c on e.codCliente = c.codCliente WHERE c.nome like 'Fabio'

SELECT sum(l.quantidade) as 'total de produtod', c.nome FROM encomenda e 
INNER JOIN cliente c on e.codCliente = c.codCliente
INNER JOIN linhaencomenda l on l.codEncomenda = e.codEncomenda
INNER JOIN produto p on p.codProduto = l.codProduto
WHERE c.codCliente = 1
GROUP BY c.codCliente

SELECT sum(l.quantidade) as 'total de produtod', c.nome, p.descricao FROM encomenda e 
INNER JOIN cliente c on e.codCliente = c.codCliente
INNER JOIN linhaencomenda l on l.codEncomenda = e.codEncomenda
INNER JOIN produto p on p.codProduto = l.codProduto
WHERE c.codCliente = 1
GROUP BY p.descricao

SELECT sum(p.preco * l.quantidade) as 'total por encomenda', e.codEncomenda FROM encomenda e 
INNER JOIN linhaencomenda l on e.codEncomenda = l.codEncomenda
INNER JOIN produto p on p.codProduto = l.codProduto
GROUP by e.codEncomenda

____________________________________________________________________________________________________________________________________________________________________________________________________________________


ex7:

create DATABASE licinio_Campeonato;

CREATE TABLE Equipas (
	id_equipa int AUTO_INCREMENT,
    nome varchar(50) not null UNIQUE,
    cidade varchar(50) not null,
    diretor varchar(50) not null,
  	CONSTRAINT PK_EQUIPAS PRIMARY KEY (id_equipa)
);

CREATE TABLE Treinadores (
	id_treinador int AUTO_INCREMENT,
    nome varchar(50) not null,
    idade int not null,
    telefone int not null,
  	CONSTRAINT PK_TREINADORES PRIMARY KEY (id_treinador)
);

CREATE TABLE Bolas (
	referencia int not null,
    id_equipa int not null,
    fabricante varchar(50) not null,
  	CONSTRAINT PK_BOLAS PRIMARY KEY (referencia),
    CONSTRAINT FK_BOLAS_EQUIPA FOREIGN KEY (id_equipa) REFERENCES equipas (id_equipa)
);

create TABLE Experiencias (
	id_equipa int not null,
    id_treinador int not null,
    escalao varchar(20) not null,
    anos int not null,
    CONSTRAINT PK_EXPERIENCIAS PRIMARY KEY (id_equipa,id_treinador,escalao),
    CONSTRAINT FK_EXPERIENCIAS_EQUIPAS FOREIGN KEY (id_equipa) REFERENCES Equipas (id_equipa),
    CONSTRAINT FK_EXPERIENCIAS_TREINADORES FOREIGN KEY (id_treinador) REFERENCES treinadores (id_treinador)
);

