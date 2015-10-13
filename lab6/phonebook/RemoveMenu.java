package phonebook;
import javax.swing.*;

import java.awt.event.*;

public class RemoveMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public RemoveMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Remove");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 String name = JOptionPane.showInputDialog("Skriv in ett namn att ta bort");
		 if(phoneBook.remove(name))	{
			 gui.setMessageArea("Name removed!" + "\n");
		 }
		 else	{
			 gui.setMessageArea("Name was not present!" + "\n");
		 }
	 }
}
