package com.live.hstander.controller;

import com.live.hstander.model.Builder;
import com.live.hstander.model.Enemy;
import com.live.hstander.model.Hero;

public class GameLoop
{
	public static void main( String[] args )
    {
		Hero hero = Builder.loadHero(1);
		System.out.print(hero.getInfo());

		Enemy enemy = Builder.loadEnemy(3);
		System.out.print(enemy.getInfo());
		// SqlClass.writeCharacterToDB("Slayer", "Syth Lord", 1, 0, 20, 0, 70, 0, 0, 0);

		// SqlClass.readDB("SELECT * From `Enemy`");
	}
}