package com.live.hstander.view;

import com.live.hstander.model.*;

public interface Interface
{
	public int newGame();
	public String heroName();
	public String heroClass();
	public int loadHero();
	public int getDir();
	public void gameOver(int gameOver);
	public void putCharacterInfo(String info);
	public int enemyFound(String enemyInfo);
	public void droppedItem(Item item, Hero hero);
}
