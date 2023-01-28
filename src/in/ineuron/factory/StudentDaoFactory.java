package in.ineuron.factory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudentDaoImpl;

public class StudentDaoFactory
{
	private static IStudentDao studentDao = null;

	// not allowed to create Object from outside
	private StudentDaoFactory()
	{
	}

	// for creating Object of implementation class without
	// knowing the implementation class name
	public static IStudentDao getStudentDao()
	{
		// singleton
		if (studentDao == null)
		{
			studentDao = new StudentDaoImpl();
		}

		System.out.println("implemntation class name is :" + studentDao.getClass().getName());
		return studentDao;
	}

}
