CREATE DATABASE IF NOT EXISTS mtbs;

USE mtbs; 

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS customer; 
DROP TABLE IF EXISTS movie; 
DROP TABLE IF EXISTS movieticket; 
DROP TABLE IF EXISTS seat;  
DROP TABLE IF EXISTS addon; 
DROP TABLE IF EXISTS inCart;
SET FOREIGN_KEY_CHECKS = 1; 


CREATE TABLE customer (  
    email varchar(30), 
    cfirstname varchar(20),  
    clastname varchar(20),
    gender char(1),  
    bdate date,
    PRIMARY KEY(email)
) ENGINE = InnoDB 

CREATE TABLE movie ( 
    name varchar(30), 
    genre varchar(20),  
    releasedate date,   
    duration time,   
    cost decimal(8,2),
    PRIMARY KEY(mname)
)  ENGINE = InnoDB

CREATE TABLE movieticket(  
    mtid int AUTO_INCREMENT,   
    cemail int,
    mname varchar(30),    
    totalPrice decimal(8,2),
    PRIMARY KEY(mtid), 
    FOREIGN KEY(cemail) references customer(cemail), 
    FOREIGN KEY(mname) references movie(mname),
) ENGINE = InnoDB

CREATE TABLE addon(  
    aid int,  
    aname varchar(20), 
    price decimal(8,2), 
    category varchar(20), 
    PRIMARY KEY(aid) 
) ENGINE = InnoDB

CREATE TABLE inCart( 
    aid int, 
    cemail varchar(30), 
    quantity int, 
    totalPrice decimal(9,2),  
    ticketid int, 
    PRIMARY KEY(aid, cemail), 
    FOREIGN KEY(aid) references addon(aid), 
    FOREIGN KEY(cemail) references customer(email), 
    FOREIGN KEY(ticketid) references movieticket(mtid)
) ENGINE = InnoDB 

CREATE TABLE seat( 
    sid int, 
    srowcol char(2),
    mname varchar(30),  
    cemail varchar(30),   
    PRIMARY KEY(sid), 
    FOREIGN KEY(mname) references movie(mname),  
    FOREIGN KEY(cemail) references customer(email),
) ENGINE = InnoDB  


INSERT INTO movie VALUES('Black Adam', 'Action', '2022-10-3', '01:30:00', 22.25); 
INSERT INTO movie VALUES('Smile', 'Horror', '2022-11-10', '2:30:00', 15.75); 
INSERT INTO movie VALUES('Thor: Love and Thunder','Action/Comedy', '2022-6-22', '02:15:00', 20.50);  

INSERT INTO customer(cfirstname, clastname, gender, email, bdate) VALUES('Zee', 'Gianay','M', 'zee@gmail.com', '2002-10-30');
INSERT INTO customer(cfirstname, clastname, gender, email, bdate) VALUES('Josh', 'Farwig','M','josh96753@gmail.com', '2002-01-31');

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
