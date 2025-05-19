INSERT INTO alumnos (nombre, matricula, contrasena, programa) VALUES
  ('Juan Pérez', 'A12345678', 'pwdJuan123', 'ICC'),
  ('María López', 'A87654321', 'pwdMaria456', 'LCC'),
  ('Luis Martínez', 'A11223344', 'pwdLuis789', 'ITI');

-- Profesores de ejemplo
INSERT INTO profesores (nombre, clave_profesor, programa) VALUES
  ('Dra. Beatriz Beltrán', 'P1001', 'ICC'),
  ('Dr. Mario Rossainz', 'P1002', 'LCC');

-- Asesorías de ejemplo
INSERT INTO asesorias (alumno_id, profesor_id, materia, es_tu_docente, fecha_solicitud, hora_solicitud, asunto, estado, comentario) VALUES
  (1, 1, 'Programación Web', TRUE,  '2025-05-20', '10:00:00', 'Dudas sobre Servlets', 'en proceso', NULL),
  (2, 2, 'Estructura de Datos', FALSE, '2025-05-18', '14:30:00', 'Repaso de árboles binarios', 'aceptada', 'Nos vemos en el laboratorio 3'),
  (3, 1, 'Bases de Datos', TRUE,  '2025-05-19', '09:00:00', 'Consultas JOIN complejas', 'denegada', 'Horario ocupado, intente otra fecha');
