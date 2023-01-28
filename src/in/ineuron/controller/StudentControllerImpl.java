package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

public class StudentControllerImpl implements IStudentController
{

	private IStudentService studentService;

	@Override
	public String save(Student student)
	{
		// C5: recieving student Object from the main to Controller
		System.out.println("Student Object reached inside Controller impl - CREATE");

		// C6: ServiceServiceImpl object creation
		studentService = StudentServiceFactory.getStudentService();
		
		// C7: transferring student object to service layer
		return studentService.save(student);
	}

	@Override
	public Student findById(Integer sid)
	{
		System.out.println("StudentControllerImpl.findById().... \n");
		
		// creating object  studentService
		studentService = StudentServiceFactory.getStudentService();
		
		// forwarsing sid to service layer
		return studentService.findById(sid);
		
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
