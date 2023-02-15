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


		Student studentRecord;

		try
		{
			while (true)
			{
				// creating Buffered Reader to Read input from Console
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("1 : CREATE");
				System.out.println("2 : READ");
				System.out.println("3 : UPDATE");
				System.out.println("4 : DELETE");
				System.out.println("5 : EXIT");

				System.out.println("Enter your option [1,2,3,4,5]...");

				Integer option = Integer.parseInt(br.readLine());

				// Creating Object of Controller without knowing impl class
				studentController = StudentControllerFactory.getIStudentController();

				switch (option)
				{
				case 1:
					System.out.println("CREATE");
					
					// to print status of the operation
					String createStatus = null;
					
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
					createStatus = studentController.save(student);

					// C 16: now status conatin success/failed message

					if (createStatus.equalsIgnoreCase("success"))
						System.out.println("Record Inserted Successfully");
					else if (createStatus.equalsIgnoreCase("failed"))
						System.out.println("Record Insertion failed");
					else
						System.out.println("Ooops...Something went wrong...");
					break;

				case 2:
					System.out.println("READ");

					
					System.out.println("Enter Student id:: ");
					Integer sid = Integer.parseInt(br.readLine());

					// studentRecord contains fetched student details from DB
					studentController = StudentControllerFactory.getIStudentController();
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

					// to print status of the operation
					String updateStatus = null;
					
					
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

						// updating id
						newStudentObj.setSid(sid_to_update);

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
						if (newCountry == null || newCountry.trim().equals(""))
							newStudentObj.setCountry(existingStudentObj.getCountry());
						else
							newStudentObj.setCountry(newCountry);

						// passing newStudent object to controller for Performing update
						studentController = StudentControllerFactory.getIStudentController();

						updateStatus = studentController.updateById(newStudentObj);

						if (updateStatus.equalsIgnoreCase("success"))
						{
							System.out.println("Record updated successfully for the id : " + sid_to_update);
						} else
						{
							System.out.println("Record Update failed");
						}
					} else
					{
						System.out.println("Student record not available for id ::" + sid_to_update);
					}

					break;

				case 4:
					System.out.println("DELETE");

					// to print status of the operation
					String deleteStatus = null;
					
					
					// checking whether records available for deleting or not
					System.out.println("Enter id of the student to delete record:: ");
					Integer sid_to_delete = Integer.parseInt(br.readLine());

					// checking whether the record is existing or not
					Student existingStudentForDelete = studentController.findById(sid_to_delete);

					if (existingStudentForDelete != null)
					{
						System.out.println("\n Record available for Deletion......");

						// passing sid to controller for Performing delete opertaion
						deleteStatus = studentController.deleteById(sid_to_delete);
					} else
					{
						System.out.println("Record , which you are looking for is not available......");
					}

					if ( deleteStatus.equals("success"))
						System.out.println("\nRecord Deleted Succesfully..........");
					else
						System.out.println("\n Oopz..Record deletion failed");
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
