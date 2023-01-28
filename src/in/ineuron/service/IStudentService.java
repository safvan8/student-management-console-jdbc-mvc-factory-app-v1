package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService
{
	String save(Student student);

	String findById(Integer sid); // create record

	String updateById(Integer sid);

	String deleteById(String sid);
}
