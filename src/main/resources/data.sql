INSERT INTO ANALYST(ID, FULL_NAME, EMPLOYEE_CODE, STATUS, BIRTH_DATE)
VALUES (1000,'Luis Carlos Lopera','2020', TRUE, '1999-01-10 12:04:00');

INSERT INTO ANALYST(ID, FULL_NAME, EMPLOYEE_CODE, STATUS, BIRTH_DATE)
VALUES (2000,'Daniel Jaramillo','2021', TRUE, '1999-01-10 12:04:00');

INSERT INTO ANALYST(ID, FULL_NAME, EMPLOYEE_CODE, STATUS, BIRTH_DATE)
VALUES (3000,'Marianela Casimiro','2022', TRUE, '1999-01-10 12:04:00');

INSERT INTO ANALYST(ID, FULL_NAME, EMPLOYEE_CODE, STATUS, BIRTH_DATE)
VALUES (4000,'Alejandra Durango','2023', FALSE, '1999-01-10 12:04:00');

INSERT INTO RESERVATION(ID, ANALYST_ID, RESERVATION_DATE, VALUE, DIAGNOSIS, STATUS, PAYMENT_TYPE, DOLLAR_VALUE)
VALUES (10, 1000, '1999-01-10 12:00:00', 35000, NULL, 'ACTIVE', 'COP', 3000);