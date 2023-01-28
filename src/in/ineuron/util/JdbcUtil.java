package in.ineuron.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil
{
	private static Connection connection;
	private static Statement statement;

	private JdbcUtil()
	{
	}

	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getJdbcConnection()
	{
		if (connection == null)
			try
			{
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldbo", "root", "Safvan@123");
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

		return connection;

	}

	public static Statement getStatement(Connection connection)
	{
		if (statement == null)
			try
			{
				statement = connection.createStatement();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

		return statement;
	}

}
