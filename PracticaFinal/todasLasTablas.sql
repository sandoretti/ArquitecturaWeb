CREATE TABLE Pelicula (
    id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre_pelicula VARCHAR(255),
    sinopsis VARCHAR(32672),
    pagina_oficial VARCHAR(255),
    titulo_oficial VARCHAR(255),
    genero VARCHAR(100),
    nacionalidad VARCHAR(100),
    duracion INT,
    ano INT,
    distribuidora VARCHAR(255),
    director VARCHAR(255),
    actor VARCHAR(255),
    clasificacion_edad VARCHAR(50),
    otros_datos VARCHAR(32672),
    PRIMARY KEY (id)
);

CREATE TABLE Sala (
    id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre_sala VARCHAR(255),
    filas INT,
    columnas INT,
    PRIMARY KEY (id)
);

CREATE TABLE Proyeccion (
    id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_pelicula INT,
    id_sala INT,
    FOREIGN KEY (id_pelicula) REFERENCES Pelicula(id),
    FOREIGN KEY (id_sala) REFERENCES Sala(id),
    PRIMARY KEY (id)
);

CREATE TABLE Entrada (
    id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_proyeccion INT,
    fila INT,
    columna INT,
    fecha DATE,
    hora TIME,
    FOREIGN KEY (id_proyeccion) REFERENCES Proyeccion(id),
    PRIMARY KEY (id)
);

CREATE TABLE Cliente (
    id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    contrasena VARCHAR(100),
    fecha_registro TIMESTAMP,
    es_admin boolean default FALSE,
    PRIMARY KEY (id)
);

CREATE TABLE Reserva (
    id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_cliente INT,
    id_proyeccion INT,
    fecha_reserva TIMESTAMP,
    numero_tarjeta CHAR(16),
    referencia_reserva CHAR(8),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id),
    FOREIGN KEY (id_proyeccion) REFERENCES Proyeccion(id),
    PRIMARY KEY (id)
);

CREATE TABLE Comentario (
    id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_cliente INT,
    id_pelicula INT,
    texto VARCHAR(32672),
    fecha_comentario TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id),
    FOREIGN KEY (id_pelicula) REFERENCES Pelicula(id),
    PRIMARY KEY (id)
);

-- crea el administrador
INSERT INTO Cliente (nombre, apellido, email, contrasena, fecha_registro, es_admin) VALUES ('admin', 'el poderoso', 'admin@admin.com', '12345', CURRENT_TIMESTAMP, TRUE);