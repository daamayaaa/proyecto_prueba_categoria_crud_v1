-- Ejecutar con un usuario administrador de PostgreSQL (ej. postgres)

-- 1. Crear la base de datos
CREATE DATABASE categorias_db;

-- 2. Crear el usuario de la aplicacion
CREATE USER categorias WITH PASSWORD '12345678';

-- 3. Otorgar privilegios sobre la base de datos
GRANT ALL PRIVILEGES ON DATABASE categorias_db TO categorias;

-- 4. Conectarse a categorias_db (\c categorias_db) y ejecutar lo siguiente:

CREATE TABLE IF NOT EXISTS categoria (
    id_categoria SERIAL PRIMARY KEY,
    nombre       VARCHAR(100) NOT NULL,
    habilitado   BOOLEAN DEFAULT TRUE
);

GRANT ALL PRIVILEGES ON TABLE categoria TO categorias;
GRANT USAGE, SELECT ON SEQUENCE categoria_id_categoria_seq TO categorias;

-- 5. (Opcional) Datos de ejemplo
INSERT INTO categoria (nombre, habilitado) VALUES
    ('Electrodomesticos', TRUE),
    ('Tecnologia', TRUE),
    ('Hogar', FALSE);
