package phonebook;

import javax.swing.*;

import java.awt.HeadlessException;
import java.awt.event.*;

@SuppressWarnings("serial")
public class FindNumbers extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public FindNumbers(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find Numbers");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog("Skriv in ett namn");
		if (name != null) {
			if (phoneBook.findNumber(name).isEmpty()) {
				gui.setMessageArea("Namnet finns inte i listan");
			}
			for (String number : phoneBook.findNumber(name)) {
				gui.setMessageArea(number + "\n");
			}
		}
	}
}
