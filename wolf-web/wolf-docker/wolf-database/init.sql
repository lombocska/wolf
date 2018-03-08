
create table if not exists customer
(
	id bigserial not null
		constraint customer_pkey
		primary key,
	name varchar,
	address varchar,
	email varchar,
	constraint customer_uk_name_address_email
	unique (name, address, email)
);
