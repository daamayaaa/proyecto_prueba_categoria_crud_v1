# proyecto_prueba_categoria_crud_v1
Proyecto de prueba para servicio de consulta de categoría.


# Desarollo de aplicaciones Web.
Gestión de categorías, construida con **Java, Spring Boot, JPA/Hibernate y Lombok**.

## Algoritmos Implementados
1. **CRUD:** Persistencia en Base de Datos con Spring Data JPA.

---

## Endpoints para Pruebas

### 1. CRUD de Productos
* `POST https://demo-api-categoria.up.railway.app/categorias` -> Crear categoría
* `GET https://demo-api-categoria.up.railway.app/categorias`  -> Listar todas las categorías.
* `GET https://demo-api-categoria.up.railway.app/categorias/1` -> Listar categoriía por ID
* `DELETE https://demo-api-categoria.up.railway.app/categorias/2` -> Eliminar categoría por ID

---

## Ejemplo de JSON
```json
{
  "idCategoria": 5,
  "nombre": "Cine",
  "habilitado": true
}