package phonebook;

import javax.swing.*;

import java.awt.event.*;
import java.util.HashSet;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class ShowAll extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public ShowAll(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Show All");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		for(String name : phoneBook.names())	{
			gui.setMessageArea(name);
			for(String number: phoneBook.findNumber(name))	{
				gui.setMessageArea(" " + number);
			}
			gui.setMessageArea("\n");
		}
	}
}
