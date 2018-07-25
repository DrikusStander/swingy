package com.live.hstander.model;

import com.live.hstander.controller.SqlClass;

public class Builder
{
	public static Hero		newHero(String name, String characterClass)
	{
		return(new Hero(name, characterClass));
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
}