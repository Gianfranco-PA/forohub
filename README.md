## Forohub

Aplicación sencilla para gestionar **topics**: crear, consultar, actualizar y eliminar registros en una base MySQL.

### Descripción

* **Entidad principal**: `Topic` con campos:

    * `id` (Long)
    * `title` (String)
    * `message` (String)
    * `status` (Enum: ACTIVE, INACTIVE)
    * `author` (String)
    * `course` (String)
    * `createdAt` (LocalDateTime)
* Persistencia vía Spring Data JPA
* Migraciones controladas con Flyway

### Endpoints

#### Topics

Base URL: `{{host}}/api/topic`

| Método | Ruta    | Descripción                  |
| ------ | ------- | ---------------------------- |
| GET    | `/`     | Lista todos los topics       |
| GET    | `/{id}` | Obtiene un topic por su ID   |
| POST   | `/`     | Crea un nuevo topic          |
| PUT    | `/{id}` | Actualiza un topic existente |
| DELETE | `/{id}` | Elimina un topic por su ID   |

#### Autenticación

Base URL: `{{host}}/api/auth`

| Método | Ruta     | Descripción                         |
| ------ | -------- | ----------------------------------- |
| POST   | `/login` | Autentica usuario y devuelve el JWT |

### Ejemplos en Postman

1. **Listar todos**

    * Método: GET
    * URL: `{{host}}/api/topic`

2. **Obtener por ID**

    * Método: GET
    * URL: `{{host}}/api/topic/1`

3. **Crear un topic**

    * Método: POST
    * URL: `{{host}}/api/topic`
    * Body:

      ```json
      {
        "title": "Nueva discusión",
        "message": "Explorando endpoints REST",
        "status": "ACTIVE",
        "author": "Gianfranco",
        "course": "Spring Boot"
      }
      ```

4. **Actualizar un topic**

    * Método: PUT
    * URL: `{{host}}/api/topic/1`
    * Body:

      ```json
      {
        "title": "Tema revisado",
        "message": "Contenido actualizado",
        "status": "INACTIVE",
        "author": "Gianfranco",
        "course": "Java Avanzado"
      }
      ```

5. **Eliminar un topic**

    * Método: DELETE
    * URL: `{{host}}/api/topic/1`

6. **Login**

    * Método: POST
    * URL: `{{host}}/api/auth/login`
    * Body:

      ```json
      {
        "username": "FOROHUB",
        "password": "123456"
      }
      ```

> **Cuenta de ejemplo**: `username=FOROHUB`, `password=123456`
