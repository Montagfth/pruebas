-- Creacion de la database
CREATE DATABASE librarysystem;

USE librarysystem;

-- Usar el drop en caso sea necesario para eliminar
-- una tabla que no pueda ser reestructurada:
-- DROP TABLE [NombreDeTabla];

-- Tabla a usar USUARIOS:
-- NOTA: Las tablas seran implementadas por clases
-- 		 en el aplicativo NetBeans(CRUD)
-- 		 [FACILITA EL MANEJO E INSERCION DE LOS DATOS].
CREATE TABLE Usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    last_name_p VARCHAR(30) NOT NULL,
    last_name_m VARCHAR(30) NOT NULL,
    domicilio VARCHAR(250),
    tel VARCHAR(15),
    sanctions INT DEFAULT 0,
    sanc_money INT NOT NULL,
    PRIMARY KEY (id)
);

-- Tabla a usar LIBROS:
-- Eliminacion de tabla nativa.
drop table librarysystem.libros;
-- NUEVA TABLA EDITADA:
CREATE TABLE Libros (
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	fecha VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    edit VARCHAR(255) NOT NULL,
    lang VARCHAR(255) NOT NULL,
    pages INT NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    ejemplares INT NOT NULL,
    stock INT NOT NULL,
    available INT NOT NULL,
    PRIMARY KEY (id)
);

