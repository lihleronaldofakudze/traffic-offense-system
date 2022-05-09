-- @BLOCK
CREATE TABLE role (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title TEXT NOT NULL,
    description TEXT NULL
);

-- @BLOCK
CREATE TABLE administrator (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role_id INTEGER,
    name TEXT NOT NULL,
    email VARCHAr(150) NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role(id)
);

-- @BLOCK
CREATE TABLE divertion (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name TEXT NOT NULL,
    type TEXT NULL,
    description TEXT NULL,
    police_id INTEGER,
    FOREIGN KEY (police_id) REFERENCES police(id)
);

-- @BLOCK
CREATE TABLE length (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name TEXT NOT NULL,
    type TEXT NULL,
    description TEXT NULL,
    time VARCHAR(100),
    route_id INTEGER,
    FOREIGN KEY (route_id) REFERENCES routes(id)
);

-- @BLOCK
CREATE TABLE routes (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    length VARCHAR(100) NOT NULL,
    name TEXT NOT NULL,
    type TEXT NULL,
    description TEXT NULL,
    police_id INTEGER,
    FOREIGN KEY (police_id) REFERENCES police(id)
);

-- @BLOCK
CREATE TABLE police (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name TEXT NOT NULL,
    type TEXT NULL,
    description TEXT NULL,
    password VARCHAR(100) UNIQUE
);
<<<<<<< HEAD

-- DISTINCT
SELECT DISTINCT name 
FROM police;

-- GROUB BY
SELECT name, COUNT(*)
FROM police
GROUP BY name;

-- LIMIT
SELECT *
FROM police
LIMIT 10;

-- Subquery
SELECT *
FROM police
WHERE id IN (SELECT police_id FROM divertion);

SELECT *
FROM divertion
WHERE police_id IN (SELECT id FROM police);

SELECT *
FROM divertion
WHERE police_id IN (SELECT id FROM police WHERE name = 'John');

-- Inner join
SELECT *
FROM divertion
INNER JOIN police
ON divertion.police_id = police.id;

SELECT *
FROM legnth
INNER JOIN routes
ON length.route_id = routes.id;

-- Left join
SELECT *
FROM divertion
LEFT JOIN police
ON divertion.police_id = police.id;

SELECT *
FROM legnth
LEFT JOIN routes
ON length.route_id = routes.id;

-- Right join
SELECT *
FROM divertion
RIGHT JOIN police
ON divertion.police_id = police.id;

SELECT *
FROM legnth
RIGHT JOIN routes
ON length.route_id = routes.id;

-- LEFT OUTER JOIN
SELECT *
FROM divertion
LEFT OUTER JOIN police
ON divertion.police_id = police.id;

SELECT *
FROM legnth
LEFT OUTER JOIN routes
ON length.route_id = routes.id;

-- RIGHT OUTER JOIN
SELECT *
FROM divertion
RIGHT OUTER JOIN police
ON divertion.police_id = police.id;

SELECT *
FROM legnth
RIGHT OUTER JOIN routes
ON length.route_id = routes.id;

-- CROSS JOIN
SELECT *
FROM divertion
CROSS JOIN police;

SELECT *
FROM legnth
CROSS JOIN routes;

-- UNION
SELECT police_id
FROM routes
UNION
SELECT police_id
FROM divertion;

SELECT role_id
FROM administrator
UNION
SELECT police_id
FROM legnth;

-- VIEWS
CREATE VIEW view_police AS
SELECT *
FROM police;

CREATE VIEW view_divertion AS
SELECT *
FROM divertion;

-- PROCEDURES
CREATE PROCEDURE get_police_by_name(IN name VARCHAR(100))
BEGIN
    SELECT *
    FROM police
    WHERE name = name;
END;

CREATE PROCEDURE get_police_by_id(IN id INTEGER)
BEGIN
    SELECT *
    FROM police
    WHERE id = id;
END;

CREATE PROCEDURE get_divertion_by_name(IN name VARCHAR(100))
BEGIN
    SELECT *
    FROM divertion
    WHERE name = name;
END;

-- TRIGGER
CREATE TRIGGER trigger_police_insert
AFTER INSERT ON police
FOR EACH ROW
BEGIN
    INSERT INTO administrator(name, email, username, password, role_id)
    VALUES(NEW.name, NULL, NEW.name, NEW.name, 1);
END #

CREATE TRIGGER trigger_police_update
AFTER UPDATE ON police
FOR EACH ROW
BEGIN
    UPDATE administrator
    SET name = NEW.name,
        email = NULL,
        username = NEW.name,
        password = NEW.name
    WHERE id = NEW.id;
END #

CREATE TRIGGER trigger_police_delete
AFTER DELETE ON police
FOR EACH ROW
BEGIN
    DELETE FROM administrator
    WHERE id = OLD.id;
END #
