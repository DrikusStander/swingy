package com.live.hstander.controller;

import com.live.hstander.model.Builder;
import com.live.hstander.model.Enemy;
import com.live.hstander.model.Hero;
import com.live.hstander.model.Map;

import java.util.concurrent.TimeUnit;

public class GameLoop
{
	public static void main( String[] args )
    {
		// Hero hero2 = Builder.newHero("Puny", "Human");
		Hero hero = Builder.loadHero(1);
		// try
		// {
		// 	TimeUnit.SECONDS.sleep(20);
		// }
		// catch(InterruptedException e)
		// {
		// 	System.out.println("time Exception: " + e);
		// }
		
		// hero2.setWeapon(Builder.loadWeapon(1));
		hero.updateDB();
		System.out.print(hero.getInfo());

		Enemy enemy = Builder.loadEnemy(3);
		System.out.print(enemy.getInfo());

		Map map = new Map(hero, 10);


	}
}