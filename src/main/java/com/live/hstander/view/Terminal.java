package com.live.hstander.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.live.hstander.controller.SqlClass;

public class Terminal
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
}