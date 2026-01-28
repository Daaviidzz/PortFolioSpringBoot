# 🚀 Portfolio Web Profesional - Spring Boot & Docker

Este proyecto es una aplicación web dinámica diseñada para gestionar y mostrar un Portfolio profesional de forma automatizada. Utiliza una arquitectura robusta basada en **Java Spring Boot**, con un diseño visual moderno y minimalista utilizando efectos de **Glassmorphism**.

## 🛠️ Stack Tecnológico

* **Backend:** Java 17, Spring Boot 3, Spring Data JPA.
* **Frontend:** Thymeleaf, HTML5, CSS3, Bootstrap 5.
* **Base de Datos:** MySQL 8.0 ejecutándose en un contenedor **Docker**.
* **Herramientas de Construcción:** Maven.

## 🎨 Características Visuales y Funcionalidades

* **Efecto Glassmorphism:** Interfaz con tarjetas translúcidas, desenfoque de fondo y bordes suaves para una apariencia premium.
* **Navegación Fluida:**
  * Barra de progreso de lectura en la parte superior.
  * Botón "Volver arriba" (Back to top) con desplazamiento suave.
  * Animaciones de entrada (Scroll Reveal) para los elementos de la página.
* **Gestión de Contenido:** Sección dinámica de Experiencia, Formación, Proyectos y Stack Tecnológico (con tooltips interactivos).
* **Responsive Design:** Optimizado para una visualización perfecta tanto en móviles como en ordenadores de escritorio.

## ⚙️ Instalación y Configuración Local

1. Clonar el repositorio
git clone https://github.com/Daaviidzz/PortFolioSpringBoot.git
cd PortFolioSpringBoot

2. Configurar Base de Datos (Docker)
Levanta el contenedor de MySQL con el siguiente comando (asegúrate de que Docker esté iniciado):

docker run --name mysql_container -e MYSQL_ROOT_PASSWORD=tu_password -e MYSQL_DATABASE=SpringBoot -p 3306:3306 -d mysql:latest

3. Importar Datos (Opcional)
Si ya dispones de un archivo data.sql con la información del portfolio, impórtalo desde la terminal (PowerShell):

Get-Content data.sql | docker exec -i mysql_container mysql -u root -p SpringBoot

4. Configurar el Entorno
Crea el archivo src/main/resources/application.properties (este archivo está excluido por .gitignore por seguridad) y añade tus credenciales:

spring.datasource.url=jdbc:mysql://localhost:3306/SpringBoot
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update

5. Ejecutar la Aplicación

mvn spring-boot:run

Accede a la web en: http://localhost:8080

📂 Estructura del Proyecto

src/main/java: Lógica de negocio (Controladores, Modelos, Repositorios).
src/main/resources/templates: Vistas HTML dinámicas con Thymeleaf.
src/main/resources/static: Estilos CSS personalizados, scripts e imágenes.
fragments: Componentes modulares (Header y Footer) para una mayor mantenibilidad.

Desarrollado por David Ballestero - 2026
