CREATE TABLE clients(
	id UUID PRIMARY KEY,
	surname varchar(30) NOT NULL,
	name varchar(15) NOT NULL,	
	middle_name varchar(20) NOT NULL,
	phone varchar(11) NOT NULL,
	email varchar(30) NOT NULL,
	passport_number varchar(6) NOT NULL
)