package in.ineuron.factory;

import in.ineuron.controller.IStudentController;
import in.ineuron.controller.StudentControllerImpl;

public class StudentControllerFactory
{

	private static IStudentController studentController = null;

	// not allowed to create object from outside class
	private StudentControllerFactory()
	{
	}

	// for creating Object of implementation class without
	//knowing the implementation class name
	public static IStudentController getIStudentController()
	{
		// singleton Design pattern
		if (studentController == null)
		{
			studentController = new StudentControllerImpl();
		}
		
		System.out.println("Implementation class is:: " + studentController.getClass().getName());

		return studentController;
	}

}
