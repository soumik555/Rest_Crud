package org.jsp.rest_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Student CRUD",description="Its a Rest Api for performing basic crud operations student  record", version="1.0",contact=@Contact(name="Soumik",email="soumiksardar535@gmail.com",url="https://www.linkedin.com/in/soumik-sardar-964a14215/")))
public class RestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCrudApplication.class, args);
		
	}

}
