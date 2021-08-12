set schema '';

CREATE TABLE products (
	id int4 NULL,
	product_number numeric NULL,
	product_name varchar NULL,
	"cost" numeric NULL,
	category varchar NULL,
	lastupdate timestamp NULL
);

create sequence products_seq start with 1 owned by products.id;

alter table products alter column id set default (nextval('products_seq'::regclass));
