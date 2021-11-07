CREATE TABLE credit_offer(
	id UUID PRIMARY KEY,
	id_client UUID NOT NULL,
	id_credit UUID NOT NULL,
	credit_amount numeric(19,4) NOT NULL,
	payment_schedule UUID NOT NULL,
	FOREIGN KEY (id_client) REFERENCES clients(id),
	FOREIGN KEY (id_credit) REFERENCES credits(id),
	FOREIGN KEY (payment_schedule) REFERENCES payment_schedule(id)
)