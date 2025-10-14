-- ========================================
-- SCRIPT DE BASE DE DATOS - SISTEMA DE GESTIÓN HOSPITALARIA
-- Autor: Elver Antony Cholan Garcia
-- Fecha: 14 de Octubre 2025
-- ========================================

-- Crear base de datos
DROP DATABASE IF EXISTS lab08;
CREATE DATABASE lab08;
USE lab08;

-- ========================================
-- TABLA: ESPECIALIDADES
-- ========================================
CREATE TABLE especialidades (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);

-- ========================================
-- TABLA: MÉDICOS
-- ========================================
CREATE TABLE medicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    colegiatura VARCHAR(50) NOT NULL,
    telefono VARCHAR(20),
    estado BOOLEAN DEFAULT TRUE
);

-- ========================================
-- TABLA: RELACIÓN MÉDICO-ESPECIALIDAD (Many-to-Many)
-- ========================================
CREATE TABLE medico_especialidad (
    medico_id BIGINT NOT NULL,
    especialidad_id BIGINT NOT NULL,
    PRIMARY KEY (medico_id, especialidad_id),
    FOREIGN KEY (medico_id) REFERENCES medicos(id) ON DELETE CASCADE,
    FOREIGN KEY (especialidad_id) REFERENCES especialidades(id) ON DELETE CASCADE
);

-- ========================================
-- TABLA: PACIENTES
-- ========================================
CREATE TABLE pacientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni VARCHAR(8) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    correo VARCHAR(100),
    activo BOOLEAN DEFAULT TRUE
);

-- ========================================
-- TABLA: HISTORIAS CLÍNICAS
-- ========================================
CREATE TABLE historias_clinicas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_historia VARCHAR(50) NOT NULL UNIQUE,
    fecha_apertura DATE NOT NULL,
    paciente_id BIGINT NOT NULL UNIQUE,
    observaciones TEXT,
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id) ON DELETE CASCADE
);

-- ========================================
-- TABLA: ANTECEDENTES MÉDICOS
-- ========================================
CREATE TABLE antecedentes_medicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    descripcion TEXT NOT NULL,
    fecha_registro DATE NOT NULL,
    historia_clinica_id BIGINT NOT NULL,
    FOREIGN KEY (historia_clinica_id) REFERENCES historias_clinicas(id) ON DELETE CASCADE
);

-- ========================================
-- TABLA: CITAS
-- ========================================
CREATE TABLE citas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    paciente_id BIGINT NOT NULL,
    medico_id BIGINT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    motivo TEXT,
    estado VARCHAR(20) DEFAULT 'PROGRAMADA',
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES medicos(id) ON DELETE CASCADE
);

-- ========================================
-- DATOS DE PRUEBA
-- ========================================

-- ESPECIALIDADES
INSERT INTO especialidades (nombre, descripcion) VALUES 
('Pediatría', 'Atención médica para niños y adolescentes'),
('Traumatología', 'Tratamiento de lesiones del sistema musculoesquelético'),
('Neurología', 'Diagnóstico y tratamiento de enfermedades del sistema nervioso');

-- MÉDICOS
INSERT INTO medicos (nombre, apellido, colegiatura, telefono, estado) VALUES 
('Antony', 'Cholán', '123', '987654321', TRUE),
('Ricardo', 'Coello', '456', '987654322', TRUE),
('María', 'García', '789', '987654323', TRUE);

-- RELACIÓN MÉDICO-ESPECIALIDAD
INSERT INTO medico_especialidad (medico_id, especialidad_id) VALUES 
(1, 1), -- Antony - Pediatría
(2, 2), -- Ricardo - Traumatología
(3, 3); -- María - Neurología

-- PACIENTES
INSERT INTO pacientes (nombres, apellidos, dni, telefono, correo, activo) VALUES 
('Elver', 'Cholán', '12345678', '987111111', 'elver@email.com', TRUE),
('María', 'García', '87654321', '987222222', 'maria@email.com', TRUE),
('Carlos', 'López', '11223344', '987333333', 'carlos@email.com', TRUE),
('Ana', 'Martínez', '55667788', '987444444', 'ana@email.com', FALSE);

-- HISTORIAS CLÍNICAS
INSERT INTO historias_clinicas (numero_historia, fecha_apertura, paciente_id, observaciones) VALUES 
('HC-20251014-0001', '2025-10-14', 1, 'Paciente regular sin complicaciones mayores'),
('HC-20251014-0002', '2025-10-14', 2, 'Requiere seguimiento post-operatorio'),
('HC-20251014-0003', '2025-10-14', 3, 'Paciente con antecedentes familiares importantes'),
('HC-20251014-0004', '2025-10-14', 4, 'Paciente inactivo temporalmente');

-- ANTECEDENTES MÉDICOS
INSERT INTO antecedentes_medicos (tipo, descripcion, fecha_registro, historia_clinica_id) VALUES 
('Personal', 'Hipertensión arterial controlada', '2025-10-14', 1),
('Alérgico', 'Alergia a la penicilina', '2025-10-14', 1),
('Familiar', 'Diabetes tipo 2 (padre)', '2025-10-14', 2),
('Quirúrgico', 'Apendicectomía en 2020', '2025-10-14', 2),
('Personal', 'Asma bronquial', '2025-10-14', 3);

-- CITAS
INSERT INTO citas (paciente_id, medico_id, fecha, hora, motivo, estado) VALUES 
(1, 1, '2025-10-15', '09:00:00', 'Revisión general', 'PROGRAMADA'),
(2, 2, '2025-10-16', '14:30:00', 'Seguimiento post operatorio', 'ATENDIDA');

-- ========================================
-- CONSULTAS DE VERIFICACIÓN
-- ========================================

-- Ver todas las especialidades
SELECT * FROM especialidades;

-- Ver todos los médicos con sus especialidades
SELECT m.nombre, m.apellido, e.nombre AS especialidad
FROM medicos m
INNER JOIN medico_especialidad me ON m.id = me.medico_id
INNER JOIN especialidades e ON me.especialidad_id = e.id;

-- Ver todos los pacientes activos
SELECT * FROM pacientes WHERE activo = TRUE;

-- Ver historias clínicas con pacientes
SELECT hc.numero_historia, p.nombres, p.apellidos, hc.fecha_apertura
FROM historias_clinicas hc
INNER JOIN pacientes p ON hc.paciente_id = p.id;

-- Ver citas programadas
SELECT c.id, p.nombres AS paciente, m.nombre AS medico, c.fecha, c.hora, c.estado
FROM citas c
INNER JOIN pacientes p ON c.paciente_id = p.id
INNER JOIN medicos m ON c.medico_id = m.id;

-- ========================================
-- FIN DEL SCRIPT
-- ========================================
