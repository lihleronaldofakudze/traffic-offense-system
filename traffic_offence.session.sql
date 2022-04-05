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
    description TEXT NULL
);

-- @BLOCK
CREATE TABLE length (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name TEXT NOT NULL,
    type TEXT NULL,
    description TEXT NULL,
    time VARCHAR(100)
);

-- @BLOCK
CREATE TABLE routes (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    length VARCHAR(100) NOT NULL,
    name TEXT NOT NULL,
    type TEXT NULL,
    description TEXT NULL
);

-- @BLOCK
CREATE TABLE police (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
     name TEXT NOT NULL,
    type TEXT NULL,
    description TEXT NULL,
    password VARCHAR(100) UNIQUE
);