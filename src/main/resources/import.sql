-- ========================================
-- DATOS DE EJEMPLO - SISTEMA HOSPITALARIO
-- ========================================

-- ESPECIALIDADES
INSERT INTO especialidades (nombre, descripcion) VALUES ('Pediatría', 'Atención médica para niños y adolescentes');
INSERT INTO especialidades (nombre, descripcion) VALUES ('Traumatología', 'Tratamiento de lesiones del sistema musculoesquelético');
INSERT INTO especialidades (nombre, descripcion) VALUES ('Neurología', 'Diagnóstico y tratamiento de enfermedades del sistema nervioso');

-- MÉDICOS
INSERT INTO medicos (nombre, apellido, colegiatura, telefono, estado) VALUES ('Antony', 'Cholán', '123', '987654321', true);
INSERT INTO medicos (nombre, apellido, colegiatura, telefono, estado) VALUES ('Ricardo', 'Coello', '456', '987654322', true);
INSERT INTO medicos (nombre, apellido, colegiatura, telefono, estado) VALUES ('María', 'García', '789', '987654323', true);

-- RELACIÓN MÉDICO-ESPECIALIDAD
INSERT INTO medico_especialidad (medico_id, especialidad_id) VALUES (1, 1); -- Antony - Pediatría
INSERT INTO medico_especialidad (medico_id, especialidad_id) VALUES (2, 2); -- Ricardo - Traumatología
INSERT INTO medico_especialidad (medico_id, especialidad_id) VALUES (3, 3); -- María - Neurología

-- PACIENTES
INSERT INTO pacientes (nombres, apellidos, dni, telefono, correo, activo) VALUES ('Elver', 'Cholán', '12345678', '987111111', 'elver@email.com', true);
INSERT INTO pacientes (nombres, apellidos, dni, telefono, correo, activo) VALUES ('María', 'García', '87654321', '987222222', 'maria@email.com', true);
INSERT INTO pacientes (nombres, apellidos, dni, telefono, correo, activo) VALUES ('Carlos', 'López', '11223344', '987333333', 'carlos@email.com', true);
INSERT INTO pacientes (nombres, apellidos, dni, telefono, correo, activo) VALUES ('Ana', 'Martínez', '55667788', '987444444', 'ana@email.com', false);

-- HISTORIAS CLÍNICAS (se generan automáticamente con número único)
INSERT INTO historias_clinicas (numero_historia, fecha_apertura, paciente_id, observaciones) VALUES ('HC-20251014-0001', '2025-10-14', 1, 'Paciente regular sin complicaciones mayores');
INSERT INTO historias_clinicas (numero_historia, fecha_apertura, paciente_id, observaciones) VALUES ('HC-20251014-0002', '2025-10-14', 2, 'Requiere seguimiento post-operatorio');
INSERT INTO historias_clinicas (numero_historia, fecha_apertura, paciente_id, observaciones) VALUES ('HC-20251014-0003', '2025-10-14', 3, 'Paciente con antecedentes familiares importantes');
INSERT INTO historias_clinicas (numero_historia, fecha_apertura, paciente_id, observaciones) VALUES ('HC-20251014-0004', '2025-10-14', 4, 'Paciente inactivo temporalmente');

-- ANTECEDENTES MÉDICOS
INSERT INTO antecedentes_medicos (tipo, descripcion, fecha_registro, historia_clinica_id) VALUES ('Personal', 'Hipertensión arterial controlada', '2025-10-14', 1);
INSERT INTO antecedentes_medicos (tipo, descripcion, fecha_registro, historia_clinica_id) VALUES ('Alérgico', 'Alergia a la penicilina', '2025-10-14', 1);
INSERT INTO antecedentes_medicos (tipo, descripcion, fecha_registro, historia_clinica_id) VALUES ('Familiar', 'Diabetes tipo 2 (padre)', '2025-10-14', 2);
INSERT INTO antecedentes_medicos (tipo, descripcion, fecha_registro, historia_clinica_id) VALUES ('Quirúrgico', 'Apendicectomía en 2020', '2025-10-14', 2);
INSERT INTO antecedentes_medicos (tipo, descripcion, fecha_registro, historia_clinica_id) VALUES ('Personal', 'Asma bronquial', '2025-10-14', 3);

-- CITAS
INSERT INTO citas (paciente_id, medico_id, fecha, hora, motivo, estado) VALUES (1, 1, '2025-10-15', '09:00:00', 'Revisión general', 'PROGRAMADA');
INSERT INTO citas (paciente_id, medico_id, fecha, hora, motivo, estado) VALUES (2, 2, '2025-10-16', '14:30:00', 'Seguimiento post operatorio', 'ATENDIDA');