package com.lewis.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}


//	public static void main(String[] args){
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String rawPassword = "password";
//		String encodedPassword = encoder.encode(rawPassword);
//		System.out.println(encodedPassword);}


}
