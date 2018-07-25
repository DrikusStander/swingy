package com.live.hstander.model;

public class Item
{
	private String _name;
	private int _buff;

	Item(String name, int buff)
	{
		this._name = name;
		this._buff = buff;
	}

	public int getBuff()
	{
		return(this._buff);
	}

	public String getName()
	{
		return(this._name);
	}
}