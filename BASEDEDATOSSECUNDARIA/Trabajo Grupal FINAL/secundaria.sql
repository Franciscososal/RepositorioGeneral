-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-09-2024 a las 06:08:26
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
-- Base de datos: `secundaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `ID_ALUMNO` int(11) NOT NULL,
  `ID_OFICINA` int(11) NOT NULL,
  `ID_CURSO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`ID_ALUMNO`, `ID_OFICINA`, `ID_CURSO`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE `asignaturas` (
  `ID_ASIGNATURA` int(11) NOT NULL,
  `Nombre_asignatura` varchar(50) DEFAULT NULL,
  `ID_DOCENTE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asignaturas`
--

INSERT INTO `asignaturas` (`ID_ASIGNATURA`, `Nombre_asignatura`, `ID_DOCENTE`) VALUES
(1, 'Lengua', 5),
(2, 'Lengua', 17),
(3, 'Lengua', 3),
(4, 'Matematica', 7),
(5, 'Matematica', 2),
(6, 'Matematica', 9),
(7, 'Biologia', 12),
(8, 'Biologia', 13),
(9, 'Historia', 1),
(10, 'Historia', 6),
(11, 'Historia', 9),
(12, 'Historia', 11),
(13, 'Geografia', 15),
(14, 'Geografia', 17),
(15, 'Quimica', 3),
(16, 'Quimica', 16),
(17, 'Fisica', 5),
(18, 'Fisica', 8),
(19, 'Fisica', 4),
(20, 'Educacion fisica', 2),
(21, 'Educacion fisica', 17),
(22, 'Educacion fisica', 14),
(23, 'Civica', 9),
(24, 'Civica', 10),
(25, 'Ingles', 7),
(26, 'Ingles', 13),
(27, 'Ingles', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `ID_CURSO` int(11) NOT NULL,
  `Año` int(11) DEFAULT NULL,
  `Division` int(11) DEFAULT NULL,
  `Turno` varchar(15) DEFAULT NULL,
  `Numero_Alumnos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`ID_CURSO`, `Año`, `Division`, `Turno`, `Numero_Alumnos`) VALUES
(1, 1, 1, 'Mañana', 2),
(2, 1, 2, 'Tarde', 3),
(3, 2, 1, 'Mañana', 2),
(4, 2, 2, 'Tarde', 2),
(5, 3, 1, 'Mañana', 2),
(6, 3, 2, 'Tarde', 3),
(7, 4, 1, 'Tarede', 2),
(8, 4, 2, 'Noche', 3),
(9, 5, 1, 'Tarde', 2),
(10, 5, 2, 'Noche', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_asignado`
--

CREATE TABLE `curso_asignado` (
  `ID_CURSO_ASIGNADO` int(11) NOT NULL,
  `ID_DOCENTE` int(11) NOT NULL,
  `ID_CURSO` int(11) NOT NULL,
  `Asignatura_asignada` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `curso_asignado`
--

INSERT INTO `curso_asignado` (`ID_CURSO_ASIGNADO`, `ID_DOCENTE`, `ID_CURSO`, `Asignatura_asignada`) VALUES
(1, 5, 1, 'Lengua'),
(2, 7, 1, 'Matematica'),
(3, 13, 1, 'Biologia'),
(4, 1, 1, 'Historia'),
(5, 17, 1, 'Geografia'),
(6, 3, 1, 'Quimica'),
(7, 5, 1, 'Fisica'),
(8, 2, 1, 'Educacion fisica'),
(9, 9, 1, 'Civica'),
(10, 6, 1, 'Ingles'),
(11, 3, 2, 'Lengua'),
(12, 2, 2, 'Matematica'),
(13, 12, 2, 'Biologia'),
(14, 9, 2, 'Historia'),
(15, 17, 2, 'Geografia'),
(16, 16, 2, 'Quimica'),
(17, 4, 2, 'Fisica'),
(18, 17, 2, 'Educacion fisica'),
(19, 10, 2, 'Civica'),
(20, 6, 2, 'Ingles'),
(21, 3, 3, 'Lengua'),
(22, 2, 3, 'Matematica'),
(23, 12, 3, 'Biologia'),
(24, 11, 3, 'Historia'),
(25, 15, 3, 'Geografia'),
(26, 16, 3, 'Quimica'),
(27, 5, 3, 'Fisica'),
(28, 2, 3, 'Educacion fisica'),
(29, 9, 3, 'Civica'),
(30, 13, 3, 'Ingles'),
(31, 17, 4, 'Lengua'),
(32, 9, 4, 'Matematica'),
(33, 12, 4, 'Biologia'),
(34, 11, 4, 'Historia'),
(35, 17, 4, 'Geografia'),
(36, 16, 4, 'Quimica'),
(37, 8, 4, 'Fisica'),
(38, 14, 4, 'Educacion fisica'),
(39, 9, 4, 'Civica'),
(40, 7, 4, 'Ingles'),
(41, 5, 5, 'Lengua'),
(42, 9, 5, 'Matematica'),
(43, 13, 5, 'Biologia'),
(44, 9, 5, 'Historia'),
(45, 15, 5, 'Geografia'),
(46, 3, 5, 'Quimica'),
(47, 4, 5, 'Fisica'),
(48, 14, 5, 'Educacion fisica'),
(49, 10, 5, 'Civica'),
(50, 13, 5, 'Ingles'),
(51, 5, 6, 'Lengua'),
(52, 9, 6, 'Matematica'),
(53, 13, 6, 'Biologia'),
(54, 9, 6, 'Historia'),
(55, 15, 6, 'Geografia'),
(56, 3, 6, 'Quimica'),
(57, 4, 6, 'Fisica'),
(58, 2, 6, 'Educacion fisica'),
(59, 9, 6, 'Civica'),
(60, 7, 6, 'Ingles'),
(61, 17, 7, 'Lengua'),
(62, 7, 7, 'Matematica'),
(63, 12, 7, 'Biologia'),
(64, 1, 7, 'Historia'),
(65, 17, 7, 'Geografia'),
(66, 16, 7, 'Quimica'),
(67, 4, 7, 'Fisica'),
(68, 17, 7, 'Educacion fisica'),
(69, 10, 7, 'Civica'),
(70, 7, 7, 'Ingles'),
(71, 3, 8, 'Lengua'),
(72, 2, 8, 'Matematica'),
(73, 13, 8, 'Biologia'),
(74, 1, 8, 'Historia'),
(75, 15, 8, 'Geografia'),
(76, 16, 8, 'Quimica'),
(77, 8, 8, 'Fisica'),
(78, 2, 8, 'Educacion fisica'),
(79, 9, 8, 'Civica'),
(80, 13, 8, 'Ingles'),
(81, 3, 9, 'Lengua'),
(82, 2, 9, 'Matematica'),
(83, 12, 9, 'Biologia'),
(84, 6, 9, 'Historia'),
(85, 15, 9, 'Geografia'),
(86, 3, 9, 'Quimica'),
(87, 8, 9, 'Fisica'),
(88, 14, 9, 'Educacion fisica'),
(89, 9, 9, 'Civica'),
(90, 6, 9, 'Ingles'),
(91, 17, 10, 'Lengua'),
(92, 9, 10, 'Matematica'),
(93, 12, 10, 'Biologia'),
(94, 11, 10, 'Historia'),
(95, 15, 10, 'Geografia'),
(96, 3, 10, 'Quimica'),
(97, 5, 10, 'Fisica'),
(98, 17, 10, 'Educacion fisica'),
(99, 10, 10, 'Civica'),
(100, 7, 10, 'Ingles');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE `docentes` (
  `ID_DOCENTE` int(11) NOT NULL,
  `ID_PERSONAL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`ID_DOCENTE`, `ID_PERSONAL`) VALUES
(1, 5),
(2, 6),
(3, 7),
(4, 8),
(5, 9),
(6, 10),
(7, 11),
(8, 12),
(9, 13),
(10, 14),
(11, 15),
(12, 16),
(13, 17),
(14, 18),
(15, 19),
(16, 20),
(17, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `ID_NOTA` int(11) NOT NULL,
  `ID_ALUMNO` int(11) NOT NULL,
  `ID_ASIGNATURA` int(11) NOT NULL,
  `1er_bimestre` varchar(30) DEFAULT NULL,
  `2do_bimestre` varchar(30) DEFAULT NULL,
  `1er_cuatrimestre` int(11) DEFAULT NULL,
  `3er_bimestre` varchar(30) DEFAULT NULL,
  `4to_bimestre` varchar(30) DEFAULT NULL,
  `2do_cuatrimestre` int(11) DEFAULT NULL,
  `1er_cierre` int(11) DEFAULT NULL,
  `2do_cierre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`ID_NOTA`, `ID_ALUMNO`, `ID_ASIGNATURA`, `1er_bimestre`, `2do_bimestre`, `1er_cuatrimestre`, `3er_bimestre`, `4to_bimestre`, `2do_cuatrimestre`, `1er_cierre`, `2do_cierre`) VALUES
(1, 1, 1, '5', '6', 5, '2', '6', 4, 4, 7),
(2, 1, 2, '7', '6', 6, '5', '5', 5, 5, 5),
(3, 1, 3, '8', '9', 8, '6', '10', 8, 8, 0),
(4, 1, 4, '10', '10', 10, '9', '10', 9, 9, 0),
(5, 1, 5, '4', '6', 5, '9', '6', 7, 6, 0),
(6, 1, 6, '6', '5', 5, '7', '7', 7, 6, 0),
(7, 1, 7, '9', '10', 9, '8', '8', 8, 8, 0),
(8, 1, 8, '7', '5', 6, '6', '8', 7, 6, 0),
(9, 1, 9, '6', '6', 6, '5', '4', 4, 5, 8),
(10, 1, 10, '8', '8', 8, '7', '7', 7, 7, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oficina_de_alumnos`
--

CREATE TABLE `oficina_de_alumnos` (
  `ID_OFICINA` int(11) NOT NULL,
  `Nombre_completo` varchar(100) DEFAULT NULL,
  `Edad` int(11) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Correo_electronico` varchar(100) DEFAULT NULL,
  `DNI` int(11) NOT NULL,
  `Fecha_nacimiento` date DEFAULT NULL,
  `Nombre_tutor_responsable` varchar(100) DEFAULT NULL,
  `Telefono_tutor_responsable` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `oficina_de_alumnos`
--

INSERT INTO `oficina_de_alumnos` (`ID_OFICINA`, `Nombre_completo`, `Edad`, `Direccion`, `Correo_electronico`, `DNI`, `Fecha_nacimiento`, `Nombre_tutor_responsable`, `Telefono_tutor_responsable`) VALUES
(1, 'Federico Santos', 12, 'Monte Castro 3600', 'fedesanto@gmail.com', 51056896, '2012-03-17', 'Maria Santos', 11030417),
(2, 'Joaquin Ledesma', 17, 'Baigorria 4523', 'joacolesma@gmail.com', 47321643, '2007-01-10', 'Pedro Alfonso Ledesma', 11245578),
(3, 'Lucas Santos', 15, 'Monte Castro 3600', 'lucascrack@hotmail.com', 49567312, '2009-08-02', 'Maria Santos', 11030417),
(4, 'Lucia Leanza', 18, 'New York 8894', 'lulilanza@gmail.com', 46424411, '2006-07-13', 'Tiziano Leanza', 11432212),
(5, 'Macarena Rivero', 14, 'Quevedo 4512', 'Macuriv@hotmail.com', 49314545, '2010-01-16', 'Juan Rivero', 11798134),
(6, 'Francisco Pecile', 13, 'Benitos Juarez 5327', 'skibiditoilet@gmail.com', 50321718, '2011-05-04', 'Esteban Peñaloza', 11245816),
(7, 'Damian Fontan', 17, 'Hawai 3076', 'damifon@gmail.com', 47873539, '2007-09-15', 'Yazmin Fontan', 117659403),
(8, 'Marco Lozano', 15, 'Allende 1215', 'marcoooooo@hotmail.com', 49335549, '2009-05-30', 'Micaela Lozano', 11094328),
(9, 'Fatima Sosa', 16, 'Mercedes 5432', 'fatisosasosa@hotmail.com', 50809442, '2008-08-02', 'Tatiana Sosa', 11882431),
(10, 'Miguel Louro', 14, 'Naciones Unidas 1005', 'migueprocapocrack@gmail.com', 49835320, '2010-05-19', 'Mario Louro', 11222211),
(11, 'Manuel Louro', 14, 'Naciones Unidas 1005', 'manueprocapocrack@gmail.com', 49835321, '2010-05-19', 'Mario Louro', 11222211);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretaria`
--

CREATE TABLE `secretaria` (
  `ID_PERSONAL` int(11) NOT NULL,
  `Cargo` varchar(30) DEFAULT NULL,
  `Nombre_completo` varchar(100) DEFAULT NULL,
  `Edad` int(11) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Correo_electronico` varchar(100) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `DNI` int(11) NOT NULL,
  `Fecha_inicio` date DEFAULT NULL,
  `Ficha_censal` int(11) DEFAULT NULL,
  `Licencias` int(11) DEFAULT NULL,
  `Asistencias` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `secretaria`
--

INSERT INTO `secretaria` (`ID_PERSONAL`, `Cargo`, `Nombre_completo`, `Edad`, `Direccion`, `Correo_electronico`, `Telefono`, `DNI`, `Fecha_inicio`, `Ficha_censal`, `Licencias`, `Asistencias`) VALUES
(1, 'Rector', 'Alfonso Gutierrez', 59, 'Avenida Lope de Vega 1592', 'alfonsooo@hotmail.com', 11242211, 2527869, '2007-07-27', 58153, 0, 100),
(2, 'Vicerrector', 'Pedro Kafka', 60, 'Avenida San Martin 9000', 'pedrokaf@hotmail.com', 11512790, 24925601, '2012-03-01', 55379, 10, 90),
(3, 'Secretario', 'Maria Mariana Lanza', 52, 'Cervantez 3789', 'LML@gmail.com', 11890213, 28765432, '2009-11-21', 70379, 20, 80),
(4, 'Regente', 'Matias Sulca', 42, 'New York 8790', 'LML@gmail.com', 11934563, 32765432, '2009-08-24', 68379, 4, 96),
(5, 'Profesor', 'Ignacio Sarale', 37, 'Avenida Salvador Maria del Carril', 'Igna@gmail.com', 11874253, 44324689, '2019-10-31', 108379, 2, 98),
(6, 'Profesor', 'Rodolfo Decurgez', 66, 'Baigorria 7894', 'Dec@gmail.com', 11324689, 23256012, '1995-11-09', 10379, 7, 93),
(7, 'Profesor', 'Francisca Roberti', 25, 'Bermudez 2142', 'FR@gmail.com', 11564302, 43152781, '2022-07-19', 110379, 1, 99),
(8, 'Profesor', 'Lorena Marta Roca', 44, 'Virgilio 7642', 'LoreMar@hotmail.com', 11346223, 33856801, '2010-03-30', 40379, 0, 100),
(9, 'Profesor', 'Anahi Ozores', 67, 'Avenida Lastra 1234', 'ana@hotmail.com', 11246567, 23105601, '1995-12-05', 12450, 5, 95),
(10, 'Profesor', 'Julian Perez', 30, 'Monte Castro 2991', 'Juli@hotmail.com', 11123409, 40056401, '2015-01-15', 80871, 2, 98),
(11, 'Profesor', 'Lola Fierro', 31, 'Avenida Lope de Vega 1300', 'lolafierro@gmail.com', 11096792, 40959601, '2013-04-21', 75871, 11, 89),
(12, 'Profesor', 'Lautaro Sosa Lanza', 51, 'Quevedo 2328', 'lautisosa@gmail.com', 11212317, 27785601, '2023-05-10', 55871, 0, 100),
(13, 'Profesor', 'Joaquin Lozano', 23, 'Avenida Rivadavia 6789', 'jl@hotmail.com', 11085391, 42531344, '2021-08-29', 99345, 1, 99),
(14, 'Profesor', 'Lionel Messi', 43, 'Avenida Corrientes 10789', 'Messi@gmail.com', 11345678, 32319874, '2011-02-13', 80649, 8, 92),
(15, 'Profesor', 'Gonzalo Mendez', 39, 'Vicente Lopez 3280', 'vicens@gmail.com', 11426243, 44913044, '2012-12-14', 62349, 18, 82),
(16, 'Profesor', 'Fernando Louro', 41, 'Avenida Lope de Vega 3131', 'ferrnan@gmail.com', 11852242, 33014778, '2016-09-29', 89245, 14, 86),
(17, 'Profesor', 'Antonio Penalba', 63, 'Florida 1238', 'antpenal@gmail.com', 11745432, 25835444, '2003-04-07', 53145, 12, 88),
(18, 'Profesor', 'Julieta Lizarraga', 33, 'Avenida Rivadavia 8901', 'juli@hotmail.com', 11890797, 45135214, '2022-01-23', 100112, 2, 98),
(19, 'Profesor', 'Diego Maradona', 59, 'Ecuador 3214', 'diego@gmail.com', 11753232, 24865432, '1997-02-10', 30649, 0, 100),
(20, 'Profesor', 'Sofia Gomez', 32, 'Gualeguaychú 3280', 'sogomez@gmail.com', 11537699, 45214137, '2020-01-14', 112349, 20, 80),
(21, 'Profesor', 'Santino Rivero', 22, 'Avenida Rivadavia 1252', 'santiriv@hotmail.com', 11142643, 42745210, '2024-07-22', 124312, 0, 100),
(22, 'Guardia', 'Tatiana Roque', 52, 'Allende 4123', 'tati@hotmail.com', 11124655, 28934798, '2001-01-01', 33349, 10, 90),
(23, 'Auxiliar de limpieza', 'Tiago Tapia Gallardo', 29, 'Chivilcoy 8731', 'tt@gmail.com', 11666342, 41913544, '2017-02-02', 92349, 6, 94),
(24, 'Auxiliar de limpieza', 'Guadalupe Colombo', 60, 'Alcaraz 7987', 'pablo@hotmail.com', 11900845, 24395792, '1998-01-27', 42349, 9, 91),
(25, 'Portero', 'Agustina Rodriguez', 40, 'Lavalle 3134', 'agustinarodriguez@hotmail.com', 11234867, 30321009, '2014-02-06', 75332, 2, 98);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`ID_ALUMNO`),
  ADD KEY `ID_OFICINA` (`ID_OFICINA`),
  ADD KEY `ID_CURSO` (`ID_CURSO`);

--
-- Indices de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`ID_ASIGNATURA`),
  ADD KEY `ID_DOCENTE` (`ID_DOCENTE`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`ID_CURSO`);

--
-- Indices de la tabla `curso_asignado`
--
ALTER TABLE `curso_asignado`
  ADD PRIMARY KEY (`ID_CURSO_ASIGNADO`),
  ADD KEY `ID_DOCENTE` (`ID_DOCENTE`),
  ADD KEY `ID_CURSO` (`ID_CURSO`);

--
-- Indices de la tabla `docentes`
--
ALTER TABLE `docentes`
  ADD PRIMARY KEY (`ID_DOCENTE`),
  ADD KEY `ID_PERSONAL` (`ID_PERSONAL`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`ID_NOTA`),
  ADD KEY `ID_ALUMNO` (`ID_ALUMNO`),
  ADD KEY `ID_ASIGNATURA` (`ID_ASIGNATURA`);

--
-- Indices de la tabla `oficina_de_alumnos`
--
ALTER TABLE `oficina_de_alumnos`
  ADD PRIMARY KEY (`ID_OFICINA`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indices de la tabla `secretaria`
--
ALTER TABLE `secretaria`
  ADD PRIMARY KEY (`ID_PERSONAL`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `ID_ALUMNO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `ID_ASIGNATURA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `ID_CURSO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `curso_asignado`
--
ALTER TABLE `curso_asignado`
  MODIFY `ID_CURSO_ASIGNADO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `docentes`
--
ALTER TABLE `docentes`
  MODIFY `ID_DOCENTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `notas`
--
ALTER TABLE `notas`
  MODIFY `ID_NOTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `oficina_de_alumnos`
--
ALTER TABLE `oficina_de_alumnos`
  MODIFY `ID_OFICINA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `secretaria`
--
ALTER TABLE `secretaria`
  MODIFY `ID_PERSONAL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`ID_OFICINA`) REFERENCES `oficina_de_alumnos` (`ID_OFICINA`),
  ADD CONSTRAINT `alumnos_ibfk_2` FOREIGN KEY (`ID_CURSO`) REFERENCES `cursos` (`ID_CURSO`);

--
-- Filtros para la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD CONSTRAINT `asignaturas_ibfk_1` FOREIGN KEY (`ID_DOCENTE`) REFERENCES `docentes` (`ID_DOCENTE`);

--
-- Filtros para la tabla `curso_asignado`
--
ALTER TABLE `curso_asignado`
  ADD CONSTRAINT `curso_asignado_ibfk_1` FOREIGN KEY (`ID_DOCENTE`) REFERENCES `docentes` (`ID_DOCENTE`),
  ADD CONSTRAINT `curso_asignado_ibfk_2` FOREIGN KEY (`ID_CURSO`) REFERENCES `cursos` (`ID_CURSO`);

--
-- Filtros para la tabla `docentes`
--
ALTER TABLE `docentes`
  ADD CONSTRAINT `docentes_ibfk_1` FOREIGN KEY (`ID_PERSONAL`) REFERENCES `secretaria` (`ID_PERSONAL`);

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`ID_ALUMNO`) REFERENCES `alumnos` (`ID_ALUMNO`),
  ADD CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `asignaturas` (`ID_ASIGNATURA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
