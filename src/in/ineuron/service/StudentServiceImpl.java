package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService
{
	private IStudentDao studentDao;

	@Override
	public String save(Student student)
	{
		// C8: recieving student Object from the controller to servcie
		System.out.println("Student Object reached inside StudentServiceImpl  - CREATE");

		// C9: Object creation of StudentDaoImpl
		studentDao = StudentDaoFactory.getStudentDao();

		// C10: passing student object to DAO layer
		return studentDao.save(student);
	}

	@Override
	public String findById(Integer sid)
	{
		return null;
	}

	@Override
	public String updateById(Integer sid)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(String sid)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
