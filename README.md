# Sistema de Gestión Hospitalaria

## Descripción
Sistema de gestión hospitalaria desarrollado con Spring Boot que permite administrar especialidades médicas, médicos, pacientes con historias clínicas y citas.

## Autor
**Elver Antony Cholan Garcia**

---

## Requisitos Previos
- Java 21
- MySQL Server (versión 5.7 o superior)
- Maven (o usar el wrapper incluido)

---

## Configuración de Base de Datos

### Opción 1: Ejecutar el Script SQL Completo

1. Abrir MySQL Workbench o línea de comandos de MySQL
2. Ejecutar el archivo `database_script.sql` que se encuentra en la raíz del proyecto:

```bash
mysql -u root -p < database_script.sql
```

O copiar y pegar el contenido del archivo en MySQL Workbench.

Este script:
- Crea la base de datos `lab08`
- Crea todas las tablas necesarias
- Inserta datos de prueba

### Opción 2: Dejar que Spring Boot lo haga automáticamente

La aplicación está configurada para crear las tablas automáticamente y cargar los datos de prueba desde `import.sql`.

Solo necesitas:
1. Crear la base de datos manualmente:
```sql
CREATE DATABASE lab08;
```

2. Configurar las credenciales en `application.properties` si es necesario:
```properties
spring.datasource.username=root
spring.datasource.password=
```

---

## Instalación y Ejecución

### Usando Maven Wrapper (Recomendado)
```bash
# Compilar el proyecto
.\mvnw.cmd clean compile

# Ejecutar la aplicación
.\mvnw.cmd spring-boot:run
```

### Usando Maven
```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar la aplicación
mvn spring-boot:run
```

## Acceso a la Aplicación

Una vez iniciada la aplicación, acceder a:
```
http://localhost:8080
```

---

## 📚 Módulos Implementados

### 1. Gestión de Especialidades
- ✅ Listar especialidades
- ✅ Crear especialidad
- ✅ Editar especialidad
- ✅ Eliminar especialidad

**Ruta:** http://localhost:8080/especialidades

### 2. Gestión de Médicos
- ✅ Listar médicos con sus especialidades
- ✅ Crear médico (asignar múltiples especialidades)
- ✅ Editar médico
- ✅ Eliminar médico
- ✅ Activar/Desactivar médico

**Ruta:** http://localhost:8080/medicos

### 3. Gestión de Pacientes
- ✅ Listar pacientes
- ✅ Registrar paciente (genera automáticamente historia clínica)
- ✅ Editar paciente
- ✅ Activar/Desactivar paciente
- ✅ Ver historia clínica completa
- ✅ Agregar antecedentes médicos (Personal, Familiar, Quirúrgico, Alérgico)
- ✅ Eliminar antecedentes

**Ruta:** http://localhost:8080/pacientes

### 4. Gestión de Citas
- ✅ Listar citas médicas
- ✅ Crear cita (seleccionar paciente y médico)
- ✅ Editar cita
- ✅ Eliminar cita
- ✅ Estados: PROGRAMADA, ATENDIDA, CANCELADA

**Ruta:** http://localhost:8080/citas

---

## 📊 Datos de Prueba Incluidos

### Especialidades (3)
- Pediatría
- Traumatología
- Neurología

### Médicos (3)
- Antony Cholán (Pediatría)
- Ricardo Coello (Traumatología)
- María García (Neurología)

### Pacientes (4)
- Elver Cholán (ACTIVO) - Con historia clínica y antecedentes
- María García (ACTIVO) - Con historia clínica y antecedentes
- Carlos López (ACTIVO) - Con historia clínica y antecedentes
- Ana Martínez (INACTIVO) - Con historia clínica

### Citas (2)
- Elver Cholán con Dr. Antony Cholán - 15/10/2025 09:00 - PROGRAMADA
- María García con Dr. Ricardo Coello - 16/10/2025 14:30 - ATENDIDA

---

## 🛠️ Tecnologías Utilizadas

- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **Thymeleaf**
- **MySQL 8.0**
- **Bootstrap 5.3.3**
- **Bootstrap Icons**
- **Maven**

---

## 📁 Estructura del Proyecto

```
src/
├── main/
│   ├── java/antony/examendaw/
│   │   ├── controllers/        # Controladores web
│   │   ├── entities/           # Entidades JPA
│   │   ├── repositories/       # Repositorios JPA
│   │   └── services/           # Servicios de negocio
│   └── resources/
│       ├── templates/          # Vistas Thymeleaf
│       │   ├── especialidad/
│       │   ├── medico/
│       │   ├── paciente/
│       │   ├── cita/
│       │   └── fragments/
│       ├── application.properties
│       └── import.sql          # Datos de prueba
└── database_script.sql         # Script SQL completo
```

---

## 🎯 Funcionalidades Destacadas

### RF1: Gestión de Pacientes
- ✅ Registrar, actualizar, consultar y desactivar pacientes

### RF2: Historia Clínica Automática
- ✅ Se genera automáticamente al registrar un paciente
- ✅ Número único de historia clínica (formato: HC-YYYYMMDD-XXXX)

### RF3: Antecedentes Médicos
- ✅ Registro de antecedentes asociados a la historia clínica
- ✅ Tipos: Personal, Familiar, Quirúrgico, Alérgico
- ✅ Fecha de registro automática

---

## 📝 Notas Importantes

- La aplicación usa `spring.jpa.hibernate.ddl-auto=create` para recrear las tablas en cada inicio
- Los datos de prueba se cargan automáticamente desde `import.sql`
- El puerto por defecto es 8080
- La contraseña de MySQL está vacía por defecto (cambiar en `application.properties` si es necesario)

---

## Autor
**Elver Antony Cholan Garcia**

## Repositorio
https://github.com/ELVERANTONY/examen-2-daw-antonycholan.git
