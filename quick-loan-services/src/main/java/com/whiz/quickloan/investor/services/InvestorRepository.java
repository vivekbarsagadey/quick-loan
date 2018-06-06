package com.whiz.quickloan.investor.services;

import org.springframework.data.repository.CrudRepository;

import com.whiz.quickloan.investor.domain.Investor;

public interface InvestorRepository  extends CrudRepository<Investor, Integer>{

}
