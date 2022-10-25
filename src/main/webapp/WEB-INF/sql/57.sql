CREATE DATABASE mydb6;
USE mydb6;

CREATE TABLE TableA (
	col1 INT
);

CREATE TABLE TableB (
	c1 INT
);

INSERT INTO TableA (col1)
VALUES (1), (2), (3), (4), (5);
INSERT INTO TableB (c1)
VALUES (2), (4), (5), (7), (8);

-- INNER JOIN : 두 컬럼에 값이 모두 있는 경우 
SELECT * FROM TableA INNER JOIN TableB B ON A.col1 = B.c1;
SELECT * FROM TableB;
