package com.bootjpa.example.jpaexample;

import com.bootjpa.example.jpaexample.dao.UserRepository;
import com.bootjpa.example.jpaexample.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaexampleApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(JpaexampleApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);


		//Creating an Object
//		User user=new User();
//		user.setName("Nikhil Butle");
//		user.setCity("Mohopada");
//		user.setState("Maharashtra");
//		user.setStatus("Software Developer");
//
//		 //Creating a single entity
//		User user1=userRepository.save(user);
//		System.out.println(user1);
//
//		//Creata a User
//		User newUser1=new User();
//
//		newUser1.setName("Sujal");
//		newUser1.setCity("Chambarli");
//		newUser1.setState("Maharashtra");
//		newUser1.setStatus("Chef");
//
//		User newUser2=new User();
//
//		newUser2.setName("Viraj");
//		newUser2.setCity("Pen");
//		newUser2.setState("Maharashtra");
//		newUser2.setStatus("MBA asparaint");
//
//		List<User> userList=List.of(newUser1,newUser2);
//
//		//Creating a Multiple Entity
//		userRepository.saveAll(userList);


		// Updating an single object
//		Optional<User> optional=userRepository.findById(3);
//
//		if(optional.isPresent()){
//			User user=optional.get();
//			user.setName("Sujal Munde");
//			userRepository.save(user);
//		}

		//how to get data
		// findById()-> return Optional containing data;
		Iterable<User> iterator=userRepository.findAll();
		iterator.forEach(user -> {
			System.out.println(user.getName()+ " "+user.getCity()+" "+user.getStatus());
		});



	}

}
