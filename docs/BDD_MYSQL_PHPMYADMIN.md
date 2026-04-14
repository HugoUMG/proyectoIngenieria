# Base de Datos MySQL para phpMyAdmin

Estructura actualizada de base de datos en español para el sistema de **control de bienes**.

```sql
CREATE DATABASE control_de_bienes;
USE control_de_bienes;

-- 2. ESTRUCTURA DE SOPORTE (CATÁLOGOS Y CONFIGURACIÓN)
CREATE TABLE Roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL
);

CREATE TABLE Departamentos (
    id_depto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_depto VARCHAR(100) NOT NULL,
    centro_costo VARCHAR(20) UNIQUE
);

CREATE TABLE Partidas_Presupuestarias (
    id_partida INT AUTO_INCREMENT PRIMARY KEY,
    codigo_partida VARCHAR(50) UNIQUE,
    nombre_partida VARCHAR(100)
);

CREATE TABLE Proveedores (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_proveedor VARCHAR(150) NOT NULL,
    correo VARCHAR(100)
);

-- 3. GESTIÓN DE PERSONAL Y SEGURIDAD (EMPLEADOS)
CREATE TABLE Empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    id_depto INT,
    firma_digital LONGTEXT,
    FOREIGN KEY (id_depto) REFERENCES Departamentos(id_depto)
);

CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    id_rol INT,
    id_empleado INT UNIQUE,
    FOREIGN KEY (id_rol) REFERENCES Roles(id_rol),
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado)
);

-- 4. MÓDULO DE ADQUISICIONES (COMPRAS)
CREATE TABLE Compras (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    no_factura VARCHAR(50) NOT NULL,
    fecha_compra DATE NOT NULL,
    id_proveedor INT,
    id_partida INT,
    FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id_proveedor),
    FOREIGN KEY (id_partida) REFERENCES Partidas_Presupuestarias(id_partida)
);

CREATE TABLE Detalle_Compra (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_compra INT,
    descripcion_articulo TEXT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(12,2),
    FOREIGN KEY (id_compra) REFERENCES Compras(id_compra)
);

-- 5. MÓDULO DE INVENTARIO CENTRAL Y ASIGNACIONES
CREATE TABLE Activos (
    id_activo INT AUTO_INCREMENT PRIMARY KEY,
    id_detalle INT,
    tag_qr_rfid VARCHAR(100) UNIQUE,
    descripcion_especifica TEXT,
    estado_bien ENUM('Nuevo', 'Usado', 'Dañado', 'Baja') DEFAULT 'Nuevo',
    valor_actual DECIMAL(12,2),
    fecha_ingreso TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_detalle) REFERENCES Detalle_Compra(id_detalle),
    INDEX (tag_qr_rfid)
);

CREATE TABLE Asignacion_Activos (
    id_asig INT AUTO_INCREMENT PRIMARY KEY,
    id_activo INT,
    id_empleado INT,
    fecha_entrega DATE NOT NULL,
    fecha_devolucion DATE NULL,
    FOREIGN KEY (id_activo) REFERENCES Activos(id_activo),
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado)
);

-- 6. MÓDULO DE AUDITORÍA GENERAL
CREATE TABLE Auditoria_General (
    id_log INT AUTO_INCREMENT PRIMARY KEY,
    tabla_afectada VARCHAR(50),
    id_registro_afectado INT,
    accion ENUM('INSERT', 'UPDATE', 'DELETE'),
    usuario_que_cambio VARCHAR(50),
    fecha_movimiento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    detalles TEXT
);

CREATE TABLE Bajas_Activos (
    id_baja INT AUTO_INCREMENT PRIMARY KEY,
    id_activo INT UNIQUE,
    motivo_baja TEXT NOT NULL,
    fecha_baja DATE NOT NULL,
    id_usuario_autoriza INT,
    documento_respaldo VARCHAR(255),
    FOREIGN KEY (id_activo) REFERENCES Activos(id_activo),
    FOREIGN KEY (id_usuario_autoriza) REFERENCES Usuarios(id_usuario)
);
```
