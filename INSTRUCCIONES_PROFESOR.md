## Sistema de Gestión Hospitalaria
**Autor:** Elver Antony Cholan Garcia

---
### 1️ Configurar Base de Datos

**Opción A - Script Automático (Recomendado):**
```bash
mysql -u root -p < database_script.sql
```
**Opción B - Manual:**
```sql
CREATE DATABASE lab08;
```

### 2️ Ejecutar la Aplicación

Abrir terminal en IntelliJ IDEA y ejecutar:
```powershell
.\mvnw.cmd clean spring-boot:run
```

### 3️ Acceder al Sistema

Abrir navegador en:
```
http://localhost:8080
```

### Puerto de la Aplicación
```
http://localhost:8080
