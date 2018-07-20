insert into user (id, email_id, password) values (1, 'whizit', 'whizit');

insert into user_role (id, name) values (1, 'USER');

insert into user (id, email_id, password) values (2, 'gsit', 'gsit');

insert into user_role (id, name) values (2, 'CUSTOMER');


INSERT INTO `quick_loan`.`investor`
(`id`,
`company_name`,
 `total_loan_lent`)
 VALUES 
(1, 
'whizit',
 1000);
	INSERT INTO `quick_loan`.`investor_address_details`
(`id`, 
`company_address`, 
`company_city`,
 `company_country`, 
`company_state`,
 `company_zip_code`, 
`investor_id`)
 VALUES 
(1, 
'Dhayari',
 'Pune',
'India', 'active',
 411041,
 1);


	INSERT INTO `quick_loan`.`investor_bank_details`
(`id`,
 
`aba_or_routing_number`,
 `account_number`,
 `account_type`, 
`bank_name`,
 `bank_phone`, 
`duration_of_bank_account`, 
`investor_id`) 
VALUES
 ( 1, 5,
 12345,
 1,
 'SBH',
 12345,
 10,
 1);
	INSERT INTO `quick_loan`.`investor_contact_details`
(`id`, `cell_phone1`, 
`cell_phone2`,
 `work_phone1`,
 `work_phone2` ,
 `company_email_id`,
 `company_website`, 
`investor_id`)
 VALUES
 ( 1,
 123,
 789,
 456,
 123,
 'vivek@whizit.co.in',
 'whizit.co.in',
 1);

	INSERT INTO `quick_loan`.`investor_payment_details`
(`id`, 
`rate_of_interest`, 
`investor_id`)
 VALUES 
( 1,
 10, 1);
