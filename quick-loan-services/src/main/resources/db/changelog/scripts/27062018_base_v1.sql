--liquibase formatted sql
--changeset fabio.barbosa:001.1
create table address_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, active_status boolean, address varchar(255), city varchar(255), country varchar(255), months_in_currentaddress integer not null, state varchar(255), stay_type varchar(255), yrs_in_currentaddress integer not null, zip_code varchar(255), customer_id integer not null, primary key (id));

create table applications (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, application_date date, customer_id integer not null, remarks varchar(255), primary key (id));

create table bank_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, aba_or_routing_number integer not null, account_number integer not null, account_type integer not null, active_status boolean, bank_name varchar(255), bank_phone varchar(255), duration_of_bank_account integer not null, is_direct_deposit boolean, monthly_income integer not null, customer_id integer not null, primary key (id));

create table contact_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, active_status boolean, cell_phone1 varchar(255), cell_phone2 varchar(255), cell_phone3 varchar(255), email_id varchar(255), home_phone1 varchar(255), home_phone2 varchar(255), home_phone3 varchar(255), work_phone varchar(255), customer_id integer not null, primary key (id));

create table customer (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, dob date, best_time_to_call varchar(255), first_name varchar(255), is_military_dependant boolean, is_us_citizen boolean, last_name varchar(255), license_number varchar(255), primary key (id));

create table employment_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, active_status boolean, current_employed_duration integer not null, employer_name varchar(255), employer_phone varchar(255), income_type varchar(255), job_title varchar(255), customer_id integer not null, primary key (id));

create table investor (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, company_name varchar(255), loan_range varchar(255), primary key (id));

create table investor_address_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, active_status boolean, company_address varchar(255), company_city varchar(255), company_country varchar(255), company_state varchar(255), company_zip_code varchar(255), investor_id integer not null, primary key (id));

create table investor_bank_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, aba_or_routing_number integer not null, account_number bigint, account_type integer not null, active_status boolean, bank_name varchar(255), bank_phone varchar(255), duration_of_bank_account integer not null, investor_id integer not null, primary key (id));

create table investor_contact_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, cell_phone1 varchar(255), cell_phone2 varchar(255), work_phone1 varchar(255), work_phone2 varchar(255), active_status boolean, company_email_id varchar(255), company_website varchar(255), investor_id integer not null, primary key (id));

create table investor_payment_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, active_status boolean, rate_of_interest integer not null, investor_id integer not null, primary key (id));

create table loan_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, deadline_date date, loan_amount integer not null, loan_purpose varchar(255), customer_id integer not null, primary key (id));

create table payment_details (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, active_status boolean, nextpay_day date, payment_frequency integer not null, secondtpay_day date, customer_id integer not null, primary key (id));

create table user (id integer not null, created_by varchar(20), created_date timestamp, updated_by varchar(20), updated_date timestamp, emaid_id varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), primary key (id));

alter table address_details add constraint fk6sbypr6i8h4s7pgjfgewof96b foreign key (customer_id) references customer;

alter table bank_details add constraint fklxahb6q7hvt3ymfvjpvdnlq02 foreign key (customer_id) references customer;

alter table contact_details add constraint fkoquianu78jwseltspxwjfrdnq foreign key (customer_id) references customer;

alter table employment_details add constraint fkqahaciti1f54om6fhobsh6v97 foreign key (customer_id) references customer;

alter table investor_address_details add constraint fkbjtno91hkdrhufkqqg9109b8y foreign key (investor_id) references investor;

alter table investor_contact_details add constraint fk2706kn4m8ifq21oabtym435g9 foreign key (investor_id) references investor;

alter table investor_payment_details add constraint fkjj7y9h973nqr7pkiv55axnk5o foreign key (investor_id) references investor;

alter table loan_details add constraint fkstim55vaton2j1s2kf8o0dy4y foreign key (customer_id) references customer;

alter table payment_details add constraint fkixvxf0b21jorw2axfhbrqyiwy foreign key (customer_id) references customer;

 
 

 
 
 
 
 













