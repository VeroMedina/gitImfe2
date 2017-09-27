-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-09-2017 a las 13:33:42
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `almacen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `piezas`
--

CREATE TABLE `piezas` (
  `id` int(11) NOT NULL,
  `codigo` varchar(7) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `color` varchar(20) NOT NULL,
  `precio` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `ciudad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `piezas`
--

INSERT INTO `piezas` (`id`, `codigo`, `nombre`, `color`, `precio`, `peso`, `ciudad`) VALUES
(1, 'alf0005', 'rueda', 'negro', 200, 10, 'sevilla'),
(2, 'neac007', 'radio', 'blanco', 40, 20, 'almeria'),
(3, 'ppj1234', 'bujia', 'rosa', 30, 30, 'cordoba'),
(4, 'jgv1224', 'parachoque', 'rojo', 1000, 40, 'sevilla'),
(84, 'c1e9c2', 'klxjytva', 'rosa', 11, 1, 'barcelona'),
(85, '237621', 'hrqdshgk', 'negro', 95, 9, 'barcelona'),
(86, '4bd630', 'kksjqgec', 'rosa', 93, 3, 'madrid'),
(87, 'bb50f3', 'ijxpdtmb', 'blanco', 72, 5, 'madrid');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `ciudad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id`, `nombre`, `ciudad`) VALUES
(1, 'michelin', 'madrid'),
(2, 'autosport', 'malaga'),
(3, 'navarro hermanos', 'granada'),
(4, 'feuvert', 'barcelona');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suministros`
--

CREATE TABLE `suministros` (
  `id` int(11) NOT NULL,
  `id_piezas` int(11) NOT NULL,
  `id_proveedores` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `suministros`
--

INSERT INTO `suministros` (`id`, `id_piezas`, `id_proveedores`, `cantidad`) VALUES
(1, 1, 4, 100),
(3, 3, 1, 200),
(4, 4, 1, 400),
(5, 2, 3, 300),
(6, 2, 1, 400),
(7, 3, 3, 400),
(8, 2, 4, 500),
(9, 3, 4, 600);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `piezas`
--
ALTER TABLE `piezas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `suministros`
--
ALTER TABLE `suministros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_piezas` (`id_piezas`),
  ADD KEY `id_proveedores` (`id_proveedores`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `piezas`
--
ALTER TABLE `piezas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;
--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `suministros`
--
ALTER TABLE `suministros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `suministros`
--
ALTER TABLE `suministros`
  ADD CONSTRAINT `suministros_ibfk_1` FOREIGN KEY (`id_piezas`) REFERENCES `piezas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `suministros_ibfk_2` FOREIGN KEY (`id_proveedores`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
