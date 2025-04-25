/*
1. После создания диаграммы классов в 6 пункте, в 7 пункте база данных "Human Friends" 
должна быть структурирована в соответствии с этой диаграммой. Например, 
можно создать таблицы, которые будут соответствовать классам "Pets" и "Pack animals", 
и в этих таблицах будут поля, которые характеризуют каждый тип животных 
(например, имена, даты рождения, выполняемые команды и т.д.).
 В ранее подключенном MySQL создать базу данных с названием "Human Friends".

*/
CREATE DATABASE Human_friends;

USE Human_friends;

-- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.

CREATE TABLE Animal_types
(
	Id INT PRIMARY KEY AUTO_INCREMENT, 
    type VARCHAR(20)
    );

INSERT INTO Animal_types(type)
VALUES ('pet'), ('pack animal');

CREATE TABLE Pets
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
	animal VARCHAR(20),
	typeId INT,
	FOREIGN KEY(typeId) REFERENCES Animal_types(Id)
);

CREATE TABLE Pack_animals
(
  Id INT PRIMARY KEY AUTO_INCREMENT,
  animal VARCHAR(20),
  typeId INT,
  FOREIGN KEY(typeId) REFERENCES Animal_types(Id)
  );
  
  

SELECT CONSTRAINT_NAME FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME ='Pets' AND TABLE_SCHEMA = 'Human_friends'; 
ALTER TABLE Pets DROP FOREIGN KEY Pets_ibfk_1;
ALTER TABLE Pets ADD CONSTRAINT Pets_ibfk_1 FOREIGN KEY(typeId) REFERENCES Animal_types(Id) ON DELETE CASCADE ON UPDATE CASCADE;

SELECT CONSTRAINT_NAME FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME ='Pack_animals' AND TABLE_SCHEMA = 'Human_friends';
ALTER TABLE Pack_animals DROP FOREIGN KEY Pack_animals_ibfk_1;
ALTER TABLE Pack_animals ADD CONSTRAINT Pack_animals_ibfk_1 FOREIGN KEY(typeId) REFERENCES Animal_types(Id) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO Pets(animal, typeId) VALUES
('cat', 1), ('dog', 1), ('hamster', 1);

INSERT INTO Pack_animals(animal, typeId) VALUES
('horse', 2), ('camel', 2), ('donkey', 2);

