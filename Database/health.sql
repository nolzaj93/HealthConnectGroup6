
CREATE TABLE `Doctor` (
                        `username` varchar(255) NOT NULL,
                        `password` varchar(255) NOT NULL
);



INSERT INTO `Doctor` (`username`,`password`) VALUES ('doctor','123');



CREATE TABLE `Patient` (
                         `username` varchar(255) NOT NULL,
                         `password` varchar(255) NOT NULL

);


INSERT INTO `Patient` (`username`,`password`) VALUES ('patient','123');

CREATE TABLE `Request` (
                         `RID` varchar(255) NOT NULL,
                         `PUsername` varchar(255) NOT NULL,
                         `Date` varchar(255) NOT NULL,
                         `Status` varchar(255) NOT NULL
);

INSERT INTO `Request` (`RID`,`PUsername`,`Date`,`Status`) VALUES ('100','patient','2021/10/10','New');
INSERT INTO `Request` (`RID`,`PUsername`,`Date`,`Status`) VALUES ('101','patient','2021/10/10','In Progress');
INSERT INTO `Request` (`RID`,`PUsername`,`Date`,`Status`) VALUES ('102','patient','2021/10/10','Closed');
INSERT INTO `Request` (`RID`,`PUsername`,`Date`,`Status`) VALUES ('103','patient','2021/10/10','New');
INSERT INTO `Request` (`RID`,`PUsername`,`Date`,`Status`) VALUES ('104','patient','2021/10/10','Closed');
INSERT INTO `Request` (`RID`,`PUsername`,`Date`,`Status`) VALUES ('105','patient','2021/10/10','In Progress');

CREATE TABLE `Message` (
                         `RID` varchar(255) NOT NULL,
                         `DUsername` varchar(255) NOT NULL,
                         `TimeStamp` varchar(255) NOT NULL,
                         `Message` varchar(255) NOT NULL
);
INSERT INTO `Message` (`RID`,`DUsername`,`TimeStamp`,`Message`) VALUES ('100','doctor','2021/10/10','Hey');
INSERT INTO `Message` (`RID`,`DUsername`,`TimeStamp`,`Message`) VALUES ('101','doctor','2021/10/10','Hey');
INSERT INTO `Message` (`RID`,`DUsername`,`TimeStamp`,`Message`) VALUES ('102','doctor','2021/10/10','Hey');
INSERT INTO `Message` (`RID`,`DUsername`,`TimeStamp`,`Message`) VALUES ('103','doctor','2021/10/10','Hey');
INSERT INTO `Message` (`RID`,`DUsername`,`TimeStamp`,`Message`) VALUES ('104','doctor','2021/10/10','Hey');
INSERT INTO `Message` (`RID`,`DUsername`,`TimeStamp`,`Message`) VALUES ('105','doctor','2021/10/10','Hey');
