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


	public static void updateHeroInDB(Hero hero)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root&useSSL=false");

			preparedStatement = connect.prepareStatement("Update `Heros` SET  `name` = ?, `class` = ? , `level` = ?, `exp` = ?, `attackDamage` = ?, `defence` = ?, `hp` = ?, `weapon` = ?, `armor` = ?, `helm`= ? WHERE `id`=" + hero.getIndex());

			preparedStatement.setString(1, hero.getName());
			preparedStatement.setString(2, hero.getCharaterClass());
			preparedStatement.setInt(3, hero.getLvl());
			preparedStatement.setInt(4, hero.getExp());
			preparedStatement.setInt(5, hero.getAttack());
			preparedStatement.setInt(6, hero.getDefence());
			preparedStatement.setInt(7, hero.getHP());
			preparedStatement.setInt(8, hero.getWeapon());
			preparedStatement.setInt(9, hero.getArmor());
			preparedStatement.setInt(10, hero.getHelm());
			preparedStatement.execute();
			close();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void writeHeroToDB(Hero hero)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root&useSSL=false");

			preparedStatement = connect.prepareStatement("INSERT INTO `Heros` (`id`, `name`, `class`, `level`, `exp`, `attackDamage`, `defence`, `hp`, `weapon`, `armor`, `helm`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, hero.getName());
			preparedStatement.setString(2, hero.getCharaterClass());
			preparedStatement.setInt(3, hero.getLvl());
			preparedStatement.setInt(4, hero.getExp());
			preparedStatement.setInt(5, hero.getAttack());
			preparedStatement.setInt(6, hero.getDefence());
			preparedStatement.setInt(7, hero.getHP());
			preparedStatement.setInt(8, hero.getWeapon());
			preparedStatement.setInt(9, hero.getArmor());
			preparedStatement.setInt(10, hero.getHelm());
			preparedStatement.execute();

			statement =  connect.createStatement();
			resultSet =  statement.executeQuery("SELECT MAX(`id`) FROM `Heros`");
			resultSet.first();
			int id = resultSet.getInt(1);
			hero.setIndex(id);
			close();

		}
		catch(Exception e)
		{
			System.out.println(e);
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
				return(new Weapon(name, damage, index));
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
				return(new Helm(name, defence, index));
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
				return(new Armor(name, defence, index));
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
				hero.setIndex(index);
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

	public static int readHeros()
	{
		String name;
		String characterClass;
		int id;
		int maxid = 0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/swingy?" + "user=root&password=root&useSSL=false");

			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `Heros` ");
			
			while(resultSet.next())
			{
				name = resultSet.getString("name");
				characterClass = resultSet.getString("class");
				id = resultSet.getInt("id");

				System.out.println(id + ". " + name + " " + characterClass);
			}
			statement =  connect.createStatement();
			resultSet =  statement.executeQuery("SELECT MAX(`id`) FROM `Heros`");
			resultSet.first();
			maxid = resultSet.getInt(1);

			close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(maxid);
	}
}


	