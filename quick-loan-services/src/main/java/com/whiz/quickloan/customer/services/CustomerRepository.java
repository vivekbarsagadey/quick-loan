package com.whiz.quickloan.customer.services;

import org.springframework.data.repository.CrudRepository;

import com.whiz.quickloan.customer.domain.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, Integer>{

}
