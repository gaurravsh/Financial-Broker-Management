DROP TABLE IF EXISTS brokerdetails;

CREATE TABLE brokerdetails (
  brokerid INT AUTO_INCREMENT  PRIMARY KEY,
  brokername VARCHAR(250) NOT NULL
);

insert into brokerdetails ( brokerid, brokername)
values(1,'Broker1');

DROP TABLE IF EXISTS userdetails;

CREATE TABLE userdetails (
	userid INT AUTO_INCREMENT  PRIMARY KEY,  
	brokerid INT NOT NULL,
  	username VARCHAR(250) NOT NULL,
  	FOREIGN KEY (brokerid) REFERENCES brokerdetails(brokerid)
);

insert into userdetails (userid, brokerid, username)
values(1,1,'User1');