# 🚗 Rentcar - Sistema de Gestión de Alquiler de Vehículos

![Versión](https://img.shields.io/badge/versión-1.0.0-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)

API Backend para el sistema Rentcar, una plataforma integral para gestionar el alquiler de vehículos de manera eficiente y segura. Desarrollado con Spring Boot y construido con Gradle.

## Tecnologías Utilizadas

- **Java**: JDK 17 o superior
- **Spring Boot**: Framework para desarrollo de aplicaciones Java
- **Spring Data JPA**: Persistencia de datos con Hibernate
- **Spring Security**: Autenticación y autorización
- **Gradle**: Sistema de construcción y gestión de dependencias
- **IntelliJ IDEA**: IDE recomendado
- **Base de Datos**: PostgreSQL (Producción) / H2 (Desarrollo)
- **Lombok**: Reducción de código boilerplate
- **Swagger/OpenAPI**: Documentación de API
- **JUnit y Mockito**: Testing

## Requisitos Previos

Para ejecutar este proyecto, necesitarás:

- Java JDK 17 o superior
- Gradle 7.0+ (el wrapper está incluido en el proyecto)
- IDE: IntelliJ IDEA (recomendado)
- PostgreSQL (para entorno de producción)

## Configuración e Instalación

### Clonar el Repositorio

```bash
git clone https://github.com/CALR0/rent-car-backend.git
cd rentcar-backend
```

### Configuración del Entorno

1. **Configuración de la Base de Datos**:
   - Edita `src/main/resources/application-dev.properties` para desarrollo
   - Edita `src/main/resources/application-prod.properties` para producción

2. **Variables de Entorno (opcional)**:
   ```
   SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/rentcar
   SPRING_DATASOURCE_USERNAME=tu_usuario
   SPRING_DATASOURCE_PASSWORD=tu_contraseña
   ```

### Compilación del Proyecto

```bash
# Usando Gradle Wrapper
./gradlew clean build

# O si tienes Gradle instalado globalmente
gradle clean build
```

### Ejecución del Proyecto

```bash
# Usando Gradle Wrapper para entorno de desarrollo
./gradlew bootRun --args='--spring.profiles.active=dev'

# Para producción
./gradlew bootRun --args='--spring.profiles.active=prod'

# O ejecuta el JAR directamente
java -jar build/libs/rentcar-1.0.0.jar --spring.profiles.active=prod
```

## Equipo de Desarrollo

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/CALR0">
        <img src="https://github.com/CALR0.png" width="100px;" alt="Carlos Lizarazo"/>
        <br />
        <sub><b>Carlos Lizarazo</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Viraviutt">
        <img src="https://github.com/Viraviutt.png" width="100px;" alt="Victor Villarreal"/>
        <br />
        <sub><b>Victor Villarreal</b></sub>
      </a>
    </td>
  </tr>
</table>