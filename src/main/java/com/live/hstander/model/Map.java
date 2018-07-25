package com.live.hstander.model;

import java.util.ArrayList;
import java.util.Random;

public class Map
{
	private Hero _hero;
	private Enemy[][] _map;
	private int _size;

	public Map(Hero hero, int size)
	{
		this._hero = hero;
		this.getMapSize(size);
		this._map = new Enemy[this._size][this._size];
		
		this.generateEnemies();
		System.out.println("map size is : " + this._size + " x " + this._size);
	}

	private void getMapSize(int size)
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
}