CREATE TABLE Cats
(
Id INT PRIMARY KEY AUTO_INCREMENT,
nickname VARCHAR(20),
birthDate DATE,
commands VARCHAR(100),
petId INT,
FOREIGN KEY(petId) REFERENCES Pets(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Dogs
(
Id INT PRIMARY KEY AUTO_INCREMENT,
nickname VARCHAR(20),
birthDate DATE,
commands VARCHAR(100),
petId INT,
FOREIGN KEY(petId) REFERENCES Pets(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Hamsters
(
Id INT PRIMARY KEY AUTO_INCREMENT,
nickname VARCHAR(20),
birthDate DATE,
commands VARCHAR(100),
petId INT,
FOREIGN KEY(petId) REFERENCES Pets(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Horses
(
Id INT PRIMARY KEY AUTO_INCREMENT,
nickname VARCHAR(20),
birthDate DATE,
commands VARCHAR(100),
packId INT,
FOREIGN KEY(packId) REFERENCES Pack_animals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Camels
(
Id INT PRIMARY KEY AUTO_INCREMENT,
nickname VARCHAR(20),
birthDate DATE,
commands VARCHAR(100),
packId INT,
FOREIGN KEY(packId) REFERENCES Pack_animals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Donkeys
(
Id INT PRIMARY KEY AUTO_INCREMENT,
nickname VARCHAR(20),
birthDate DATE,
commands VARCHAR(100),
packId INT,
FOREIGN KEY(packId) REFERENCES Pack_animals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Заполнить таблицы данными о животных, их командах и датами рождения.
INSERT INTO Cats(nickname, birthDate, commands, petId) VALUES
('Kiti', '2020-11-15', 'up, sit down, catch, come', 1),
('Milli', '2024-01-30', 'voice, catch, jump, come', 1),
('Sunny', '2019-08-07', 'freeze, jump, play, come', 1);

INSERT INTO Dogs(nickname, birthDate, commands, petId) VALUES
('Bobby', '2020-08-14', 'up, down, come, voice', 2),
('Milli', '2024-01-30', 'jump, catch, aport', 2),
('Sunny', '2019-08-07', 'freeze, jump, catch, come', 2);

INSERT INTO Hamsters(nickname, birthDate, commands, petId) VALUES
('Mini', '2024-08-21', 'come, food', 3),
('Maxi', '2024-01-28', 'come, food', 3),
('Middle', '2025-02-27', 'come, food', 3);

INSERT INTO Horses(nickname, birthDate, commands, packId) VALUES
('Hero', '2015-03-22', 'straight, stop, ride', 1),
('Loyal', '2020-07-19', 'trot, up, down', 1),
('Grumpy', '2018-10-12', 'stop, go, down', 1);

INSERT INTO Camels(nickname, birthDate, commands, packId) VALUES
('Titan', '2017-07-05', 'stop, go, down', 2),
('Zeus', '2020-05-03', 'stop, go, down', 2),
('Mars', '2023-09-11', 'stop, ride', 2);

INSERT INTO Donkeys(nickname, birthDate, commands, packId) VALUES
('Morning', '2021-08-10', 'freeze, go, stop', 3),
('Evening', '2022-09-28', 'come, go, stop', 3),
('Night', '2018-04-19', 'go, stop, freeze', 3);

-- Удалить записи о верблюдах
-- SELECT @@sql_safe_updates;
   
   DELETE FROM Camels;
   
-- объединить таблицы лошадей и ослов.

SELECT pac.animal, h.nickname, h.birthDate, h.commands
FROM Horses h
INNER JOIN Pack_animals pac
ON h.packId = pac.Id

UNION

SELECT pac.animal, d.nickname, d.birthDate, d.commands
FROM Donkeys d
INNER JOIN Pack_animals pac
ON d.packId = pac.Id;

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

CREATE TABLE Teens
AS
SELECT 
animal, nickname, birthDate, commands,
CONCAT (TIMESTAMPDIFF(YEAR, birthDate, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthDate, CURDATE()) - TIMESTAMPDIFF(YEAR, birthDate, CURDATE()) * 12, ' m') AS age
FROM (
SELECT p.animal, c.nickname, c.birthDate, c.commands
FROM Cats c
INNER JOIN Pets p
ON c.petId = p.Id

UNION

SELECT p.animal, Dogs.nickname, Dogs.birthDate, Dogs.commands
FROM Dogs
INNER JOIN Pets p
ON Dogs.petId = p.Id

UNION

SELECT p.animal, ha.nickname, ha.birthDate, ha.commands
FROM Hamsters ha
INNER JOIN Pets p
ON ha.petId = p.Id

UNION

SELECT pac.animal, h.nickname, h.birthDate, h.commands
FROM Horses h
INNER JOIN Pack_animals pac
ON h.packId = pac.Id

UNION

SELECT pac.animal, d.nickname, d.birthDate, d.commands
FROM Donkeys d
INNER JOIN Pack_animals pac
ON d.packId = pac.Id
) all_animals

WHERE TIMESTAMPDIFF(MONTH, birthDate, CURDATE()) >= 12 AND TIMESTAMPDIFF(MONTH, birthDate, CURDATE()) < 48;


-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.


SELECT DISTINCT a.type, p.animal, c.nickname, c.birthDate, c.commands, t.age
FROM Cats c
LEFT JOIN Teens t ON c.nickname= t.nickname AND  c.birthdate = t.birthdate
INNER JOIN Pets p ON c.petId = p.Id
INNER JOIN Animal_types a ON p.typeID = a.id

UNION

SELECT DISTINCT a.type, p.animal, Dogs.nickname, Dogs.birthDate, Dogs.commands, t.age
FROM Dogs
LEFT JOIN Teens t ON Dogs.nickname= t.nickname AND  Dogs.birthdate = t.birthdate
INNER JOIN Pets p ON Dogs.petId = p.Id
INNER JOIN Animal_types a ON p.typeID = a.id

UNION

SELECT DISTINCT a.type, p.animal, ha.nickname, ha.birthDate, ha.commands, t.age
FROM Hamsters ha
LEFT JOIN Teens t ON ha.nickname= t.nickname AND  ha.birthdate = t.birthdate
INNER JOIN Pets p ON ha.petId = p.Id
INNER JOIN Animal_types a ON p.typeID = a.id

UNION

SELECT DISTINCT a.type, pac.animal, h.nickname, h.birthDate, h.commands, t.age
FROM Horses h
LEFT JOIN Teens t ON h.nickname= t.nickname AND  h.birthdate = t.birthdate
INNER JOIN Pack_animals pac ON h.packId = pac.Id
INNER JOIN Animal_types a ON pac.typeID = a.id

UNION

SELECT DISTINCT a.type, pac.animal, d.nickname, d.birthDate, d.commands, t.age
FROM Donkeys d
LEFT JOIN Teens t ON d.nickname= t.nickname AND  d.birthdate = t.birthdate
INNER JOIN Pack_animals pac ON d.packId = pac.Id
INNER JOIN Animal_types a ON pac.typeID = a.id;







