package com.example.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mongo.entity.Customer;
import com.example.mongo.repository.CustomerRepository;

@SpringBootApplication
public class MongoDbDataAccessApplication implements CommandLineRunner {

	// All the Mongo DB Access is done through the CRUD provided by the autowired repository class
	@Autowired
	private CustomerRepository repository;

	
	public static void main(String[] args) {
		SpringApplication.run(MongoDbDataAccessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Clear the repository of any prior objects
		repository.deleteAll();
		
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Indrajit", "Hajra"));
		
		
		// Fetch all customers
		for(Customer customer : repository.findAll())
		{
			System.out.println(customer.toString());
		}
		
		
	}

}
