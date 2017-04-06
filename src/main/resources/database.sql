/*-------------------------Users--------------------------------*/
CREATE TABLE users (
  id          INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username    VARCHAR(255)  NOT NULL,
  password    VARCHAR(255)  NOT NULL,
  firstname   VARCHAR(255)  NOT NULL,
  lastname    VARCHAR(255)  NOT NULL,
  gender_id   INT           NOT NULL,
  birthdate   DATE          NOT NULL,
  mobilephone VARCHAR(255)  NULL,
  email       VARCHAR(300)  NOT NULL,
  avatar      VARCHAR(1000) NOT NULL,
  address_id  INT           NOT NULL,

  FOREIGN KEY fk_gender_id(gender_id) REFERENCES genders (id),

  UNIQUE (username, email)
)
  ENGINE = InnoDB;

/*-------------------------Gender--------------------------------*/
CREATE TABLE genders (
  id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(20),

  UNIQUE (type)
)
  ENGINE = InnoDB;

/*-------------------------ROLES--------------------------------*/
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(255) NOT NULL DEFAULT ''ANONYMUS'',

  UNIQUE (type)
)
  ENGINE = InnoDB;

/*-------------------------Many To Many--------------------------------*/
/*-------------------------USER-ROLES--------------------------------*/
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY fk_user_id(user_id) REFERENCES users (id),
  FOREIGN KEY fk_role_id(role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

/*-------------------------Teacher--------------------------------*/
CREATE TABLE teachers (
  id                 INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  teacher_statude_id INT NOT NULL,
  user_id            INT NOT NULL,

  FOREIGN KEY fk_teacher_statude_id(teacher_statude_id) REFERENCES teacher_statutes (id),
  FOREIGN KEY fk_user_id(user_id) REFERENCES users (id)
)
  ENGINE = InnoDB;

/*-------------------------Teacher_Statutes--------------------------------*/
CREATE TABLE teacher_statutes (
  id           INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  teacher_type VARCHAR(255) NOT NULL,

  UNIQUE (teacher_type)
)
  ENGINE = InnoDB;

/*-------------------------Student--------------------------------*/
CREATE TABLE students (
  id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id  INT NOT NULL,
  group_id INT NOT NULL,

  FOREIGN KEY fk_user_id(user_id) REFERENCES users (id),
  FOREIGN KEY fk_group_id (group_id) REFERENCES groups (id)
)
  ENGINE = InnoDB;

/*-------------------------Course--------------------------------*/
CREATE TABLE courses (
  id      INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(255) NOT NULL,
  credits INT          NOT NULL
)
  ENGINE = InnoDB;

/*-------------------------Classroom--------------------------------*/
CREATE TABLE classrooms (
  id     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  number INT NOT NULL,

  UNIQUE (number)
)
  ENGINE = InnoDB;

/*-------------------------Many To Many--------------------------------*/
/*-------------------------Courses_Rooms--------------------------------*/
CREATE TABLE courses_rooms (
  course_id    INT NOT NULL,
  classroom_id INT NOT NULL,

  FOREIGN KEY fk_course_id(course_id) REFERENCES courses (id),
  FOREIGN KEY fk_classroom_id(classroom_id) REFERENCES classrooms (id)
)
  ENGINE = InnoDB;

/*-------------------------Many To Many--------------------------------*/
/*-------------------------Courses_Teachers--------------------------------*/
CREATE TABLE courses_teachers (
  course_id  INT NOT NULL,
  teacher_id INT NOT NULL,

  FOREIGN KEY fk_course_id(course_id) REFERENCES courses (id),
  FOREIGN KEY fk_teacher_id(teacher_id) REFERENCES teachers (id)
)
  ENGINE = InnoDB;

/*-------------------------Many To Many--------------------------------*/
/*-------------------------Courses_Specializations--------------------------------*/
CREATE TABLE courses_specializations (
  course_id         INT NOT NULL,
  specialization_id INT NOT NULL,

  FOREIGN KEY fk_course_id (course_id) REFERENCES courses (id),
  FOREIGN KEY fk_specialization_id(specialization_id) REFERENCES specializations (id)
)
  ENGINE = InnoDB;

/*-------------------------Group--------------------------------*/
CREATE TABLE groups (
  id                INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name              VARCHAR(255) NOT NULL,
  specialization_id INT          NOT NULL,

  FOREIGN KEY fk_specialization_id(specialization_id) REFERENCES specializations (id),

  UNIQUE (specialization_id)
)
  ENGINE = InnoDB;


/*-------------------------Specialization--------------------------------*/
CREATE TABLE specializations (
  id            INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(255) NOT NULL,
  year_of_study INT          NOT NULL,
  specialty_id  INT          NOT NULL,

  FOREIGN KEY fk_specialty_id (specialty_id) REFERENCES specialties (id),
)
  ENGINE = InnoDB;


/*-------------------------Specialty--------------------------------*/
CREATE TABLE specialties (
  id         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  faculty_id INT          NOT NULL,

  FOREIGN KEY fk_faculty_id(faculty_id) REFERENCES faculties (id),

  UNIQUE (faculty_id)
)
  ENGINE = InnoDB;

/*-------------------------Faculty--------------------------------*/
CREATE TABLE faculties (
  id            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  details_id    INT NOT NULL,
  university_id INT NOT NULL,

  FOREIGN KEY fk_details_id(details_id) REFERENCES official_details (id),
  FOREIGN KEY fk_university_id(university_id) REFERENCES universities (id)
)
  ENGINE = InnoDB;


/*-------------------------University--------------------------------*/
CREATE TABLE universities (
  id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  details_id INT NOT NULL,
  adress_id  INT NOT NULL,

  FOREIGN KEY fk_details_id(details_id) REFERENCES official_details (id),
  FOREIGN KEY fk_adress_id(adress_id) REFERENCES addresses (id)
)
  ENGINE = InnoDB;


/*-------------------------Official_details--------------------------------*/
CREATE TABLE official_details (
  id           INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name         VARCHAR(255) NOT NULL,
  email        VARCHAR(255) NOT NULL,
  office_phone VARCHAR(255) NOT NULL,
  web_page     VARCHAR(255) NOT NULL,

  UNIQUE (email, office_phone, web_page)
)
  ENGINE = InnoDB;


/*-------------------------Addresses--------------------------------*/
CREATE TABLE addresses (
  id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  city_id   INT NOT NULL,
  street_id INT NOT NULL,

  FOREIGN KEY fk_city_id(city_id) REFERENCES cities (id),
  FOREIGN KEY fk_street_id(street_id) REFERENCES streets (id)
)
  ENGINE = InnoDB;

/*-------------------------StreetDAO--------------------------------*/
CREATE TABLE streets (
  id            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(255),
  street_number INT NULL,
  post_code     VARCHAR(100)
)
  ENGINE = InnoDB;
/*ALTER TABLE streets MODIFY COLUMN street_number varchar(20);*/

/*-------------------------City--------------------------------*/
CREATE TABLE cities (
  id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(255),
  country_id INT NOT NULL,

  FOREIGN KEY fk_country_id (country_id) REFERENCES countries (id)
)
  ENGINE = InnoDB;

/*-------------------------Country--------------------------------*/
CREATE TABLE countries (
  id            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  official_name VARCHAR(255),
  ISO           VARCHAR(25),
  UNIQUE (official_name, ISO)
)
  ENGINE = InnoDB;

/*Sample Data*/

/*------------------INSERT INTO COUNTRIES------------------------*/
INSERT INTO countries VALUES (NULL, ''Moldova'', ''MD'');
INSERT INTO countries VALUES (NULL, ''Russia'', ''RU'');
INSERT INTO countries VALUES (NULL, ''Romania'', ''RO'');
INSERT INTO countries VALUES (NULL, ''Germania'', ''DE'');
INSERT INTO countries VALUES (NULL, ''Great Britain'', ''GB'');
INSERT INTO countries VALUES (NULL, ''Australia'', ''AU'');
INSERT INTO countries VALUES (NULL, ''Brazil'', ''BR'');
INSERT INTO countries VALUES (NULL, ''Canada'', ''CA'');
INSERT INTO countries VALUES (NULL, ''Japan'', ''JP'');

SELECT *
FROM countries
ORDER BY id;

/*------------------INSERT INTO CITIES------------------------*/
INSERT INTO cities VALUES (NULL, ''Chisinau'', 1);
INSERT INTO cities VALUES (NULL, ''Balti'', 1);
INSERT INTO cities VALUES (NULL, ''Edinet'', 1);
INSERT INTO cities VALUES (NULL, ''Orhei'', 1);
INSERT INTO cities VALUES (NULL, ''Sangerei'', 1);

INSERT INTO cities VALUES (NULL, ''Moskow'', 2);
INSERT INTO cities VALUES (NULL, ''Bucharest'', 3);
INSERT INTO cities VALUES (NULL, ''Berlin'', 4);
INSERT INTO cities VALUES (NULL, ''London'', 5);
INSERT INTO cities VALUES (NULL, ''Canberra'', 6);
INSERT INTO cities VALUES (NULL, ''Rio de Janeiro'', 7);
INSERT INTO cities VALUES (NULL, ''Ottawa'', 8);
INSERT INTO cities VALUES (NULL, ''Tokyo'', 9);


SELECT *
FROM cities;

/*Country with their cities */
SELECT
  countries.official_name,
  cities.name
FROM countries
  INNER JOIN cities
    ON countries.id = cities.country_id;

/*------------------INSERT INTO STREETS------------------------*/
INSERT INTO streets VALUES (NULL, ''Stefan Cel Mare'', ''2 / 4'', 2000);
INSERT INTO streets VALUES (NULL, ''Mihail Kogalniceanu'', ''6 / 10'', 2012);
INSERT INTO streets VALUES (NULL, ''Bill Clinton'', ''2 / 13'', 2009);
INSERT INTO streets VALUES (NULL, ''Abraham Lincoln'', ''4 / 16'', 2003);
INSERT INTO streets VALUES (NULL, ''Alexandr Puskin'', ''6 / 18'', 2017);
INSERT INTO streets VALUES (NULL, ''Joe Dassin'', ''9 / 17'', 2019);
INSERT INTO streets VALUES (NULL, ''Adolf Hitler'', ''3 / 13'', 2011);

SELECT *
FROM streets
ORDER BY id;

/*------------------INSERT INTO Addresses------------------------*/
INSERT INTO addresses VALUES (NULL, 1, 1);
INSERT INTO addresses VALUES (NULL, 1, 2);

INSERT INTO addresses VALUES (NULL, 2, 1);
INSERT INTO addresses VALUES (NULL, 3, 2);
INSERT INTO addresses VALUES (NULL, 4, 2);
INSERT INTO addresses VALUES (NULL, 5, 1);

INSERT INTO addresses VALUES (NULL, 6, 5);
INSERT INTO addresses VALUES (NULL, 7, 1);
INSERT INTO addresses VALUES (NULL, 8, 7);
INSERT INTO addresses VALUES (NULL, 9, 3);
INSERT INTO addresses VALUES (NULL, 10, 6);
INSERT INTO addresses VALUES (NULL, 11, 4);
INSERT INTO addresses VALUES (NULL, 12, 7);
INSERT INTO addresses VALUES (NULL, 13, 3);

/*------------------INSERT INTO Official Details------------------------*/
INSERT INTO official_details
VALUES (NULL, ''Universitatea de Stat din Moldova'', ''usm@gmail.com'', '' + 373 22 577 401'', ''www.usm.md'');

INSERT INTO official_details
VALUES (NULL, ''Academia de Studii Economice din Moldova'', ''asem@gmail.com'', '' + 373 24 557 461'', ''www.asem.md'');

INSERT INTO official_details
VALUES (NULL, ''University of Cambridge'', ''cambridge@gbmail.com'', '' + 44 1223 337733'', ''cam.ac.uk'');

INSERT INTO official_details
VALUES (NULL, ''Free University Of Berlin'', ''freeu@gmail.com'', '' + 49 30 8381'', ''fu - berlin.de'');

INSERT INTO official_details
VALUES (NULL, ''Matematica si Informatica'', ''fmi@usm.md'', '' + 373 22 45 54 78'', ''www.fmi.md'');
INSERT INTO official_details VALUES (NULL, ''Law'', ''law@usm.md'', '' + 373 24 55 21 32'', ''www.law.md'');
INSERT INTO official_details VALUES (NULL, ''Psychology'', ''pshy@usm.md'', '' + 373 22 44 55 11'', ''www.pshy.md'');

SELECT *
FROM official_details;

/*------------------INSERT INTO University------------------------*/
INSERT INTO universities VALUES (NULL, 1, 1);
INSERT INTO universities VALUES (NULL, 2, 2);
INSERT INTO universities VALUES (NULL, 3, 7);
INSERT INTO universities VALUES (NULL, 4, 8);
INSERT INTO universities VALUES (NULL, 5, 9);
INSERT INTO universities VALUES (NULL, 6, 10);
INSERT INTO universities VALUES (NULL, 7, 11);

SELECT *
FROM universities;


/*------------------INSERT INTO Faculty------------------------*/
INSERT INTO faculties VALUES (NULL, 5, 1);
INSERT INTO faculties VALUES (NULL, 6, 2);
INSERT INTO faculties VALUES (NULL, 7, 3);
INSERT INTO faculties VALUES (NULL, 5, 4);
INSERT INTO faculties VALUES (NULL, 6, 1);
INSERT INTO faculties VALUES (NULL, 7, 2);
INSERT INTO faculties VALUES (NULL, 5, 3);

SELECT *
FROM faculties;

/*------------------INSERT INTO Specialty------------------------*/
INSERT INTO specialties VALUES (NULL, ''Informatics'', 1);
INSERT INTO specialties VALUES (NULL, ''Law & Justice'', 2);
INSERT INTO specialties VALUES (NULL, ''Psychology Clinique'', 3);


INSERT INTO specialties VALUES (NULL, ''Applied IT'', 4);
INSERT INTO specialties VALUES (NULL, ''Justice'', 5);
INSERT INTO specialties VALUES (NULL, ''MEMORY Reflexes'', 6);

SELECT *
FROM specialties;

/*------------------INSERT INTO Specialization------------------------*/
INSERT INTO specializations VALUES (NULL, ''Programming'', 1, 1);
INSERT INTO specializations VALUES (NULL, ''Human Rights'', 2, 2);
INSERT INTO specializations VALUES (NULL, ''Logix'', 3, 3);

INSERT INTO specializations VALUES (NULL, ''Web Design'', 2, 4);
INSERT INTO specializations VALUES (NULL, ''Mass Media Rights'', 3, 5);
INSERT INTO specializations VALUES (NULL, ''Emotions AND Feelings'', 2, 6);

SELECT *
FROM specializations;

UPDATE specializations
SET id = 6
WHERE id = 7;

/*------------------INSERT INTO Group------------------------*/
INSERT INTO groups VALUES (NULL, ''I - 11'', 1);
INSERT INTO groups VALUES (NULL, ''HR - 23'', 2);
INSERT INTO groups VALUES (NULL, ''PSH - 31'', 3);

INSERT INTO groups VALUES (NULL, ''WD - 21'', 4);
INSERT INTO groups VALUES (NULL, ''MM - 33'', 5);
INSERT INTO groups VALUES (NULL, ''E & F - 24'', 6);

SELECT *
FROM groups;

/*------------------INSERT INTO Course------------------------*/
INSERT INTO courses VALUES (NULL, ''Java'', 6);
INSERT INTO courses VALUES (NULL, ''Rights & Concepts'', 4);
INSERT INTO courses VALUES (NULL, ''Brain'', 3);

INSERT INTO courses VALUES (NULL, ''HTML & CSS'', 5);
INSERT INTO courses VALUES (NULL, ''Lawsuits'', 6);
INSERT INTO courses VALUES (NULL, ''Emotions control'', 3);

SELECT *
FROM courses;

/*------------------INSERT INTO Course-Specialization------------------------*/
INSERT INTO courses_specializations VALUES (1, 1);
INSERT INTO courses_specializations VALUES (2, 2);
INSERT INTO courses_specializations VALUES (2, 6);
INSERT INTO courses_specializations VALUES (3, 3);
INSERT INTO courses_specializations VALUES (6, 3);
INSERT INTO courses_specializations VALUES (4, 4);
INSERT INTO courses_specializations VALUES (4, 1);

SELECT *
FROM courses_specializations;

/*------------------INSERT INTO Class-Rooms------------------------*/
INSERT INTO classrooms (number) VALUES (23);
INSERT INTO classrooms (number) VALUES (333);
INSERT INTO classrooms (number) VALUES (223);

INSERT INTO classrooms (number) VALUES (542);
INSERT INTO classrooms (number) VALUES (152);
INSERT INTO classrooms (number) VALUES (352);

SELECT *
FROM classrooms;

/*------------------INSERT INTO Course-Rooms------------------------*/
INSERT INTO courses_rooms VALUES (1, 6);
INSERT INTO courses_rooms VALUES (1, 4);
INSERT INTO courses_rooms VALUES (2, 5);
INSERT INTO courses_rooms VALUES (3, 5);
INSERT INTO courses_rooms VALUES (3, 1);
INSERT INTO courses_rooms VALUES (4, 4);
INSERT INTO courses_rooms VALUES (4, 3);
INSERT INTO courses_rooms VALUES (5, 2);
INSERT INTO courses_rooms VALUES (6, 2);

SELECT *
FROM courses_rooms;

/*------------------INSERT INTO Teacher statutes------------------------*/
INSERT INTO teacher_statutes (teacher_type) VALUES (''Teacher'');
INSERT INTO teacher_statutes (teacher_type) VALUES (''ProDean'');
INSERT INTO teacher_statutes (teacher_type) VALUES (''Dean'');
INSERT INTO teacher_statutes (teacher_type) VALUES (''Rector'');

SELECT *
FROM teacher_statutes;


/*------------------INSERT INTO Teacher------------------------*/
INSERT INTO teachers VALUES (NULL, 1, 2);
/* user 2- teacher-Epifanova Irina*/

INSERT INTO teachers VALUES (NULL, 2, 3);
/* user 3- ProDean- Capcelea Titu*/

INSERT INTO teachers VALUES (NULL, 3, 4);
/*user 4- Dean - Rusu Galina */

INSERT INTO teachers VALUES (NULL, 4, 5);
/*user 5- Rector - Cicocanu Gheorghe*/

SELECT *
FROM teachers;


/*------------------INSERT INTO Gender------------------------*/
INSERT INTO genders (type) VALUES (''man'');
INSERT INTO genders (type) VALUES (''woman'');

SELECT *
FROM genders;
/*------------------INSERT INTO Users------------------------*/

INSERT INTO users VALUES
  (NULL, ''Sandu_Cristi'', ''number23'', ''Sandu'', ''Cristian'', 1, 01 / 07 / 1996, ''0 - 60 - 47 - 20 - 85'',
   ''sandu.cristian@mail.ru'',
   ''link photo url'');
SELECT *
FROM users;

UPDATE users
SET birthdate =''01 - 07 - 1996'' WHERE id = 1;


INSERT INTO t_gender VALUES (1, 'MALE');
INSERT INTO t_gender VALUES (2, 'FEMALE');

INSERT INTO t_role VALUES (1, 'ADMIN');

INSERT INTO t_city VALUES (1, 'Chisinau', 1);
INSERT INTO t_country VALUES (1, 'Moldova', 'MD');
INSERT INTO t_street VALUES (1, 'Stefan Cel Mare', '2012', '20/12');
INSERT INTO t_adress VALUES (1, 1, 1);
SELECT *
FROM t_adress;

INSERT INTO t_user VALUES
  (1, 'Cristian', 'avatarlink', '10/10/1996', 'sandu.cristian@mail.ru', 'Sandu', '060-47-20-85',
      '$2a$04$HWzqOcsol2OrungeOJguieKon1UqrRznTHJAIu.hi2j16LO8NOF62', 'Sandu_Cristian',
      1, 1);

# parola este sandu

SELECT *
FROM t_user;

INSERT INTO t_user_role VALUES (1, 1);

SELECT *
FROM t_user_role;


UPDATE t_user
SET password = '$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm'
WHERE user_id = 1;

# parola asta este : abc125

SELECT *
FROM t_user;