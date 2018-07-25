package com.whiz.quickloan.application.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.whiz.quickloan.applications.domain.Application;

public interface ApplicationsRepository  extends CrudRepository<Application, Integer>{

	List<Application> findByInvestorId(Integer invertorId);
}
