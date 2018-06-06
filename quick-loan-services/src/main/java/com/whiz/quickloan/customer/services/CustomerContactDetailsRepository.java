package com.whiz.quickloan.customer.services;

import org.springframework.data.repository.CrudRepository;

import com.whiz.quickloan.customer.domain.ContactDetails;

public interface CustomerContactDetailsRepository  extends CrudRepository<ContactDetails, Integer>{

}
