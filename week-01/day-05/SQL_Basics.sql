# this is a comment in SQL
####### you can type things that won't execute
# case does NOT matter except for actual data being entered
# traditionally, keywords are capitalized, while names of databases, tables and fields are lowercase

# creating a database
CREATE DATABASE `company`;

# creating a table
CREATE TABLE `company`.`certification` (
  `certification_id` INT NOT NULL AUTO_INCREMENT,
  `certification_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`certification_id`),
  UNIQUE INDEX `certification_name_UNIQUE` (`certification_name` ASC) VISIBLE);
  
# dropping a table
DROP TABLE `company`.`certification`;

# grabbing everything from my new table
SELECT * FROM certification;

# to select individual columns
SELECT certification_id, certification_name FROM certification;

# entering records into our table
INSERT INTO certification(certification_name) VALUES("Java");
INSERT INTO certification(certification_name) 
	VALUES("SQL"), ("Angular"), ("MongoDB"), ("Sales"), ("Marketing"), ("Design"), ("Spring Boot");

CREATE TABLE `company`.`department` (
	`department_id` INT NOT NULL AUTO_INCREMENT,
    `department_name` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`department_id`),
	UNIQUE INDEX `department_name_UNIQUE` (`department_name` ASC) VISIBLE);
    
INSERT INTO department(department_name) VALUES("Accounting"), ("Sales"), ("Marketing"), ("Training"), ("Human Resources");

# getting an ordered result
SELECT * FROM department ORDER BY department_id;

# changing something in our records
UPDATE department SET department_name = "HR" WHERE department_id = 5;
UPDATE department SET department_name = "Human Resources" WHERE department_id = 5;

SELECT * FROM department WHERE department_id > 3;

# wildcards -- % is any number of characters, _ is a single character
SELECT * FROM department WHERE department_name LIKE("_____");
SELECT * FROM department WHERE department_name LIKE("M%");

# deleting a record
# safe mode prohibits us from deleting without a WHERE clause; good practice anyway
DELETE FROM department WHERE department_id = 5;
INSERT INTO department(department_name) VALUES("Human Resources");

UPDATE department SET department_id = 5, department_name = "Human Resources" WHERE department_id = 10;

# CRUD Operations = Create (POST), Read (GET), Update(PUT), Delete(DELETE)

# Creating a table with a foreign key
CREATE TABLE `company`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `employee_firstname` VARCHAR(30) NOT NULL,
  `employee_lastname` VARCHAR(30) NOT NULL,
  `department_id` INT NULL,
  PRIMARY KEY (`employee_id`),
  INDEX `department_id1_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `department_id1`
    FOREIGN KEY (`department_id`)
    REFERENCES `company`.`department` (`department_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);
    
INSERT INTO employee(employee_firstname, employee_lastname, department_id)
	VALUES("Joe", "Joebeth", 1);
    
SELECT * FROM employee;
SELECT * FROM department;

SELECT employee_firstname, employee_lastname, department_name FROM employee INNER JOIN department WHERE employee.department_id = department.department_id;

INSERT INTO employee(employee_firstname, employee_lastname, department_id)
	VALUES("Abby", "Normal", 1), ("Doug", "Fresh", 2), ("Susan", "Dohnz", 2), ("Cheyenne", "Wyoming", 1);
    
INSERT INTO employee(employee_firstname, employee_lastname)
	VALUES("Janice", "Von Trapp"), ("Elwood", "Decker");
    
INSERT INTO department(department_name) VALUES("Research"), ("Development");
    
# Joins
# INNER JOIN / JOIN = all fields in both tables for records with a match
# LEFT JOIN - all records from the left (first) table, only matches from the right, null on the right when there's no match
# RIGHT JOIN - opposite of the above
# FULL JOIN - every record on the left matched with each record on the right (does not require a condition)

SELECT * FROM employee JOIN department ON employee.department_id = department.department_id;
SELECT * FROM employee LEFT JOIN department ON employee.department_id = department.department_id;
SELECT * FROM employee RIGHT JOIN department ON employee.department_id = department.department_id;
SELECT * FROM employee FULL JOIN department;

# creating our join table
CREATE TABLE `company`.`employee_certification` (
  `employee_id` INT NOT NULL,
  `certification_id` INT NOT NULL,
  PRIMARY KEY (`employee_id`, `certification_id`),
  INDEX `certification_id1_idx` (`certification_id` ASC) VISIBLE,
  CONSTRAINT `employee_id1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `company`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `certification_id1`
    FOREIGN KEY (`certification_id`)
    REFERENCES `company`.`certification` (`certification_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

SELECT * FROM employee_certification;

INSERT INTO employee_certification(employee_id, certification_id) 
	VALUES ( 1 , 646 ), ( 1 , 647 ), ( 1 , 648 ), ( 1 , 649 ), ( 2 , 648 ), ( 2 , 649 ), ( 3 , 648 ), ( 3 , 649 );

# these actions affect our employee_certification table, because we set it up with CASCADE
# updating the id in the certification table updates it in this table
# deleting the record from the certification table removes any corresponding records in this table
# same behavior in place with regards to the employee table
UPDATE certification SET certification_id = 700 WHERE certification_id = 649;
DELETE FROM certification WHERE certification_id = 700;

# to join employees and certifications, since it's many-to-many with a join table
# first join employee with the join table, then join the result with the certification table 
SELECT employee.employee_id, employee_firstname, employee_lastname, department_id, certification.certification_id, certification_name FROM employee
	JOIN employee_certification ON employee.employee_id = employee_certification.employee_id
    JOIN certification ON employee_certification.certification_id = certification.certification_id;







