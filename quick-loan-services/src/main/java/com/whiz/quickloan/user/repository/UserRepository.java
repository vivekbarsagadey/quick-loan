package com.whiz.quickloan.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.whiz.quickloan.user.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmailId(String emailId);
	public User findById(int id);
	public User save(User user);
	public void deleteUserById(int id);
	public Iterable<User> findAll();
	public boolean existsById(int id);
}
