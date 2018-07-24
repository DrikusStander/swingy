package com.live.hstander.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SqlClass 
{
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;


	public void writeCharecterToDB(String name, String characterClass, int level, int exp, int attDamage, int defecnce, int hp, int weapon, int armor, int helm) throws Exception
	{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root");

			preparedStatement = connect.prepareStatement("INSERT INTO `Heros` (`id`, `name`, `class`, `level`, `exp`, `atackDamage`, `defence`, `hp`, `weapon`, `armor`, `helm`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, characterClass);
			preparedStatement.setInt(3, level);
			preparedStatement.setInt(4, exp);
			preparedStatement.setInt(5, attDamage);
			preparedStatement.setInt(6, defecnce);
			preparedStatement.setInt(7, hp);
			preparedStatement.setInt(8, weapon);
			preparedStatement.setInt(9, armor);
			preparedStatement.setInt(10, helm);
			preparedStatement.executeUpdate();

			close();
	}

	public void readDataBase(String query) throws Exception 
	{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root");

			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			writeResultSet(resultSet);

			// preparedStatement = connect.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
			// resultSet = preparedStatement.executeQuery();
			// writeResultSet(resultSet);

			// resultSet = statement.executeQuery("select * from feedback.comments");
			close();

	}


	private void writeResultSet(ResultSet resultSet) throws SQLException 
	{
		// ResultSet is initially before the first data set
		while (resultSet.next()) 
		{
			System.out.println(resultSet);
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			// String user = resultSet.getString("myuser");
			// String website = resultSet.getString("webpage");
			// String summary = resultSet.getString("summary");
			// Date date = resultSet.getDate("datum");
			// String comment = resultSet.getString("comments");
			// System.out.println("User: " + user);
			// System.out.println("Website: " + website);
			// System.out.println("summary: " + summary);
			// System.out.println("Date: " + date);
			// System.out.println("Comment: " + comment);
		}
	}

	private void close()
	{
		try
		{
			if (resultSet != null)
			{
				resultSet.close();
			}

			if (statement != null)
			{
				statement.close();
			}

			if (connect != null)
			{
				connect.close();
			}
		}
		catch (Exception e)
		{

		}
	}

}