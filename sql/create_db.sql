-- Ejecutar como superusuario de PostgreSQL (postgres)

CREATE DATABASE categorias_db;

CREATE USER categorias WITH PASSWORD '12345678';

GRANT ALL PRIVILEGES ON DATABASE categorias_db TO categorias;

-- Conectarse a la base de datos creada
\c categorias_db

CREATE TABLE IF NOT EXISTS categoria (
    id_categoria SERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    habilitado BOOLEAN DEFAULT TRUE
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO categorias;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO categorias;
