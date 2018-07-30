package com.live.hstander.controller;

import com.live.hstander.model.*;
import com.live.hstander.view.*;

public class Main
{
	public static void main( String[] args )
    {

		Terminal term = new Terminal();
		Hero hero = null;

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
			// hero = Builder.loadHero(index);
		}
		else
		{

		}

		if (hero != null)
		{
			System.out.print(hero.getInfo());

			Map map = new Map(hero);
		}


	}
}