# CRUD de Músicas

API REST (Spring Boot + PostgreSQL) com front-end simples para gerenciar músicas.

Campos: `id` - `nome` - `artista(s)` - `duração`.

## Requisitos
- mvn;
- java 11+;
- PostgreSQL (usuário `postgres`, senha `admin`, porta `5432`).

## Banco de dados
Crie o banco `songs-crud` e a tabela `songs` (script em `src/main/resources/db/schema.sql`):

```sql
CREATE DATABASE "songs-crud";
-- conecte no banco songs-crud e rode:
CREATE TABLE IF NOT EXISTS songs (
    id       UUID PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    artists  TEXT[]       NOT NULL DEFAULT '{}',
    duration INTEGER      NOT NULL CHECK (duration >= 0)
);
```

A conexão é configurada em `ConnectionFactory.java`.

## Execução
Executar comando `./mvnw clean spring-boot:run`
Acesso ao front-end em `http://localhost:8080/`

## Endpoints
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/songs` | Lista todas as músicas |
| GET | `/songs/{id}` | Busca uma música |
| POST | `/songs` | Cria uma música |
| PUT | `/songs/{id}` | Atualiza (ou cria) uma música |
| DELETE | `/songs/{id}` | Remove uma música |

Exemplo de JSON (`duration` em segundos):

```json
{
  "name": "Under Pressure",
  "artists": ["Queen", "David Bowie"],
  "duration": 248
}
```
