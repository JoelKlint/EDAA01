package sudoku;

public class SudokuSolver {
	private int[][] matrix;

	/**
	 * Creates a new Sudoku Solver
	 */
	public SudokuSolver() {
		matrix = new int[9][9];
	}

	/**
	 * Returns the value of square x, y.
	 * @param x x position
	 * @param y y position
	 * @return	the value in the square 
	 */
	public String get(int x, int y) {
		return "" + matrix[x][y];
	}

	/**
	 * Inserts the value val and position x and Y
	 * @param val value to be inserted
	 * @param x x position
	 * @param y y position
	 */
	public void put(int val, int x, int y) {
		matrix[x][y] = val;
	}

	/**
	 * Clears the Sudoku solver
	 */
	public void removeAll() {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				matrix[x][y] = 0;

			}
		}
	}
	/**
	 * Solves the Sudoku
	 * @return true if solved, false if not solved
	 */
	public boolean solveTable() {
		return solve(0, 0);
	}
	
	private boolean solve(int x, int y) {
		//Ser till att vi alltid stannar inom ramarna
		if (x >= 9) {
			x = 0;
			y++;
			if (y >= 9) {
				return true;
			}
		}
		//Om rutan redan är fylld
		if (matrix[x][y] != 0) {
			return solve(x + 1, y);
		} else {
			//testar alla värden
			for (int i = 1; i <= 9; i++) {
				if (doesItWork(i, x, y)) {
					matrix[x][y] = i;

					if (solve(x + 1, y)) {
						return true;
					}
				}
			}
			matrix[x][y] = 0;
		}
		return false;
	}
	/**
	 * Checks if the table is following the rules of sudoku
	 * @return true if legal, false if not.
	 */
	public boolean isLegal() {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (matrix[x][y] != 0) {
					if (!doesItWork(matrix[x][y], x, y)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private boolean doesItWork(int val, int x, int y) {
		//Kollar upp och ner
		for (int tempY = 0; tempY < 9; tempY++) {
			if (tempY != y) {
				if (matrix[x][tempY] != 0) {
					if (matrix[x][tempY] == val) {
						return false;
					}
				}
			}
		}
		//Kollar höger och vänster
		for (int tempX = 0; tempX < 9; tempX++) {
			if (tempX != x) {
				if (matrix[tempX][y] != 0) {
					if (matrix[tempX][y] == val) {
						return false;
					}
				}
			}
		}
		//Kollar regionen.
		int rX = (x / 3) * 3;
		int rY = (y / 3) * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (rX + i != x && rY + j != y) {
					if (matrix[rX + i][rY + j] != 0) {
						if (matrix[rX + i][rY + j] == val) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
