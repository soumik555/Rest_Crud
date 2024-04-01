package org.jsp.rest_crud.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.rest_crud.dto.Student;
import org.jsp.rest_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {
	
	@Autowired
	StudentRepository repository;
	
	
	public void saveStudent(Student student)
	{
		repository.save(student);
		
	}


	public Optional<Student> findById(int id) {
		return repository.findById(id);
		
	}


	public List<Student> fetchAllRecords() {
		
		return repository.findAll();
	}
	
	
	public List<Student> saveStudents(List<Student> students)
	{
		return repository.saveAll(students);
		
	}


	public List<Student> findByName(String name) {
		return repository.findByName(name);
		
	}


	public List<Student> findByMobile(long mobile) {
		
		return repository.findByMobile(mobile);
	}


	public List<Student> findByResult(String result) {
		
		return repository.findByResult(result);
	}


	public List<Student> findByMathsGreater(int marks) {
		
		return repository.findByMathsGreaterThanEqual(marks);

	}


	public List<Student> findByEnglishGreater(int marks) {
		return repository.findByEnglishGreaterThanEqual(marks);

		
	}


	public List<Student> findByScienceGreater(int marks) 
	{
		return repository.findByScienceGreaterThanEqual(marks);

		
	}


	public List<Student> findByMathsBetween(int marks, int marks2) {
		
		return repository.findByMathsBetween(marks,marks2);
	}


	public List<Student> findByEnglishBetween(int marks, int marks2) {
		// TODO Auto-generated method stub
		return repository.findByEnglishBetween(marks,marks2);
	}


	public List<Student> findByScienceBetween(int marks, int marks2) {
		// TODO Auto-generated method stub
		return repository.findByScienceBetween(marks,marks2);
	}
	
		
	


	







	

	


	

	

}
