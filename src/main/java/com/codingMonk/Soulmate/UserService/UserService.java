package com.codingMonk.Soulmate.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingMonk.Soulmate.UserRepository.UserRepository;
import com.codingMonk.Soulmate.model.User;


@Service
public class UserService {
		
	
	UserRepository repo;
	
	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}

public User addUser(User p) {
		
		return repo.save(p);
	}
public User updateUser(User p) {
	
	return repo.save(p);
}
public void deleteById(int id) {
	
	repo.deleteById(id);
}

public Iterable<User> getAll() {
	// TODO Auto-generated method stub
	return repo.findAll(); 
}

public List<User> getAllUserByName(String name) {
	return repo.getAllUserByName(name);
}
public List<User> getAllUserByGender(String gender) {
	// TODO Auto-generated method stub
	return repo.getAllUserByGender(gender);
}

public List<User> getAllUserByAge(int age) {
	// TODO Auto-generated method stub
	return repo.getAllUserByAge(age) ;
}

public List<User> getAllUserByAgeAndGender(String gender,int age){
	return repo.getAllUserByAgeAndGender(gender, age);
}

	
}
