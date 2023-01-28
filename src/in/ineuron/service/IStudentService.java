package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService
{
	String save(Student student);

	Student findById(Integer sid); // create record

	String updateById(Integer sid);

	String deleteById(String sid);
}
