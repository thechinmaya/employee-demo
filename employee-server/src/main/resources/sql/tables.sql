CREATE TABLE department (
   id INTEGER  NOT NULL,
   dept_name VARCHAR (45),
   PRIMARY KEY (id)
); 


CREATE TABLE employee (
   id INTEGER  NOT NULL,
   first_name VARCHAR (45),
   last_name VARCHAR (45),
   gender VARCHAR (10),
   dob DATE,
   dept_id INTEGER, 
   PRIMARY KEY (id),
   FOREIGN KEY (dept_id) REFERENCES department(id)
); 

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 11;