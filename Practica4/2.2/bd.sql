-- Crear las tablas
CREATE TABLE Profesor (
    DNI VARCHAR(20) PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Sueldo FLOAT
);

CREATE TABLE Asignatura (
    IDAsignatura INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Descripcion VARCHAR(255),
    DNIProfesor VARCHAR(20),
    FOREIGN KEY (DNIProfesor) REFERENCES Profesor(DNI)
);

CREATE TABLE Alumno (
    DNI VARCHAR(20) PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Sueldo FLOAT
);

CREATE TABLE Asistencia (
    DNIAlumno VARCHAR(20),
    IDAsignatura INT,
    PRIMARY KEY (DNIAlumno, IDAsignatura),
    FOREIGN KEY (DNIAlumno) REFERENCES Alumno(DNI),
    FOREIGN KEY (IDAsignatura) REFERENCES Asignatura(IDAsignatura)
);

-- Insertar datos en las tablas
-- Profesor
INSERT INTO Profesor (DNI, Nombre, Apellido, Sueldo) VALUES
    ('123456789A', 'Juan', 'Perez', 50000.00),
    ('987654321B', 'Maria', 'Gomez', 48000.50),
    ('555666777C', 'Ana', 'Garcia', 52000.75),
    ('888999000D', 'Javier', 'Fernandez', 49000.00);

-- Asignatura
INSERT INTO Asignatura (IDAsignatura, Nombre, Descripcion, DNIProfesor) VALUES
    (1, 'Matematicas', 'Curso de matematicas avanzadas', '123456789A'),
    (2, 'Historia', 'Curso de historia antigua', '987654321B'),
    (3, 'Ciencias', 'Curso de ciencias naturales', '555666777C'),
    (4, 'Ingles', 'Curso de ingles avanzado', '888999000D');

-- Alumno
INSERT INTO Alumno (DNI, Nombre, Apellido, Sueldo) VALUES
    ('111222333X', 'Carlos', 'Martinez', 25000.75),
    ('444555666Y', 'Laura', 'Lopez', 26000.25),
    ('777888999Z', 'Miguel', 'Sanchez', 27000.50),
    ('111222333A', 'Isabel', 'Rodriguez', 25500.00),
    ('333444555W', 'Roberto', 'Gutierrez', 26500.00),
    ('666777888V', 'Elena', 'Ramirez', 25550.25),
    ('999888777U', 'Luisa', 'Diaz', 28000.50),
    ('222333444T', 'Pedro', 'Lopez', 27000.75),
    ('555666777S', 'Sofia', 'Gomez', 26000.00);

-- Asistencia
INSERT INTO Asistencia (DNIAlumno, IDAsignatura) VALUES
    ('111222333X', 1),
    ('444555666Y', 2),
    ('111222333X', 2),
    ('777888999Z', 3),
    ('111222333A', 4),
    ('777888999Z', 4),
    ('444555666Y', 3),
    ('333444555W', 1),
    ('666777888V', 2),
    ('333444555W', 3),
    ('666777888V', 1),
    ('999888777U', 2),
    ('222333444T', 3),
    ('555666777S', 1),
    ('999888777U', 4),
    ('222333444T', 1),
    ('555666777S', 2);
