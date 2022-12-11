package com.codingMonk.Soulmate.UserRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingMonk.Soulmate.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

	@Query("select  e  from User e  where e.name =?1")
	public  List<User>  getAllUserByName(String name);
	
	@Query("select  e  from User e  where e.name =?1")
	public  List<User>  getAllUserByGender(String gender);
	
	@Query("select  e  from User e  where e.name =?1")
	public  List<User>  getAllUserByAge(int age);
	
	@Query("select  e  from User e  where e.name =?1")
	public List<User> getAllUserByAgeAndGender(@Param("gender") String gender,@Param("age") int age);
}
