# Bienvenido al Proyecto Oriontek Test

<p align="center">
    <img alt="Spring Doc Resources" title="Spring Doc Resources" src="https://i.imgur.com/fGi6EaT.png" width="450">
</p>
## Leer Primero

Lo siguiente se descubrió al construir este proyecto:

- El nombre del paquete original `com.oriontek-test.oriontek-test` es inválido. Este proyecto utiliza `com.oriontek_test.oriontek_test` en su lugar.

## Comenzando

¡Bienvenido al Proyecto Oriontek Test! Este proyecto está construido con Spring Boot y Maven. A continuación, se presentan algunos recursos para ayudarte a comenzar:

### Documentación de Referencia

Para más información, por favor consulta las siguientes secciones:

- [Documentación Oficial de Apache Maven](https://maven.apache.org/guides/index.html)
- [Guía de Referencia del Plugin Maven de Spring Boot](https://docs.spring.io/spring-boot/3.3.2/maven-plugin)
- [Crear una Imagen OCI](https://docs.spring.io/spring-boot/3.3.2/maven-plugin/build-image.html)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#web)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
- [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#data.nosql.mongodb)
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#using.devtools)

### Guías

Las siguientes guías ilustran cómo utilizar algunas características concretas:

- [Construyendo un Servicio Web RESTful](https://spring.io/guides/gs/rest-service/)
- [Sirviendo Contenido Web con Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Construyendo Servicios REST con Spring](https://spring.io/guides/tutorials/rest/)
- [Accediendo a Datos con JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Accediendo a Datos con MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
- [Accediendo a Datos con MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

### Swagger

Este proyecto incluye [Swagger](https://swagger.io/), una herramienta para la documentación de APIs. Puedes visualizar la documentación interactiva de tu API accediendo a:

- `http://localhost:8080/swagger-ui/index.html` (si estás ejecutando el proyecto localmente)

### Endpoints Disponibles

#### Address Controller

- `GET /address/client/{clientId}`: Obtiene las direcciones asociadas a un cliente específico.
- `GET /address/client/data/{clientId}`: Obtiene todos los datos del cliente junto con sus direcciones.
- `POST /address`: Crea una nueva dirección.

#### Client Controller

- `GET /client`: Obtiene la lista de todos los clientes.
- `POST /client`: Crea un nuevo cliente.
- `GET /client/{id}`: Obtiene un cliente específico por su ID.
- `PUT /client/{id}`: Actualiza un cliente existente por su ID.

### Pruebas Unitarias

Se han implementado pruebas unitarias para garantizar el correcto funcionamiento de los componentes del proyecto. Estas pruebas ayudan a verificar que las funcionalidades se comporten como se espera y facilitan la detección de errores y problemas de manera temprana.

### Principios SOLID

Este proyecto sigue los principios SOLID para el diseño de software, lo que asegura un código más limpio, mantenible y escalable. Los principios SOLID son:

- **S**: **Single Responsibility Principle (SRP)** - Cada clase debe tener una única responsabilidad.
- **O**: **Open/Closed Principle (OCP)** - Las entidades de software deben estar abiertas para la extensión pero cerradas para la modificación.
- **L**: **Liskov Substitution Principle (LSP)** - Los objetos de una clase derivada deben ser sustituibles por objetos de la clase base sin alterar el correcto funcionamiento del programa.
- **I**: **Interface Segregation Principle (ISP)** - Los clientes no deben verse obligados a depender de interfaces que no utilizan.
- **D**: **Dependency Inversion Principle (DIP)** - Los módulos de alto nivel no deben depender de los módulos de bajo nivel. Ambos deben depender de abstracciones.

### Maven Parent Overrides

Debido al diseño de Maven, los elementos se heredan del POM padre al POM del proyecto. Aunque la mayoría de la herencia es adecuada, también hereda elementos no deseados como `<license>` y `<developers>` del padre. Para evitar esto, el POM del proyecto contiene sobrescrituras vacías para estos elementos. Si cambias manualmente a un padre diferente y realmente deseas la herencia, debes eliminar esas sobrescrituras.
