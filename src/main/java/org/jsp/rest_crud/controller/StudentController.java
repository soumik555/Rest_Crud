package org.jsp.rest_crud.controller;

import java.util.List;

import org.jsp.rest_crud.dto.Student;
import org.jsp.rest_crud.helper.ResponseStructure;
import org.jsp.rest_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController

public class StudentController {

	
@Autowired
StudentService service;
	
	//for saving record
   
    @Operation(summary="Saving one Record")
	@PostMapping("/students")
	public ResponseEntity<ResponseStructure>  saveStudent(@RequestBody Student student)
	
	{
		return new ResponseEntity<ResponseStructure>(service.saveStudent(student),HttpStatus.CREATED);
		
	}
    
	@Operation(summary="Find students by specific id")
	@GetMapping("/students/{id}")
	public ResponseEntity <ResponseStructure> findStudentById(@PathVariable int id)
	{
		return new ResponseEntity<ResponseStructure>(service.findById(id),HttpStatus.FOUND);
	}
	
	
	@Operation(summary = "Find all the students")
	@GetMapping("/students")
	public ResponseEntity <ResponseStructure> findAllRecord()
	{
		return new ResponseEntity<ResponseStructure>( service.fetchAllRecords(),HttpStatus.FOUND);
		
	}
	
	
    @Operation(summary="Save multiple/all students Records")
	@PostMapping("/students/many")
	public ResponseEntity<ResponseStructure> saveStudents(@RequestBody  List<Student> students)
	{
		return  new ResponseEntity<ResponseStructure> (service.saveStudents(students),HttpStatus.CREATED);
		
		
	}
	
	@Operation(summary="Find specific students by name")
	@GetMapping("/students/name/{name}")
	public ResponseEntity <ResponseStructure> findByName(@PathVariable String name)
	{
		return new ResponseEntity  <ResponseStructure>(service.findByName(name),HttpStatus.FOUND);
		
	}
	
	@Operation(summary="Find specific students by Mobile number")
	@GetMapping("/students/mobile/{mobile}")
	public ResponseEntity findByMobile(@ PathVariable long mobile)
	{
		return  new ResponseEntity <ResponseStructure>(service.findBYMobile(mobile),HttpStatus.FOUND);
		
	}
	@Operation(summary="Find students by Result")
	
	@GetMapping("/students/result/{result}")
	public ResponseEntity findByResult(@PathVariable String result)
	{
		return new ResponseEntity<ResponseStructure>(service.findByResult(result),HttpStatus.FOUND);
		
	}
	
	
	@Operation(summary="Find by Subject greater than marks")
	@GetMapping("students/{subject}/greater/{marks}")
	public ResponseEntity findByMarksAndSubjectGreater(@PathVariable String subject,@PathVariable int marks)
	{
		return new ResponseEntity<ResponseStructure>(service.findBySubjectMarksGreater(subject,marks),HttpStatus.FOUND);
	}
	
	
		
@Operation(summary = "Find by Subject between Marks")
@GetMapping("students/{subject}/between/{marks}/{marks2}")
public ResponseEntity findByMarksAndSubjectBetween(@PathVariable String subject,@PathVariable int marks, @PathVariable int  marks2)
{
		return new ResponseEntity<ResponseStructure>( service.findByMarksAndSubjectBetween(subject, marks,marks2),HttpStatus.FOUND);
		
}

	
	
	
	
	
	
	
	
	
}