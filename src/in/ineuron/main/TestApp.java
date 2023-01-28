package in.ineuron.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentControllerFactory;

public class TestApp
{
	// starting of the APP
	public static void main(String[] args)
	{

		IStudentController studentController = null;

		String name, city, email, country;

		String status = null;
		
		Student studentRecord;

		try
		{
			while (true)
			{
				// creating Buffered Reader to Read input from Console
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("1 : CREATE");
				System.out.println("2 : READ");
				System.out.println("3 : DELETE");
				System.out.println("4 : UPDATE");
				System.out.println("5 : EXIT");

				System.out.println("Enter your option [1,2,3,4,5]...");

				Integer option = Integer.parseInt(br.readLine());

				// Creating Object of Controller without knowing impl class
				studentController = StudentControllerFactory.getIStudentController();

				switch (option)
				{
				case 1:
					System.out.println("CREATE");

					// C1: Creating Student Object
					Student student = new Student();

					// C2: getting input from user through console
					System.out.println("Enter  name:: ");
					name = br.readLine();

					System.out.println("Enter city:: ");
					city = br.readLine();

					System.out.println("Enter email:: ");
					email = br.readLine();

					System.out.println("Enter Country:: ");
					country = br.readLine();

					// C3: Setting user entered data to the Object
					student.setName(name);
					student.setCity(city);
					student.setEmail(email);
					student.setCountry(country);

					// C4: transferring object data to the Controller by calling save method inside
					// controller
					status = studentController.save(student);

					// C 16: now status conatin success/failed message

					if (status.equalsIgnoreCase("success"))
						System.out.println("Record Inserted Successfully");
					else if (status.equalsIgnoreCase("failed"))
						System.out.println("Record Insertion failed");
					else
						System.out.println("Ooops...Something went wrong...");
					break;

				case 2:
					System.out.println("READ");
					
					System.out.println("Enter Student id:: ");
					Integer sid = Integer.parseInt(br.readLine());
					
					 studentRecord= studentController.findById(sid);
					 
					 System.out.println(studentRecord);
					
					break;

				case 3:
					System.out.println("UPDATE");
					
					break;

				case 4:
					System.out.println("DELETE");
					break;

				case 5:
					System.out.println("Thanks for using our Application....");
					System.exit(0);

				default:
					System.out.println("invalid Option. please Enter a number between 1 to 5  ");
					break;
				}
			}
		}

		catch (IOException e)
		{

			e.printStackTrace();
		}
	}
}
