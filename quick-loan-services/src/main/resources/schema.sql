
CREATE TABLE `address_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `months_in_currentaddress` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `stay_type` varchar(255) DEFAULT NULL,
  `yrs_in_currentaddress` int(11) NOT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6sbypr6i8h4s7pgjfgewof96b` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `application_date` date DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `investor_id` int(11) NOT NULL,
  `loan_amount` double DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `bank_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `aba_or_routing_number` int(11) NOT NULL,
  `account_number` bigint(20) NOT NULL,
  `account_type` int(11) NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_phone` varchar(255) DEFAULT NULL,
  `duration_of_bank_account` int(11) NOT NULL,
  `monthly_income` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlxahb6q7hvt3ymfvjpvdnlq02` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `contact_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `cell_phone1` varchar(255) DEFAULT NULL,
  `cell_phone2` varchar(255) DEFAULT NULL,
  `cell_phone3` varchar(255) DEFAULT NULL,
  `confirm_email` varchar(255) DEFAULT NULL,
  `confirm_password` varchar(255) DEFAULT NULL,
  `date_of_move` date DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `home_phone1` varchar(255) DEFAULT NULL,
  `home_phone2` varchar(255) DEFAULT NULL,
  `home_phone3` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `residential_status` varchar(255) DEFAULT NULL,
  `work_phone` varchar(255) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoquianu78jwseltspxwjfrdnq` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `employment_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `current_employed_duration` int(11) NOT NULL,
  `employer_name` varchar(255) DEFAULT NULL,
  `employer_phone` varchar(255) DEFAULT NULL,
  `income_type` varchar(255) DEFAULT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqahaciti1f54om6fhobsh6v97` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `investor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `loan_range` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_loan_lent` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `investor_address_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `active_status` bit(1) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `company_city` varchar(255) DEFAULT NULL,
  `company_country` varchar(255) DEFAULT NULL,
  `company_state` varchar(255) DEFAULT NULL,
  `company_zip_code` varchar(255) DEFAULT NULL,
  `investor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbjtno91hkdrhufkqqg9109b8y` (`investor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `investor_bank_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `aba_or_routing_number` int(11) NOT NULL,
  `account_number` bigint(20) DEFAULT NULL,
  `account_type` int(11) NOT NULL,
  `active_status` bit(1) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_phone` varchar(255) DEFAULT NULL,
  `duration_of_bank_account` int(11) NOT NULL,
  `investor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1d306g45b0delfdjluw5814wf` (`investor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `investor_contact_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `cell_phone1` varchar(255) DEFAULT NULL,
  `cell_phone2` varchar(255) DEFAULT NULL,
  `work_phone1` varchar(255) DEFAULT NULL,
  `work_phone2` varchar(255) DEFAULT NULL,
  `active_status` bit(1) DEFAULT NULL,
  `company_email_id` varchar(255) DEFAULT NULL,
  `company_website` varchar(255) DEFAULT NULL,
  `investor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2706kn4m8ifq21oabtym435g9` (`investor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `investor_payment_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `active_status` bit(1) DEFAULT NULL,
  `rate_of_interest` int(11) NOT NULL,
  `investor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjj7y9h973nqr7pkiv55axnk5o` (`investor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `loan_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `deadline_date` date DEFAULT NULL,
  `loan_amount` int(11) NOT NULL,
  `loan_purpose` varchar(255) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKstim55vaton2j1s2kf8o0dy4y` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `payment_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `bank_account` varchar(255) DEFAULT NULL,
  `income_source` varchar(255) DEFAULT NULL,
  `monthly_expenses` int(11) NOT NULL,
  `monthly_income` int(11) NOT NULL,
  `nextpay_day` date DEFAULT NULL,
  `payment_frequency` int(11) NOT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `second_pay_day` date DEFAULT NULL,
  `sort_code` varchar(255) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKixvxf0b21jorw2axfhbrqyiwy` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `user_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(20) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `best_time_to_call` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `lic_expiration_date` date DEFAULT NULL,
  `lic_issue_date` date DEFAULT NULL,
  `lic_state` varchar(255) DEFAULT NULL,
  `license_number` varchar(255) DEFAULT NULL,
  `marital_status` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpi9iyrapxo40phmd8vj7kcx07` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `roles_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_amwlmdeik2qdnksxgd566knop` (`roles_id`),
  KEY `FK55itppkw3i07do3h7qoclqd4k` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


ALTER TABLE ADDRESS_DETAILS add constraint FK6sbypr6i8h4s7pgjfgewof96b foreign key (customer_id) references customer;

ALTER TABLE BANK_DETAILS add constraint fklxahb6q7hvt3ymfvjpvdnlq02 foreign key (customer_id) references customer;

ALTER TABLE CONTACT_DETAILS add constraint fkoquianu78jwseltspxwjfrdnq foreign key (customer_id) references customer;

ALTER TABLE EMPLOYMENT_DETAILS add constraint fkqahaciti1f54om6fhobsh6v97 foreign key (customer_id) references customer;

ALTER TABLE INVESTOR_ADDRESS_DETAILS add constraint fkbjtno91hkdrhufkqqg9109b8y foreign key (investor_id) references investor;

ALTER TABLE INVESTOR_CONTACT_DETAILS add constraint fk2706kn4m8ifq21oabtym435g9 foreign key (investor_id) references investor;

ALTER TABLE INVESTOR_PAYMENT_DETAILS add constraint fkjj7y9h973nqr7pkiv55axnk5o foreign key (investor_id) references investor;

ALTER TABLE LOAN_DETAILS add constraint fkstim55vaton2j1s2kf8o0dy4y foreign key (customer_id) references customer;

ALTER TABLE PAYMENT_DETAILS add constraint fkixvxf0b21jorw2axfhbrqyiwy foreign key (customer_id) references customer;
 












