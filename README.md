# Proyecto Literatura - LiterAlura

Este proyecto es un catálogo de libros desarrollado en **Java** con **Spring Boot**, que permite almacenar y consultar información sobre libros y autores. Además, se integra con la API **Gutendex** para buscar libros por título.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- PostgreSQL
- Gson
- Maven

---

## Instalación y configuración

1. Clona el repositorio:

```bash
git clone <https://github.com/dugoprogram/literatura>
cd Literatura
Configura la base de datos PostgreSQL en src/main/resources/application.properties:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/literatura
spring.datasource.username=postgres
spring.datasource.password=Jakecito123_
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
Construye el proyecto con Maven:

bash
Copiar código
mvn clean install
Ejecuta la aplicación:

bash
Copiar código
mvn spring-boot:run
Funcionalidades
Menú de consola
Listar todos los libros.

Listar todos los autores.

Listar autores vivos en un año específico.

Listar libros por idioma.

Endpoints REST
Libros
GET /libros → Lista todos los libros.

POST /libros → Agrega un libro.

Ejemplo de JSON:

json
Copiar código
{
  "titulo": "El Quijote",
  "idioma": "es",
  "descargas": 0,
  "autor": {
    "id": 1
  }
}
Integración con Gutendex
GET /gutendex/buscar?titulo=<nombre_libro> → Busca libros por título usando la API de Gutendex.

Estructura del proyecto
bash
Copiar código
src/main/java/com/alura/literatura
│
├── AplicacionLiteratura.java       # Clase principal
├── LiteraturaApp.java             # Menú de consola
├── modelo
│   ├── Libro.java
│   └── Autor.java
├── repositorio
│   ├── LibroRepositorio.java
│   └── AutorRepositorio.java
├── servicio
│   └── GutendexService.java
└── controlador
    ├── LibroControlador.java
    └── GutendexControlador.java
Autor
Pablo Andrés Verdugo Salazar

Licencia
Este proyecto está bajo la licencia MIT.
