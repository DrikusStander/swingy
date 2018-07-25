package com.live.hstander.model;

import com.live.hstander.controller.SqlClass;

public class Hero extends Character
{
	private int _index;

	public Hero(String name, String characterClass)
	{
		super(name, characterClass);
	}

	public Hero(String name, String characterClass, int level, int exp, int hp, int attack_damage, int defence)
	{
		super(name, characterClass, level, exp, hp, attack_damage, defence);
	}

	public void updateDB()
	{
		SqlClass.updateHeroInDB(this);
	}

	public void setIndex(int index)
	{
		this._index = index;
	}

	public String getName()
	{
		return(this._name);
	}

	public String getCharaterClass()
	{
		return(this._characterClass);
	}

	public int getLvl()
	{
		return(this._level);
	}

	public int getExp()
	{
		return(this._expierience);
	}

	public int getHP()
	{
		return(this._hitpoints);
	}

	public int getDefence()
	{
		return(this._defence);
	}

	public int getAttack()
	{
		return(this._attack_damage);
	}

	public int getWeapon()
	{
		if (this._weapon != null)
			return(this._weapon.getIndex());
		return(0);
	}

	public int getArmor()
	{
		if (this._armor != null)
			return(this._armor.getIndex());
		return(0);
	}

	public int getHelm()
	{
		if (this._helm != null)
			return(this._helm.getIndex());
		return(0);
	}

	public int getIndex()
	{
		return(this._index);
	}

}