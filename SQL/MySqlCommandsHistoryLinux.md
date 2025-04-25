veronik@UbuntuM3:~$ sudo mysql -u root -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 15
Server version: 8.4.4-0ubuntu2 (Ubuntu)

Copyright (c) 2000, 2025, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> CREATE DATABASE Human_friends;
Query OK, 1 row affected (0.01 sec)

mysql> USE Human_friends;
Database changed
mysql> CREATE TABLE Animal_types
    -> (
    -> Id INT PRIMARY KEY AUTO_INCREMENT, 
    ->   type VARCHAR(20)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> 
mysql> INSERT INTO Animal_types(type)
    -> VALUES ('pet'), ('pack animal');
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> CREATE TABLE Pets
    -> (
    -> Id INT PRIMARY KEY AUTO_INCREMENT,
    -> animal VARCHAR(20),
    -> typeId INT,
    -> FOREIGN KEY(typeId) REFERENCES Animal_types(Id)
    -> );
Query OK, 0 rows affected (0.03 sec)

mysql> CREATE TABLE Pack_animals
    -> (
    ->   Id INT PRIMARY KEY AUTO_INCREMENT,
    ->   animal VARCHAR(20),
    ->   typeId INT,
    ->   FOREIGN KEY(typeId) REFERENCES Animal_types(Id)
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> SELECT CONSTRAINT_NAME FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME ='Pets' AND TABLE_SCHEMA = 'Human_friends'; 
+-----------------+
| CONSTRAINT_NAME |
+-----------------+
| PRIMARY         |
| Pets_ibfk_1     |
+-----------------+
2 rows in set (0.00 sec)

mysql> ALTER TABLE Pets DROP FOREIGN KEY Pets_ibfk_1;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> ALTER TABLE Pets ADD CONSTRAINT Pets_ibfk_1 FOREIGN KEY(typeId) REFERENCES Animal_types(Id) ON DELETE CASCADE ON UPDATE CASCADE;
Query OK, 0 rows affected (0.05 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> SELECT CONSTRAINT_NAME FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME ='Pack_animals' AND TABLE_SCHEMA = 'Human_friends';
+---------------------+
| CONSTRAINT_NAME     |
+---------------------+
| PRIMARY             |
| Pack_animals_ibfk_1 |
+---------------------+
2 rows in set (0.00 sec)

mysql> ALTER TABLE Pack_animals DROP FOREIGN KEY Pack_animals_ibfk_1;
Query OK, 0 rows affected (0.00 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> ALTER TABLE Pack_animals ADD CONSTRAINT Pack_animals_ibfk_1 FOREIGN KEY(typeId) REFERENCES Animal_types(Id) ON DELETE CASCADE ON UPDATE CASCADE;
Query OK, 0 rows affected (0.04 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Pets(animal, typeId) VALUES
    -> ('cat', 1), ('dog', 1), ('hamster', 1);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Pack_animals(animal, typeId) VALUES
    -> ('horse', 2), ('camel', 2), ('donkey', 2);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> CREATE TABLE Cats
    -> (
    -> Id INT PRIMARY KEY AUTO_INCREMENT,
    -> nickname VARCHAR(20),
    -> birthDate DATE,
    -> commands VARCHAR(100),
    -> petId INT,
    -> FOREIGN KEY(petId) REFERENCES Pets(Id) ON DELETE CASCADE ON UPDATE CASCADE
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> CREATE TABLE Dogs
    -> (
    -> Id INT PRIMARY KEY AUTO_INCREMENT,
    -> nickname VARCHAR(20),
    -> birthDate DATE,
    -> commands VARCHAR(100),
    -> petId INT,
    -> FOREIGN KEY(petId) REFERENCES Pets(Id) ON DELETE CASCADE ON UPDATE CASCADE
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> CREATE TABLE Hamsters
    -> (
    -> Id INT PRIMARY KEY AUTO_INCREMENT,
    -> nickname VARCHAR(20),
    -> birthDate DATE,
    -> commands VARCHAR(100),
    -> petId INT,
    -> FOREIGN KEY(petId) REFERENCES Pets(Id) ON DELETE CASCADE ON UPDATE CASCADE
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> CREATE TABLE Horses
    -> (
    -> Id INT PRIMARY KEY AUTO_INCREMENT,
    -> nickname VARCHAR(20),
    -> birthDate DATE,
    -> commands VARCHAR(100),
    -> packId INT,
    -> FOREIGN KEY(packId) REFERENCES Pack_animals(Id) ON DELETE CASCADE ON UPDATE CASCADE
    -> );
Query OK, 0 rows affected (0.03 sec)

mysql> CREATE TABLE Camels
    -> (
    -> Id INT PRIMARY KEY AUTO_INCREMENT,
    -> nickname VARCHAR(20),
    -> birthDate DATE,
    -> commands VARCHAR(100),
    -> packId INT,
    -> FOREIGN KEY(packId) REFERENCES Pack_animals(Id) ON DELETE CASCADE ON UPDATE CASCADE
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> CREATE TABLE Donkeys
    -> (
    -> Id INT PRIMARY KEY AUTO_INCREMENT,
    -> nickname VARCHAR(20),
    -> birthDate DATE,
    -> commands VARCHAR(100),
    -> packId INT,
    -> FOREIGN KEY(packId) REFERENCES Pack_animals(Id) ON DELETE CASCADE ON UPDATE CASCADE
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> INSERT INTO Cats(nickname, birthDate, commands, petId) VALUES
    -> ('Kiti', '2020-11-15', 'up, sit down, catch, come', 1),
    -> ('Milli', '2024-01-30', 'voice, catch, jump, come', 1),
    -> ('Sunny', '2019-08-07', 'freeze, jump, play, come', 1);
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Dogs(nickname, birthDate, commands, petId) VALUES
    -> ('Bobby', '2020-08-14', 'up, down, come, voice', 2),
    -> ('Milli', '2024-01-30', 'jump, catch, aport', 2),
    -> ('Sunny', '2019-08-07', 'freeze, jump, catch, come', 2);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Hamsters(nickname, birthDate, commands, petId) VALUES
    -> ('Mini', '2024-08-21', 'come, food', 3),
    -> ('Maxi', '2024-01-28', 'come, food', 3),
    -> ('Middle', '2025-02-27', 'come, food', 3);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Horses(nickname, birthDate, commands, packId) VALUES
    -> ('Hero', '2015-03-22', 'straight, stop, ride', 1),
    -> ('Loyal', '2020-07-19', 'trot, up, down', 1),
    -> ('Grumpy', '2018-10-12', 'stop, go, down', 1);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Camels(nickname, birthDate, commands, packId) VALUES
    -> ('Titan', '2017-07-05', 'stop, go, down', 2),
    -> ('Zeus', '2020-05-03', 'stop, go, down', 2),
    -> ('Mars', '2023-09-11', 'stop, ride', 2);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO Donkeys(nickname, birthDate, commands, packId) VALUES
    -> ('Morning', '2021-08-10', 'freeze, go, stop', 3),
    -> ('Evening', '2022-09-28', 'come, go, stop', 3),
    -> ('Night', '2018-04-19', 'go, stop, freeze', 3);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql>  DELETE FROM CAMELS;
ERROR 1146 (42S02): Table 'Human_friends.CAMELS' doesn't exist
mysql> DELETE FROM Camels;
Query OK, 3 rows affected (0.00 sec)

mysql> SELECT pac.animal, h.nickname, h.birthDate, h.commands
    -> FROM Horses h
    -> INNER JOIN Pack_animals pac
    -> ON h.packId = pac.Id
    -> 
    -> UNION
    -> 
    -> SELECT pac.animal, d.nickname, d.birthDate, d.commands
    -> FROM Donkeys d
    -> INNER JOIN Pack_animals pac
    -> ON d.packId = pac.Id;
+--------+----------+------------+----------------------+
| animal | nickname | birthDate  | commands             |
+--------+----------+------------+----------------------+
| horse  | Hero     | 2015-03-22 | straight, stop, ride |
| horse  | Loyal    | 2020-07-19 | trot, up, down       |
| horse  | Grumpy   | 2018-10-12 | stop, go, down       |
| donkey | Morning  | 2021-08-10 | freeze, go, stop     |
| donkey | Evening  | 2022-09-28 | come, go, stop       |
| donkey | Night    | 2018-04-19 | go, stop, freeze     |
+--------+----------+------------+----------------------+
6 rows in set (0.01 sec)

mysql> 
mysql> -- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
Query OK, 0 rows affected (0.00 sec)

mysql> 
mysql> CREATE TABLE Teens
    -> AS
    -> SELECT 
    -> animal, nickname, birthDate, commands,
    -> CONCAT (TIMESTAMPDIFF(YEAR, birthDate, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthDate, CURDATE()) - TIMESTAMPDIFF(YEAR, birthDate, CURDATE()) * 12, ' m') AS age
    -> FROM (
    -> SELECT p.animal, c.nickname, c.birthDate, c.commands
    -> FROM Cats c
    -> INNER JOIN Pets p
    -> ON c.petId = p.Id
    -> 
    -> UNION
    -> 
    -> SELECT p.animal, Dogs.nickname, Dogs.birthDate, Dogs.commands
    -> FROM Dogs
    -> INNER JOIN Pets p
    -> ON Dogs.petId = p.Id
    -> 
    -> UNION
    -> 
    -> SELECT p.animal, ha.nickname, ha.birthDate, ha.commands
    -> FROM Hamsters ha
    -> INNER JOIN Pets p
    -> ON ha.petId = p.Id
    -> 
    -> UNION
    -> 
    -> SELECT pac.animal, h.nickname, h.birthDate, h.commands
    -> FROM Horses h
    -> INNER JOIN Pack_animals pac
    -> ON h.packId = pac.Id
    -> 
    -> UNION
    -> 
    -> SELECT pac.animal, d.nickname, d.birthDate, d.commands
    -> FROM Donkeys d
    -> INNER JOIN Pack_animals pac
    -> ON d.packId = pac.Id
    -> ) all_animals
    -> 
    -> WHERE TIMESTAMPDIFF(MONTH, birthDate, CURDATE()) >= 12 AND TIMESTAMPDIFF(MONTH, birthDate, CURDATE()) < 48;
Query OK, 5 rows affected (0.03 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM Teens;
+---------+----------+------------+--------------------------+---------+
| animal  | nickname | birthDate  | commands                 | age     |
+---------+----------+------------+--------------------------+---------+
| cat     | Milli    | 2024-01-30 | voice, catch, jump, come | 1 y 2 m |
| dog     | Milli    | 2024-01-30 | jump, catch, aport       | 1 y 2 m |
| hamster | Maxi     | 2024-01-28 | come, food               | 1 y 2 m |
| donkey  | Morning  | 2021-08-10 | freeze, go, stop         | 3 y 8 m |
| donkey  | Evening  | 2022-09-28 | come, go, stop           | 2 y 6 m |
+---------+----------+------------+--------------------------+---------+
5 rows in set (0.00 sec)

mysql> SELECT DISTINCT a.type, p.animal, c.nickname, c.birthDate, c.commands, t.age
    -> FROM Cats c
    -> LEFT JOIN Teens t ON c.nickname= t.nickname AND  c.birthdate = t.birthdate
    -> INNER JOIN Pets p ON c.petId = p.Id
    -> INNER JOIN Animal_types a ON p.typeID = a.id
    -> 
    -> UNION
    -> 
    -> SELECT DISTINCT a.type, p.animal, Dogs.nickname, Dogs.birthDate, Dogs.commands, t.age
    -> FROM Dogs
    -> LEFT JOIN Teens t ON Dogs.nickname= t.nickname AND  Dogs.birthdate = t.birthdate
    -> INNER JOIN Pets p ON Dogs.petId = p.Id
    -> INNER JOIN Animal_types a ON p.typeID = a.id
    -> 
    -> UNION
    -> 
    -> SELECT DISTINCT a.type, p.animal, ha.nickname, ha.birthDate, ha.commands, t.age
    -> FROM Hamsters ha
    -> LEFT JOIN Teens t ON ha.nickname= t.nickname AND  ha.birthdate = t.birthdate
    -> INNER JOIN Pets p ON ha.petId = p.Id
    -> INNER JOIN Animal_types a ON p.typeID = a.id
    -> 
    -> UNION
    -> 
    -> SELECT DISTINCT a.type, pac.animal, h.nickname, h.birthDate, h.commands, t.age
    -> FROM Horses h
    -> LEFT JOIN Teens t ON h.nickname= t.nickname AND  h.birthdate = t.birthdate
    -> INNER JOIN Pack_animals pac ON h.packId = pac.Id
    -> INNER JOIN Animal_types a ON pac.typeID = a.id
    -> 
    -> UNION
    -> 
    -> SELECT DISTINCT a.type, pac.animal, d.nickname, d.birthDate, d.commands, t.age
    -> FROM Donkeys d
    -> LEFT JOIN Teens t ON d.nickname= t.nickname AND  d.birthdate = t.birthdate
    -> INNER JOIN Pack_animals pac ON d.packId = pac.Id
    -> INNER JOIN Animal_types a ON pac.typeID = a.id;
+-------------+---------+----------+------------+---------------------------+---------+
| type        | animal  | nickname | birthDate  | commands                  | age     |
+-------------+---------+----------+------------+---------------------------+---------+
| pet         | cat     | Kiti     | 2020-11-15 | up, sit down, catch, come | NULL    |
| pet         | cat     | Milli    | 2024-01-30 | voice, catch, jump, come  | 1 y 2 m |
| pet         | cat     | Sunny    | 2019-08-07 | freeze, jump, play, come  | NULL    |
| pet         | dog     | Bobby    | 2020-08-14 | up, down, come, voice     | NULL    |
| pet         | dog     | Milli    | 2024-01-30 | jump, catch, aport        | 1 y 2 m |
| pet         | dog     | Sunny    | 2019-08-07 | freeze, jump, catch, come | NULL    |
| pet         | hamster | Mini     | 2024-08-21 | come, food                | NULL    |
| pet         | hamster | Maxi     | 2024-01-28 | come, food                | 1 y 2 m |
| pet         | hamster | Middle   | 2025-02-27 | come, food                | NULL    |
| pack animal | horse   | Hero     | 2015-03-22 | straight, stop, ride      | NULL    |
| pack animal | horse   | Loyal    | 2020-07-19 | trot, up, down            | NULL    |
| pack animal | horse   | Grumpy   | 2018-10-12 | stop, go, down            | NULL    |
| pack animal | donkey  | Morning  | 2021-08-10 | freeze, go, stop          | 3 y 8 m |
| pack animal | donkey  | Evening  | 2022-09-28 | come, go, stop            | 2 y 6 m |
| pack animal | donkey  | Night    | 2018-04-19 | go, stop, freeze          | NULL    |
+-------------+---------+----------+------------+---------------------------+---------+
15 rows in set (0.00 sec)
