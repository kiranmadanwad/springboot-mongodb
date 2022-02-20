package com.kiran.madanwad.mongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address("Aurangabad", "India","431005");
			Student student = new Student(
					"Kiran",
					"Madanwad",
					"kiran.madanwad@gmail.com",
					Gender.MALE,
					address,
					List.of("Maths", "Computer Science"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);
			//usingMongoTemplateAndQuery(repository, mongoTemplate, student);
			//usingRepository(repository, student);
		};
	}

	private void usingRepository(StudentRepository repository, Student student) {
		repository.findStudentByEmail("kiran.madanwad@gmail.com").ifPresentOrElse(s -> {
			System.out.println("Email already exists");
		}, () -> {
			System.out.println("inserting student");
			repository.insert(student);
		});
	}

	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is("kiran.madanwad@gmail.com"));
		List<Student> students =  mongoTemplate.find(query, Student.class);
		if(!students.isEmpty()) {
			throw new IllegalStateException(" Email already exists");
		} else {
			System.out.println("inserting student");
			repository.insert(student);
		}
	}
}
