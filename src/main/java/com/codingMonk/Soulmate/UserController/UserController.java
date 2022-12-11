package com.codingMonk.Soulmate.UserController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codingMonk.Soulmate.UserService.UserService;
import com.codingMonk.Soulmate.model.User;

@RestController
@RequestMapping("api/v1")
public class UserController {

	
	
	UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.POST)
	public User addUser(@RequestBody User p) {
		return service.addUser(p);
	}
	@RequestMapping(value="/profile",method=RequestMethod.PUT)
	public User updateUser(@RequestBody User p) {
		return service.updateUser(p);
	}
	@RequestMapping(value="/profile/{id}",method=RequestMethod.DELETE)
	public String  deleteById(@PathVariable int id) {
		
		
		 service.deleteById(id);
		
		return "Employee Deleted Successfully";
		 
		// return  new ResponseEntity<String>("Record Deleted",HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public List<User> getAll() {
		
			List<User>  list = new ArrayList<User>();
		
	      Iterable<User> it =	service.getAll();
	      
	      it.forEach((usr)->{ list.add(usr);  });
	      
	      return list;
		
	}

	@RequestMapping(value="/profile/name/{name}",method=RequestMethod.GET)
	public List<User>  getAllUserByName(@PathVariable String name) {
		
		return	service.getAllUserByName(name);
		
	}
	@RequestMapping(value="/profile/gender/{gender}",method=RequestMethod.GET)
	public List<User>  getAllUserByGender(@PathVariable String gender) {
		
		return	service.getAllUserByGender(gender);
		
	}
	@RequestMapping(value="/profile/age/{age}",method=RequestMethod.GET)
	public List<User>  getUserByAge(@PathVariable int age) {
		
		return	service.getAllUserByAge(age);
		
	}
	@RequestMapping(value="/profile/gender/age/{gender}/{age}",method=RequestMethod.GET)
	public List<User> getAllUserByAgeAndGender(@PathVariable String gender,@PathVariable int age) {
		List<User>  list = new ArrayList<User>();
		
	      Iterable<User> it =	service.getAllUserByAgeAndGender(gender,age);
	      
	      it.forEach((usr)->{ list.add(usr);  });
	      
	      return list;
	}
	


	
	
}
