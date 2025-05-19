# Proyecto Final: Sistema de Asesorías Web

Este proyecto es una aplicación web para la gestión de asesorías académicas, permitiendo la interacción entre alumnos y profesores.


## Estructura del Proyecto

```
build.xml
nbproject/
    ...archivos de configuración de NetBeans...
src/
    conf/
        MANIFEST.MF
    java/
web/
    index.html
    inicio_Sesion.jsp
    META-INF/
        context.xml
    WEB-INF/
```
### Estructura planteada:
AsesoriasWeb/
│
├── WebContent/
│   ├── index.html
│   ├── loginAlumno.jsp
│   ├── loginProfesor.jsp
│   ├── registro.jsp
│   ├── alumno/
│   │   ├── home.jsp
│   │   ├── solicitarAsesoria.jsp
│   │   ├── asesoriasAgendadas.jsp
│   └── profesor/
│       ├── solicitudes.jsp
│
├── src/
│   └── controlador/
│       ├── LoginServlet.java
│       ├── RegistroServlet.java
│       ├── AsesoriaServlet.java
│       ├── ProfesorServlet.java
│
├── modelos/
│   ├── Estudiante.java
│   ├── Asesoria.java
│   └── Profesor.java
│
├── BD/
│   └── asesorias_web.sql
│   └── conexion.java
│
└── build.xml

### Descripción de Carpetas y Archivos
- **build.xml**: Script de construcción del proyecto (usualmente usado por Apache Ant).
- **nbproject/**: Archivos de configuración del proyecto para NetBeans.
- **src/**: Código fuente y archivos de configuración.
  - **conf/**: Archivos de configuración, como el manifiesto de la aplicación.
  - **java/**: Aquí se debe ubicar el código Java (servlets, modelos, controladores).
- **web/**: Archivos web accesibles por el usuario y configuración de la aplicación.
  - **index.html**: Página principal.
  - **inicio_Sesion.jsp**: Página de inicio de sesión.
  - **META-INF/** y **WEB-INF/**: Carpetas de configuración estándar para aplicaciones Java EE.

## Requisitos
- JDK 8 o superior
- Apache Tomcat 8.5+ o servidor compatible con JSP/Servlets
- NetBeans (opcional, pero recomendado para facilitar la gestión del proyecto)

## Instalación y Ejecución
1. Clona o descarga este repositorio en tu máquina local.
2. Abre el proyecto en NetBeans o tu IDE favorito.
3. Configura un servidor Tomcat y asegúrate de que esté funcionando.
4. Compila y despliega el proyecto usando el archivo `build.xml` o desde el IDE.
5. Accede a la aplicación desde tu navegador en la URL correspondiente (por ejemplo, `http://localhost:8080/Proyecto_Final`).

## Notas
- Asegúrate de tener configurada la base de datos y los recursos necesarios en `context.xml` si la aplicación lo requiere.
- Personaliza este README según las características específicas de tu implementación.

## Autor
- [Tu nombre aquí]
