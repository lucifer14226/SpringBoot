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
		User user=new User();
		user.setName("Nikhil Butle");
		user.setCity("Mohopada");
		user.setState("Maharashtra");
		user.setStatus("Software Developer");

		 //Creating a single entity
		User user1=userRepository.save(user);
		System.out.println(user1);

		//Creata a User
		User newUser1=new User();

		newUser1.setName("Sujal");
		newUser1.setCity("Chambarli");
		newUser1.setState("Maharashtra");
		newUser1.setStatus("Chef");

		User newUser2=new User();

		newUser2.setName("Viraj");
		newUser2.setCity("Pen");
		newUser2.setState("Maharashtra");
		newUser2.setStatus("MBA asparaint");

		List<User> userListToInsert=List.of(newUser1,newUser2);

		//Creating a Multiple Entity
		userRepository.saveAll(userListToInsert);


		 //Updating an single object
		Optional<User> optional=userRepository.findById(3);

		if(optional.isPresent()){
			User user3=optional.get();
			user3.setName("Sujal Munde");
			userRepository.save(user3);
		}

		//how to get data
		// findById()-> return Optional containing data;
		Iterable<User> iterator=userRepository.findAll();
		iterator.forEach(users -> {
			System.out.println(users.getName()+ " "+users.getCity()+" "+users.getStatus());
		});

		List<User> userList=userRepository.findByName("Nikhil Butle");
		userList.forEach(users -> {
			System.out.println(users.getStatus());
		});

		userList=userRepository.findByState("Maharashtra");

		userList.forEach(users -> {
			System.out.println(users.getName()+" "+users.getCity()+" "+users.getStatus());
		});

		userList=userRepository.findByNameAndCity("Nikhil Butle","Mohopada");

		userList.forEach(users -> {
			System.out.println(users.getName()+" "+users.getCity()+" "+users.getStatus());
		});

		userList=userRepository.findByNameOrCity("Nikhil Butle","Pen");

		userList.forEach(users -> {
			System.out.println(users.getName()+" "+users.getCity()+" "+users.getStatus());
		});

	}

}
