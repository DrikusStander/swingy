package com.live.hstander.controller;

import com.live.hstander.model.*;
import com.live.hstander.view.*;

public class Main
{
	public static void main( String[] args )
    {
		Interface term = null;
		Hero hero = null;
		Map map = null;
		Game game = null;
		if (args.length > 0)
		{
			if (args[0].equals("gui"))
				term = new GUI();
			else if (args[0].equals("console"))
				term = new Terminal();
			else
			{
				System.out.println("Invalid Argument");
				System.exit(-1);
			}
		}
		else
		{
			System.out.println("Invalid Argument");
			System.exit(-1);
		}
		int option = term.newGame();
		if (option == 1)
		{
			hero = Builder.newHero(term.heroName(), term.heroClass());
		}
		else if (option == 2)
		{
			int index = term.loadHero();
			if (index > 0)
			{
				hero = Builder.loadHero(index);
			}
			else
				hero = Builder.newHero(term.heroName(), term.heroClass());
		}
		if (hero != null)
		{
			term.putCharacterInfo(hero.getInfo());
			map = new Map(hero);
			game = new Game(term, map, hero);
		}
		
	}
}