package com.live.hstander.model;

public class CharacterBuilder
{
	public Hero		newHero(String name, String characterClass)
	{
		return(new Hero(name, characterClass));
	}

	// public Hero		loadHero()
	// {
	// 	return(new Hero());
	// }
}