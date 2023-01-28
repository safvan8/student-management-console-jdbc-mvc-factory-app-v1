package in.ineuron.factory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

public class StudentServiceFactory
{

	private static IStudentService studentService = null;

	// to avoid Object creation from  outside class
	private StudentServiceFactory()
	{
	}

	// for creating Object of implementation class without
	//knowing the implementation class name
	public static IStudentService getStudentService()
	{
		if (studentService == null)
			studentService = new StudentServiceImpl();

		System.out.println("Implemenatation class is ::" + studentService.getClass().getName());

		return studentService;
	}
}
