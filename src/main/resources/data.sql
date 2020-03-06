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

insert into userdetails (id,userid, brokerid, username) values(1,'gopi','sampat','Gopi');
insert into userdetails (id,userid, brokerid, username) values(2,'soni','sampat','Soni');

DROP TABLE IF EXISTS lendingdetails;

CREATE TABLE lendingdetails (
	recordid INT AUTO_INCREMENT  PRIMARY KEY,  
	lender_id VARCHAR(250) NOT NULL,
	borrower_id VARCHAR(250) NOT NULL,
	broker_id VARCHAR(250) NOT NULL,
  	rate float not null,
  	amount INT not null,
  	start_date DATE not null,
  	end_date date not null,
  	booking_date date not null,
  	duration int not null,
  	final_amount float not null,
  	FOREIGN KEY (broker_id) REFERENCES brokerdetails(brokerid),
  	FOREIGN KEY (lender_id) REFERENCES userdetails(userid),
  	FOREIGN KEY (borrower_id) REFERENCES userdetails(userid),
  	
);

DROP TABLE IF EXISTS credentialdetails;

CREATE TABLE credentialdetails (
	credentialid INT AUTO_INCREMENT  PRIMARY KEY,  
  	username VARCHAR(250) NOT NULL,
  	password VARCHAR(250) NOT NULL,
  	role VARCHAR(250) NOT NULL
);