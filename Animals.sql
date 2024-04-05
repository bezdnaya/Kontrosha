CREATE TABLE Pets(
id INT  AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(40),
Type VARCHAR(40),
BirthDate Date,
Commands VARCHAR(100));

INSERT INTO Pets (Name, Type, BirthDate, Commands)
VALUES ('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
		('Whiskers', 'Cat',	'2019-05-15',	'Sit, Pounce'),
        ('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
        ('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
        ('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
        ('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
        ('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
        ('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');
        
CREATE TABLE PackAnimals(
id INT  AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(40),
Type VARCHAR(40),
BirthDate Date,
Commands VARCHAR(100));

INSERT INTO PackAnimals (Name, Type, BirthDate, Commands)
VALUES ('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
		('Sandy', 'Camel', '2016-11-03',	'Walk, Carry Load'),
        ('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
        ('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
        ('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
        ('Burro', 'Donkey',	'2019-01-23',	'Walk, Bray, Kick'),
        ('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
        ('Sahara', 'Camel', '2015-08-14', 'Walk, Run');
        
-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
DELETE FROM PackAnimals
WHERE Type = 'Camel' AND id > 0;

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
CREATE TABLE animals_under_3(
WITH ut AS(SELECT * FROM Pets
UNION
SELECT * FROM PackAnimals),
age_table AS (SELECT *, CAST(TIMESTAMPDIFF(MONTH, ut.BirthDate, CURRENT_DATE()) AS SIGNED) as age_in_months FROM ut)
SELECT id, Name, Type, BirthDate, Commands, CONCAT (floor(age_in_months/12), ' years and ', age_in_months - floor(age_in_months/12)*12, ' months') AS Age from age_table
WHERE Age_in_months < 36);

-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

SELECT id, Name, Type, BirthDate, Commands, 'Pets' AS AnimalType FROM Pets
UNION
SELECT id, Name, Type, BirthDate, Commands, 'PackAnimals' AS AnimalType FROM PackAnimals
UNION ALL
SELECT id, Name, Type, BirthDate, Commands, 'Animals under 3y.o' AS AnimalType FROM animals_under_3;



