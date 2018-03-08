
create table if not exists customer
(
	id bigserial not null
		constraint customer_pkey
			primary key,
	name varchar,
	address varchar,
	email varchar
)
;