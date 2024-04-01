package org.jsp.rest_crud.repository;

import java.util.List;

import org.jsp.rest_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

	List<Student> findByName(String name);

	List<Student> findByMobile(long mobile);

	List<Student> findByResult(String result);

	List<Student> findByMathsGreaterThanEqual(int marks);

	List<Student> findByEnglishGreaterThanEqual(int marks);

	List<Student> findByScienceGreaterThanEqual(int marks);

	List<Student> findByMathsBetween(int marks, int marks2);

	List<Student> findByEnglishBetween(int marks, int marks2);

	List<Student> findByScienceBetween(int marks, int marks2);

	

	

	


}
