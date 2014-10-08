package calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorInterface {
	private Stack stack;
	
	public CalculatorInterface(Stack stack)	{
		this.stack = stack;
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(nbrs(), BorderLayout.SOUTH);
		frame.add(operations(), BorderLayout.WEST);
		frame.add(extraButtons(), BorderLayout.EAST);
		frame.add(output(), BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.pack();
	}
	
	public JPanel nbrs()	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 3));
		
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		panel.add(new JButton("clr"));
		panel.add(new JButton("0"));
		panel.add(new JButton("clrstck"));
		return panel;
	}
	
	public JPanel operations()	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		
		panel.add(new JButton("+"));
		panel.add(new JButton("-"));
		panel.add(new JButton("x"));
		panel.add(new JButton("/"));
	
		return panel;
	}
	
	public JPanel extraButtons()	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		
		panel.add(new JButton("Chnge"));
		panel.add(new JButton("Enter"));
		return panel;
	}
	
	public JPanel output()	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		
		JLabel label0 = new JLabel(Integer.valueOf(stack.get(0)).toString());
		JLabel label1 = new JLabel(Integer.valueOf(stack.get(1)).toString());
		JLabel label2 = new JLabel(Integer.valueOf(stack.get(2)).toString());
		JLabel label3 = new JLabel(Integer.valueOf(stack.get(3)).toString());
		
		panel.add(label0);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		return panel;
	}
	
	

}
