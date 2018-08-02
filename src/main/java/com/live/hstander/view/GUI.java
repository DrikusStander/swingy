package com.live.hstander.view;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.DefaultEditor;

import com.live.hstander.controller.SqlClass;
import com.live.hstander.model.*;
import com.mysql.cj.xdevapi.JsonArray;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements Interface, ActionListener
{

	private JButton moveNorth;
	private JButton moveEast;
	private JButton moveSouth;
	private JButton moveWest;
	private int playerArea_active;
	
	private JFrame frame;
	private JTextArea outputArea;
	private JLabel consoleLabel;
	
	private int returnVal;


	public int newGame()
	{
		JButton createHero; 
		JButton loadHero;
		returnVal = 0;
		frame = new JFrame();

		frame.setLayout(null);
		frame.setSize(440, 230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outputArea = new JTextArea();
		consoleLabel = new JLabel("Console says:");

		JScrollPane outputScroll = new JScrollPane(outputArea);
		outputScroll.setBounds(220, 40, 180, 160);

		consoleLabel.setBounds(220, 20, 180, 20);
		outputArea.setBounds(220, 40, 180, 160);
		outputArea.setEditable(false);
		frame.add(outputScroll);
		frame.add(consoleLabel);
		createHero = new JButton("Create Hero");
		loadHero = new JButton("Load Hero");

		createHero.setBounds(40, 40, 140, 40);
		loadHero.setBounds(40, 80, 140, 40);

		createHero.addActionListener(this);
		loadHero.addActionListener(this);
		frame.add(createHero);
		frame.add(loadHero);

		createHero.setVisible(true);
		loadHero.setVisible(true);
		frame.setVisible(true);

		while(returnVal == 0)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{

			}
			if (returnVal != 0)
			{
				frame.remove(createHero);
				frame.remove(loadHero);
				outputArea.setText("");

				break;
			}
		}
		return(returnVal);
	}

	public String heroName()
	{
		removePlayArea();
		JLabel label = new JLabel("Enter hero name");
		JTextField textField = new JTextField();
		JButton submit;
		String str = "";
		returnVal = 0;
		submit = new JButton("Submit");
		submit.addActionListener(this);
		label.setBounds(40, 20, 140, 20);
		textField.setBounds(40, 40, 140, 20);
		submit.setBounds(40, 80, 140, 40);
		outputArea.setText("Give your Hero a name");
		
		frame.add(label);
		frame.add(textField);
		frame.add(submit);
		frame.repaint();
		while(returnVal == 0)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{

			}
			if (returnVal != 0)
			{
				str = textField.getText();
				frame.remove(label);
				frame.remove(submit);
				frame.remove(textField);
				outputArea.setText("");
				break;
			}
		}
		return(str);
	}

	public String heroClass()
	{
		JLabel label = new JLabel("Enter hero class");
		DefaultListModel listModel = new DefaultListModel<>();
		listModel.addElement("Mage");
		listModel.addElement("Elf");
		listModel.addElement("Hunter");
		listModel.addElement("Battle Mage");
		JList list = new JList<>(listModel);
		outputArea.setText("Select a class for your Hero");

		JScrollPane listScroll = new JScrollPane(list);
		listScroll.setBounds(40, 40, 140, 80);
		frame.add(listScroll);
		JButton submit;
		String str = "";
		returnVal = 0;
		submit = new JButton("Submit");
		submit.addActionListener(this);
		label.setBounds(40, 20, 140, 20);
		submit.setBounds(40, 120, 140, 40);
	
		frame.add(label);
		frame.add(submit);
		submit.setEnabled(false);
		frame.repaint();
		frame.setVisible(true);
		int index = -1;
		while(returnVal == 0)
		{
			index = list.getSelectedIndex();
			if (index != -1)
			{
				submit.setEnabled(true);
			}
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
			if (returnVal != 0)
			{
				str = (String)listModel.get(index);
				frame.remove(listScroll);
				frame.remove(label);
				frame.remove(submit);
				outputArea.setText("");
				setPlayDisplay();
				break;
			}
		}
		return(str);
	}

	private void setPlayDisplay()
	{
		playerArea_active = 1;

		moveNorth = new JButton("N");
		moveEast = new JButton("E");
		moveSouth = new JButton("S");
		moveWest = new JButton("W");

		moveNorth.setBounds(80, 40, 40, 40);
		moveEast.setBounds(120, 80, 40, 40);
		moveSouth.setBounds(80, 120, 40, 40);
		moveWest.setBounds(40, 80, 40, 40);

		moveNorth.addActionListener(this);
		moveEast.addActionListener(this);
		moveSouth.addActionListener(this);
		moveWest.addActionListener(this);

		frame.add(moveNorth);
		frame.add(moveEast);
		frame.add(moveSouth);
		frame.add(moveWest);
		frame.setVisible(true);
		frame.repaint();
	}

	private void removePlayArea()
	{
		if (playerArea_active > 0)
		{
			frame.remove(moveNorth);
			frame.remove(moveEast);
			frame.remove(moveSouth);
			frame.remove(moveWest);
			frame.setVisible(true);
			frame.repaint();
		}
		playerArea_active = 0;
	}

	public int loadHero()
	{
		JButton submit = new JButton("Submit");

		submit.addActionListener(this);
		submit.setBounds(40, 120, 140, 40);
	
		frame.add(submit);

		int maxid;
		returnVal = 0;
		maxid = SqlClass.readHeros(this);
		if (maxid > 0)
		{
			SpinnerNumberModel numberModel = new SpinnerNumberModel(1, 1, maxid, 1);
			JSpinner spinner = new JSpinner(numberModel);

			spinner.setBounds(40, 40, 140, 20);
			frame.add(spinner);
			((DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
			frame.repaint();
			spinner.setVisible(true);
			frame.setVisible(true);

			while(returnVal == 0)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
				}
				if (returnVal != 0)
				{
					returnVal = (int)spinner.getValue();
					frame.remove(spinner);
					frame.remove(submit);
					outputArea.setText("");
					setPlayDisplay();
					break;
				}
			}
		}
		else
		{
			frame.remove(submit);
			outputArea.setText("No Heros to load");
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{

			}
			
			return(-1);
		}
		return(returnVal);
	}

	public int getDir()
	{
		returnVal = 0;
		while(returnVal == 0)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
			if (returnVal != 0)
			{
				outputArea.setText("");
				break;
			}
		}
		return(returnVal);
	}

	public void gameOver(int gameOver)
	{
		removePlayArea();
		if (gameOver == 1)
			outputArea.setText("Congradulations You Won!!");
		else
			outputArea.setText("Sorry You Lost!!");

		try
		{
			Thread.sleep(4000);
		}
		catch(InterruptedException e)
		{
		}

		frame.dispose();
	}

	public void putCharacterInfo(String info)
	{
		outputArea.setText(info);
	}

	public int enemyFound(String enemyInfo)
	{
		JButton run = new JButton("Run");
		JButton fight = new JButton("Fight");
		returnVal = 0;
		removePlayArea();
		outputArea.setText("An Enemy Apeared!\n" + enemyInfo);
		fight.setBounds(40, 40, 140, 40);
		run.setBounds(40, 80, 140, 40);

		run.addActionListener(this);
		fight.addActionListener(this);

		frame.add(run);
		frame.add(fight);
		frame.repaint();
		while(returnVal == 0)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
			if (returnVal != 0)
			{
				outputArea.setText("");
				frame.remove(fight);
				frame.remove(run);
				setPlayDisplay();
				break;
			}
		}
		return(returnVal);
	}

	public void droppedItem(Item item, Hero hero)
	{
		JButton yes = new JButton("Yes");
		JButton no = new JButton("No");
		returnVal = 0;
		removePlayArea();
		yes.setBounds(40, 40, 140, 40);
		no.setBounds(40, 80, 140, 40);

		no.addActionListener(this);
		yes.addActionListener(this);

		frame.add(no);
		frame.add(yes);
		frame.repaint();
		if (item instanceof Armor)
		{
			outputArea.setText(item.getName() + " Armor Droped. Equip? Y/N");
		}
		else if (item instanceof Weapon)
		{
			outputArea.setText(item.getName() + " Droped. Equip? Y/N");
		}
		else if (item instanceof Helm)
		{
			outputArea.setText(item.getName() + " Helm Droped. Equip? Y/N");
		}
		while(returnVal == 0)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
			if (returnVal != 0)
			{
				if (returnVal == 1)
				{
					Builder.equipItem(item, hero);
				}
				outputArea.setText("");
				frame.remove(yes);
				frame.remove(no);
				setPlayDisplay();
				break;
			}
		}
	}


	public void actionPerformed(ActionEvent e) 
	{
		String event = e.getActionCommand();
		if (event.equals("Create Hero"))
		{
			returnVal = 1;
		}
		else if (event.equals("Load Hero"))
		{
			returnVal = 2;
		}
		else if (event.equals("Submit"))
		{
			returnVal = 1;
		}
		else if (event.equals("N"))
		{
			returnVal = 1;
		}
		else if (event.equals("E"))
		{
			returnVal = 2;
		}
		else if (event.equals("S"))
		{
			returnVal = 3;
		}
		else if (event.equals("W"))
		{
			returnVal = 4;
		}
		else if (event.equals("Fight"))
		{
			returnVal = 1;
		}
		else if (event.equals("Run"))
		{
			returnVal = 2;
		}
		else if (event.equals("Yes"))
		{
			returnVal = 1;
		}
		else if (event.equals("No"))
		{
			returnVal = 2;
		}
	}
}