DROP TABLE IF EXISTS brokerdetails;

CREATE TABLE brokerdetails (
  id INT AUTO_INCREMENT PRIMARY KEY,
  brokerId VARCHAR(250) UNIQUE NOT NULL,
  brokerName VARCHAR(250) NOT NULL
);

insert into brokerdetails (id,brokerid, brokername) values(1,'sampat','Sampat Sharma');

DROP TABLE IF EXISTS userdetails;

CREATE TABLE userdetails (
	id INT AUTO_INCREMENT PRIMARY KEY,  
	brokerid VARCHAR(250) NOT NULL,
	userid VARCHAR(250) UNIQUE NOT NULL, 
  	username VARCHAR(250) NOT NULL,
  	FOREIGN KEY (brokerid) REFERENCES brokerdetails(brokerid)
);

--insert into userdetails (userid, brokerid, username) values(1,1,'User1');

DROP TABLE IF EXISTS lendingdetails;

CREATE TABLE lendingdetails (
	recordid INT AUTO_INCREMENT  PRIMARY KEY,  
	lender_id INT NOT NULL,
	borrower_id INT NOT NULL,
	broker_id INT NOT NULL,
  	rate INT not null,
  	amount INT not null,
  	FOREIGN KEY (broker_id) REFERENCES brokerdetails(brokerid)
);

DROP TABLE IF EXISTS credentialdetails;

CREATE TABLE credentialdetails (
	credentialid INT AUTO_INCREMENT  PRIMARY KEY,  
  	username VARCHAR(250) NOT NULL,
  	password VARCHAR(250) NOT NULL,
  	role VARCHAR(250) NOT NULL
);