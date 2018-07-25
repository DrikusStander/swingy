package com.live.hstander.model;

public class Character
{
	private String _name;
	private String _characterClass;
	private int _level;
	private int _expierience;
	private int _attack_damage;
	private int _defence;
	private int _hitpoints;
	private Armor _armor;
	private Weapon _weapon;
	private Helm _helm;
	private int[] _position = new int[2];

	Character(String name, String characterClass)
	{
		this._name = name;
		this._characterClass = characterClass;
		this._level = 1;
		this._expierience = 0;
		this._hitpoints = 100;
		this._attack_damage = 5;
		this._defence = 0;
		this._armor = null;
		this._weapon = null;
		this._helm = null;
	}

	Character(String name, String characterClass, int level, int exp, int hp, int attack_damage, int defence)
	{
		this._name = name;
		this._characterClass = characterClass;
		this._level = level;
		this._expierience = exp;
		this._hitpoints = hp;
		this._attack_damage = attack_damage;
		this._defence = defence;
		this._armor = null;
		this._weapon = null;
		this._helm = null;
	}

	public void setPos(int x, int y)
	{
		this._position[0] = x;
		this._position[1] = y;
	}

	public void setArmor(Armor armor)
	{
		this._armor = armor;
	}

	public void setWeapon(Weapon weapon)
	{
		this._weapon = weapon;
	}

	public void setHelm(Helm helm)
	{
		this._helm = helm;
	}

	public String getInfo()
	{
		String info = ""; 
		info += "Name    : " + this._name + "\n";
		info += "Class   : " + this._characterClass + "\n";
		info += "Level   : " + this._level + "\n";
		info += "Exp     : " + this._expierience + "\n";
		info += "HP      : " + this._hitpoints + "\n";
		info += "Damage  : " + this._level + "\n";
		info += "Defence : " + this._level + "\n";
		if (this._weapon != null)
		{
			info += "Weapon  : " + this._weapon.getName() + "\n";
			info += "Wpn Dmg : " + this._weapon.getBuff() + "\n";
		}
		if (this._armor != null)
		{
			info += "Armor   : " + this._armor.getName() + "\n";
			info += "Armor D : " + this._armor.getBuff() + "\n";
		}
		if (this._helm != null)
		{
			info += "Helm    : " + this._helm.getName() + "\n";
			info += "Helm D  : " + this._helm.getBuff() + "\n";
		}
		return(info);
	}
}