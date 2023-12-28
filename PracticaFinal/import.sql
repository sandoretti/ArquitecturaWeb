-- Crea el administrador
INSERT INTO Cliente (nombre, apellido, email, contrasena, fecha_registro, es_admin) VALUES ('admin', 'el poderoso', 'admin@admin.com', '12345', CURRENT_TIMESTAMP, TRUE);

-- Crear clientes
INSERT INTO Cliente (nombre, apellido, email, contrasena, fecha_registro) VALUES ('Juan', 'Perez', 'juan.perez@email.com', '12345', CURRENT_TIMESTAMP);
INSERT INTO Cliente (nombre, apellido, email, contrasena, fecha_registro) VALUES ('Maria', 'Gonzalez', 'maria.gonzalez@email.com', '12345', CURRENT_TIMESTAMP);
INSERT INTO Cliente (nombre, apellido, email, contrasena, fecha_registro) VALUES ('Pedro', 'Gonzalez', 'pedro.gonzalez@email.com', '12345', CURRENT_TIMESTAMP);

-- Crea los actores
INSERT INTO Actor (nombre, apellido) VALUES ('Joaquin', 'Phoenix');
INSERT INTO Actor (nombre, apellido) VALUES ('Robert', 'De Niro');
INSERT INTO Actor (nombre, apellido) VALUES ('Robert', 'Downey Jr.');

-- Crea las salas
INSERT INTO Sala (nombre_sala, filas, columnas) VALUES ('Sala 1', 10, 10);
INSERT INTO Sala (nombre_sala, filas, columnas) VALUES ('Sala 2', 10, 10);
INSERT INTO Sala (nombre_sala, filas, columnas) VALUES ('Sala 3', 10, 10);
INSERT INTO Sala (nombre_sala, filas, columnas) VALUES ('Sala 4', 10, 10);
INSERT INTO Sala (nombre_sala, filas, columnas) VALUES ('Sala 5', 10, 10);