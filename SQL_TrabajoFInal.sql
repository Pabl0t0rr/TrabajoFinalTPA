SELECT * FROM bd_trabajo.usuario;
-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS bd_trabajo;
USE bd_trabajo;

-- Crear la tabla 'usuarios'
CREATE TABLE IF NOT EXISTS usuarios (
    Idusuario INT PRIMARY KEY,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    clave VARCHAR(255) NOT NULL
);

-- Insertar datos de ejemplo
INSERT INTO usuarios (Idusuario, usuario, clave) VALUES
(1, 'usuario1', 'clave1'),
(2, 'usuario2', 'clave2'),
(3, 'usuario3', 'clave3');

-- Restricciones adicionales (pueden variar según tus necesidades)
ALTER TABLE usuarios ADD CONSTRAINT unique_usuario UNIQUE (usuario);
