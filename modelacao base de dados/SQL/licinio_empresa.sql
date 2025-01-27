-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 27-Jan-2025 às 13:55
-- Versão do servidor: 10.4.32-MariaDB
-- versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `licinio_empresa`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `empregado`
--

CREATE TABLE `empregado` (
  `numEmp` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `numSeccao` int(11) NOT NULL,
  `posto` varchar(20) NOT NULL,
  `chefe` int(11) DEFAULT NULL,
  `salario` decimal(8,2) NOT NULL,
  `comissao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `empregado`
--

INSERT INTO `empregado` (`numEmp`, `nome`, `numSeccao`, `posto`, `chefe`, `salario`, `comissao`) VALUES
(1, 'Ana', 10, 'Programador', 3, 3000.00, 10),
(2, 'Nuno', 70, 'Engenheiro', 1, 1500.00, 40),
(3, 'Álvaro', 50, 'Administrador', NULL, 2500.00, 0),
(4, 'António', 10, 'Engenheiro', 3, 1450.00, 20),
(5, 'Susana', 20, 'Administrador', NULL, 2750.00, 30),
(6, 'Cláudio', 60, 'Vendedor', 4, 1000.00, 50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `seccao`
--

CREATE TABLE `seccao` (
  `numSec` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cidade` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `seccao`
--

INSERT INTO `seccao` (`numSec`, `nome`, `cidade`) VALUES
(10, 'Fabrico', 'Porto'),
(20, 'Comercial', 'Porto'),
(30, 'Marketing', 'Braga'),
(40, 'Planeamento', 'Guimarães'),
(50, 'Administração', 'Porto'),
(60, 'Informática', 'Braga'),
(70, 'Recursos Humanos', 'Guimarães');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `empregado`
--
ALTER TABLE `empregado`
  ADD PRIMARY KEY (`numEmp`),
  ADD KEY `FK_SECCAO_NUMSECCAO` (`numSeccao`);

--
-- Índices para tabela `seccao`
--
ALTER TABLE `seccao`
  ADD PRIMARY KEY (`numSec`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `empregado`
--
ALTER TABLE `empregado`
  MODIFY `numEmp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `seccao`
--
ALTER TABLE `seccao`
  MODIFY `numSec` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `empregado`
--
ALTER TABLE `empregado`
  ADD CONSTRAINT `FK_SECCAO_NUMSECCAO` FOREIGN KEY (`numSeccao`) REFERENCES `seccao` (`numSec`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
