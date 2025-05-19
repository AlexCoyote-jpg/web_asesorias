-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2025 a las 05:11:34
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `asesorias_web`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id_alumno` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `matricula` varchar(20) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `programa` enum('ICC','LCC','ITI') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id_alumno`, `nombre`, `matricula`, `contrasena`, `programa`) VALUES
(1, 'Juan Pérez', 'A12345678', 'pwdJuan123', 'ICC'),
(2, 'María López', 'A87654321', 'pwdMaria456', 'LCC'),
(3, 'Luis Martínez', 'A11223344', 'pwdLuis789', 'ITI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asesorias`
--

CREATE TABLE `asesorias` (
  `id_asesoria` int(11) NOT NULL,
  `alumno_id` int(11) NOT NULL,
  `profesor_id` int(11) NOT NULL,
  `materia` varchar(100) NOT NULL,
  `es_tu_docente` tinyint(1) NOT NULL DEFAULT 0,
  `fecha_solicitud` date NOT NULL,
  `hora_solicitud` time NOT NULL,
  `asunto` text NOT NULL,
  `estado` enum('en proceso','aceptada','denegada') NOT NULL DEFAULT 'en proceso',
  `comentario` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `asesorias`
--

INSERT INTO `asesorias` (`id_asesoria`, `alumno_id`, `profesor_id`, `materia`, `es_tu_docente`, `fecha_solicitud`, `hora_solicitud`, `asunto`, `estado`, `comentario`) VALUES
(1, 1, 1, 'Programación Web', 1, '2025-05-20', '10:00:00', 'Dudas sobre Servlets', 'en proceso', NULL),
(2, 2, 2, 'Estructura de Datos', 0, '2025-05-18', '14:30:00', 'Repaso de árboles binarios', 'aceptada', 'Nos vemos en el laboratorio 3'),
(3, 3, 1, 'Bases de Datos', 1, '2025-05-19', '09:00:00', 'Consultas JOIN complejas', 'denegada', 'Horario ocupado, intente otra fecha');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `id_profesor` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `clave_profesor` varchar(20) NOT NULL,
  `contrasena` varchar(100) NOT NULL DEFAULT 'cambiar123',
  `programa` enum('ICC','LCC','ITI') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`id_profesor`, `nombre`, `clave_profesor`, `contrasena`, `programa`) VALUES
(1, 'Dra. Beatriz Beltrán', 'P1001', 'cambiar123', 'ICC'),
(2, 'Dr. Mario Rossainz', 'P1002', 'cambiar123', 'LCC');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id_alumno`),
  ADD UNIQUE KEY `matricula` (`matricula`);

--
-- Indices de la tabla `asesorias`
--
ALTER TABLE `asesorias`
  ADD PRIMARY KEY (`id_asesoria`),
  ADD KEY `alumno_id` (`alumno_id`),
  ADD KEY `profesor_id` (`profesor_id`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id_profesor`),
  ADD UNIQUE KEY `clave_profesor` (`clave_profesor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id_alumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `asesorias`
--
ALTER TABLE `asesorias`
  MODIFY `id_asesoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `id_profesor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asesorias`
--
ALTER TABLE `asesorias`
  ADD CONSTRAINT `asesorias_ibfk_1` FOREIGN KEY (`alumno_id`) REFERENCES `alumnos` (`id_alumno`) ON UPDATE CASCADE,
  ADD CONSTRAINT `asesorias_ibfk_2` FOREIGN KEY (`profesor_id`) REFERENCES `profesores` (`id_profesor`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
