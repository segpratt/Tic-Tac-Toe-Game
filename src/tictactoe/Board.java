package tictactoe;

/**
 * Provides data fields and methods to create a Java data-type, representing the
 * Board in a tic-tac-toe Java Application.
 *
 * @author Stewart Pratt
 * @version 1.0
 * @since September 20, 2022
 */

public class Board implements Constants {

	/**
	 * The theBoard of a Board. Char values in an array
	 */
	private char theBoard[][];
	/**
	 * The markCount of a Board
	 */
	private int markCount;

	/**
	 * Constructs a Board object. Initializes the Board array to 3x3 and to contain
	 * SPACE_CHAR for each index location.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * gets the mark of the Board with the specified values for row and col.
	 * 
	 * @param row is value of the mark on the board
	 * @param col is value of the mark on the board
	 * @return a char representing the Board's mark
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * gets the mark count of the Board.
	 * 
	 * @return an int representing the Board's markCount
	 */
	public int getMarkCount() {
		return markCount;
	}

	/**
	 * checks if the Board is full or not.
	 * 
	 * @return true if the markCount is equal to 9, and false if the markCount
	 *         doesn't equal 9
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * checks if xWins.
	 * 
	 * @return true if checkWinner(LETTER_X) == 1 and false otherwise
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * checks if oWins.
	 * 
	 * @return true if checkWinner(LETTER_O) == 1 and false otherwise
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * displays the contents of the Board with the mark values at each row and
	 * column of the Board array.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * adds a Mark to the Board with the specified values for row, col and mark.
	 * Also updates the markCount.
	 * 
	 * @param row  the row location on the board where the mark will be added
	 * @param col  the col location on the board where the mark will be added
	 * @param mark the mark that will be added to the board based on the col and row
	 */
	public void addMark(int row, int col, char mark) {
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * clears the contents of theBoard by putting a SPACE_CHAR at each location in
	 * the array and sets the markCount to 0.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks the winner of the board based on the specified mark value.
	 * 
	 * @param mark the char that is being used to check the winner of the Board.
	 * 
	 * @return result as an integer 1 if the mark has three values consecutively in
	 *         any row or col, or three values consecutively diagonally on the
	 *         Board. Otherwise the return value is 0.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Displays the column headers on the board with col and col number.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * adds Hyphens to the Board display
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * adds spaces to the Board display
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
