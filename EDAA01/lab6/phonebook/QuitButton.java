package phonebook;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;

public class QuitButton extends JButton implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public QuitButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Quit");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String fileName = JOptionPane
				.showInputDialog("Vad ska sparfilen döpas till?");
		if (fileName != null) {
			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(fileName+".txt"));
				out.writeObject(phoneBook);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.exit(1);
		}
	}
}
