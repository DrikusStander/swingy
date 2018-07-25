package com.live.hstander.model;

public class Item
{
	protected String _name;
	protected int _buff;
	protected int _item_index;

	Item(String name, int buff, int index)
	{
		this._name = name;
		this._buff = buff;
		this._item_index = index;
	}

	public int getBuff()
	{
		return(this._buff);
	}

	public String getName()
	{
		return(this._name);
	}

	public int getIndex()
	{
		return(this._item_index);
	}
}