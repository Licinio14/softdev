-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 29-Jan-2025 às 10:00
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
-- Banco de dados: `laraveldb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cache`
--

CREATE TABLE `cache` (
  `key` varchar(255) NOT NULL,
  `value` mediumtext NOT NULL,
  `expiration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cache_locks`
--

CREATE TABLE `cache_locks` (
  `key` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `expiration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `connection` text NOT NULL,
  `queue` text NOT NULL,
  `payload` longtext NOT NULL,
  `exception` longtext NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `flights`
--

CREATE TABLE `flights` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `number` int(11) NOT NULL,
  `model` varchar(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `departure` datetime NOT NULL,
  `passengers` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gifts`
--

CREATE TABLE `gifts` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `costs` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `gifts`
--

INSERT INTO `gifts` (`id`, `name`, `price`, `user_id`, `costs`) VALUES
(1, 'Chocolates', 4.99, 2, 4.99),
(2, 'Livro de Laravel', 12.99, 1, 9.99);

-- --------------------------------------------------------

--
-- Estrutura da tabela `jobs`
--

CREATE TABLE `jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `queue` varchar(255) NOT NULL,
  `payload` longtext NOT NULL,
  `attempts` tinyint(3) UNSIGNED NOT NULL,
  `reserved_at` int(10) UNSIGNED DEFAULT NULL,
  `available_at` int(10) UNSIGNED NOT NULL,
  `created_at` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `job_batches`
--

CREATE TABLE `job_batches` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `total_jobs` int(11) NOT NULL,
  `pending_jobs` int(11) NOT NULL,
  `failed_jobs` int(11) NOT NULL,
  `failed_job_ids` longtext NOT NULL,
  `options` mediumtext DEFAULT NULL,
  `cancelled_at` int(11) DEFAULT NULL,
  `created_at` int(11) NOT NULL,
  `finished_at` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '0001_01_01_000000_create_users_table', 1),
(2, '0001_01_01_000001_create_cache_table', 1),
(3, '0001_01_01_000002_create_jobs_table', 1),
(4, '2025_01_21_155922_create_flights_table', 1),
(5, '2025_01_21_162547_create_tasks_table', 1),
(6, '2025_01_21_164233_add_address_to_users_table', 2),
(7, '2025_01_27_201054_create_gifts_table', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `password_reset_tokens`
--

CREATE TABLE `password_reset_tokens` (
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sessions`
--

CREATE TABLE `sessions` (
  `id` varchar(255) NOT NULL,
  `user_id` bigint(20) UNSIGNED DEFAULT NULL,
  `ip_address` varchar(45) DEFAULT NULL,
  `user_agent` text DEFAULT NULL,
  `payload` longtext NOT NULL,
  `last_activity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `sessions`
--

INSERT INTO `sessions` (`id`, `user_id`, `ip_address`, `user_agent`, `payload`, `last_activity`) VALUES
('x5NYDwTj1AXtMnfqjGdWGTU9HRZJ7MBp3ZxomwB0', NULL, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36', 'YTozOntzOjY6Il90b2tlbiI7czo0MDoiSk44YUd1RDMwRDN1MmJxSThBSGpIZENhZVN4UHdyUFYwa01QRUJjaSI7czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6MjY6Imh0dHA6Ly8xMjcuMC4wLjE6ODAwMC9ob21lIjt9czo2OiJfZmxhc2giO2E6Mjp7czozOiJvbGQiO2E6MDp7fXM6MzoibmV3IjthOjA6e319fQ==', 1738082687);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tasks`
--

CREATE TABLE `tasks` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `due_at` date DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `tasks`
--

INSERT INTO `tasks` (`id`, `name`, `description`, `due_at`, `status`, `created_at`, `updated_at`, `user_id`) VALUES
(5, 'exemplo1', 'descrição1', '0000-00-00', 0, '2025-01-28 10:38:38', NULL, 1),
(6, 'exemplo2', 'descrição2', '0000-00-00', 0, '2025-01-28 10:38:38', NULL, 1),
(7, 'exemplo3', 'descrição3', '0000-00-00', 1, '2025-01-28 10:38:38', NULL, 2),
(8, 'exemplo4', 'descrição4', '0000-00-00', 0, '2025-01-28 10:38:38', NULL, 2),
(9, 'exemplo5', 'descrição5', '0000-00-00', 0, '2025-01-28 10:38:38', NULL, 1),
(10, 'fazer formulario', 'ferag rg aerga erg', '2025-01-31', NULL, NULL, NULL, 1),
(11, 'fazer formulario', 'ferag rg aerga erg', '2025-01-31', 0, '2025-01-28 15:22:04', NULL, 1),
(12, 'desenhar o site', 'far gaerg earg aer ge', '2025-01-31', 0, '2025-01-28 15:22:18', NULL, 2),
(13, 'desenhar site', 'feawf earf afewe f', '2025-01-31', 0, '2025-01-28 15:22:52', NULL, 2),
(14, 'desenhar site', 'feawf earf afewe f', '2025-01-31', 0, '2025-01-28 15:24:31', NULL, 2),
(15, 'acabar o projeto', 'este e um teste para ver se funciona o id', '2025-01-31', 0, '2025-01-28 15:29:58', NULL, 1),
(16, 'acabar o projeto', 'este e um teste para ver se funciona o id', '2025-01-31', 0, '2025-01-28 15:30:19', NULL, 11),
(17, 'acabar o projeto', 'este e um teste para ver se funciona o id', '2025-01-31', 0, '2025-01-28 15:31:03', NULL, 11),
(18, 'Aprender ingles', 'dea earg regregseg', '2025-02-06', 0, '2025-01-28 15:33:31', NULL, 1),
(19, 'Aprender ingles', 'dea earg regregseg', '2025-02-06', 0, '2025-01-28 15:34:18', NULL, 1),
(20, 'Aprender ingles', 'dea earg regregseg', '2025-02-06', 0, '2025-01-28 15:34:40', NULL, 1),
(21, 'Aprender ingles', 'dea earg regregseg', '2025-02-06', 0, '2025-01-28 15:35:02', NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL DEFAULT 'rua da pessoa em questao',
  `nif` varchar(255) DEFAULT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `address`, `nif`, `email_verified_at`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'Licinio', 'l@gmail.com', 'Rua nova atualizada', '147852369', '2025-01-28 16:44:29', '1234', NULL, NULL, '2025-01-28 16:44:29'),
(2, 'Marta', 'marta123@gmail.com', 'rua da pessoa em questao', '789654123', NULL, '5678', NULL, NULL, '2025-01-28 16:23:58'),
(5, 'Mario', 'mario@gmail.com', 'Rua qualquer uma v1', '789456123', NULL, 'qwerty', NULL, '2025-01-28 10:43:15', NULL),
(6, 'Catarina', 'cat@gmail.com', 'Rua qualquer uma v1', '719456123', NULL, 'qwerty', NULL, '2025-01-28 10:43:15', NULL),
(7, 'Maria', 'maria@gmail.com', 'Rua qualquer uma v1', '729456123', NULL, 'qwerty', NULL, '2025-01-28 10:43:15', NULL),
(8, 'Antonio', 'anto@gmail.com', 'Rua qualquer uma v1', '739456123', NULL, 'qwerty', NULL, '2025-01-28 10:43:15', NULL),
(9, 'Marelena', 'marelena@gmail.com', 'Rua qualquer uma v1', '749456123', NULL, 'qwerty', NULL, '2025-01-28 10:43:15', NULL),
(10, 'Mariana', 'mariana@gmail.com', 'Rua qualquer uma v1', '759456123', NULL, 'qwerty', NULL, '2025-01-28 10:43:15', NULL),
(11, 'Mario', 'teste@gmail.com', 'rua tras dos montes de cima', NULL, NULL, '$2y$12$O07RF.L2WSld554bENYFcuhBHp38cMdrlAyPgna2DNiUNlo04..hq', NULL, NULL, NULL),
(12, 'Ana', 'axassad@gmail.com', 'fergsregrg areg argag r', NULL, NULL, '$2y$12$kKYPdHVnP9RAMBdLsKg78e7OqeYr3U/DD5R28kLn5mffznk6XbMoO', NULL, NULL, NULL),
(13, 'Mario', 'fge@fese.com', 'fgarg aerg arg', NULL, NULL, '$2y$12$gjz3RORfDo28VDMzfAuS3.RqKiTOlEQrLD6.pyFb755NmkhNmnjoe', NULL, NULL, NULL),
(14, 'Mario', 'fefht@gmail.com', 'g reg rg serg', NULL, NULL, '$2y$12$D5mEqcHwRUu0CtayjhHvveyKEbpyGY.Od8XLFPlN988SHI39zRXQS', NULL, NULL, NULL),
(15, 'feafae', 'feafae@gmail.com', 'fgaer reag earg er', NULL, NULL, '$2y$12$Rx.4IzVMwgSExWDdQ8KCweOUepg1MYG8Uwd4NKUdExifFofd7Vome', NULL, NULL, NULL),
(16, 'foi mudificado', 'mudificado@gmail.com', 'Rua mudificada', NULL, NULL, '$2y$12$8n.U4hRW0Sr839wjvy.1z.k9zkzM.3XrhYCNcXgh6I1WhZnF4Kv3G', NULL, NULL, '2025-01-28 16:24:33'),
(17, 'foi mudificado', 'mfeawfea@gmail.com', 'Rua mudificada', NULL, NULL, '$2y$12$z3fW3H.nwDMTtJno6Xhgy.XzACiIjvogu/ZQKZ2LpiBADwjs70pg2', NULL, NULL, '2025-01-28 16:34:47');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cache`
--
ALTER TABLE `cache`
  ADD PRIMARY KEY (`key`);

--
-- Índices para tabela `cache_locks`
--
ALTER TABLE `cache_locks`
  ADD PRIMARY KEY (`key`);

--
-- Índices para tabela `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`);

--
-- Índices para tabela `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `gifts`
--
ALTER TABLE `gifts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gifts_user_id_foreign` (`user_id`);

--
-- Índices para tabela `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jobs_queue_index` (`queue`);

--
-- Índices para tabela `job_batches`
--
ALTER TABLE `job_batches`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `password_reset_tokens`
--
ALTER TABLE `password_reset_tokens`
  ADD PRIMARY KEY (`email`);

--
-- Índices para tabela `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sessions_user_id_index` (`user_id`),
  ADD KEY `sessions_last_activity_index` (`last_activity`);

--
-- Índices para tabela `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tasks_user_id_foreign` (`user_id`);

--
-- Índices para tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `flights`
--
ALTER TABLE `flights`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `gifts`
--
ALTER TABLE `gifts`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `gifts`
--
ALTER TABLE `gifts`
  ADD CONSTRAINT `gifts_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
