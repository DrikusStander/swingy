package com.live.hstander.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.live.hstander.model.*;



public class SqlClass
{
	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;


	public static void writeCharacterToDB(String name, String characterClass, int level, int exp, int attDamage, int defecnce, int hp, int weapon, int armor, int helm)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root&useSSL=false");

			preparedStatement = connect.prepareStatement("INSERT INTO `Heros` (`id`, `name`, `class`, `level`, `exp`, `attackDamage`, `defence`, `hp`, `weapon`, `armor`, `helm`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			close();
		}
	}

	
	public static Weapon readWeaponDB(int index)
	{
		String name;
		int damage;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root&useSSL=false");

			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `Weapons` WHERE `id`=" + index);

			if (resultSet.first())
			{
				name = resultSet.getString("type");
				damage = resultSet.getInt("damage");
				close();
				return(new Weapon(name, damage));
			}
			else
				return(null);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(null);
	}

	public static Helm readHelmDB(int index)
	{
		String name;
		int defence;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root&useSSL=false");

			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `Helm` WHERE `id`=" + index);

			if (resultSet.first())
			{
				name = resultSet.getString("type");
				defence = resultSet.getInt("defence");
				close();
				return(new Helm(name, defence));
			}
			else
				return(null);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(null);
	}

	public static Armor readArmorDB(int index)
	{
		String name;
		int defence;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root&useSSL=false");

			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `Armor` WHERE `id`=" + index);

			if (resultSet.first())
			{
				name = resultSet.getString("type");
				defence = resultSet.getInt("defence");
				close();
				return(new Armor(name, defence));
			}
			else
				return(null);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(null);
	}


	public static Hero readHeroDB(int index)
	{
		String name;
		String characterClass;
		int lvl;
		int exp;
		int hp;
		int attDamage;
		int defence;
		int weapon;
		int helm;
		int armor;
		Hero hero = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root&useSSL=false");

			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `Heros` WHERE `id`=" + index);
			
			if (resultSet.first())
			{
				name = resultSet.getString("name");
				characterClass = resultSet.getString("class");
				lvl = resultSet.getInt("level");
				exp = resultSet.getInt("exp");
				attDamage = resultSet.getInt("attackDamage");
				defence = resultSet.getInt("defence");
				hp = resultSet.getInt("hp");
				weapon = resultSet.getInt("weapon");
				armor = resultSet.getInt("armor");
				helm = resultSet.getInt("helm");

				close();
				hero = new Hero(name, characterClass, lvl, exp, attDamage, hp, defence);
				hero.setHelm(readHelmDB(helm));
				hero.setArmor(readArmorDB(armor));
				hero.setWeapon(readWeaponDB(weapon));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(hero);
	}

	public static Enemy readEnemyDB(int index)
	{
		String name;
		String characterClass;
		int lvl;
		int exp;
		int hp;
		int attDamage;
		int defence;
		int weapon;
		int helm;
		int armor;
		Enemy enemy = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root&useSSL=false");

			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `Enemy` WHERE `id`=" + index);
			if (resultSet.first())
			{
				name = resultSet.getString("name");
				characterClass = resultSet.getString("class");
				lvl = resultSet.getInt("level");
				exp = resultSet.getInt("exp");
				attDamage = resultSet.getInt("attackDamage");
				defence = resultSet.getInt("defence");
				hp = resultSet.getInt("hp");
				weapon = resultSet.getInt("weapon");
				armor = resultSet.getInt("armor");
				helm = resultSet.getInt("helm");

				close();
				enemy = new Enemy(name, characterClass, lvl, exp, attDamage, hp, defence);
				enemy.setHelm(readHelmDB(helm));
				enemy.setArmor(readArmorDB(armor));
				enemy.setWeapon(readWeaponDB(weapon));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(enemy);
	}

	private static void close()
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