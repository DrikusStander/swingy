package com.live.hstander.model;

import java.util.Random;
import java.util.Set;
import java.util.logging.Level;

import com.live.hstander.controller.SqlClass;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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

	public int getTrueAttack()
	{
		int att = this._attack_damage;
		if (this._weapon != null)
		{
			att -= this._weapon.getBuff();
		}
		return(att);
	}
	
	public int getTrueDeff()
	{
		int deff = this._defence;
		if (this._armor != null)
		{
			deff -= this._armor.getBuff();
		}
		return(deff);
	}

	public int getExp()
	{
		return(this._expierience);
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

	public int getIndex()	{
		return(this._index);
	}

	public void moveHero(int dir)
	{
		if (dir == 1)
		{
			this._position[1] -= 1; 
		}
		else if (dir == 3)
		{
			this._position[1] += 1; 
		}
		else if (dir == 4)
		{
			this._position[0] -= 1; 
		}
		else if (dir == 2)
		{
			this._position[0] += 1; 
		}
	}
	public int getX()
	{
		return(this._position[0]);
	}

	public int getY()
	{
		return(this._position[1]);
	}

	public void expGain(int lvl)
	{
		this._expierience += (lvl * 10);
		if (this._expierience >= (this._level * 1000 + ((this._level - 1)*2) * 450))
		{
			this._level += 1;
		}
	}

	public void attack(Character opponent)
	{
		int damage = this._attack_damage;
		Random rand = new Random();
		int chance = rand.nextInt(2);
		if (chance == 1)
			opponent.takeDamage(damage);
	}

	public String validate()
	{
		String errors = "";
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Hero>> violations = validator.validate(this);
		for (ConstraintViolation<Hero> violation : violations) 
		{
			errors += violation.getMessage() + "\n";
		}
		return(errors);
	}
}