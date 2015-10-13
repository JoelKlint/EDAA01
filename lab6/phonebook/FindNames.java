package phonebook;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class FindNames extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public FindNames(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find Names");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String number = JOptionPane.showInputDialog("Skriv in ett nummer");
		if (number != null) {
			if (phoneBook.findNames(number).isEmpty()) {
				gui.setMessageArea("Det finns inga namn kopplade till det numret!");
			} else {
				for (String name : phoneBook.findNames(number)) {
					gui.setMessageArea(name + "\n");
				}
			}
		}
	}
}
