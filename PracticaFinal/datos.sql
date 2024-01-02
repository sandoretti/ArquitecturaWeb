-- Actores (14)
INSERT INTO actor (nombre, apellido) VALUES
('Johnny', 'Depp'),
('Cillian', 'Murphy'),
('Leonardo', 'DiCaprio'),
('Jennifer', 'Lawrence'),
('Scarlett', 'Johansson'),
('Brad', 'Pitt'),
('Christian', 'Bale'),
('Tom', 'Hardy'),
('Joseph', 'Gordon-Levitt'),
('Michael', 'Caine'),
('Bradley', 'Cooper'),
('Robert', 'Downey Jr.');

-- Crea el administrador (1)
INSERT INTO Cliente (nombre, apellido, email, contrasena, fecha_registro, es_admin) VALUES ('admin', 'el poderoso', 'admin@admin.com', '12345', CURRENT_TIMESTAMP, true);
-- Clientes (2-8)
INSERT INTO cliente (nombre, apellido, email, contrasena, fecha_registro, es_admin) VALUES
('Carlos', 'García', 'carlos@example.com', 'clave123', CURRENT_TIMESTAMP, false),
('Laura', 'Pérez', 'laura@example.com', '12345', CURRENT_TIMESTAMP, false),
('Ana', 'Martínez', 'ana@example.com', 'clave123', CURRENT_TIMESTAMP, false),
('David', 'López', 'david@example.com', '12345', CURRENT_TIMESTAMP, false),
('Elena', 'Rodríguez', 'elena@example.com', 'clave123', CURRENT_TIMESTAMP, false),
('Miguel', 'Sánchez', 'miguel@example.com', '12345', CURRENT_TIMESTAMP, false),
('María', 'López', 'maria@example.com', 'contraseña123', CURRENT_TIMESTAMP, false);

-- Salas (10)
INSERT INTO sala (nombre_sala, filas, columnas) VALUES
('Sala 1', 10, 15),
('Sala 2', 10, 12),
('Sala 3', 12, 18),
('Sala 4', 15, 20),
('Sala 5', 10, 18),
('Sala 6', 12, 15),
('Sala 7', 10, 12),
('Sala 3D', 12, 20),
('Sala VIP', 10, 10),
('Sala Infantil', 15, 25);

