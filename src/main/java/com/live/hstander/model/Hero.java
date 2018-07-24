package com.live.hstander.model;

public class Hero extends Character
{
	public Hero(String name, String characterClass)
	{
		super(name, characterClass);
	}

	public Hero(String name, String characterClass, int level, int exp, int hp, int attack_damage, int defence)
	{
		super(name, characterClass, level, exp, hp, attack_damage, defence);
	}
}