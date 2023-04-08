DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE employees
(
    id      BIGSERIAL PRIMARY KEY,
    firstName    VARCHAR(64)  NOT NULL UNIQUE,
    lastName VARCHAR(64)  NOT NULL,
    middleName VARCHAR(64)  NOT NULL,
    dateOfBirth   DATE  NOT NULL,
    dateOfHire   DATE  NOT NULL,
    salary INTEGER NOT NULL,
    department VARCHAR(32) NOT NULL,
    position VARCHAR(64),
    sex BOOLEAN, 
    ismarried BOOLEAN
   
);
