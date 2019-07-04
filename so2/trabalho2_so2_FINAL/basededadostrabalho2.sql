CREATE TABLE userA(
	userID SERIAL,
	username varchar(255),
	password varchar(255),
	PRIMARY KEY(userID)
);

CREATE TABLE allergy(
	allergyID SERIAL,
	allergyType varchar(255),
	PRIMARY KEY(allergyID)
);

INSERT into allergy values(DEFAULT, 'Platano');
INSERT into allergy values(DEFAULT, 'Gramineas');
INSERT into allergy values(DEFAULT, 'Oliveira');
INSERT into allergy values(DEFAULT, 'Azinheiro');

CREATE TABLE entries(
	entryID SERIAL,
	latitude real,
	longitude real,
    entrydate timestamp,
    allergyID int,
    userID int,
    uniqueCode varchar(255),
	PRIMARY KEY(entryID),
	FOREIGN KEY(allergyID) REFERENCES allergy(allergyID) ON DELETE CASCADE,
    FOREIGN KEY(userID) REFERENCES userA(userID) ON DELETE CASCADE
);

CREATE TABLE user_allergy(
    userID int,
    allergyID int,
    FOREIGN KEY(userID) REFERENCES userA(userID) ON DELETE CASCADE,
	FOREIGN KEY(allergyID) REFERENCES allergy(allergyID) ON DELETE CASCADE
);
