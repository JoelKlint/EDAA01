package phonebook;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public AddMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Add");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 String name = JOptionPane.showInputDialog("Skriv in ett namn");
		 String number = JOptionPane.showInputDialog("Skriv in ett nummer");
		 if(phoneBook.put(name, number))	{
			 gui.setMessageArea("Number added!" + "\n");
		 }
		 else	{
			 gui.setMessageArea("Number did already excist!" + "\n");
		 }
		 
		 
	 }
}
