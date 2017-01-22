drop table if exists cab_data;
drop table if exists customer_data;
drop table if exists trips_data;
drop table if exists bills_data;

create table cab_data(
	cab_id int auto_increment,
	cab_driver_name varchar(255),
	cab_regn_number varchar(55),
	availability_status boolean
);

insert into cab_data(cab_driver_name,cab_regn_number,availability_status) values ('Sathish','KA01AB1234',true);
insert into cab_data(cab_driver_name,cab_regn_number,availability_status) values ('Kumar','KA02AB1234',true);
insert into cab_data(cab_driver_name,cab_regn_number,availability_status) values ('Pavan','KA03AB1234',true);

create table customer_data(
	customer_id int auto_increment,
	customer_name  varchar(500),
	customer_mobilenumber bigint
);

insert into customer_data(customer_name,customer_mobilenumber) values('Raj',9123456789);
insert into customer_data(customer_name,customer_mobilenumber) values('Venky',8123456789);
insert into customer_data(customer_name,customer_mobilenumber) values('Suraj',7123456789);

create table trips_data(
	trip_id int auto_increment,
	customer_id  int,
	cab_id int,
	trip_kms long,
	total_fare int,
	trip_date timestamp,
	trip_status varchar(55)
);

create table bills_data(
	bills_data_id int auto_increment,
	customer_id  int,
	total_kms int,
	total_fare int,
	bill_genrated_date date
);