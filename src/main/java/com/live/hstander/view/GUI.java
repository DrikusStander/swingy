package com.live.hstander.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.live.hstander.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements Interface, ActionListener
{


	private JButton _moveNorth; 
	private JButton _moveEast; 
	private JButton _moveSouth; 
	private JButton _moveWest; 
	JFrame frame;
	JButton createHero; 
	JButton loadHero;
	private int returnVal;


	public int newGame()
	{
		
		returnVal = 0;
		frame = new JFrame();
		// GuiEvents evl = new GuiEvents();
		// this._frame.getContentPane().setLayout(new GridLayout());
		createHero = new JButton("Create Hero");
		loadHero = new JButton("Load Hero");
		this._moveNorth = new JButton("N");
		this._moveEast = new JButton("E");
		this._moveSouth = new JButton("S");
		this._moveWest = new JButton("W");

		createHero.setBounds(40, 40, 140, 40);
		loadHero.setBounds(40, 80, 140, 40);
		this._moveNorth.setBounds(600, 330, 40, 40);
		this._moveEast.setBounds(640, 350, 40, 40);
		this._moveWest.setBounds(560, 350, 40, 40);
		this._moveSouth.setBounds(600, 370, 40, 40);

		createHero.addActionListener(this);
		frame.add(createHero);
		frame.add(loadHero);

		// if ()
		// this._frame.add(this._moveNorth);
		// this._frame.add(this._moveEast);
		// this._frame.add(this._moveWest);
		// this._frame.add(this._moveSouth);

		frame.setSize(220, 170);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		while(returnVal == 0)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				
			}
			System.out.println(returnVal);
			if (returnVal != 0)
			{
				System.out.println("break");
				break;
			}
		}
		return(returnVal);
	}

	public String heroName()
	{
		JButton submit;
		submit = new JButton("Submit");

		submit.setBounds(40, 80, 140, 40);
		
		frame.add(submit);
		return("");
	}

	public String heroClass()
	{
		return("");
	}

	public int loadHero()
	{
		return(0);
	}

	public int getDir()
	{
		return(0);
	}

	public void gameOver(int gameOver)
	{
		if (gameOver == 1)
		{

		}
		else
		{
			
		}
	}

	public void putCharacterInfo(String info)
	{

	}

	public int enemyFound(String enemyInfo)
	{
		return(0);
	}

	public void droppedItem(Item item, Hero hero)
	{
		return;
	}


	public void actionPerformed(ActionEvent e) 
	{
		String event = e.getActionCommand();
		if (event.equals("Create Hero"))
		{
			returnVal = 1;
			System.out.println("success" + returnVal);
		}
		else if (event.equals("Load Hero"))
		{
			System.out.println("success");
		}
	}
}