-- Execute conectado ao banco padrão "postgres":
--   CREATE DATABASE "songs-crud";
-- Depois conecte em "songs-crud" e execute o restante:

CREATE TABLE IF NOT EXISTS songs (
    id       UUID PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    artists  TEXT[]       NOT NULL DEFAULT '{}',
    duration INTEGER      NOT NULL CHECK (duration >= 0) -- duração em segundos
);
