package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao
{

	String save(Student student);

	String findById(Integer sid); // create record

	String updateById(Integer sid);

	String deleteById(String sid);

}
