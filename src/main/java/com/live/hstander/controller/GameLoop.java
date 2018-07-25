package com.live.hstander.controller;

public class GameLoop
{
	public static void main( String[] args )
    {
		SqlClass.readDB("SELECT * From `Enemy`");
	}
}