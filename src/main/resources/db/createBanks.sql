CREATE TABLE bank(
	id_credit int NOT NULL,
	id_client int NOT NULL,
	FOREIGN KEY (id_client) REFERENCES clients(id), 
	FOREIGN KEY (id_credit) REFERENCES credits(id) 
)