package com.whiz.quickloan.application.services;

import org.springframework.data.repository.CrudRepository;

import com.whiz.quickloan.applications.domain.Application;

public interface ApplicationsRepository  extends CrudRepository<Application, Integer>{

}
