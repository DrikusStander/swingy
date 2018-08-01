package com.live.hstander.controller;

import java.util.Random;

import com.live.hstander.model.*;
import com.live.hstander.view.*;

public class Game
{
	int dir = 0;
	public Game(Interface term, Map map, Hero hero)
	{
		int gameOver = 0;
		while (gameOver == 0)
		{
			if ((gameOver = map.checkHeroPos()) == 1 )
				break;
			dir  = term.getDir();
			hero.moveHero(dir);
			if (map.checkEnemyPos() == 1)
			{
				
				int fight = term.enemyFound(map.enemyInfo());
				if (fight == 1)
				{
					if (map.fight(term) == 0)
						gameOver = -1;
					else
						term.putCharacterInfo("You Won the Battle\n" + hero.getInfo());
				}
				else if (fight == 2)
				{
					Random rand = new Random();
					if (rand.nextInt(2) == 1)
					{
						if (map.fight(term) == 0)
							gameOver = -1;
						else
							term.putCharacterInfo("You Won the Battle\n" + hero.getInfo());
					}
					else
					{
						if (dir == 1)
							dir = 3;
						else if (dir == 2)
							dir = 4;
						else if (dir == 3)
							dir = 1;
						else if (dir == 4)
							dir = 2;
						hero.moveHero(dir);
					}
				}
			}
		}
		term.gameOver(gameOver);
		SqlClass.updateHeroInDB(hero);
	}
}