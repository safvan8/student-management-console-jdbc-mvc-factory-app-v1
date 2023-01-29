package in.ineuron.dao;
/* A Data Access Object (DAO) is a Java design pattern that separates the code for accessing a database
 *  from the rest of the application. Using a DAO, makes it easy to swap out the underlying data store
 *   with minimal changes to the rest of the application.
 *   DAO typically includes methods like insert, update, delete, readetc for performing these operations.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao
{

	private Connection connection;

	private Statement statement;

	// write logc for Student Insert Operation
	@Override
	public String save(Student student)
	{
		System.out.println("Student Object reached inside StudentDaoImpl  - CREATE");
		System.out.println("executing StudentDaoImpl.save() -- CREATE");

		// C 11: getting connection
		connection = JdbcUtil.getJdbcConnection();

		// C 12 : Create Statement object
		statement = JdbcUtil.getStatement(connection);

		// C 13: getting data from Student Object
		String name = student.getName();
		String city = student.getCity();
		String email = student.getEmail();
		String country = student.getCountry();

		String insertQuery = String.format("INSERT INTO schooldbo.student_tab2 "
				+ "(`name`,`city`,`email`,`country`) VALUES ('%s','%s','%s','%s')", name, city, email, country);

		// C 14: excuting Query
		Integer rowAffected = null;

		try
		{
			rowAffected = statement.executeUpdate(insertQuery);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		// C 15: retrning result;
		if (rowAffected == 1)
		{
			return "success";
		} else
			return "failed";
	}

	// write logc for Read Operation
	@Override
	public Student findById(Integer sid)
	{

		System.out.println("StudentDaoImpl.findById()............\n");
		Connection connection = JdbcUtil.getJdbcConnection();
		
		Statement statement = JdbcUtil.getStatement(connection);

		String selectQuery =String.format("SELECT * FROM schooldbo.student_tab2 WHERE sid=%d ", sid); 
		
		// to return output as a Student Object
		Student student = null;

		// execute Query :
		try
		{
			ResultSet resultSet = statement.executeQuery(selectQuery);
			if (resultSet.next())
			{
				// copy the reusltSet data to StudentDTO and trasfer to the view part
				
				// Creating new object
				student = new Student();
				
				student.setSid(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setCity(resultSet.getString(3));
				student.setEmail(resultSet.getString(4));
				student.setCountry(resultSet.getString(5));

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		// return student object with result
		return student;
	}

	@Override
	public String updateById(Student  student)
	{
		// geting connection and creating Statement
		connection = JdbcUtil.getJdbcConnection();
		statement = JdbcUtil.getStatement(connection);
		
		// getting Details from newStudentObject to update
		String name= student.getName();
		String city = student.getCity();
		String email = student.getEmail();
		String coutry = student.getCountry();
		Integer id = student.getSid();
		
		String updateQuery=String.format("UPDATE schooldbo.student_tab2 SET name='%s', city ='%s', email='%s' ,country='%s'"
				+ "WHERE sid=%d",name,city,email,coutry,id) ;
		
		// executing update query
		int rowAffected=0;
		try
		{
			rowAffected = statement.executeUpdate(updateQuery);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (rowAffected == 1)
		{
			return "success";
		}
		else
			return "failed";

	}

	@Override
	public String deleteById(String sid)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
