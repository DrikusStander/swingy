package com.live.hstander.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.live.hstander.controller.SqlClass;
import com.live.hstander.model.*;


public class Terminal implements Interface
{
	public int newGame()
	{
		Integer val = 0;
		try
		{
			System.out.println("Please select a option to continue");
			System.out.println("1. Create New Hero");
			System.out.println("2. Load Hero");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String value = reader.readLine();
			try
			{
				val = Integer.valueOf(value);
				if (val < 1 || val > 2)
					return(newGame());
			}
			catch(NumberFormatException e)
			{
				return (newGame());
			}
		}
		catch(IOException e)
		{
			System.out.println("Invalid input");
			return(newGame());
		}
		return(val);
	}

	public String heroName()
	{
		String name = "" ;
		try
		{
			System.out.println("Please enter a name for your Hero");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			name = reader.readLine();
			name.trim();
			if (name.length() < 1)
			{
				return(heroName());
			}
		}
		catch(IOException e)
		{
			System.out.println("Invalid input");
			return(heroName());
		}
		return(name);
	}

	public String heroClass()
	{
		String hClass = "" ;
		try
		{
			System.out.println("Please select a Class for your Hero");
			System.out.println("1. Mage");
			System.out.println("2. Elf");
			System.out.println("3. Hunter");
			System.out.println("4. Battle Mage");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			hClass = reader.readLine();
			hClass.trim();
			try
			{
				Integer val = Integer.valueOf(hClass);
				if (val < 1 || val > 4)
					return(heroClass());
				else if (val == 1)
					return("Mage");
				else if (val == 2)
					return("Elf");
				else if (val == 3)
					return("Hunter");
				else if (val == 4)
					return("Battle Mage");
			}
			catch(NumberFormatException e)
			{
				return (heroClass());
			}
			if (hClass.length() < 1)
			{
				return(heroClass());
			}
		}
		catch(IOException e)
		{
			System.out.println("Invalid input");
			return(heroClass());
		}
		return(hClass);
	}

	public int loadHero()
	{
		int index = 0;
		int maxid;
		String line;
		try
		{
			maxid = SqlClass.readHeros();
			if (maxid > 0)
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				line = reader.readLine();
				line.trim();
				index = Integer.valueOf(line);
				if (index < 1 || index > maxid)
				{
					System.out.println("Invalid input");
					return(loadHero());
				}
			}
			else
			{
				System.out.println("No Heros to load");
				return(-1);
			}
		}
		catch(IOException e)
		{
			System.out.println("Invalid input");
			return(loadHero());
		}
		return(index);
	}

	public int getDir()
	{
		String line;
		int val = 0;
		try
		{
			System.out.println("Please select a direction to move in");
			System.out.println("1. North");
			System.out.println("2. East");
			System.out.println("3. South");
			System.out.println("4. West");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			line = reader.readLine();
			line.trim();
			try
			{
				val = Integer.valueOf(line);
				if (val < 1 || val > 4)
					return(getDir());
				else
					return(val);
			}
			catch(NumberFormatException e)
			{
				return (getDir());
			}
		}
		catch(IOException e)
		{
			return(getDir());
		}
		// return(val);
	}

	public void gameOver(int gameOver)
	{
		if (gameOver == 1)
			System.out.println("Congradulations You Won!!");
		else
			System.out.println("Sorry You Lost!!");

	}

	public void putCharacterInfo(String info)
	{
		System.out.println(info);
	}

	public int enemyFound(String enemyInfo)
	{
		String line;
		int val;
		try
		{
			System.out.println("An Enemy appeared!");
			System.out.println(enemyInfo);
			System.out.println("1. Fight");
			System.out.println("2. Run");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			line = reader.readLine();
			line.trim();
			try
			{
				val = Integer.valueOf(line);
				if (val < 1 || val > 2)
					return(enemyFound(enemyInfo));
				else
					return(val);
			}
			catch(NumberFormatException e)
			{
				return (enemyFound(enemyInfo));
			}
		}
		catch(IOException e)
		{
			return(enemyFound(enemyInfo));
		}
	}

	public void droppedItem(Item item, Hero hero)
	{
		String line;
		try
		{
			if (item instanceof Armor)
			{
				System.out.println(item.getName() + " Armor Droped. Equip? Y/N");
			}
			else if (item instanceof Weapon)
			{
				System.out.println(item.getName() + " Droped. Equip? Y/N");
			}
			else if (item instanceof Helm)
			{
				System.out.println(item.getName() + " Helm Droped. Equip? Y/N");
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			line = reader.readLine();
			line.trim();
			if (line.equals("Y") || line.equals("Yes"))
			{
				Builder.equipItem(item, hero);
			}
			else
			{
				return;
			}
		}
		catch(IOException e)
		{
			droppedItem(item, hero);
		}
	}
}