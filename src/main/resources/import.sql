-- ========================================
-- DATOS DE EJEMPLO - SISTEMA HOSPITALARIO
-- ========================================

-- ESPECIALIDADES
INSERT INTO especialidades (nombre, descripcion) VALUES ('Pediatría', 'Atención médica para niños y adolescentes');
INSERT INTO especialidades (nombre, descripcion) VALUES ('Traumatología', 'Tratamiento de lesiones del sistema musculoesquelético');
INSERT INTO especialidades (nombre, descripcion) VALUES ('Neurología', 'Diagnóstico y tratamiento de enfermedades del sistema nervioso');
INSERT INTO especialidades (nombre, descripcion) VALUES ('Cardiología', 'Especialidad enfocada en el corazón y sistema circulatorio');

-- MÉDICOS
INSERT INTO medicos (nombre, apellido, colegiatura, telefono, estado) VALUES ('Antony', 'Cholán', '123', '987654321', true);
INSERT INTO medicos (nombre, apellido, colegiatura, telefono, estado) VALUES ('Ricardo', 'Coello', '456', '987654322', true);
INSERT INTO medicos (nombre, apellido, colegiatura, telefono, estado) VALUES ('María', 'García', '789', '987654323', true);

-- RELACIÓN MÉDICO-ESPECIALIDAD
INSERT INTO medico_especialidad (medico_id, especialidad_id) VALUES (1, 1); -- Antony - Pediatría
INSERT INTO medico_especialidad (medico_id, especialidad_id) VALUES (2, 2); -- Ricardo - Traumatología
INSERT INTO medico_especialidad (medico_id, especialidad_id) VALUES (3, 3); -- María - Neurología

-- PACIENTES
INSERT INTO pacientes (nombres, apellidos, dni, telefono, correo) VALUES ('Elver', 'Cholán', '12345678', '987111111', 'elver@email.com');
INSERT INTO pacientes (nombres, apellidos, dni, telefono, correo) VALUES ('María', 'García', '87654321', '987222222', 'maria@email.com');
INSERT INTO pacientes (nombres, apellidos, dni, telefono, correo) VALUES ('Carlos', 'López', '11223344', '987333333', 'carlos@email.com');

-- CITAS
INSERT INTO citas (paciente_id, medico_id, fecha, hora, motivo, estado) VALUES (1, 1, '2025-10-15', '09:00:00', 'Revisión general', 'PROGRAMADA');
INSERT INTO citas (paciente_id, medico_id, fecha, hora, motivo, estado) VALUES (2, 2, '2025-10-16', '14:30:00', 'Seguimiento post operatorio', 'ATENDIDA');