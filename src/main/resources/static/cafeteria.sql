-- Acceso a MySQL: root / root

SET sql_mode = 'STRICT_ALL_TABLES';

DROP DATABASE IF EXISTS cafeteria;
CREATE DATABASE IF NOT EXISTS cafeteria
CHARACTER SET utf8mb4
  COLLATE utf8mb4_spanish_ci;

USE cafeteria;

-- 2. Tabla Categorias
CREATE TABLE categorias
(
	id INT NOT NULL UNIQUE AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
	activo BOOLEAN DEFAULT 1,
    
    PRIMARY KEY PK_categorias (id)
)
COMMENT "Tabla Principal Categorias";

-- 3. Tabla Productos
CREATE TABLE productos 
(
	id INT NOT NULL UNIQUE AUTO_INCREMENT,
    categoria INT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
	activo BOOLEAN DEFAULT 1,
     
    FOREIGN KEY (categoria) REFERENCES categorias (id),
    PRIMARY KEY PK_productos (id)
);

-- 4. Tabla Mesas
CREATE TABLE mesas 
(
	id INT NOT NULL UNIQUE AUTO_INCREMENT,
    mesa INT NOT NULL,
	activo BOOLEAN DEFAULT 1,
    
    PRIMARY KEY PK_mesas (id)
);

-- 1. Tabla MesasPagadas
CREATE TABLE mesasPagadas
(
	id TINYINT NOT NULL UNIQUE AUTO_INCREMENT,
    numeroMesa INT NOT NULL,
    importe DECIMAL(10,2),
    hora TIME NOT NULL,
    fecha DATE NOT NULL,
	activo BOOLEAN DEFAULT 1,
    
    PRIMARY KEY PK_mesas_pagadas (id),
    FOREIGN KEY (NumeroMesa) REFERENCES mesas (id)
) 
COMMENT "Tabla Principal MesasPagadas";

-- 5. Tabla Cuentas
CREATE TABLE cuentas
(
	id INT NOT NULL UNIQUE AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    precioTotal DECIMAL(10,2) NOT NULL,
    precioUnidad DECIMAL(10,2) NOT NULL,
    unidades INT NOT NULL,
	producto INT NOT NULL,
	mesa INT NOT NULL,
	activo BOOLEAN DEFAULT 1,
	
    FOREIGN KEY (producto) REFERENCES productos (id),
    FOREIGN KEY (mesa) REFERENCES mesas (id),
    PRIMARY KEY PK_cuentas (id)
);




