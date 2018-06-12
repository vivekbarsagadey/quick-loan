package com.whiz.quickloan.application.services;

import org.springframework.data.repository.CrudRepository;

import com.whiz.quickloan.applications.domain.Applications;

public interface ApplicationsRepository  extends CrudRepository<Applications, Integer>{

}