-- Películas (9)
INSERT INTO pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_oficial, genero, nacionalidad, duracion, ano, distribuidora, director, otros_datos, class_edad, portada) VALUES
('¿A quién ama Gilbert Grape?', 'Gilbert Grape (Johnny Depp) vive en una pequeña ciudad y cuida de su hermano con discapacidad mental, Arnie (Leonardo DiCaprio). Su vida se complica cuando conoce a una mujer, Becky (Juliette Lewis), que cambia su perspectiva sobre el amor y la responsabilidad familiar.', 'https://www.gilbertgrapemovie.com/', 'Whats Eating Gilbert Grape', 'Drama', 'Estados Unidos', 118, 1993, 'Paramount Pictures', 'Lasse Hallström', 'Actores: Johnny Depp, Leonardo DiCaprio', 'Apta para mayores de 13 años', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnNeN7QUITtGaFgs-P-um-jwhY-Fj3I3GXKAOV_kkqN7R2OZqE'),
('Origen', 'Dom Cobb (Leonardo DiCaprio) es un ladrón hábil que se especializa en robar secretos valiosos del subconsciente de las personas mientras sueñan. Se le ofrece la oportunidad de redimirse si puede realizar la tarea aparentemente imposible de "inserción de ideas".', 'http://inceptionmovie.warnerbros.com/', 'Inception', 'Ciencia ficción', 'Estados Unidos', 148, 2010, 'Warner Bros. Pictures', 'Christopher Nolan', 'Actores: Leonardo DiCaprio, Joseph Gordon-Levitt', 'Apta para mayores de 13 años', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTfZzcNIKne1CvXHbUn1q-wvuB7-eVp93ZmL2oI2sW0COs0OdcW'),
('The Dark Knight Rises', 'Ocho años después de la desaparición de Batman, Bruce Wayne (Christian Bale) vuelve a la acción para enfrentarse al terrorista Bane (Tom Hardy), quien amenaza con destruir Gotham City.', 'http://www.thedarkknightrises.com/', 'The Dark Knight Rises', 'Acción', 'Estados Unidos', 164, 2012, 'Warner Bros. Pictures', 'Christopher Nolan', 'Actores: Christian Bale, Tom Hardy', 'Apta para mayores de 13 años', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvBFJHFgWUsjg_M4qP742Y_isAC_Rh3P_ticEK5sYRIxlGlnWj'),
('La Gran Estafa Americana', 'En la década de 1970, el estafador Irving Rosenfeld (Christian Bale) y su socia Sydney Prosser (Amy Adams) son obligados a trabajar con un agente del FBI (Bradley Cooper) para desmantelar una red de corrupción política y financiera.', 'https://www.americanhustle-movie.com/', 'American Hustle', 'Crimen', 'Estados Unidos', 138, 2013, 'Columbia Pictures', 'David O. Russell', 'Actores: Christian Bale, Amy Adams, Bradley Cooper', 'Apta para mayores de 16 años', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRPj5j6JmrWXG395vliv6_y8nU5h62qAUjJ7sK9dWd29ogrhzR0'),
('El Truco Final', 'Dos magos, Robert Angier (Hugh Jackman) y Alfred Borden (Christian Bale), compiten ferozmente para crear el mejor truco de magia, pero su rivalidad lleva a consecuencias mortales y revelaciones sorprendentes.', 'https://wwws.warnerbros.co.uk/theprestige/', 'The Prestige', 'Drama', 'Estados Unidos', 130, 2006, 'Warner Bros. Pictures', 'Christopher Nolan', 'Actores: Hugh Jackman, Christian Bale', 'Apta para mayores de 13 años', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSTPe4-wizXAlotjWXAtEPVs8AZ8GpClhmbBMwNoInPFGOwi8Ex'),
('Don Jon', 'Jon Martello (Joseph Gordon-Levitt) es un joven adicto al porno que intenta cambiar su vida cuando conoce a Barbara Sugarman (Scarlett Johansson). La película explora temas de relaciones, expectativas y la búsqueda del amor verdadero.', 'http://www.donjonmovie.com/', 'Don Jon', 'Comedia', 'Estados Unidos', 90, 2013, 'Relativity Media', 'Joseph Gordon-Levitt', 'Actores: Joseph Gordon-Levitt, Scarlett Johansson', 'Apta para mayores de 18 años', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSFOJOs2bn0UYNxEYegtYDi1xibbjoca2Y-_HQxj-a3Pd_AfN2f'),
('Vengadores: Endgame', 'Los Vengadores se reúnen para derrotar a Thanos y revertir el daño causado por su chasquido de dedos, que desapareció a la mitad de la vida en el universo. La batalla final es épica y marca el fin de una era.', 'https://www.marvel.com/movies/avengers-endgame', 'Avengers: Endgame', 'Acción', 'Estados Unidos', 181, 2019, 'Marvel Studios', 'Anthony y Joe Russo', 'Actores: Robert Downey Jr., Chris Evans, Scarlett Johansson', 'Apta para mayores de 13 años', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQujAu6RsAWa1Wd-jdlI5ScYSt6-qAGjX8sGGmkHdesGK5LXQOv'),
('Érase una vez en Hollywood', 'La película sigue a Rick Dalton (Leonardo DiCaprio), un actor en decadencia, y su doble de riesgo, Cliff Booth (Brad Pitt), mientras intentan encontrar el éxito en la industria del cine en la década de 1960.', 'https://www.onceuponatimeinhollywood.movie/', 'Once Upon a Time in Hollywood', 'Comedia dramática', 'Estados Unidos', 161, 2019, 'Sony Pictures', 'Quentin Tarantino', 'Actores: Leonardo DiCaprio, Brad Pitt', 'Apta para mayores de 16 años', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlSFE8ZPwkDZ5QBla-hpvAIQkHNIOE1lyFDsKrCh5kUPZFLxlR'),
('El renacido', 'Hugh Glass (Leonardo DiCaprio) lucha por sobrevivir en el desierto después de ser atacado por un oso y abandonado por su equipo de caza. La película narra su épica búsqueda de venganza.', 'https://www.foxmovies.com/movies/the-revenant', 'The Revenant', 'Aventura', 'Estados Unidos', 156, 2015, '20th Century Studios', 'Alejandro González Iñárritu', 'Actores: Leonardo DiCaprio, Tom Hardy', 'Apta para mayores de 18 años', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAF6B6bTlYVHDopMd43EAInxIABjUdHCdZawmdR5RVKjCD8r1b');


-- Comentarios
INSERT INTO comentario (id_cliente, id_pelicula, texto, fecha_comentario) VALUES
(2, 1, '¡Una película con una historia conmovedora y actuaciones impresionantes!', '2023-01-15 12:30:00'),
(3, 2, 'Inception es una obra maestra de la ciencia ficción, ¡me dejó pensando durante días!', '2023-02-02 15:45:00'),
(4, 3, 'El regreso de Batman fue épico, ¡Christian Bale y Tom Hardy brillaron en sus roles!', '2023-02-20 18:20:00'),
(5, 4, 'American Hustle tiene un elenco increíble y una trama intrigante, ¡me mantuvo al borde de mi asiento!', '2023-03-10 21:10:00'),
(6, 5, 'The Prestige es una película fascinante sobre magia y rivalidad, ¡Hugh Jackman y Christian Bale fueron fenomenales!', '2023-03-28 09:00:00'),
(7, 6, 'Don Jon aborda temas interesantes con humor, ¡Joseph Gordon-Levitt y Scarlett Johansson hacen una pareja increíble!', '2023-04-15 14:30:00'),
(8, 7, 'Avengers: Endgame fue la culminación perfecta del Universo Cinematográfico de Marvel, ¡una experiencia inolvidable!', '2023-05-01 20:45:00'),
(2, 8, 'Érase una vez en Hollywood captura perfectamente la atmósfera de la década de 1960, ¡Leonardo DiCaprio y Brad Pitt brillan!', '2023-05-18 11:55:00'),
(3, 9, 'El renacido es una experiencia intensa y visualmente impresionante, ¡Leonardo DiCaprio entrega una actuación magistral!', '2023-06-02 17:30:00'),
(4, 8, 'Once Upon a Time in Hollywood es un viaje nostálgico y divertido, ¡Quentin Tarantino sabe cómo contar una historia!', '2023-06-20 19:40:00'),
(5, 1, '¿A quién ama Gilbert Grape? es conmovedora y realista, ¡Johnny Depp y Leonardo DiCaprio son asombrosos!', '2023-07-05 08:15:00'),
(6, 2, 'La trama de Inception es tan ingeniosa, ¡Christopher Nolan siempre sorprende con su creatividad!', '2023-07-22 13:20:00'),
(7, 3, 'The Dark Knight Rises cierra la trilogía de Batman de manera épica, ¡una montaña rusa de emociones!', '2023-08-08 16:55:00'),
(8, 4, 'American Hustle tiene un guion brillante y giros inesperados, ¡una joya del cine contemporáneo!', '2023-08-25 22:10:00'),
(2, 5, 'The Prestige es un thriller psicológico fascinante, ¡la rivalidad entre Jackman y Bale es increíble!', '2023-09-10 10:05:00'),
(3, 6, 'Don Jon aborda la adicción de manera honesta y divertida, ¡Joseph Gordon-Levitt es brillante!', '2023-09-27 14:40:00'),
(4, 7, 'Avengers: Endgame es un espectáculo impresionante, ¡el final perfecto para una saga increíble!', '2023-10-15 18:25:00'),
(5, 8, 'Érase una vez en Hollywood es una oda al cine clásico, ¡DiCaprio y Pitt forman un dúo increíble!', '2023-10-31 23:50:00'),
(6, 9, 'El renacido es visualmente impactante, ¡la dirección de Iñárritu y la actuación de DiCaprio son sobresalientes!', '2023-11-15 12:15:00');


-- Proyecciones (generación manual para 9 películas, 10 salas y hasta 4 proyecciones por película)
INSERT INTO proyeccion (id_pelicula, id_sala, fecha_hora)
VALUES
-- Proyecciones para la película con id 1
(1, 1, '2023-01-01 15:00:00'),
(1, 1, '2023-01-02 18:00:00'),
(1, 2, '2023-01-03 20:00:00'),

-- Proyecciones para la película con id 2
(2, 2, '2023-01-01 15:30:00'),
(2, 6, '2023-01-02 19:30:00'),
(2, 5, '2023-01-03 20:30:00'),
(2, 8, '2023-01-03 22:00:00'),

-- Proyecciones para la película con id 3
(3, 9, '2023-01-01 19:00:00'),
(3, 10, '2023-01-03 14:00:00'),
(3, 1, '2023-01-03 14:00:00'),
(3, 2, '2023-01-04 19:00:00'),

-- Proyecciones para la película con id 4
(4, 3, '2023-01-01 14:00:00'),
(4, 4, '2023-01-02 16:00:00'),
(4, 5, '2023-01-03 16:00:00'),
(4, 6, '2023-01-03 18:00:00'),

-- Proyecciones para la película con id 5
(5, 1, '2023-01-01 20:00:00'),
(5, 2, '2023-01-02 20:00:00'),
(5, 3, '2023-01-04 18:00:00'),
(5, 4, '2023-01-04 20:00:00'),

-- Proyecciones para la película con id 6
(6, 5, '2023-01-01 21:30:00'),
(6, 6, '2023-01-03 21:30:00'),
(6, 7, '2023-01-04 21:30:00'),
(6, 8, '2023-01-05 21:30:00'),

-- Proyecciones para la película con id 7
(7, 9, '2023-01-01 15:30:00'),
(7, 10, '2023-01-02 15:30:00'),
(7, 1, '2023-01-02 19:30:00'),
(7, 2, '2023-01-04 15:30:00'),

-- Proyecciones para la película con id 8
(8, 3, '2023-01-01 17:30:00'),
(8, 4, '2023-01-02 19:30:00'),
(8, 6, '2023-01-04 17:30:00'),

-- Proyecciones para la película con id 9
(9, 7, '2023-01-01 18:00:00'),
(9, 10, '2023-01-01 18:00:00');


INSERT INTO entrada (id_proyeccion, fila, columna)
VALUES
-- Combinaciones para la entrada con id_proyeccion 1
(1, 1, 1), (1, 1, 2), (1, 1, 3), (1, 1, 4), (1, 1, 5), (1, 1, 6), (1, 1, 7), (1, 1, 8), (1, 1, 9),
(1, 2, 1), (1, 2, 2), (1, 2, 3), (1, 2, 4), (1, 2, 5), (1, 2, 6), (1, 2, 7), (1, 2, 8), (1, 2, 9),
(1, 3, 1), (1, 3, 2), (1, 3, 3), (1, 3, 4), (1, 3, 5), (1, 3, 6), (1, 3, 7), (1, 3, 8), (1, 3, 9),
-- ... Puedes continuar hasta (1, 9, 9)

-- Combinaciones para la entrada con id_proyeccion 2
(2, 1, 1), (2, 1, 2), (2, 1, 3), (2, 1, 4), (2, 1, 5), (2, 1, 6), (2, 1, 7), (2, 1, 8), (2, 1, 9),
(2, 2, 1), (2, 2, 2), (2, 2, 3), (2, 2, 4), (2, 2, 5), (2, 2, 6), (2, 2, 7), (2, 2, 8), (2, 2, 9),
(2, 3, 1), (2, 3, 2), (2, 3, 3), (2, 3, 4), (2, 3, 5), (2, 3, 6), (2, 3, 7), (2, 3, 8), (2, 3, 9),
-- ... Continuar hasta (2, 9, 9)

-- Combinaciones para la entrada con id_proyeccion 3
(3, 1, 1), (3, 1, 2), (3, 1, 3), (3, 1, 4), (3, 1, 5), (3, 1, 6), (3, 1, 7), (3, 1, 8), (3, 1, 9),
(3, 2, 1), (3, 2, 2), (3, 2, 3), (3, 2, 4), (3, 2, 5), (3, 2, 6), (3, 2, 7), (3, 2, 8), (3, 2, 9),
(3, 3, 1), (3, 3, 2), (3, 3, 3), (3, 3, 4), (3, 3, 5), (3, 3, 6), (3, 3, 7), (3, 3, 8), (3, 3, 9),
-- ... Continuar hasta (3, 9, 9)

-- Combinaciones para la entrada con id_proyeccion 4
(4, 1, 1), (4, 1, 2), (4, 1, 3), (4, 1, 4), (4, 1, 5), (4, 1, 6), (4, 1, 7), (4, 1, 8), (4, 1, 9),
(4, 2, 1), (4, 2, 2), (4, 2, 3), (4, 2, 4), (4, 2, 5), (4, 2, 6), (4, 2, 7), (4, 2, 8), (4, 2, 9),
(4, 3, 1), (4, 3, 2), (4, 3, 3), (4, 3, 4), (4, 3, 5), (4, 3, 6), (4, 3, 7), (4, 3, 8), (4, 3, 9),
-- ... Continuar hasta (4, 9, 9)

-- Combinaciones para la entrada con id_proyeccion 5
(5, 1, 1), (5, 1, 2), (5, 1, 3), (5, 1, 4), (5, 1, 5), (5, 1, 6), (5, 1, 7), (5, 1, 8), (5, 1, 9),
(5, 2, 1), (5, 2, 2), (5, 2, 3), (5, 2, 4), (5, 2, 5), (5, 2, 6), (5, 2, 7), (5, 2, 8), (5, 2, 9),
(5, 3, 1), (5, 3, 2), (5, 3, 3), (5, 3, 4), (5, 3, 5), (5, 3, 6), (5, 3, 7), (5, 3, 8), (5, 3, 9),
-- ... Continuar hasta (5, 9, 9)

-- Combinaciones para la entrada con id_proyeccion 6
(6, 1, 1), (6, 1, 2), (6, 1, 3), (6, 1, 4), (6, 1, 5), (6, 1, 6), (6, 1, 7), (6, 1, 8), (6, 1, 9),
(6, 2, 1), (6, 2, 2), (6, 2, 3), (6, 2, 4), (6, 2, 5), (6, 2, 6), (6, 2, 7), (6, 2, 8), (6, 2, 9),
(6, 3, 1), (6, 3, 2), (6, 3, 3), (6, 3, 4), (6, 3, 5), (6, 3, 6), (6, 3, 7), (6, 3, 8), (6, 3, 9),
-- ... Continuar hasta (6, 9, 9)

-- Combinaciones para la entrada con id_proyeccion 7
(7, 1, 1), (7, 1, 2), (7, 1, 3), (7, 1, 4), (7, 1, 5), (7, 1, 6), (7, 1, 7), (7, 1, 8), (7, 1, 9),
(7, 2, 1), (7, 2, 2), (7, 2, 3), (7, 2, 4), (7, 2, 5), (7, 2, 6), (7, 2, 7), (7, 2, 8), (7, 2, 9),
(7, 3, 1), (7, 3, 2), (7, 3, 3), (7, 3, 4), (7, 3, 5), (7, 3, 6), (7, 3, 7), (7, 3, 8), (7, 3, 9),
-- ... Continuar hasta (7, 9, 9)

-- Combinaciones para la entrada con id_proyeccion 8
(8, 1, 1), (8, 1, 2), (8, 1, 3), (8, 1, 4), (8, 1, 5), (8, 1, 6), (8, 1, 7), (8, 1, 8), (8, 1, 9),
(8, 2, 1), (8, 2, 2), (8, 2, 3), (8, 2, 4), (8, 2, 5), (8, 2, 6), (8, 2, 7), (8, 2, 8), (8, 2, 9),
(8, 3, 1), (8, 3, 2), (8, 3, 3), (8, 3, 4), (8, 3, 5), (8, 3, 6), (8, 3, 7), (8, 3, 8), (8, 3, 9),
-- ... Continuar hasta (8, 9, 9)

-- Combinaciones para la entrada con id_proyeccion 9
(9, 1, 1), (9, 1, 2), (9, 1, 3), (9, 1, 4), (9, 1, 5), (9, 1, 6), (9, 1, 7), (9, 1, 8), (9, 1, 9),
(9, 2, 1), (9, 2, 2), (9, 2, 3), (9, 2, 4), (9, 2, 5), (9, 2, 6), (9, 2, 7), (9, 2, 8), (9, 2, 9),
(9, 3, 1), (9, 3, 2), (9, 3, 3), (9, 3, 4), (9, 3, 5), (9, 3, 6), (9, 3, 7), (9, 3, 8), (9, 3, 9);
-- ... Continuar hasta (9, 9, 9)



-- ¿A quién ama Gilbert Grape?
INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
    (1, 1),  -- Johnny Depp
    (1, 3);  -- Leonardo DiCaprio

-- Origen
INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
    (2, 2),  -- Cillian Murphy
    (2, 3),  -- Leonardo DiCaprio
    (2, 8);  -- Tom Hardy

-- The Dark Knight Rises
INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
    (3, 2),  -- Cillian Murphy
    (3, 7),  -- Christian Bale
    (3, 9),  -- Joseph Gordon-Levitt
    (3, 8),  -- Tom Hardy
    (3, 10);  -- Michael Caine

-- La Gran Estafa Americana
INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
    (4, 7),  -- Christian Bale
    (4, 11),  -- Bradley Cooper
    (4, 4);  -- Jennifer Lawrence

-- El Truco Final
INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
    (5, 7),  -- Christian Bale
    (5, 10),  -- Michael Caine
    (5, 5);  -- Scarlett Johansson

-- Don Jon
INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
    (6, 9),  -- Joseph Gordon-Levitt
    (6, 5),  -- Scarlett Johansson
    (6, 3);  -- Leonardo DiCaprio

-- Vengadores: Endgame
INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
    (7, 3),  -- Leonardo DiCaprio
    (7, 12),  -- Robert Downey Jr.
    (7, 5);  -- Scarlett Johansson

-- Érase una vez en Hollywood
INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
    (8, 3),  -- Leonardo DiCaprio
    (8, 6);  -- Brad Pitt

-- El renacido
INSERT INTO pelicula_actor (pelicula_id, actor_id) VALUES
    (9, 3),  -- Leonardo DiCaprio
    (9, 8);  -- Tom Hardy


-- Reservas
INSERT INTO reserva (id_cliente, fecha_reserva, numero_tarjeta, referencia_reserva, precio) VALUES
(2, CURRENT_TIMESTAMP, '************1234', 'ABC123', 15.99),
(3, CURRENT_TIMESTAMP, '************5678', 'DEF456', 18.50),
(4, CURRENT_TIMESTAMP, '************4321', 'XYZ789', 19.99),
(5, CURRENT_TIMESTAMP, '************8765', 'GHI123', 22.50),
(8, CURRENT_TIMESTAMP, '************1111', 'RES123', 14.99),
(3, CURRENT_TIMESTAMP, '************2222', 'RES456', 17.50),
(4, CURRENT_TIMESTAMP, '************3333', 'RES789', 21.99),
(5, CURRENT_TIMESTAMP, '************4444', 'RESABC', 24.50),
(6, CURRENT_TIMESTAMP, '************5555', 'RESDEF', 18.99),
(2, CURRENT_TIMESTAMP, '************6666', 'RESGHI', 25.99),
(7, CURRENT_TIMESTAMP, '************7777', 'RESJKL', 19.50);
