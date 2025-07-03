# Sales-service-EcoMarket

Microservicio de ventas para el sistema Ecomarket, desarrollado con Spring Boot y PostgreSQL.

## Descripción

Este microservicio permite gestionar las ventas de Ecomarket a través de una API REST. Incluye endpoints para listar, crear, buscar y eliminar ventas, así como pruebas unitarias para asegurar su correcto funcionamiento.

---

## Endpoints y uso de verbos HTTP

| Verbo  | Endpoint                | Descripción                        | Ejemplo de uso                |
|--------|-------------------------|------------------------------------|-------------------------------|
| GET    | `/api/ventas`           | Listar todas las ventas            | `GET /api/ventas`             |
| POST   | `/api/ventas`           | Crear una nueva venta              | `POST /api/ventas`            |
| GET    | `/api/ventas/{id}`      | Buscar una venta por su ID         | `GET /api/ventas/1`           |
| DELETE | `/api/ventas/{id}`      | Eliminar una venta por su ID       | `DELETE /api/ventas/1`        |

### Ejemplo de JSON para crear una venta (`POST /api/ventas`)

```json
{
  "marca": "MarcaX",
  "modelo": "ModeloY",
  "tipo": "TipoA",
  "fecha": "2025-06-29T00:00:00.000+00:00",
  "cliente": "Cliente1"
}
```

---

## Pruebas unitarias

Las pruebas unitarias del controlador (`VentaControllerTest`) usan **JUnit**, **Mockito** y **MockMvc** para simular peticiones HTTP y validar el comportamiento de los endpoints.

### Pruebas incluidas

- **Listar ventas:** Verifica que el endpoint `GET /api/ventas` responde correctamente.
- **Guardar venta:** Verifica que el endpoint `POST /api/ventas` crea una venta y responde con el estado adecuado.
- **Buscar venta por ID:** Verifica que el endpoint `GET /api/ventas/{id}` responde correctamente cuando la venta existe.
- **Eliminar venta:** Verifica que el endpoint `DELETE /api/ventas/{id}` elimina la venta y responde con el estado adecuado.

### Ejecutar las pruebas

Desde la terminal, ejecuta:
```sh
mvn test
```

---

## Configuración

1. **Base de datos:**  
   Crea la base de datos en PostgreSQL:
   ```sql
   CREATE DATABASE db_ecomarket;
   ```

2. **Configura las credenciales en `src/main/resources/application.properties`:**
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/db_ecomarket
   spring.datasource.username=postgres
   spring.datasource.password=Vicente5150.
   ```

---

## Documentación Swagger

Accede a la documentación interactiva en:  
[http://localhost:8081/doc/swagger-ui.html](http://localhost:8081/doc/swagger-ui.html)

---

## Estructura del proyecto

```
src/
 ├─ main/
 │   ├─ java/com/ecomarket/user_service/
 │   │    ├─ controller/   # Controladores REST
 │   │    ├─ model/        # Entidades JPA
 │   │    └─ service/      # Servicios
 │   └─ resources/
 │        └─ application.properties
 └─ test/
      └─ java/com/ecomarket/user_service/controller/
           └─ VentaControllerTest.java
```

---

## Ejecución

Compila y ejecuta el proyecto:
```sh
mvn clean install
mvn spring-boot:run
```

El servicio estará disponible en:  
[http://localhost:8081](http://localhost:8081)

---

## Autor

- Vicente

---

¡Contribuciones y sugerencias