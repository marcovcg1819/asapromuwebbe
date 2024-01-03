DROP DATABASE asapromuweb;
CREATE DATABASE asapromuweb;
CREATE USER asapromuuser WITH PASSWORD 'asauser456';
GRANT ALL PRIVILEGES ON DATABASE "asapromuweb" to asapromuuser;
GRANT CREATE ON SCHEMA public TO asapromuuser;
GRANT CREATE ON SCHEMA asapromu TO asapromuuser;
GRANT admin TO asapromuuser;


DROP DATABASE sales;
CREATE DATABASE sales;
CREATE USER salesroot WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE "sales" to salesroot;
GRANT CREATE ON SCHEMA public TO salesroot;
GRANT CREATE ON SCHEMA sales TO salesroot;
GRANT admin TO salesroot;

CREATE TABLE asapromu.donation  (
	id numeric NOT NULL,
	donationname varchar NOT NULL,
	description  varchar NOT NULL,
	goal float not null,
	collected float not null,
	active int not null,
	datend timestamp not null,
	id_zone numeric not null,
	id_currency numeric not null,
	CONSTRAINT donation_pk PRIMARY KEY (id)
);

ALTER TABLE public.manager ADD CONSTRAINT manager_fk FOREIGN KEY (id_currency) REFERENCES public.lottocurrecncy(id);
ALTER TABLE public.manager ADD CONSTRAINT manager_fk_1 FOREIGN KEY (id_zone) REFERENCES public.lottozone(id);

select * from manager

select * from asapromu.donation

create sequence asapromu.donation_id_seq;

CREATE TABLE asapromu.donationphoto  (
	id numeric NOT NULL,
	id_donation numeric NOT NULL,
	photo bytea NOT NULL,
	CONSTRAINT donationphoto_pk PRIMARY KEY (id),
	CONSTRAINT donationphoto_fk FOREIGN KEY (id_donation) REFERENCES asapromu.donation(id)
);

select * from asapromu.donationphoto

create sequence asapromu.donationphoto_id_seq;

CREATE TABLE asapromu.project  (
	id numeric NOT NULL,
	projectname varchar NOT NULL,
	description  varchar NOT NULL,
	active int not null,
	site varchar not null,
	datedo timestamp not null,
	datend timestamp not null,
	CONSTRAINT project_pk PRIMARY KEY (id)
);
select * from asapromu.project
create sequence asapromu.project_id_seq;


CREATE TABLE asapromu.proyectphoto  (
	id numeric NOT NULL,
	id_project numeric NOT NULL,
	photo bytea NOT NULL,
	CONSTRAINT proyectphoto_pk PRIMARY KEY (id),
	CONSTRAINT proyectphoto_fk FOREIGN KEY (id_project) REFERENCES asapromu.project(id)
);

select * from asapromu.proyectphoto
create sequence asapromu.projectphoto_id_seq;

CREATE TABLE asapromu.users  (
	id numeric NOT NULL,
	username varchar NOT NULL,
	passworduser varchar NOT NULL,
	tokenuser varchar not null,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

select * from asapromu.users 
insert into asapromu.users values(1, 'marcocastro', '$2a$10$r5rnT30izGr04iVkyajm3uPTrRK0SLYkdaL/oKSqHYHI9UJ8xiq56', '')

create sequence asapromu.users_id_seq;

CREATE TABLE asapromu.settings  (
	id numeric NOT NULL,
	namesetting varchar NOT NULL,
	value varchar NOT NULL,
	CONSTRAINT settings_pk PRIMARY KEY (id)
);

select * from asapromu.settings

create sequence asapromu.settings_id_seq;

select * from asapromu.settings
insert into asapromu.settings values (1, 'MAX_VIEW_PROJECTS', '15');

CREATE TABLE asapromu.payhistory  (
	id numeric NOT NULL,
	id_donation numeric NOT NULL,
	amount float NOT NULL,
	datepay timestamp not null,
	CONSTRAINT payhistory_pk PRIMARY KEY (id),
	CONSTRAINT payhistory_fk FOREIGN KEY (id_donation) REFERENCES asapromu.donation(id)
);

create sequence asapromu.payhistory_id_seq;
