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
('Sala 1', 5, 12),
('Sala 2', 7, 10),
('Sala 3', 9, 15),
('Sala 4', 10, 18),
('Sala 5', 7, 16),
('Sala 6', 9, 12),
('Sala 7', 7, 10),
('Sala 3D', 9, 16),
('Sala VIP', 7, 8),
('Sala Infantil', 10, 20);

-- Películas (9)
INSERT INTO pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_oficial, genero, nacionalidad, duracion, ano, distribuidora, director, otros_datos, class_edad, portada, trailer) VALUES
('¿A quién ama Gilbert Grape?', 'Gilbert Grape (Johnny Depp) vive en una pequeña ciudad y cuida de su hermano con discapacidad mental, Arnie (Leonardo DiCaprio). Su vida se complica cuando conoce a una mujer, Becky (Juliette Lewis), que cambia su perspectiva sobre el amor y la responsabilidad familiar.', 'https://www.gilbertgrapemovie.com/', 'Whats Eating Gilbert Grape', 'Drama', 'Estados Unidos', 118, 1993, 'Paramount Pictures', 'Lasse Hallström', 'Actores: Johnny Depp, Leonardo DiCaprio', '+13', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnNeN7QUITtGaFgs-P-um-jwhY-Fj3I3GXKAOV_kkqN7R2OZqE', 'https://www.youtube.com/embed/nCsVjQaNV0E'),
('Origen', 'Dom Cobb (Leonardo DiCaprio) es un ladrón hábil que se especializa en robar secretos valiosos del subconsciente de las personas mientras sueñan. Se le ofrece la oportunidad de redimirse si puede realizar la tarea aparentemente imposible de "inserción de ideas".', 'http://inceptionmovie.warnerbros.com/', 'Inception', 'Ciencia ficción', 'Estados Unidos', 148, 2010, 'Warner Bros. Pictures', 'Christopher Nolan', 'Actores: Leonardo DiCaprio, Joseph Gordon-Levitt', '+13', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTfZzcNIKne1CvXHbUn1q-wvuB7-eVp93ZmL2oI2sW0COs0OdcW', 'https://www.youtube.com/embed/RV9L7ui9Cn8'),
('El Caballero Oscuro', 'Ocho años después de la desaparición de Batman, Bruce Wayne (Christian Bale) vuelve a la acción para enfrentarse al terrorista Bane (Tom Hardy), quien amenaza con destruir Gotham City.', 'http://www.thedarkknightrises.com/', 'The Dark Knight Rises', 'Acción', 'Estados Unidos', 164, 2012, 'Warner Bros. Pictures', 'Christopher Nolan', 'Actores: Christian Bale, Tom Hardy', '+13', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvBFJHFgWUsjg_M4qP742Y_isAC_Rh3P_ticEK5sYRIxlGlnWj', 'https://www.youtube.com/embed/e0qwi-4iOpE'),
('La Gran Estafa Americana', 'En la década de 1970, el estafador Irving Rosenfeld (Christian Bale) y su socia Sydney Prosser (Amy Adams) son obligados a trabajar con un agente del FBI (Bradley Cooper) para desmantelar una red de corrupción política y financiera.', 'https://www.americanhustle-movie.com/', 'American Hustle', 'Crimen', 'Estados Unidos', 138, 2013, 'Columbia Pictures', 'David O. Russell', 'Actores: Christian Bale, Amy Adams, Bradley Cooper', '+16', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRPj5j6JmrWXG395vliv6_y8nU5h62qAUjJ7sK9dWd29ogrhzR0', 'https://www.youtube.com/embed/HPGL8-j8pF0'),
('El Truco Final', 'Dos magos, Robert Angier (Hugh Jackman) y Alfred Borden (Christian Bale), compiten ferozmente para crear el mejor truco de magia, pero su rivalidad lleva a consecuencias mortales y revelaciones sorprendentes.', 'https://wwws.warnerbros.co.uk/theprestige/', 'The Prestige', 'Drama', 'Estados Unidos', 130, 2006, 'Warner Bros. Pictures', 'Christopher Nolan', 'Actores: Hugh Jackman, Christian Bale', '+13', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSTPe4-wizXAlotjWXAtEPVs8AZ8GpClhmbBMwNoInPFGOwi8Ex', 'https://www.youtube.com/embed/6EzGhJN5xVE'),
('Don Jon', 'Jon Martello (Joseph Gordon-Levitt) es un joven adicto al porno que intenta cambiar su vida cuando conoce a Barbara Sugarman (Scarlett Johansson). La película explora temas de relaciones, expectativas y la búsqueda del amor verdadero.', 'http://www.donjonmovie.com/', 'Don Jon', 'Comedia', 'Estados Unidos', 90, 2013, 'Relativity Media', 'Joseph Gordon-Levitt', 'Actores: Joseph Gordon-Levitt, Scarlett Johansson', '+18', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSFOJOs2bn0UYNxEYegtYDi1xibbjoca2Y-_HQxj-a3Pd_AfN2f', 'https://www.youtube.com/embed/87DONTaGg3M'),
('Vengadores: Endgame', 'Los Vengadores se reúnen para derrotar a Thanos y revertir el daño causado por su chasquido de dedos, que desapareció a la mitad de la vida en el universo. La batalla final es épica y marca el fin de una era.', 'https://www.marvel.com/movies/avengers-endgame', 'Avengers: Endgame', 'Acción', 'Estados Unidos', 181, 2019, 'Marvel Studios', 'Anthony y Joe Russo', 'Actores: Robert Downey Jr., Chris Evans, Scarlett Johansson', '+13', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQujAu6RsAWa1Wd-jdlI5ScYSt6-qAGjX8sGGmkHdesGK5LXQOv', 'https://www.youtube.com/embed/svLSGZkTzC0'),
('Érase una vez en Hollywood', 'La película sigue a Rick Dalton (Leonardo DiCaprio), un actor en decadencia, y su doble de riesgo, Cliff Booth (Brad Pitt), mientras intentan encontrar el éxito en la industria del cine en la década de 1960.', 'https://www.onceuponatimeinhollywood.movie/', 'Once Upon a Time in Hollywood', 'Comedia dramática', 'Estados Unidos', 161, 2019, 'Sony Pictures', 'Quentin Tarantino', 'Actores: Leonardo DiCaprio, Brad Pitt', '+16', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlSFE8ZPwkDZ5QBla-hpvAIQkHNIOE1lyFDsKrCh5kUPZFLxlR', 'https://www.youtube.com/embed/J0rFGJV3cYw'),
('El renacido', 'Hugh Glass (Leonardo DiCaprio) lucha por sobrevivir en el desierto después de ser atacado por un oso y abandonado por su equipo de caza. La película narra su épica búsqueda de venganza.', 'https://www.foxmovies.com/movies/the-revenant', 'The Revenant', 'Aventura', 'Estados Unidos', 156, 2015, '20th Century Studios', 'Alejandro González Iñárritu', 'Actores: Leonardo DiCaprio, Tom Hardy', '+18', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAF6B6bTlYVHDopMd43EAInxIABjUdHCdZawmdR5RVKjCD8r1b', 'https://www.youtube.com/embed/a8HRA49kaok');


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


INSERT INTO entrada (id_proyeccion, fila, columna) VALUES
-- Combinaciones para la entrada con id_proyeccion 1
(1, 1, 1), (1, 1, 2), (1, 1, 3), (1, 1, 4), (1, 1, 5), (1, 1, 6), (1, 1, 7), (1, 1, 8), (1, 1, 9), (1, 1, 10), (1, 1, 11), (1, 1, 12),
(1, 2, 1), (1, 2, 2), (1, 2, 3), (1, 2, 4), (1, 2, 5), (1, 2, 6), (1, 2, 7), (1, 2, 8), (1, 2, 9), (1, 2, 10), (1, 2, 11), (1, 2, 12),
(1, 3, 1), (1, 3, 2), (1, 3, 3), (1, 3, 4), (1, 3, 5), (1, 3, 6), (1, 3, 7), (1, 3, 8), (1, 3, 9), (1, 3, 10), (1, 3, 11), (1, 3, 12),
(1, 4, 1), (1, 4, 2), (1, 4, 3), (1, 4, 4), (1, 4, 5), (1, 4, 6), (1, 4, 7), (1, 4, 8), (1, 4, 9), (1, 4, 10), (1, 4, 11), (1, 4, 12),
(1, 5, 1), (1, 5, 2), (1, 5, 3), (1, 5, 4), (1, 5, 5), (1, 5, 6), (1, 5, 7), (1, 5, 8), (1, 5, 9), (1, 5, 10), (1, 5, 11), (1, 5, 12),

-- Combinaciones para la entrada con id_proyeccion 2
(2, 1, 1), (2, 1, 2), (2, 1, 3), (2, 1, 4), (2, 1, 5), (2, 1, 6), (2, 1, 7), (2, 1, 8), (2, 1, 9), (2, 1, 10),
(2, 2, 1), (2, 2, 2), (2, 2, 3), (2, 2, 4), (2, 2, 5), (2, 2, 6), (2, 2, 7), (2, 2, 8), (2, 2, 9), (2, 2, 10),
(2, 3, 1), (2, 3, 2), (2, 3, 3), (2, 3, 4), (2, 3, 5), (2, 3, 6), (2, 3, 7), (2, 3, 8), (2, 3, 9), (2, 3, 10),
(2, 4, 1), (2, 4, 2), (2, 4, 3), (2, 4, 4), (2, 4, 5), (2, 4, 6), (2, 4, 7), (2, 4, 8), (2, 4, 9), (2, 4, 10),
(2, 5, 1), (2, 5, 2), (2, 5, 3), (2, 5, 4), (2, 5, 5), (2, 5, 6), (2, 5, 7), (2, 5, 8), (2, 5, 9), (2, 5, 10),
(2, 6, 1), (2, 6, 2), (2, 6, 3), (2, 6, 4), (2, 6, 5), (2, 6, 6), (2, 6, 7), (2, 6, 8), (2, 6, 9), (2, 6, 10),
(2, 7, 1), (2, 7, 2), (2, 7, 3), (2, 7, 4), (2, 7, 5), (2, 7, 6), (2, 7, 7), (2, 7, 8), (2, 7, 9), (2, 7, 10),

-- Combinaciones para la entrada con id_proyeccion 3
(3, 1, 1), (3, 1, 2), (3, 1, 3), (3, 1, 4), (3, 1, 5), (3, 1, 6), (3, 1, 7), (3, 1, 8), (3, 1, 9), (3, 1, 10), (3, 1, 11), (3, 1, 12), (3, 1, 13), (3, 1, 14), (3, 1, 15),
(3, 2, 1), (3, 2, 2), (3, 2, 3), (3, 2, 4), (3, 2, 5), (3, 2, 6), (3, 2, 7), (3, 2, 8), (3, 2, 9), (3, 2, 10), (3, 2, 11), (3, 2, 12), (3, 2, 13), (3, 2, 14), (3, 2, 15),
(3, 3, 1), (3, 3, 2), (3, 3, 3), (3, 3, 4), (3, 3, 5), (3, 3, 6), (3, 3, 7), (3, 3, 8), (3, 3, 9), (3, 3, 10), (3, 3, 11), (3, 3, 12), (3, 3, 13), (3, 3, 14), (3, 3, 15),
(3, 4, 1), (3, 4, 2), (3, 4, 3), (3, 4, 4), (3, 4, 5), (3, 4, 6), (3, 4, 7), (3, 4, 8), (3, 4, 9), (3, 4, 10), (3, 4, 11), (3, 4, 12), (3, 4, 13), (3, 4, 14), (3, 4, 15),
(3, 5, 1), (3, 5, 2), (3, 5, 3), (3, 5, 4), (3, 5, 5), (3, 5, 6), (3, 5, 7), (3, 5, 8), (3, 5, 9), (3, 5, 10), (3, 5, 11), (3, 5, 12), (3, 5, 13), (3, 5, 14), (3, 5, 15),
(3, 6, 1), (3, 6, 2), (3, 6, 3), (3, 6, 4), (3, 6, 5), (3, 6, 6), (3, 6, 7), (3, 6, 8), (3, 6, 9), (3, 6, 10), (3, 6, 11), (3, 6, 12), (3, 6, 13), (3, 6, 14), (3, 6, 15),
(3, 7, 1), (3, 7, 2), (3, 7, 3), (3, 7, 4), (3, 7, 5), (3, 7, 6), (3, 7, 7), (3, 7, 8), (3, 7, 9), (3, 7, 10), (3, 7, 11), (3, 7, 12), (3, 7, 13), (3, 7, 14), (3, 7, 15),
(3, 8, 1), (3, 8, 2), (3, 8, 3), (3, 8, 4), (3, 8, 5), (3, 8, 6), (3, 8, 7), (3, 8, 8), (3, 8, 9), (3, 8, 10), (3, 8, 11), (3, 8, 12), (3, 8, 13), (3, 8, 14), (3, 8, 15),
(3, 9, 1), (3, 9, 2), (3, 9, 3), (3, 9, 4), (3, 9, 5), (3, 9, 6), (3, 9, 7), (3, 9, 8), (3, 9, 9), (3, 9, 10), (3, 9, 11), (3, 9, 12), (3, 9, 13), (3, 9, 14), (3, 9, 15),

-- Combinaciones para la entrada con id_proyeccion 4
(4, 1, 1), (4, 1, 2), (4, 1, 3), (4, 1, 4), (4, 1, 5), (4, 1, 6), (4, 1, 7), (4, 1, 8), (4, 1, 9), (4, 1, 10), (4, 1, 11), (4, 1, 12), (4, 1, 13), (4, 1, 14), (4, 1, 15), (4, 1, 16), (4, 1, 17), (4, 1, 18),
(4, 2, 1), (4, 2, 2), (4, 2, 3), (4, 2, 4), (4, 2, 5), (4, 2, 6), (4, 2, 7), (4, 2, 8), (4, 2, 9), (4, 2, 10), (4, 2, 11), (4, 2, 12), (4, 2, 13), (4, 2, 14), (4, 2, 15), (4, 2, 16), (4, 2, 17), (4, 2, 18),
(4, 3, 1), (4, 3, 2), (4, 3, 3), (4, 3, 4), (4, 3, 5), (4, 3, 6), (4, 3, 7), (4, 3, 8), (4, 3, 9), (4, 3, 10), (4, 3, 11), (4, 3, 12), (4, 3, 13), (4, 3, 14), (4, 3, 15), (4, 3, 16), (4, 3, 17), (4, 3, 18),
(4, 4, 1), (4, 4, 2), (4, 4, 3), (4, 4, 4), (4, 4, 5), (4, 4, 6), (4, 4, 7), (4, 4, 8), (4, 4, 9), (4, 4, 10), (4, 4, 11), (4, 4, 12), (4, 4, 13), (4, 4, 14), (4, 4, 15), (4, 4, 16), (4, 4, 17), (4, 4, 18),
(4, 5, 1), (4, 5, 2), (4, 5, 3), (4, 5, 4), (4, 5, 5), (4, 5, 6), (4, 5, 7), (4, 5, 8), (4, 5, 9), (4, 5, 10), (4, 5, 11), (4, 5, 12), (4, 5, 13), (4, 5, 14), (4, 5, 15), (4, 5, 16), (4, 5, 17), (4, 5, 18),
(4, 6, 1), (4, 6, 2), (4, 6, 3), (4, 6, 4), (4, 6, 5), (4, 6, 6), (4, 6, 7), (4, 6, 8), (4, 6, 9), (4, 6, 10), (4, 6, 11), (4, 6, 12), (4, 6, 13), (4, 6, 14), (4, 6, 15), (4, 6, 16), (4, 6, 17), (4, 6, 18),
(4, 7, 1), (4, 7, 2), (4, 7, 3), (4, 7, 4), (4, 7, 5), (4, 7, 6), (4, 7, 7), (4, 7, 8), (4, 7, 9), (4, 7, 10), (4, 7, 11), (4, 7, 12), (4, 7, 13), (4, 7, 14), (4, 7, 15), (4, 7, 16), (4, 7, 17), (4, 7, 18),
(4, 8, 1), (4, 8, 2), (4, 8, 3), (4, 8, 4), (4, 8, 5), (4, 8, 6), (4, 8, 7), (4, 8, 8), (4, 8, 9), (4, 8, 10), (4, 8, 11), (4, 8, 12), (4, 8, 13), (4, 8, 14), (4, 8, 15), (4, 8, 16), (4, 8, 17), (4, 8, 18),
(4, 9, 1), (4, 9, 2), (4, 9, 3), (4, 9, 4), (4, 9, 5), (4, 9, 6), (4, 9, 7), (4, 9, 8), (4, 9, 9), (4, 9, 10), (4, 9, 11), (4, 9, 12), (4, 9, 13), (4, 9, 14), (4, 9, 15), (4, 9, 16), (4, 9, 17), (4, 9, 18),
(4, 10, 1), (4, 10, 2), (4, 10, 3), (4, 10, 4), (4, 10, 5), (4, 10, 6), (4, 10, 7), (4, 10, 8), (4, 10, 9), (4, 10, 10), (4, 10, 11), (4, 10, 12), (4, 10, 13), (4, 10, 14), (4, 10, 15), (4, 10, 16), (4, 10, 17), (4, 10, 18),

-- Combinaciones para la entrada con id_proyeccion 5
(5, 1, 1), (5, 1, 2), (5, 1, 3), (5, 1, 4), (5, 1, 5), (5, 1, 6), (5, 1, 7), (5, 1, 8), (5, 1, 9), (5, 1, 10), (5, 1, 11), (5, 1, 12), (5, 1, 13), (5, 1, 14), (5, 1, 15), (5, 1, 16),
(5, 2, 1), (5, 2, 2), (5, 2, 3), (5, 2, 4), (5, 2, 5), (5, 2, 6), (5, 2, 7), (5, 2, 8), (5, 2, 9), (5, 2, 10), (5, 2, 11), (5, 2, 12), (5, 2, 13), (5, 2, 14), (5, 2, 15), (5, 2, 16),
(5, 3, 1), (5, 3, 2), (5, 3, 3), (5, 3, 4), (5, 3, 5), (5, 3, 6), (5, 3, 7), (5, 3, 8), (5, 3, 9), (5, 3, 10), (5, 3, 11), (5, 3, 12), (5, 3, 13), (5, 3, 14), (5, 3, 15), (5, 3, 16),
(5, 4, 1), (5, 4, 2), (5, 4, 3), (5, 4, 4), (5, 4, 5), (5, 4, 6), (5, 4, 7), (5, 4, 8), (5, 4, 9), (5, 4, 10), (5, 4, 11), (5, 4, 12), (5, 4, 13), (5, 4, 14), (5, 4, 15), (5, 4, 16),
(5, 5, 1), (5, 5, 2), (5, 5, 3), (5, 5, 4), (5, 5, 5), (5, 5, 6), (5, 5, 7), (5, 5, 8), (5, 5, 9), (5, 5, 10), (5, 5, 11), (5, 5, 12), (5, 5, 13), (5, 5, 14), (5, 5, 15), (5, 5, 16),
(5, 6, 1), (5, 6, 2), (5, 6, 3), (5, 6, 4), (5, 6, 5), (5, 6, 6), (5, 6, 7), (5, 6, 8), (5, 6, 9), (5, 6, 10), (5, 6, 11), (5, 6, 12), (5, 6, 13), (5, 6, 14), (5, 6, 15), (5, 6, 16),
(5, 7, 1), (5, 7, 2), (5, 7, 3), (5, 7, 4), (5, 7, 5), (5, 7, 6), (5, 7, 7), (5, 7, 8), (5, 7, 9), (5, 7, 10), (5, 7, 11), (5, 7, 12), (5, 7, 13), (5, 7, 14), (5, 7, 15), (5, 7, 16),

-- Combinaciones para la entrada con id_proyeccion 6
(6, 1, 1), (6, 1, 2), (6, 1, 3), (6, 1, 4), (6, 1, 5), (6, 1, 6), (6, 1, 7), (6, 1, 8), (6, 1, 9), (6, 1, 10), (6, 1, 11), (6, 1, 12),
(6, 2, 1), (6, 2, 2), (6, 2, 3), (6, 2, 4), (6, 2, 5), (6, 2, 6), (6, 2, 7), (6, 2, 8), (6, 2, 9), (6, 2, 10), (6, 2, 11), (6, 2, 12),
(6, 3, 1), (6, 3, 2), (6, 3, 3), (6, 3, 4), (6, 3, 5), (6, 3, 6), (6, 3, 7), (6, 3, 8), (6, 3, 9), (6, 3, 10), (6, 3, 11), (6, 3, 12),
(6, 4, 1), (6, 4, 2), (6, 4, 3), (6, 4, 4), (6, 4, 5), (6, 4, 6), (6, 4, 7), (6, 4, 8), (6, 4, 9), (6, 4, 10), (6, 4, 11), (6, 4, 12),
(6, 5, 1), (6, 5, 2), (6, 5, 3), (6, 5, 4), (6, 5, 5), (6, 5, 6), (6, 5, 7), (6, 5, 8), (6, 5, 9), (6, 5, 10), (6, 5, 11), (6, 5, 12),
(6, 6, 1), (6, 6, 2), (6, 6, 3), (6, 6, 4), (6, 6, 5), (6, 6, 6), (6, 6, 7), (6, 6, 8), (6, 6, 9), (6, 6, 10), (6, 6, 11), (6, 6, 12),
(6, 7, 1), (6, 7, 2), (6, 7, 3), (6, 7, 4), (6, 7, 5), (6, 7, 6), (6, 7, 7), (6, 7, 8), (6, 7, 9), (6, 7, 10), (6, 7, 11), (6, 7, 12),
(6, 8, 1), (6, 8, 2), (6, 8, 3), (6, 8, 4), (6, 8, 5), (6, 8, 6), (6, 8, 7), (6, 8, 8), (6, 8, 9), (6, 8, 10), (6, 8, 11), (6, 8, 12),
(6, 9, 1), (6, 9, 2), (6, 9, 3), (6, 9, 4), (6, 9, 5), (6, 9, 6), (6, 9, 7), (6, 9, 8), (6, 9, 9), (6, 9, 10), (6, 9, 11), (6, 9, 12),

-- Combinaciones para la entrada con id_proyeccion 7
(7, 1, 1), (7, 1, 2), (7, 1, 3), (7, 1, 4), (7, 1, 5), (7, 1, 6), (7, 1, 7), (7, 1, 8), (7, 1, 9), (7, 1, 10),
(7, 2, 1), (7, 2, 2), (7, 2, 3), (7, 2, 4), (7, 2, 5), (7, 2, 6), (7, 2, 7), (7, 2, 8), (7, 2, 9), (7, 2, 10),
(7, 3, 1), (7, 3, 2), (7, 3, 3), (7, 3, 4), (7, 3, 5), (7, 3, 6), (7, 3, 7), (7, 3, 8), (7, 3, 9), (7, 3, 10),
(7, 4, 1), (7, 4, 2), (7, 4, 3), (7, 4, 4), (7, 4, 5), (7, 4, 6), (7, 4, 7), (7, 4, 8), (7, 4, 9), (7, 4, 10),
(7, 5, 1), (7, 5, 2), (7, 5, 3), (7, 5, 4), (7, 5, 5), (7, 5, 6), (7, 5, 7), (7, 5, 8), (7, 5, 9), (7, 5, 10),
(7, 6, 1), (7, 6, 2), (7, 6, 3), (7, 6, 4), (7, 6, 5), (7, 6, 6), (7, 6, 7), (7, 6, 8), (7, 6, 9), (7, 6, 10),
(7, 7, 1), (7, 7, 2), (7, 7, 3), (7, 7, 4), (7, 7, 5), (7, 7, 6), (7, 7, 7), (7, 7, 8), (7, 7, 9), (7, 7, 10),

-- Combinaciones para la entrada con id_proyeccion 8
(8, 1, 1), (8, 1, 2), (8, 1, 3), (8, 1, 4), (8, 1, 5), (8, 1, 6), (8, 1, 7), (8, 1, 8), (8, 1, 9), (8, 1, 10), (8, 1, 11), (8, 1, 12), (8, 1, 13), (8, 1, 14), (8, 1, 15), (8, 1, 16),
(8, 2, 1), (8, 2, 2), (8, 2, 3), (8, 2, 4), (8, 2, 5), (8, 2, 6), (8, 2, 7), (8, 2, 8), (8, 2, 9), (8, 2, 10), (8, 2, 11), (8, 2, 12), (8, 2, 13), (8, 2, 14), (8, 2, 15), (8, 2, 16),
(8, 3, 1), (8, 3, 2), (8, 3, 3), (8, 3, 4), (8, 3, 5), (8, 3, 6), (8, 3, 7), (8, 3, 8), (8, 3, 9), (8, 3, 10), (8, 3, 11), (8, 3, 12), (8, 3, 13), (8, 3, 14), (8, 3, 15), (8, 3, 16),
(8, 4, 1), (8, 4, 2), (8, 4, 3), (8, 4, 4), (8, 4, 5), (8, 4, 6), (8, 4, 7), (8, 4, 8), (8, 4, 9), (8, 4, 10), (8, 4, 11), (8, 4, 12), (8, 4, 13), (8, 4, 14), (8, 4, 15), (8, 4, 16),
(8, 5, 1), (8, 5, 2), (8, 5, 3), (8, 5, 4), (8, 5, 5), (8, 5, 6), (8, 5, 7), (8, 5, 8), (8, 5, 9), (8, 5, 10), (8, 5, 11), (8, 5, 12), (8, 5, 13), (8, 5, 14), (8, 5, 15), (8, 5, 16),
(8, 6, 1), (8, 6, 2), (8, 6, 3), (8, 6, 4), (8, 6, 5), (8, 6, 6), (8, 6, 7), (8, 6, 8), (8, 6, 9), (8, 6, 10), (8, 6, 11), (8, 6, 12), (8, 6, 13), (8, 6, 14), (8, 6, 15), (8, 6, 16),
(8, 7, 1), (8, 7, 2), (8, 7, 3), (8, 7, 4), (8, 7, 5), (8, 7, 6), (8, 7, 7), (8, 7, 8), (8, 7, 9), (8, 7, 10), (8, 7, 11), (8, 7, 12), (8, 7, 13), (8, 7, 14), (8, 7, 15), (8, 7, 16),
(8, 8, 1), (8, 8, 2), (8, 8, 3), (8, 8, 4), (8, 8, 5), (8, 8, 6), (8, 8, 7), (8, 8, 8), (8, 8, 9), (8, 8, 10), (8, 8, 11), (8, 8, 12), (8, 8, 13), (8, 8, 14), (8, 8, 15), (8, 8, 16),
(8, 9, 1), (8, 9, 2), (8, 9, 3), (8, 9, 4), (8, 9, 5), (8, 9, 6), (8, 9, 7), (8, 9, 8), (8, 9, 9), (8, 9, 10), (8, 9, 11), (8, 9, 12), (8, 9, 13), (8, 9, 14), (8, 9, 15), (8, 9, 16),

-- Combinaciones para la entrada con id_proyeccion 9
(9, 1, 1), (9, 1, 2), (9, 1, 3), (9, 1, 4), (9, 1, 5), (9, 1, 6), (9, 1, 7), (9, 1, 8),
(9, 2, 1), (9, 2, 2), (9, 2, 3), (9, 2, 4), (9, 2, 5), (9, 2, 6), (9, 2, 7), (9, 2, 8),
(9, 3, 1), (9, 3, 2), (9, 3, 3), (9, 3, 4), (9, 3, 5), (9, 3, 6), (9, 3, 7), (9, 3, 8),
(9, 4, 1), (9, 4, 2), (9, 4, 3), (9, 4, 4), (9, 4, 5), (9, 4, 6), (9, 4, 7), (9, 4, 8),
(9, 5, 1), (9, 5, 2), (9, 5, 3), (9, 5, 4), (9, 5, 5), (9, 5, 6), (9, 5, 7), (9, 5, 8),
(9, 6, 1), (9, 6, 2), (9, 6, 3), (9, 6, 4), (9, 6, 5), (9, 6, 6), (9, 6, 7), (9, 6, 8),
(9, 7, 1), (9, 7, 2), (9, 7, 3), (9, 7, 4), (9, 7, 5), (9, 7, 6), (9, 7, 7), (9, 7, 8),

-- Combinaciones para la entrada con id_proyeccion 10
(10, 1, 1), (10, 1, 2), (10, 1, 3), (10, 1, 4), (10, 1, 5), (10, 1, 6), (10, 1, 7), (10, 1, 8), (10, 1, 9), (10, 1, 10), (10, 1, 11), (10, 1, 12), (10, 1, 13), (10, 1, 14), (10, 1, 15), (10, 1, 16), (10, 1, 17), (10, 1, 18), (10, 1, 19), (10, 1, 20),
(10, 2, 1), (10, 2, 2), (10, 2, 3), (10, 2, 4), (10, 2, 5), (10, 2, 6), (10, 2, 7), (10, 2, 8), (10, 2, 9), (10, 2, 10), (10, 2, 11), (10, 2, 12), (10, 2, 13), (10, 2, 14), (10, 2, 15), (10, 2, 16), (10, 2, 17), (10, 2, 18), (10, 2, 19), (10, 2, 20),
(10, 3, 1), (10, 3, 2), (10, 3, 3), (10, 3, 4), (10, 3, 5), (10, 3, 6), (10, 3, 7), (10, 3, 8), (10, 3, 9), (10, 3, 10), (10, 3, 11), (10, 3, 12), (10, 3, 13), (10, 3, 14), (10, 3, 15), (10, 3, 16), (10, 3, 17), (10, 3, 18), (10, 3, 19), (10, 3, 20),
(10, 4, 1), (10, 4, 2), (10, 4, 3), (10, 4, 4), (10, 4, 5), (10, 4, 6), (10, 4, 7), (10, 4, 8), (10, 4, 9), (10, 4, 10), (10, 4, 11), (10, 4, 12), (10, 4, 13), (10, 4, 14), (10, 4, 15), (10, 4, 16), (10, 4, 17), (10, 4, 18), (10, 4, 19), (10, 4, 20),
(10, 5, 1), (10, 5, 2), (10, 5, 3), (10, 5, 4), (10, 5, 5), (10, 5, 6), (10, 5, 7), (10, 5, 8), (10, 5, 9), (10, 5, 10), (10, 5, 11), (10, 5, 12), (10, 5, 13), (10, 5, 14), (10, 5, 15), (10, 5, 16), (10, 5, 17), (10, 5, 18), (10, 5, 19), (10, 5, 20),
(10, 6, 1), (10, 6, 2), (10, 6, 3), (10, 6, 4), (10, 6, 5), (10, 6, 6), (10, 6, 7), (10, 6, 8), (10, 6, 9), (10, 6, 10), (10, 6, 11), (10, 6, 12), (10, 6, 13), (10, 6, 14), (10, 6, 15), (10, 6, 16), (10, 6, 17), (10, 6, 18), (10, 6, 19), (10, 6, 20),
(10, 7, 1), (10, 7, 2), (10, 7, 3), (10, 7, 4), (10, 7, 5), (10, 7, 6), (10, 7, 7), (10, 7, 8), (10, 7, 9), (10, 7, 10), (10, 7, 11), (10, 7, 12), (10, 7, 13), (10, 7, 14), (10, 7, 15), (10, 7, 16), (10, 7, 17), (10, 7, 18), (10, 7, 19), (10, 7, 20),
(10, 8, 1), (10, 8, 2), (10, 8, 3), (10, 8, 4), (10, 8, 5), (10, 8, 6), (10, 8, 7), (10, 8, 8), (10, 8, 9), (10, 8, 10), (10, 8, 11), (10, 8, 12), (10, 8, 13), (10, 8, 14), (10, 8, 15), (10, 8, 16), (10, 8, 17), (10, 8, 18), (10, 8, 19), (10, 8, 20),
(10, 9, 1), (10, 9, 2), (10, 9, 3), (10, 9, 4), (10, 9, 5), (10, 9, 6), (10, 9, 7), (10, 9, 8), (10, 9, 9), (10, 9, 10), (10, 9, 11), (10, 9, 12), (10, 9, 13), (10, 9, 14), (10, 9, 15), (10, 9, 16), (10, 9, 17), (10, 9, 18), (10, 9, 19), (10, 9, 20),
(10, 10, 1), (10, 10, 2), (10, 10, 3), (10, 10, 4), (10, 10, 5), (10, 10, 6), (10, 10, 7), (10, 10, 8), (10, 10, 9), (10, 10, 10), (10, 10, 11), (10, 10, 12), (10, 10, 13), (10, 10, 14), (10, 10, 15), (10, 10, 16), (10, 10, 17), (10, 10, 18), (10, 10, 19), (10, 10, 20);


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
