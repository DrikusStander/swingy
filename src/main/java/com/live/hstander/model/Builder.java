package com.live.hstander.model;

import java.util.Random;



import com.live.hstander.controller.SqlClass;
import com.live.hstander.view.Interface;

public class Builder
{
	public static Hero		newHero(String name, String characterClass, Interface term)
	{
		Hero hero = new Hero(name, characterClass);
		String errors = "";
		errors = hero.validate();
		if (errors.length() > 0)
		{
			term.putCharacterInfo(errors);
			return(null);
		}
		SqlClass.writeHeroToDB(hero);
		return(hero);
	}

	public static Hero		loadHero(int index)
	{
		return(SqlClass.readHeroDB(index));
	}

	public static Enemy		loadEnemy(int index)
	{
		return(SqlClass.readEnemyDB(index));
	}

	public static Weapon loadWeapon(int index)
	{
		return(SqlClass.readWeaponDB(index));
	}

	public static Helm loadHelm(int index)
	{
		return(SqlClass.readHelmDB(index));
	}

	public static Armor loadArmor(int index)
	{
		return(SqlClass.readArmorDB(index));
	}

	public static Item itemGenerator()
	{
		Random rand = new Random();
		int val = rand.nextInt(50);
		if (val == 10)
		{
			return(Builder.loadHelm(rand.nextInt(3) + 1));
		}
		else if (val == 21)
		{
			return(Builder.loadWeapon(rand.nextInt(5) + 1));
		}
		else if (val == 42)
		{
			return(Builder.loadArmor(rand.nextInt(3) + 1));
		}
		return(null);
	}

	public static void equipItem(Item item, Hero hero)
	{
		if (item instanceof Armor)
		{
			hero.setArmor((Armor)item);
		}
		else if (item instanceof Helm)
		{
			hero.setHelm((Helm)item);
		}
		else if ( item instanceof Weapon)
		{
			hero.setWeapon((Weapon)item);
		}
	}
}