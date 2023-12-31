CREATE TABLE actor (
    id       INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre   VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cliente (
    id             INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre         VARCHAR(100) NOT NULL,
    apellido       VARCHAR(100) NOT NULL,
    email          VARCHAR(100) NOT NULL UNIQUE,
    contrasena     VARCHAR(100) NOT NULL,
    fecha_registro TIMESTAMP NOT NULL,
    es_admin       BOOLEAN DEFAULT false NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE sala (
    id          INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre_sala VARCHAR(255) NOT NULL,
    filas       INTEGER NOT NULL,
    columnas    INTEGER NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE pelicula (
    id              INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre_pelicula VARCHAR(255) NOT NULL,
    sinopsis        VARCHAR(32672) NOT NULL,
    pagina_oficial  VARCHAR(255) NOT NULL,
    titulo_oficial  VARCHAR(255) NOT NULL,
    genero          VARCHAR(100) NOT NULL,
    nacionalidad    VARCHAR(100) NOT NULL,
    duracion        INTEGER NOT NULL,
    ano             INTEGER NOT NULL,
    distribuidora   VARCHAR(255) NOT NULL,
    director        VARCHAR(255) NOT NULL,
    otros_datos     VARCHAR(255) NOT NULL,
    class_edad      VARCHAR(255) NOT NULL,
    portada         VARCHAR(255),
    PRIMARY KEY (id)
);


CREATE TABLE comentario (
    id               INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_cliente       INTEGER NOT NULL,
    id_pelicula      INTEGER NOT NULL,
    texto            VARCHAR(32672) NOT NULL,
    fecha_comentario TIMESTAMP NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE CASCADE,
    FOREIGN KEY (id_pelicula) REFERENCES pelicula(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE proyeccion (
    id          INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_pelicula INTEGER NOT NULL,
    id_sala     INTEGER NOT NULL,
    fecha_hora  TIMESTAMP NOT NULL,
    FOREIGN KEY (id_pelicula) REFERENCES pelicula(id) ON DELETE CASCADE,
    FOREIGN KEY (id_sala) REFERENCES sala(id),
    PRIMARY KEY (id)
);

CREATE TABLE entrada (
    id            INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_proyeccion INTEGER NOT NULL,
    fila          INTEGER NOT NULL,
    columna       INTEGER NOT NULL,
    FOREIGN KEY (id_proyeccion) REFERENCES proyeccion(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE pelicula_actor (
    id          INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    pelicula_id INTEGER NOT NULL,
    actor_id    INTEGER NOT NULL,
    FOREIGN KEY (pelicula_id) REFERENCES pelicula(id) ON DELETE CASCADE,
    FOREIGN KEY (actor_id) REFERENCES actor(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE reserva (
    id                 INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_cliente         INTEGER NOT NULL,
    fecha_reserva      TIMESTAMP NOT NULL,
    numero_tarjeta     CHAR(16) NOT NULL,
    referencia_reserva CHAR(8) NOT NULL,
    precio             REAL NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE reserva_entrada (
    id         INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    reserva_id INTEGER NOT NULL,
    entrada_id INTEGER NOT NULL,
    FOREIGN KEY (reserva_id) REFERENCES reserva(id) ON DELETE CASCADE,
    FOREIGN KEY (entrada_id) REFERENCES entrada(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);