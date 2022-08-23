package com.example.Eadmission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
@SpringBootApplication
public class EadmissionApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	Logger log=LoggerFactory.getLogger(EadmissionApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EadmissionApplication.class, args);
	}
}
