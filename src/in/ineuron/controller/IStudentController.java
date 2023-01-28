package in.ineuron.controller;

import in.ineuron.dto.Student;

public interface IStudentController
{
	String save(Student student); 
	
	String findById(Integer sid); // create record
	
	String updateById(Integer sid); 
	
	String deleteById(String sid);
}
