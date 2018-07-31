package com.live.hstander.model;

import java.util.Random;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Character
{
	@NotBlank(message = "Name canot be Nulll or Blank")
	@Size(min = 4, max = 255, message = "Name must be between 4 and 255 characters")
	protected String _name;
	protected String _characterClass;
	protected int _level;
	protected int _expierience;
	protected int _attack_damage;
	protected int _defence;
	protected int _hitpoints;
	protected Armor _armor;
	protected Weapon _weapon;
	protected Helm _helm;
	protected int[] _position = new int[2];

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
		if (this._armor != null)
			this._defence += this._armor.getBuff();
	}

	public void setWeapon(Weapon weapon)
	{
		this._weapon = weapon;
		if (this._weapon != null)
			this._attack_damage += this._weapon.getBuff();
	}

	public void setHelm(Helm helm)
	{
		this._helm = helm;
		if (this._helm != null)
			this._hitpoints += this._helm.getBuff();
	}

	public String getInfo()
	{
		String info = "";
		info += "Name    : " + this._name + "\n";
		info += "Class   : " + this._characterClass + "\n";
		info += "Level   : " + this._level + "\n";
		info += "Exp     : " + this._expierience + "\n";
		info += "HP      : " + this._hitpoints + "\n";
		info += "Damage  : " + this._attack_damage + "\n";
		info += "Defence : " + this._defence + "\n";
		if (this._weapon != null)
		{
			info += "Weapon  : " + this._weapon.getName() + "\n";
			// info += "Wpn Dmg : " + this._weapon.getBuff() + "\n";
		}
		if (this._armor != null)
		{
			info += "Armor   : " + this._armor.getName() + "\n";
			// info += "Armor D : " + this._armor.getBuff() + "\n";
		}
		if (this._helm != null)
		{
			info += "Helm    : " + this._helm.getName() + "\n";
			// info += "Helm D  : " + this._helm.getBuff() + "\n";
		}
		return(info);
	}

	public int getHP()
	{
		return(this._hitpoints);
	}

	public int getLvl()
	{
		return(this._level);
	}

	public void attack(Character opponent)
	{
		int damage = this._attack_damage;
		Random rand = new Random();
		int chance = rand.nextInt(4);
		if (chance == 1)
			opponent.takeDamage(damage);
	}

	public void takeDamage(int damage)
	{
		int damage_taken = damage - this._defence;
		this._hitpoints -= damage_taken;

	}


}