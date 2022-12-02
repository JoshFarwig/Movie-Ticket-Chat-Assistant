CREATE DATABASE IF NOT EXISTS mtbs;

USE mtbs; 

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS customer; 
DROP TABLE IF EXISTS movie;  
DROP TABLE IF EXISTS movieticket; 
DROP TABLE IF EXISTS seat;  
SET FOREIGN_KEY_CHECKS = 1; 

CREATE TABLE customer (  
    email varchar(30), 
    name varchar(40),  
    gender char(1),  
    phone char(10),
    bdate char(10),
    PRIMARY KEY(email)
); 

CREATE TABLE movie ( 
    name varchar(30), 
    genre varchar(20), 
    dateofmovie varchar(20), 
    timeofmovie varchar(20),    
    cost decimal(8,2),
    PRIMARY KEY(name)
);  

CREATE TABLE seat( 
    sid int, 
    srowcol char(2),
    mname varchar(30),  
    cemail varchar(30),   
    PRIMARY KEY(sid), 
    FOREIGN KEY(mname) references movie(name),  
    FOREIGN KEY(cemail) references customer(email)
); 

CREATE TABLE movieticket(  
    mtid int AUTO_INCREMENT,   
    cemail varchar(30),
    mname varchar(30),     
    seatID int,
    totalPrice decimal(8,2),
    PRIMARY KEY(mtid), 
    FOREIGN KEY(seatID) references seat(sid)
);  

INSERT INTO movie VALUES('Black Adam', 'Action', '11/15/2022', '3:30pm', 22.25); 
INSERT INTO movie VALUES('Smile', 'Horror', '11/17/2022', '5:00pm', 15.75); 
INSERT INTO movie VALUES('Thor: Love and Thunder','Action/Comedy', '11/19/2022', '9:15pm', 20.50);   

INSERT INTO customer VALUES('josh96753@gmail.com', 'Josh Farwig', 'M', '8088663480', '01/31/2002');

INSERT INTO seat VALUES(1, 'A1', 'Black Adam', null); 
INSERT INTO seat VALUES(2, 'A2', 'Black Adam', null);  
INSERT INTO seat VALUES(3, 'A3', 'Black Adam', null);  
INSERT INTO seat VALUES(4, 'A4', 'Black Adam', null); 
INSERT INTO seat VALUES(5, 'B1', 'Black Adam', null); 
INSERT INTO seat VALUES(6, 'B2', 'Black Adam', null);
INSERT INTO seat VALUES(7, 'B3', 'Black Adam', null);  
INSERT INTO seat VALUES(8, 'B4', 'Black Adam', null); 
INSERT INTO seat VALUES(9, 'C1', 'Black Adam', null); 
INSERT INTO seat VALUES(10, 'C2', 'Black Adam', null); 
INSERT INTO seat VALUES(11, 'C3', 'Black Adam', null); 
INSERT INTO seat VALUES(12, 'C4', 'Black Adam', null); 

INSERT INTO seat VALUES(13, 'A1', 'Smile', null); 
INSERT INTO seat VALUES(14, 'A2', 'Smile', null);  
INSERT INTO seat VALUES(15, 'A3', 'Smile', null);  
INSERT INTO seat VALUES(16, 'A4', 'Smile', null); 
INSERT INTO seat VALUES(17, 'B1', 'Smile', null); 
INSERT INTO seat VALUES(18, 'B2', 'Smile', null); 
INSERT INTO seat VALUES(19, 'B3', 'Smile', null);  
INSERT INTO seat VALUES(20, 'B4', 'Smile', null); 
INSERT INTO seat VALUES(21, 'C1', 'Smile', null); 
INSERT INTO seat VALUES(22, 'C2', 'Smile', null); 
INSERT INTO seat VALUES(23, 'C3', 'Smile', null); 
INSERT INTO seat VALUES(24, 'C4', 'Smile', null);  

INSERT INTO seat VALUES(25, 'A1', 'Thor: Love and Thunder', null); 
INSERT INTO seat VALUES(26, 'A2', 'Thor: Love and Thunder', null);  
INSERT INTO seat VALUES(27, 'A3', 'Thor: Love and Thunder', null);  
INSERT INTO seat VALUES(28, 'A4', 'Thor: Love and Thunder', null); 
INSERT INTO seat VALUES(29, 'B1', 'Thor: Love and Thunder', null); 
INSERT INTO seat VALUES(30, 'B2', 'Thor: Love and Thunder', null); 
INSERT INTO seat VALUES(31, 'B3', 'Thor: Love and Thunder', null);  
INSERT INTO seat VALUES(32, 'B4', 'Thor: Love and Thunder', null); 
INSERT INTO seat VALUES(33, 'C1', 'Thor: Love and Thunder', null); 
INSERT INTO seat VALUES(34, 'C2', 'Thor: Love and Thunder', null); 
INSERT INTO seat VALUES(35, 'C3', 'Thor: Love and Thunder', null); 
INSERT INTO seat VALUES(36, 'C4', 'Thor: Love and Thunder', null); 
