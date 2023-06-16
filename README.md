# Projecto Java fundamentals

El Proyecto es una API RESTfull basado en Spring Boot que proporciona la gestión de usuarios.


## Tecnologías Utilizadas

- Java
- Spring Boot
- MySQL
- Docker



## Configuración

1. Clona el repositorio: `git clone https://github.com/cristopherSaldanaY/Project-Java-Fundamentals-users.git`
2. Abre el proyecto en tu IDE favorito.
3. Configura las propiedades de la aplicación según tus necesidades en el archivo `application.properties`.
4. Ejecutar desde el terminal el `docker compose up -d` para levantar el contenedor con mysql

## Ejecución

1. Desde tu IDE, ejecuta la clase principal `JavaFundamentalsApplication`.

## Uso

Para saber el uso completo esta disponible la url de Swagger `http://localhost:8080/doc/swagger-ui/index.html`
Para ver las metricas con actuator metodo `GET` `http://localhost:8080/actuator/metrics/http.server.requests`

### Endpoint Crear

- **URL**: `http://localhost:8080/users/`
- **Método**: `POST`
- **Descripción**: Creación de un usuario

#### Parámetros de Solicitud

| Nombre     | Tipo   | Descripción          |
|------------| ------ |----------------------|
| name       | String | nombre del usuario   |
| email      | Int    | correo electronico   |
| password   | Int    | contraseña           |
| phones     | Int    | Arreglo de telefonos |
| celNumber  | Int    | numero de telefono   |
| codCity    | Int    | codigo de ciudad     |
| codCountry | Int    | codigo de pais       |

#### Ejemplo de Solicitud

```json

{
  "name": "nombre apellido",
  "email": "correo@email.com",
  "password": "password1234",
  "phones": [
    {
      "celNumber": "123456789",
      "codCity": "12",
      "codCountry": "34"
    }
  ]
}
```
#### Ejemplo de Respuesta

```json
{
  "id": "500de496-2e95-41d2-a152-983e47b64d52",
  "created": "16/06/2023 03:20:37",
  "modified": "16/06/2023 03:20:37",
  "active": true
}
```