-- Tabla a usar PRESTAMOS:
CREATE TABLE Prestamos (
	id INT NOT NULL AUTO_INCREMENT,
	users_id INT NOT NULL,
    book_id INT NOT NULL,
    date_out VARCHAR(255) NOT NULL,
    date_return VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- ESCALABILIDAD: Se puede agregar mas tablas en caso se requiera.

-- Consultas generales a las tablas existentes:
SELECT * FROM usuarios;

-- Insercion de datos de prueba a la tabla USUARIOS:
-- INSERT INTO Usuarios(name,last_name_p,last_name_m,domicilio,tel,sanctions,sanc_money) VALUES('abc','def','ghi','jkl','mno',01,02);
-- ESTADO: INSERCION CORRECTA
-- CHECKPOINT: Viernes, 10/01/2025


-- CONTINUACION:
-- Correccion de la tabla USUARIOS:
-- ALTER TABLE Usuarios
-- MODIFY sanc_money INT NULL;

-- CHECKPOINT: Sabado, 11/01/2025 

-- CONTINUACION:
-- Anexado de las tablas con las funcionalidades [Tabla Libros & Tabla Prestamos]

-- CHECKPOINT: Viernes, 24/01/2025
select * from libros;

-- INSERCION DE DATOS GENERICOS:
-- Uso de la IA para los datos genericos:
-- Primeros 10 datos de prueba:
insert into librarysystem.libros
(title, fecha, author, category, edit, lang, descripcion, pages, ejemplares, stock, available) values
('To Kill a Mockingbird', '1960-07-11', 'Harper Lee', 'Fiction', '1st', 'English', 'Classic novel on racism and morality.', 281, 10, 10, 10),
('1984', '1949-06-08', 'George Orwell', 'Dystopian', '1st', 'English', 'Dystopian tale of a totalitarian regime.', 328, 12, 12, 12),
('The Great Gatsby', '1925-04-10', 'F. Scott Fitzgerald', 'Classic', '3rd', 'English', 'A tragic love story set in the 1920s.', 180, 8, 8, 8),
('Cien años de soledad', '1967-05-30', 'Gabriel García Márquez', 'Magical Realism', '1st', 'Spanish', 'Chronicle of the Buendía family.', 417, 15, 15, 15),
('Pride and Prejudice', '1813-01-28', 'Jane Austen', 'Romance', '5th', 'English', 'Romantic critique of British society.', 279, 7, 7, 7),
('El alquimista', '1988-05-01', 'Paulo Coelho', 'Adventure', '1st', 'Portuguese', 'Story of self-discovery.', 208, 14, 14, 14),
('Moby Dick', '1851-10-18', 'Herman Melville', 'Adventure', '2nd', 'English', 'A captain’s obsession with a whale.', 635, 9, 9, 9),
('Don Quijote de la Mancha', '1605-01-16', 'Miguel de Cervantes', 'Classic', '4th', 'Spanish', 'Journey of an imaginative knight.', 863, 11, 11, 11),
('The Catcher in the Rye', '1951-07-16', 'J.D. Salinger', 'Fiction', '1st', 'English', 'Teen rebellion against society.', 277, 6, 6, 6),
('Fahrenheit 451', '1953-10-19', 'Ray Bradbury', 'Dystopian', '1st', 'English', 'A world where books are banned.', 194, 13, 13, 13);
-- Insercion de 10 datos de prueba adicionales:
insert into librarysystem.libros
(title, fecha, author, category, edit, lang, descripcion, pages, ejemplares, stock, available) values
('Brave New World', '1932-08-18', 'Aldous Huxley', 'Science Fiction', '1st', 'English', 'Vision of a future utopia/dystopia.', 311, 10, 10, 10),
('El amor en los tiempos del cólera', '1985-09-05', 'Gabriel García Márquez', 'Romance', '1st', 'Spanish', 'Love story across decades.', 348, 14, 14, 14),
('The Road', '2006-09-26', 'Cormac McCarthy', 'Post-apocalyptic', '1st', 'English', 'Survival in a dystopian world.', 287, 7, 7, 7),
('Los miserables', '1862-04-03', 'Victor Hugo', 'Historical', '3rd', 'French', 'Epic tale of justice and redemption.', 1232, 10, 10, 10),
('Anna Karenina', '1877-03-01', 'Leo Tolstoy', 'Romance', '1st', 'Russian', 'Love and betrayal in aristocracy.', 864, 9, 9, 9),
('Crime and Punishment', '1866-12-01', 'Fyodor Dostoevsky', 'Philosophical', '2nd', 'Russian', 'The moral dilemmas of a criminal.', 671, 12, 12, 12),
('The Hobbit', '1937-09-21', 'J.R.R. Tolkien', 'Fantasy', '1st', 'English', 'Journey of a hobbit to reclaim treasure.', 310, 20, 20, 20),
('Harry Potter and the Sorcerer\'s Stone', '1997-06-26', 'J.K. Rowling', 'Fantasy', '1st', 'English', 'The magical beginnings of Harry Potter.', 309, 30, 30, 30),
('The Divine Comedy', '1320-01-01', 'Dante Alighieri', 'Epic', '5th', 'Italian', 'Journey through Hell, Purgatory, and Heaven.', 798, 5, 5, 5),
('The Kite Runner', '2003-05-29', 'Khaled Hosseini', 'Drama', '1st', 'English', 'A story of friendship and redemption.', 372, 10, 10, 10);

-- CHECKPOINT: Domingo, 26/01/2025 - 
select * from libros;

-- CHECKPOINT: Lunes, 27/01/2025
 USE librarysystem;

select * from librarysystem.libros;

-- CHECKPOINT: Miercoles, 29/01/2025
 USE librarysystem;
 
select * from librarysystem.libros;

-- TRANSFORMACION DE LA TABLA libros DE VALORES int A String(VARCHAR(?)): 
-- Eliminacion de tabla nativa.
DROP TABLE librarysystem.libros;
-- NUEVA TABLA EDITADA:
CREATE TABLE Libros (
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	fecha VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    edit VARCHAR(255) NOT NULL,
    lang VARCHAR(255) NOT NULL,
    pages VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    ejemplares VARCHAR(255) NOT NULL,
    stock VARCHAR(255) NOT NULL,
    available VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- INSERCION DE NUEVOS VALORES A LA TABLA libros:
INSERT INTO librarysystem.libros (title, fecha, author, category, edit, lang, descripcion, pages, ejemplares, stock, available)  
VALUES  
('Brave New World', '1932-08-18', 'Aldous Huxley', 'Science Fiction', '1st', 'English', 'Vision of a future utopia/dystopia.', '311', '10', '10', '10'),  
('El amor en los tiempos del cólera', '1985-09-05', 'Gabriel García Márquez', 'Romance', '1st', 'Spanish', 'Love story across decades.', '348', '14', '14', '14'),  
('The Road', '2006-09-26', 'Cormac McCarthy', 'Post-apocalyptic', '1st', 'English', 'Survival in a dystopian world.', '287', '7', '7', '7'),  
('Los miserables', '1862-04-03', 'Victor Hugo', 'Historical', '3rd', 'French', 'Epic tale of justice and redemption.', '1232', '10', '10', '10'),  
('Anna Karenina', '1877-03-01', 'Leo Tolstoy', 'Romance', '1st', 'Russian', 'Love and betrayal in aristocracy.', '864', '9', '9', '9'),  
('Crime and Punishment', '1866-12-01', 'Fyodor Dostoevsky', 'Philosophical', '2nd', 'Russian', 'The moral dilemmas of a criminal.', '671', '12', '12', '12'),  
('The Hobbit', '1937-09-21', 'J.R.R. Tolkien', 'Fantasy', '1st', 'English', 'Journey of a hobbit to reclaim treasure.', '310', '20', '20', '20'),  
('Harry Potter and the Sorcerer\'s Stone', '1997-06-26', 'J.K. Rowling', 'Fantasy', '1st', 'English', 'The magical beginnings of Harry Potter.', '309', '30', '30', '30'),  
('The Divine Comedy', '1320-01-01', 'Dante Alighieri', 'Epic', '5th', 'Italian', 'Journey through Hell, Purgatory, and Heaven.', '798', '5', '5', '5'),  
('The Kite Runner', '2003-05-29', 'Khaled Hosseini', 'Drama', '1st', 'English', 'A story of friendship and redemption.', '372', '10', '10', '10');  

-- INSERCION DE 10 DATOS MAS DE PRUEBA:
INSERT INTO librarysystem.libros  
(title, fecha, author, category, edit, lang, descripcion, pages, ejemplares, stock, available)  
VALUES  
('To Kill a Mockingbird', '1960-07-11', 'Harper Lee', 'Fiction', '1st', 'English', 'Classic novel on racism and morality.', '281', '10', '10', '10'),  
('1984', '1949-06-08', 'George Orwell', 'Dystopian', '1st', 'English', 'Dystopian tale of a totalitarian regime.', '328', '12', '12', '12'),  
('The Great Gatsby', '1925-04-10', 'F. Scott Fitzgerald', 'Classic', '3rd', 'English', 'A tragic love story set in the 1920s.', '180', '8', '8', '8'),  
('Cien años de soledad', '1967-05-30', 'Gabriel García Márquez', 'Magical Realism', '1st', 'Spanish', 'Chronicle of the Buendía family.', '417', '15', '15', '15'),  
('Pride and Prejudice', '1813-01-28', 'Jane Austen', 'Romance', '5th', 'English', 'Romantic critique of British society.', '279', '7', '7', '7'),  
('El alquimista', '1988-05-01', 'Paulo Coelho', 'Adventure', '1st', 'Portuguese', 'Story of self-discovery.', '208', '14', '14', '14'),  
('Moby Dick', '1851-10-18', 'Herman Melville', 'Adventure', '2nd', 'English', 'A captain’s obsession with a whale.', '635', '9', '9', '9'),  
('Don Quijote de la Mancha', '1605-01-16', 'Miguel de Cervantes', 'Classic', '4th', 'Spanish', 'Journey of an imaginative knight.', '863', '11', '11', '11'),  
('The Catcher in the Rye', '1951-07-16', 'J.D. Salinger', 'Fiction', '1st', 'English', 'Teen rebellion against society.', '277', '6', '6', '6'),  
('Fahrenheit 451', '1953-10-19', 'Ray Bradbury', 'Dystopian', '1st', 'English', 'A world where books are banned.', '194', '13', '13', '13');  

-- CONSULTA A LA TABLA:
SELECT * FROM librarysystem.libros;

-- CHECHPOINT: Miercoles, 29/01/2025 - 07:18
-- NOTA: Analizar si se requiere algun tipo de cambio de datos en la base de datos, 
-- 		 consultarlo con el programa CRUD en NetBeans.

-- CHECHPOINT: Jueves,30/01/2025
-- NOTA: Se analiza los tipos de datos de la base de datos, se documentara en caso de alteraciones.
USE librarysystem;

SELECT * FROM librarysystem.libros;

-- CHECHPOINT: Jueves,30/01/2025 - 17:09
-- NOTA: Correccion del CRUD lista, se continua implementando las otras funcionalidades del panel.

-- CHECKPOINT: Martes, 04/02/2025
-- NOTA: Implementacion de la tabla de "ACTUALIZACIONES" para la clase "Reportes.java"

-- Prototipo de tabla de "Reportes.java", NOTA: Implementar y adecuar al CRUD en NetBeans IDE 23
CREATE TABLE Prestamos (
	id INT NOT NULL AUTO_INCREMENT,
	users_id INT NOT NULL,
    book_id INT NOT NULL,
    date_out VARCHAR(255) NOT NULL,
    date_return VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

use librarysystem;

select * from librarysystem.prestamos;

-- CHECKPOINT: Martes, 04/02/2025 - 20:20
-- NOTA: Implementar las funcionalidades de los otros paneles interactivos.
-- 	     No se requiere ningun cambio por el momento

-- CHECKPOINT: Miercoles, 05/02/2025 - 22:02
-- NOTA: Correccion e implementacion de nuevas clases en el CRUD.


-- CHECKPOINT: Sabado, 08/02/2025 - 
-- NOTA: Correccion de los tipos de datos de la base de dato y luego en el CRUD.

use librarysystem;

-- RETRANSFORMACION DE LA TABLA libros DE VALORES A TIPO int 
-- Eliminacion de tabla nativa.
DROP TABLE librarysystem.libros;
-- NUEVA TABLA EDITADA:
CREATE TABLE Libros (
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	fecha VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    edit VARCHAR(255) NOT NULL,
    lang VARCHAR(255) NOT NULL,
    pages VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    ejemplares VARCHAR(255) NOT NULL,
    stock int NULL,
    available int NULL,
    PRIMARY KEY (id)
);

-- REINSERCION DE LIBROS DE PRUEBA:
INSERT INTO librarysystem.libros  
(title, fecha, author, category, edit, lang, descripcion, pages, ejemplares, stock, available)  
VALUES  
('To Kill a Mockingbird', '1960-07-11', 'Harper Lee', 'Fiction', '1st', 'English', 'Classic novel on racism and morality.', '281', '10', 10, 10),  
('1984', '1949-06-08', 'George Orwell', 'Dystopian', '1st', 'English', 'Dystopian tale of a totalitarian regime.', '328', '12', 12, 12),  
('The Great Gatsby', '1925-04-10', 'F. Scott Fitzgerald', 'Classic', '3rd', 'English', 'A tragic love story set in the 1920s.', '180', '8', 8, 8),  
('Cien años de soledad', '1967-05-30', 'Gabriel García Márquez', 'Magical Realism', '1st', 'Spanish', 'Chronicle of the Buendía family.', '417', '15', 15, 15),  
('Pride and Prejudice', '1813-01-28', 'Jane Austen', 'Romance', '5th', 'English', 'Romantic critique of British society.', '279', '7', 7, 7),  
('El alquimista', '1988-05-01', 'Paulo Coelho', 'Adventure', '1st', 'Portuguese', 'Story of self-discovery.', '208', '14', 14, 14),  
('Moby Dick', '1851-10-18', 'Herman Melville', 'Adventure', '2nd', 'English', 'A captain’s obsession with a whale.', '635', '9', 9, 9),  
('Don Quijote de la Mancha', '1605-01-16', 'Miguel de Cervantes', 'Classic', '4th', 'Spanish', 'Journey of an imaginative knight.', '863', '11', 11, 11),  
('The Catcher in the Rye', '1951-07-16', 'J.D. Salinger', 'Fiction', '1st', 'English', 'Teen rebellion against society.', '277', '6', 6, 6),  
('Fahrenheit 451', '1953-10-19', 'Ray Bradbury', 'Dystopian', '1st', 'English', 'A world where books are banned.', '194', '13', 13, 13);  

select * from librarysystem.libros;

INSERT INTO librarysystem.libros (title, fecha, author, category, edit, lang, descripcion, pages, ejemplares, stock, available)  
VALUES  
('Brave New World', '1932-08-18', 'Aldous Huxley', 'Science Fiction', '1st', 'English', 'Vision of a future utopia/dystopia.', 311, 10, 10, 10),  
('El amor en los tiempos del cólera', '1985-09-05', 'Gabriel García Márquez', 'Romance', '1st', 'Spanish', 'Love story across decades.', 348, 14, 14, 14),  
('The Road', '2006-09-26', 'Cormac McCarthy', 'Post-apocalyptic', '1st', 'English', 'Survival in a dystopian world.', 287, 7, 7, 7),  
('Los miserables', '1862-04-03', 'Victor Hugo', 'Historical', '3rd', 'French', 'Epic tale of justice and redemption.', 1232, 10, 10, 10),  
('Anna Karenina', '1877-03-01', 'Leo Tolstoy', 'Romance', '1st', 'Russian', 'Love and betrayal in aristocracy.', 864, 9, 9, 9),  
('Crime and Punishment', '1866-12-01', 'Fyodor Dostoevsky', 'Philosophical', '2nd', 'Russian', 'The moral dilemmas of a criminal.', 671, 12, 12, 12),  
('The Hobbit', '1937-09-21', 'J.R.R. Tolkien', 'Fantasy', '1st', 'English', 'Journey of a hobbit to reclaim treasure.', 310, 20, 20, 20),  
('Harry Potter and the Sorcerer\'s Stone', '1997-06-26', 'J.K. Rowling', 'Fantasy', '1st', 'English', 'The magical beginnings of Harry Potter.', 309, 30, 30, 30),  
('The Divine Comedy', '1320-01-01', 'Dante Alighieri', 'Epic', '5th', 'Italian', 'Journey through Hell, Purgatory, and Heaven.', 798, 5, 5, 5),  
('The Kite Runner', '2003-05-29', 'Khaled Hosseini', 'Drama', '1st', 'English', 'A story of friendship and redemption.', 372, 10, 10, 10);  


-- CORRECCION DE LA TABLA "Prestamos" PARA EL INGRESO DE DATOS "NULL":
-- Eliminacion de tabla nativa.
-- DROP TABLE librarysystem.prestamos;
-- NUEVA TABLA:
CREATE TABLE Prestamos (
	id INT NOT NULL AUTO_INCREMENT,
	users_id INT NOT NULL,
    book_id INT NOT NULL,
    date_out date NULL,
    date_return date NULL,
    PRIMARY KEY (id)
);

-- CHECKPOINT: Sabado, 08/02/2025 - 20:06
-- NOTA: Continuar la implementacion del panel de Reportes. Nada para modificar en la base de datos.

select * from librarysystem.prestamos;

-- CHECKPOINT: Sabado, 08/02/2025 - 23:13
-- NOTA: Revision general del cada parte del codigo y continuacion de implementaciones de funcionalidad.
-- 		 NO se modifico la base de datos MySQL WorkBench

-- CHECKPOINT: Domingo, 09/02/2025 - 10:24
-- NOTA: Verificacion de cada paquete, y sus analisis independiente.
-- 		 No se requieren cambios en la base de datos.

-- CHECKPOINT: Lunes, 10/02/2025  
-- NOTA: Correccion de posibles errores en el CRUD. Analisar la estructura final de la base de datos.

-- CHECKPOINT: Lunes, 17/02/2025  
-- NOTA: Correccion de la comunicacion con la base de datos, busqueda de "user_id"

use librarysystem;

select * from librarysystem.prestamos;

-- CHECKPOINT: Lunes, 17/02/2025 - 18:00
-- NOTA: Correccion del apartado de "Devoluciones.java", funcionalidad completa y corregida.
--       Continuar con la optimizacion del codigo para la mejora y produccion final.
-- 		 No se modifico la estructura de la base de datos, continuar la optimizacion y produccion en el CRUD en NetBeans.