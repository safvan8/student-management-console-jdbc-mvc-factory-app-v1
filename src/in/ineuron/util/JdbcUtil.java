package in.ineuron.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil
{
	private static Connection physicalConnection;
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
		FileInputStream fis = null;

		// creating properties object
		Properties properties = new Properties();
		try
		{ // getting Inputstream
			fis = new FileInputStream(new File("src\\in\\ineuron\\properties\\database.properties"));
			// loading properties file
			properties.load(fis);
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}

		// getting db details from properties
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		if (physicalConnection == null)
			try
			{
				physicalConnection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

		return physicalConnection;

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
