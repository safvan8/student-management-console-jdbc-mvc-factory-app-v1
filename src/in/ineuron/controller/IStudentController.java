package in.ineuron.controller;

import in.ineuron.dto.Student;

public interface IStudentController
{
	String save(Student student); 
	
	Student findById(Integer sid); // create record
	
	String updateById(Integer sid); 
	
	String deleteById(String sid);
}
