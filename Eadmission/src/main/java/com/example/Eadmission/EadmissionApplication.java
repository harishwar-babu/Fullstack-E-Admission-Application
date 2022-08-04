package com.example.Eadmission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class EadmissionApplication {
	Logger log=LoggerFactory.getLogger(EadmissionApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EadmissionApplication.class, args);
	}
}
