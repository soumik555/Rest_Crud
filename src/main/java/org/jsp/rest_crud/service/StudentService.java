package org.jsp.rest_crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.rest_crud.dao.StudentDao;
import org.jsp.rest_crud.dto.Student;
import org.jsp.rest_crud.exception.DataNotFoundException;
import org.jsp.rest_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	
	
	
	@Autowired
	StudentDao dao;
	
	@Autowired
	ResponseStructure structure;

	public ResponseStructure saveStudent(Student student) {
		
		double percentage=(student.getEnglish()+student.getMaths()+student.getScience())/3.0;
		student.setPercentage(percentage);
	
		
		if(student.getEnglish()<35||student.getMaths()<35||student.getScience()<35)
		{
			student.setResult("fail");
		}
		
		else
		{
			if(student.getPercentage()>=85)
			{
				student.setResult("distinction");
				
			}
			

			else if(student.getPercentage()>=60)
			{
				student.setResult("first class");
				
			}
			
			else if(student.getPercentage()>=35)
			{
				student.setResult("second class");
				
			}
			else
			{
				student.setResult("fail");
			}
		}
		
		
		
		
		dao.saveStudent(student);
		structure.setMessage("Data saved Success");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(student);
		return structure;
		
	
		
	}

	public ResponseStructure findById(int id)
	{
		
		Optional<Student> op=dao.findById(id);
		if(op.isEmpty())
		{
			throw new DataNotFoundException("Data not found with id " + id);
			
//			structure.setData(null);
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
			
			
		}
		
		else
		{   structure.setData(op.get());
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			
			
			
		}
		return structure;
	}

	public ResponseStructure fetchAllRecords() {
		List<Student> list=dao.fetchAllRecords();
		if(list.isEmpty())
		{

//			structure.setData(null);
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
			throw new DataNotFoundException("Data not found ");
			
		}
		else
		{
			structure.setData(list);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			
			
			
		}
		return structure;
		
	   
	}
	
	
	
	public ResponseStructure saveStudents(List<Student> students)
	{
	
	for(Student student:students)
	{
		
		double percentage=(student.getEnglish()+student.getMaths()+student.getScience())/3.0;
		student.setPercentage(percentage);
	
		
		if(student.getEnglish()<35||student.getMaths()<35||student.getScience()<35)
		{
			student.setResult("fail");
		}
		
		else
		{
			if(student.getPercentage()>=85)
			{
				student.setResult("distinction");
				
			}
			

			else if(student.getPercentage()>=60)
			{
				student.setResult("first class");
				
			}
			
			else if(student.getPercentage()>=35)
			{
				student.setResult("second class");
				
			}
			else
			{
				student.setResult("fail");
			}
		}
	
		
	}
	
	dao.saveStudents(students);
	structure.setMessage("Data saved Success");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(students);
	return structure;
	
	
	

	}

	public ResponseStructure findByName(String name) {
		
		
		List<Student> list=dao.findByName(name);
		if(list.isEmpty())
		{
			throw new DataNotFoundException("Data not found with id " + name);

//			structure.setData(null);
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
			
		}
		else
		{
			structure.setData(list);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			
			
			
		}
		return structure;
	}

	public ResponseStructure findBYMobile(long mobile) {
	
		List<Student> list=dao.findByMobile(mobile);
		
		if(list.isEmpty())
		{
			throw new DataNotFoundException("Data not found with id " + mobile);
			
		
//
//			structure.setData(null);
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			
		}
		else
		{
			structure.setData(list);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			
			
			
		}
		return structure;
	}

	public ResponseStructure findByResult(String result) {
		List<Student> list=dao.findByResult(result);
		if(list.isEmpty())
		{

//			structure.setData(null);
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
			throw new DataNotFoundException("Data not found with result " + result);
			
		}
		else
		{
			structure.setData(list);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			
			
			
		}
		
		return structure;
	}

	public ResponseStructure findBySubjectMarksGreater(String subject, int marks)
	{
		List<Student>list=null;
		if(subject.equals("math"))
		{
			list=dao.findByMathsGreater(marks);
		}
		
		else if(subject.equals("english"))
		{
			list=dao.findByEnglishGreater(marks);
		}
		
		else if(subject.equals("science"))
		{
			list=dao.findByScienceGreater(marks);
		}
		
		else
		{
			list=new ArrayList<Student>();
		}
		
		if(list.isEmpty())
		{
//			structure.setData(null);
//			structure.setMessage("data nit found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
			throw new DataNotFoundException("Data not found with subject and marks greater than " + subject + " and "+ marks);
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		
		return structure;
	}

	public ResponseStructure findByMarksAndSubjectBetween(String subject, int marks ,int marks2) {
		
		List<Student>list=null;
		if(subject.equals("maths"))
		{
			list=dao.findByMathsBetween(marks,marks2);
		}
		
		else if(subject.equals("english"))
		{
			list=dao.findByEnglishBetween(marks,marks2);
		}
		
		else if(subject.equals("science"))
		{
			list=dao.findByScienceBetween(marks,marks2);
		}
		
		else
		{
			list=new ArrayList<Student>();
		}
		
		if(list.isEmpty())
		{
//			structure.setData(null);
//			structure.setMessage("data not found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
			throw new DataNotFoundException("Data not found with subject and marks between " + subject +" and " + marks);
		}
		
		else
		{
			structure.setData(list);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		
		return structure;
	}



	




	
	}
	
	
	

	
	


