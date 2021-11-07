CREATE TABLE payment_schedule(
	id UUID PRIMARY KEY,
	date_payment date NOT NULL,
	payment_amount numeric(19,4) NOT NULL,	
	amount_body numeric(19,4) NOT NULL,
	amount_interest numeric(19,4) NOT NULL
)