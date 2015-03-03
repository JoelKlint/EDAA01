package phonebook;

import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.util.*;

public class PhoneBookGUI extends JFrame {
	private PhoneBook phoneBook;
	JTextArea messageArea;

	public PhoneBookGUI(PhoneBook pb) {
		super("PhoneBook");
		phoneBook = pb;
		String fileName = JOptionPane
				.showInputDialog("Vilken sparfil vill du läsa in?");
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fileName+".txt"));
			phoneBook = (PhoneBook) in.readObject();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sparfilen kunde inte hittas.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sparfilen kunde inte läsas.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.exit(0);
		}

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		Locale.setDefault(new Locale("en"));
		/* To avoid hardcoded Swedish text on OptionPane dialogs */
		UIManager.put("OptionPane.cancelButtonText", "Cancel");

		setLayout(new BorderLayout());
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu editMenu = new JMenu("Edit");
		menubar.add(editMenu);
		editMenu.add(new AddMenu(phoneBook, this));
		editMenu.add(new RemoveMenu(phoneBook, this));
		JMenu findMenu = new JMenu("Find");
		menubar.add(findMenu);
		findMenu.add(new FindNumbers(phoneBook, this));
		findMenu.add(new FindNames(phoneBook, this));
		JMenu viewMenu = new JMenu("View");
		menubar.add(viewMenu);
		viewMenu.add(new ShowAll(phoneBook, this));

		JPanel southPanel = new JPanel();
		messageArea = new JTextArea(4, 25);
		messageArea.setEditable(false);
		southPanel.add(new JScrollPane(messageArea));
		southPanel.add(new QuitButton(phoneBook, this));
		add(southPanel, BorderLayout.CENTER);

		pack();

		setVisible(true);
	}

	public void setMessageArea(String string) {
		messageArea.append(string);
	}
}
