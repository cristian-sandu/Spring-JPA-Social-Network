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
  FOREIGN KEY fk_address_id (address_id) REFERENCES addresses (id),

  UNIQUE (username, email)
)
  ENGINE = InnoDB;

/*-------------------------Genders--------------------------------*/
CREATE TABLE genders (
  id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(20),

  UNIQUE (type)
)
  ENGINE = InnoDB;

/*-------------------------ROLES--------------------------------*/
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(255) NOT NULL DEFAULT 'ANONYMUS',

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

/*-------------------------Teachers--------------------------------*/
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

/*-------------------------Students--------------------------------*/
CREATE TABLE students (
  id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id  INT NOT NULL,
  group_id INT NOT NULL,

  FOREIGN KEY fk_user_id(user_id) REFERENCES users (id),
  FOREIGN KEY fk_group_id (group_id) REFERENCES groups (id)
)
  ENGINE = InnoDB;

/*-------------------------Courses--------------------------------*/
CREATE TABLE courses (
  id      INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(255) NOT NULL,
  credits INT          NOT NULL
)
  ENGINE = InnoDB;

/*-------------------------Classrooms--------------------------------*/
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

/*-------------------------Groups--------------------------------*/
CREATE TABLE groups (
  id                INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name              VARCHAR(255) NOT NULL,
  specialization_id INT          NOT NULL,

  FOREIGN KEY fk_specialization_id(specialization_id) REFERENCES specializations (id),

  UNIQUE (specialization_id)
)
  ENGINE = InnoDB;


/*-------------------------Specializations--------------------------------*/
CREATE TABLE specializations (
  id            INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(255) NOT NULL,
  year_of_study INT          NOT NULL,
  specialty_id  INT          NOT NULL,

  FOREIGN KEY fk_specialty_id (specialty_id) REFERENCES specialties (id),

  UNIQUE (year_of_study)
)
  ENGINE = InnoDB;


/*-------------------------Specialties--------------------------------*/
CREATE TABLE specialties (
  id         INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  faculty_id INT          NOT NULL,

  FOREIGN KEY fk_faculty_id(faculty_id) REFERENCES faculties (id),

  UNIQUE (faculty_id)
)
  ENGINE = InnoDB;

/*-------------------------Faculties--------------------------------*/
CREATE TABLE faculties (
  id            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  details_id    INT NOT NULL,
  university_id INT NOT NULL,

  FOREIGN KEY fk_details_id(details_id) REFERENCES official_details (id),
  FOREIGN KEY fk_university_id(university_id) REFERENCES universities (id)
)
  ENGINE = InnoDB;


/*-------------------------Universities--------------------------------*/
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

/*-------------------------Streets--------------------------------*/
CREATE TABLE streets (
  id            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(255),
  street_number INT NULL,
  post_code     VARCHAR(100)
)
  ENGINE = InnoDB;
/*ALTER TABLE streets MODIFY COLUMN street_number varchar(20);*/

/*-------------------------Cities--------------------------------*/
CREATE TABLE cities (
  id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(255),
  country_id INT NOT NULL,

  FOREIGN KEY fk_country_id (country_id) REFERENCES countries (id)
)
  ENGINE = InnoDB;

/*-------------------------Countries--------------------------------*/
CREATE TABLE countries (
  id            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  official_name VARCHAR(255),
  ISO           VARCHAR(25),
  UNIQUE (official_name, ISO)
)
  ENGINE = InnoDB;

/*Sample Data*/

/*------------------INSERT INTO COUNTRIES------------------------*/
INSERT INTO countries VALUES (NULL, 'Moldova', 'MD');
INSERT INTO countries VALUES (NULL, 'Russia', 'RU');
INSERT INTO countries VALUES (NULL, 'Romania', 'RO');
INSERT INTO countries VALUES (NULL, 'Germania', 'DE');
INSERT INTO countries VALUES (NULL, 'Great Britain', 'GB');
INSERT INTO countries VALUES (NULL, 'Australia', 'AU');
INSERT INTO countries VALUES (NULL, 'Brazil', 'BR');
INSERT INTO countries VALUES (NULL, 'Canada', 'CA');
INSERT INTO countries VALUES (NULL, 'Japan', 'JP');

SELECT *
FROM countries
ORDER BY id;

/*------------------INSERT INTO CITIES------------------------*/
INSERT INTO cities VALUES (NULL, 'Chisinau', 1);
INSERT INTO cities VALUES (NULL, 'Balti', 1);
INSERT INTO cities VALUES (NULL, 'Edinet', 1);
INSERT INTO cities VALUES (NULL, 'Orhei', 1);
INSERT INTO cities VALUES (NULL, 'Sangerei', 1);

INSERT INTO cities VALUES (NULL, 'Moskow', 2);
INSERT INTO cities VALUES (NULL, 'Bucharest', 3);
INSERT INTO cities VALUES (NULL, 'Berlin', 4);
INSERT INTO cities VALUES (NULL, 'London', 5);
INSERT INTO cities VALUES (NULL, 'Canberra', 6);
INSERT INTO cities VALUES (NULL, 'Rio de Janeiro', 7);
INSERT INTO cities VALUES (NULL, 'Ottawa', 8);
INSERT INTO cities VALUES (NULL, 'Tokyo', 9);


SELECT *
FROM cities;

/*Countries with their cities */
SELECT
  countries.official_name,
  cities.name
FROM countries
  INNER JOIN cities
    ON countries.id = cities.country_id;

/*------------------INSERT INTO STREETS------------------------*/
INSERT INTO streets VALUES (NULL, 'Stefan Cel Mare', '2/4', 2000);
INSERT INTO streets VALUES (NULL, 'Mihail Kogalniceanu', '6/10', 2012);
INSERT INTO streets VALUES (NULL, 'Bill Clinton', '2/13', 2009);
INSERT INTO streets VALUES (NULL, 'Abraham Lincoln', '4/16', 2003);
INSERT INTO streets VALUES (NULL, 'Alexandr Puskin', '6/18', 2017);
INSERT INTO streets VALUES (NULL, 'Joe Dassin', '9/17', 2019);
INSERT INTO streets VALUES (NULL, 'Adolf Hitler', '3/13', 2011);

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
VALUES (NULL, 'Universitatea de Stat din Moldova', 'usm@gmail.com', '+373 22 577 401', 'www.usm.md');

INSERT INTO official_details
VALUES (NULL, 'Academia de Studii Economice din Moldova', 'asem@gmail.com', '+373 24 557 461', 'www.asem.md');

INSERT INTO official_details
VALUES (NULL, 'University of Cambridge', 'cambridge@gbmail.com', '+44 1223 337733', 'cam.ac.uk');

INSERT INTO official_details
VALUES (NULL, 'Free University Of Berlin', 'freeu@gmail.com', ' +49 30 8381', 'fu-berlin.de');

INSERT INTO official_details VALUES (NULL, 'Matematica si Informatica', )