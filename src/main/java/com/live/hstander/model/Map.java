package com.live.hstander.model;

import java.util.Random;

import com.live.hstander.view.Interface;
import com.live.hstander.view.Terminal;

public class Map
{
	private Hero _hero;
	private Enemy[][] _map;
	private int _size;

	public Map(Hero hero)
	{
		this._hero = hero;
		this.getMapSize();
		this._hero.setPos(this._size / 2, this._size / 2);
		this._map = new Enemy[this._size][this._size];
		
		this.generateEnemies();
		System.out.println("map size is : " + this._size + " x " + this._size);
	}

	private void getMapSize()
	{
		int level = this._hero.getLvl();
		this._size = (level - 1) * 5 + 10 - (level % 2);
	}

	private void generateEnemies()
	{
		Random rand = new Random();

		for (int i = 0; i < this._size; i++)
		{
			for (int j = 0; j < this._size; j++)
			{
					if ((rand.nextInt(10)+ 1) == 1)
					{
						this._map[i][j] = Builder.loadEnemy(rand.nextInt(4) + 1);
						System.out.print(1 + " ");
					}
					else
						System.out.print(0 + " ");
			}
			System.out.print("\n");
		}
	}

	public int checkHeroPos()
	{
		int x = this._hero.getX();
		int y = this._hero.getY();
		if (x < 0 || x >= this._size)
			return(1);
		if (y < 0 || y >= this._size)
			return(1);
		return(0);
	}

	public int checkEnemyPos()
	{
		int heroX = this._hero.getX();
		int heroY = this._hero.getY();
		if ((heroX >= 0 && heroX < this._size) && (heroY >= 0 && heroY < this._size))
		{
			if (this._map[heroY][heroX] != null)
			{
				this._map[heroY][heroX].getInfo();
				return(1);
			}
		}
		return(0);
	}

	public int fight(Interface term)
	{
		int x = this._hero.getX();
		int y = this._hero.getY();
		while(true)
		{
			this._hero.attack(this._map[y][x]);
			if (this._map[y][x].getHP() <= 0)
			{
				Item droped_item = Builder.itemGenerator();
				if (droped_item != null)
				{
					term.droppedItem(droped_item, this._hero);
				}
				this._hero.expGain(this._map[y][x].getLvl());
				this._map[y][x] = null;
				return(1);
			}
			this._map[y][x].attack(this._hero);
			if (this._hero.getHP() <= 0)
				return(0);
		}
	}

	public String enemyInfo()
	{
		int x = this._hero.getX();
		int y = this._hero.getY();
		return(this._map[y][x].getInfo());
	}


}