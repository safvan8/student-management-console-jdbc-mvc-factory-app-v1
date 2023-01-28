package in.ineuron.dao;
/* A Data Access Object (DAO) is a Java design pattern that separates the code for accessing a database
 *  from the rest of the application. Using a DAO, makes it easy to swap out the underlying data store
 *   with minimal changes to the rest of the application.
 *   DAO typically includes methods like insert, update, delete, readetc for performing these operations.
 */

import java.sql.Connection;
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

		String insertQuery = String.format(
				"INSERT INTO schooldbo.student_tab2 " + "(`name`,`city`,`email`,`country`) VALUES ('%s','%s','%s','%s')",
				name, city, email, country);

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

	@Override
	public String findById(Integer sid)
	{
		// TODO Auto-generated method stub
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
