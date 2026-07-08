# proyecto_prueba_categoria_crud_v1
Proyecto de prueba para servicio de consulta de categoría.


# Desarollo de aplicaciones Web.
Gestión de categorías, construida con **Java, Spring Boot, JPA/Hibernate y Lombok**.

## Algoritmos Implementados
1. **CRUD:** Persistencia en Base de Datos con Spring Data JPA.

---

## Endpoints para Pruebas

### 1. CRUD de Categorías
* `POST https://demo-api-categoria.up.railway.app/categorias` -> Crear categoría
* `GET https://demo-api-categoria.up.railway.app/categorias`  -> Listar todas las categorías.
* `GET https://demo-api-categoria.up.railway.app/categorias/1` -> Listar categoriía por ID
* `PUT https://demo-api-categoria.up.railway.app/categorias/1` -> Actualizar categoriía por ID
* `DELETE https://demo-api-categoria.up.railway.app/categorias/2` -> Eliminar categoría por ID

---

## Endpoints de Categorías

| Método | Ruta               | Descripción                 |
|--------|--------------------|-----------------------------|
| GET    | /categorias        | Lista todas las categorías  |
| GET    | /categorias/{id}   | Obtiene una categoría       |
| POST   | /categorias        | Crea una categoría          |
| PUT    | /categorias/{id}   | Actualiza una categoría     |
| DELETE | /categorias/{id}   | Elimina una categoría       |


Ejemplo de body para POST/PUT:
```json
{ "nombre": "Internacional", "habilitado": false }
```

## Ejemplo de JSON para consulta.
```json
{
  "idCategoria": 5,
  "nombre": "Cine",
  "habilitado": true
}
```

##  Subir el proyecto a GitHub

Railway despliega directamente desde un repositorio:

```bash
git init
git add .
git commit -m "Proyecto API Categorías"
git branch -M main
git remote add origin https://github.com/daamayaaa/proyecto_prueba_categoria_crud_v1
git push -u origin main
```

## Crear el proyecto en Railway

1. Entra a [railway.app](https://railway.app) e inicia sesión.
2. Clic en **New Project → Deploy from GitHub repo** y selecciona tu repositorio.


## Añadir la base de datos PostgreSQL

1. Dentro del mismo proyecto, clic en **New → Database → Add PostgreSQL**.
2. Railway crea un servicio "Postgres" con sus propias variables (`HOST`, `PORT`, `DATABASE`, `USER`, `PASSWORD`, etc.).


## Conectar tu app con la base de datos (variables de entorno)

En el servicio de tu aplicación (no el de Postgres):

1. Ve a la pestaña **Variables**.
2. Añade estas variables usando **referencias** al servicio de Postgres (Railway te las sugiere automáticamente al escribir `${{`):


## Desplegar

Railway construye y despliega automáticamente en cada push a `main`. Puedes ver el progreso en la pestaña **Deployments** y los logs en **Logs**.

Cuando termine, ve a **Settings → Networking → Generate Domain** para obtener una URL pública tipo `https://demo-api-categoria.up.railway.app`.

