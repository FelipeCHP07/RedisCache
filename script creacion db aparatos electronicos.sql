CREATE TABLE `aparatoelectronico` (
  `id_aparatoelectronico` bigint PRIMARY KEY AUTO_INCREMENT,
  `id_tipoelectrodomestico` bigint,
  `descripcion_aparatoelectronico` varchar(100)
);

CREATE TABLE `tipoelectrodomestico` (
  `id_tipoelectrodomestico` bigint PRIMARY KEY AUTO_INCREMENT,
  `id_tipoelectrodomesticogeneral` bigint,
  `nombre_tipoelectrodomestico` varchar(30),
  `caracteristicas_tipoelectrodomestico` varchar(150)
);

CREATE TABLE `reparacion` (
  `id_reparacion` bigint PRIMARY KEY AUTO_INCREMENT,
  `id_cliente` bigint,
  `id_aparatoelectronico` bigint,
  `descripcion` varchar(200),
  `fecha_reparacion` date
);

CREATE TABLE `reparacioncomponente` (
  `id_reparacioncomponente` bigint PRIMARY KEY AUTO_INCREMENT,
  `id_reparacion` bigint,
  `id_componente` bigint
);

CREATE TABLE `cliente` (
  `id_cliente` bigint PRIMARY KEY AUTO_INCREMENT,
  `nombre_cliente` varchar(50),
  `apellido_cliente` varchar(50),
  `numero_documento` varchar(10),
  `direccion` varchar(30),
  `telefono` varchar(10),
  `correo_electronico` varchar(30)
);

CREATE TABLE `aparatocomponente` (
  `id_aparatocomponente` bigint PRIMARY KEY AUTO_INCREMENT,
  `id_componente` bigint,
  `id_aparatoelectronico` bigint,
  `cantidad` int,
  `precio` dec(6,3)
);

CREATE TABLE `componente` (
  `id_componente` bigint PRIMARY KEY AUTO_INCREMENT,
  `nombre_componente` varchar(50),
  `especificaciones_componente` varchar(100),
  `id_fabricante` bigint
);

CREATE TABLE `fabricante` (
  `id_fabricante` bigint PRIMARY KEY AUTO_INCREMENT,
  `rif` varchar(15) UNIQUE,
  `domicilio` varchar(50)
);

ALTER TABLE `aparatocomponente` ADD CONSTRAINT `ae_ac_fk` FOREIGN KEY (`id_aparatoelectronico`) REFERENCES `aparatoelectronico` (`id_aparatoelectronico`);

ALTER TABLE `aparatocomponente` ADD CONSTRAINT `co_ac_fk` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`);

ALTER TABLE `componente` ADD CONSTRAINT `fa_co_fk` FOREIGN KEY (`id_fabricante`) REFERENCES `fabricante` (`id_fabricante`);

ALTER TABLE `reparacioncomponente` ADD CONSTRAINT `co_rc_fk` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`);

ALTER TABLE `reparacion` ADD CONSTRAINT `cl_re_fk` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

ALTER TABLE `reparacioncomponente` ADD CONSTRAINT `re_rc_fk` FOREIGN KEY (`id_reparacion`) REFERENCES `reparacion` (`id_reparacion`);

ALTER TABLE `tipoelectrodomestico` ADD CONSTRAINT `te_te_fk` FOREIGN KEY (`id_tipoelectrodomesticogeneral`) REFERENCES `tipoelectrodomestico` (`id_tipoelectrodomestico`);

ALTER TABLE `aparatoelectronico` ADD CONSTRAINT `te_ae_fk` FOREIGN KEY (`id_tipoelectrodomestico`) REFERENCES `tipoelectrodomestico` (`id_tipoelectrodomestico`);

ALTER TABLE `reparacion` ADD CONSTRAINT `ae_re_fk` FOREIGN KEY (`id_aparatoelectronico`) REFERENCES `aparatoelectronico` (`id_aparatoelectronico`);
