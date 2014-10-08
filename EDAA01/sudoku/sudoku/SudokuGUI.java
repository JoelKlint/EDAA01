package sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SudokuGUI {
	private SudokuSquare[][] GUISquares;
	private SudokuSolver sudoku;
	
	/**
	 * Creates a GUI for playing sudoku.
	 * @param sudoku Solver to solve the sudoku.
	 */
	//I denna metod skapar vi hela fönstret och dess komponenter.
	public SudokuGUI(SudokuSolver sudoku) {
		GUISquares = new SudokuSquare[9][9];
		this.sudoku = sudoku;
		
		JFrame frame = new JFrame("Sudoku Solver");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel gridPanel = new JPanel();
		frame.add(gridPanel, BorderLayout.NORTH);
		gridPanel.setLayout(new GridLayout(9, 9));
		JPanel buttonPanel = new JPanel();
		frame.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.add(new SolveButton());
		buttonPanel.add(new ClearButton());
		//Skapar rutor och färgar dem.
		for (int x = 0; x < 9; x++) {
			Color c = new Color(200, 250, 250);
			for (int y = 0; y < 9; y++) {
				SudokuSquare sq = new SudokuSquare();
				if (x < 3 || x > 5) {
					if (y < 3 || y > 5)
						sq.color(c);
				} else if (y > 2 && y < 6) {
					sq.color(c);
				}
				GUISquares[x][y] = sq;
				gridPanel.add(sq);
			}
		}

		frame.setSize(230, 330);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	class SolveButton extends JButton implements ActionListener {
		
		/**
		 * Creates a new Solve Button
		 */
		public SolveButton() {
			super("Solve");
			addActionListener(this);

		}
		
		/**
		 * Action performed when button is pressed
		 */
		public void actionPerformed(ActionEvent e) {
			sudoku.removeAll();
			//Läs in de tal som användaren skrivit in.
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
					try {
						sudoku.put(
								Integer.parseInt(GUISquares[x][y].getText()),
								x, y);
					} catch (NumberFormatException e1) {
					}
				}
			}
			//Löser sudokun
			if (sudoku.isLegal() && sudoku.solveTable()) {
				for (int x = 0; x < 9; x++) {
					for (int y = 0; y < 9; y++) {
						//Skriver ut lösningen
						GUISquares[x][y].setText(sudoku.get(x, y));
					}
				}
			} else {
				//Ingen lösning hittades
				JOptionPane.showMessageDialog(null,
						"No solution found, please try again");
			}
		}
	}

	class ClearButton extends JButton implements ActionListener {
		
		/**
		 * Creates a new Solve Button
		 */
		public ClearButton() {
			super("Clear");
			addActionListener(this);

		}
		
		/**
		 * Action performed when button is pressed
		 */
		public void actionPerformed(ActionEvent e) {
			//Tömmer både sudokusolvern och GUI.
			sudoku.removeAll();
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
					GUISquares[x][y].setText("");
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SudokuGUI GUI = new SudokuGUI(new SudokuSolver());
	}
}
