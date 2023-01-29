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

					// studentRecord contains fetched student details from DB
					studentRecord = studentController.findById(sid);

					// printing the result to end user
					if (studentRecord != null)
					{
						System.out.println("Student  details existing in DB ::");
						System.out.println(studentRecord + "\n");
					} else
					{
						System.out.println("Student record not available for the id: " + sid);
					}

					break;

				case 3:
					System.out.println("UPDATE");

					// checking whether records available for updating , or not
					System.out.println("Enter id of the student to update details:: ");
					Integer sid_to_update = Integer.parseInt(br.readLine());

					// checking student is already existing or not
					Student existingStudentObj = studentController.findById(sid_to_update);

					if (existingStudentObj != null)
					{
						// creating a new Student opbject to pass updated details to coontroller
						Student newStudentObj = new Student();

						System.out.println("Enter new  name [ old name: " + existingStudentObj.getName() + " ]-->");
						String newName = br.readLine();

						System.out.println("Enter new  city [ old city: " + existingStudentObj.getCity() + " ]-->");
						String newCity = br.readLine();

						System.out.println("Enter new  Email [ old name: " + existingStudentObj.getEmail() + " ]-->");
						String newEmail = br.readLine();

						System.out
								.println("Enter new Country [ old name: " + existingStudentObj.getCountry() + " ]-->");
						String newCountry = br.readLine();

						// updating name only if user enterd new valid data
						if (newName == null || newName.trim().equals(""))
						{
							// setting same name again
							newStudentObj.setName(existingStudentObj.getName());
						} else
						{
							newStudentObj.setName(newName);
						}

						// updating city only if user enterd new valid data
						if (newCity == null || newCity.trim().equals(""))
						{
							newStudentObj.setCity(existingStudentObj.getCity());
						} else
						{
							newStudentObj.setCity(newCity);
						}

						// updating Email only if user enterd new valid data
						if (newEmail == null || newEmail.trim().equals(""))
							newStudentObj.setEmail(existingStudentObj.getEmail());
						else
							newStudentObj.setEmail(newEmail);

						// updating country only if user enterd new valid data
						if (newCountry== null || newCountry.trim().equals(""))
							newStudentObj.setCountry(existingStudentObj.getCountry());
						else
							newStudentObj.setCountry(newCountry);
						
					} 
					else
					{
						System.out.println("Student record not available for id ::" + sid_to_update);
					}

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
