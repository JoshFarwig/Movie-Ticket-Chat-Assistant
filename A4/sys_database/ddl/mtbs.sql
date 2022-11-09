CREATE DATABASE mtbs IF NOT EXISTS;  

USE mtbs; 

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE customer IF EXISTS; 
DROP TABLE movie IF EXISTS; 
DROP TABLE movieticket IF EXISTS; 
DROP TABLE addon IF EXISTS; 
DROP TABLE seat IF EXISTS; 
SET FOREIGN_KEY_CHECKS = 1; 


CREATE TABLE customer ( 
    cid int AUTO_INCREMENT, 
    cfirstname varchar(20),  
    clastname varchar(20),
    gender char(1), 
    email varchar(30) UNIQUE, 
    bdate date, 
    PRIMARY KEY(cid)
) ENGINE = InnoDB 

CREATE TABLE movie ( 
    mid int, 
    mname varchar(30), 
    genre varchar(20),  
    releasedate date,   
    duration time,  
    PRIMARY KEY(mid)
)  ENGINE = InnoDB

CREATE TABLE movieticket(  
    mtid int AUTO_INCREMENT,   
    cid int,
    mid int,  
    sid int,  
    aid int, 
    cost DECIMAL(9,2),  
    PRIMARY KEY(mtid), 
    FOREIGN KEY(cid) references customer(cid), 
    FOREIGN KEY(mid) references movie(mid),
    FOREIGN KEY(sid) references seat(sid), 
    FOREIGN KEY(aid,cid) references inCart(aid,cid)
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
    cid int, 
    quantity int, 
    totalPrice decimal(9,2), 
    PRIMARY KEY(aid, cid), 
    FOREIGN KEY(aid) references addon(aid), 
    FOREIGN KEY(cid) references customer(cid)
) ENGINE = InnoDB

CREATE TABLE seat( 
    sid int, 
    srowcol char(2),
    mid int,      
    PRIMARY KEY(sid, mid), 
    FOREIGN KEY(mid) references movie(mid)  
) ENGINE = InnoDB  

CREATE TABLE seatreserved(  
    sid int, 
    cid int, 
    PRIMARY KEY(sid, cid), 
    FOREIGN KEY(cid) references customer(cid),   
    FOREIGN KEY(sid) references seat(sid) 
)

INSERT INTO movie VALUES(1, 'Black Adam', 'Action', '2022-10-3', '01:30:00'); 
INSERT INTO movie VALUES(2, 'Smile', 'Horror', '2022-11-10', '2:30:00'); 
INSERT INTO movie VALUES(3, 'Thor: Love and Thunder','Action/Comedy', '2022-6-22', '02:15:00');  

INSERT INTO customer(cfirstname, clastname, gender, email, bdate) VALUES('Zee', 'Gianay','M', 'zee@gmail.com', '2002-10-30');
INSERT INTO customer(cfirstname, clastname, gender, email, bdate) VALUES('Josh', 'Farwig','M','josh96753@gmail.com', '2002-01-31');

INSERT INTO seat VALUES(1, 'A1', 1); 
INSERT INTO seat VALUES(2, 'A2', 1);  
INSERT INTO seat VALUES(3, 'A3', 1);  
INSERT INTO seat VALUES(4, 'A4', 1); 
INSERT INTO seat VALUES(5, 'B1', 1); 
INSERT INTO seat VALUES(6, 'B2', 1);
INSERT INTO seat VALUES(7, 'B3', 1);  
INSERT INTO seat VALUES(8, 'B4', 1); 
INSERT INTO seat VALUES(9, 'C1', 1); 
INSERT INTO seat VALUES(10, 'C2', 1); 
INSERT INTO seat VALUES(11, 'C3', 1); 
INSERT INTO seat VALUES(12, 'C4', 1); 

INSERT INTO seat VALUES(13, 'A1', 2); 
INSERT INTO seat VALUES(14, 'A2', 2);  
INSERT INTO seat VALUES(15, 'A3', 2);  
INSERT INTO seat VALUES(16, 'A4', 2); 
INSERT INTO seat VALUES(17, 'B1', 2); 
INSERT INTO seat VALUES(18, 'B2', 2); 
INSERT INTO seat VALUES(19, 'B3', 2);  
INSERT INTO seat VALUES(20, 'B4', 2); 
INSERT INTO seat VALUES(21, 'C1', 2); 
INSERT INTO seat VALUES(22, 'C2', 2); 
INSERT INTO seat VALUES(23, 'C3', 2); 
INSERT INTO seat VALUES(24, 'C4', 2);  

INSERT INTO seat VALUES(25, 'A1', 3); 
INSERT INTO seat VALUES(26, 'A2', 3);  
INSERT INTO seat VALUES(27, 'A3', 3);  
INSERT INTO seat VALUES(28, 'A4', 3); 
INSERT INTO seat VALUES(29, 'B1', 3); 
INSERT INTO seat VALUES(30, 'B2', 3); 
INSERT INTO seat VALUES(31, 'B3', 3);  
INSERT INTO seat VALUES(32, 'B4', 3); 
INSERT INTO seat VALUES(33, 'C1', 3); 
INSERT INTO seat VALUES(34, 'C2', 3); 
INSERT INTO seat VALUES(35, 'C3', 3); 
INSERT INTO seat VALUES(36, 'C4', 3);