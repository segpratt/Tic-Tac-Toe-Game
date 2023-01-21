package tictactoe;

import java.io.IOException;

/**
 * Provides data fields and methods to create a Java data-type, representing a
 * Player in a tic-tac-toe Java Application.
 *
 * @author Stewart Pratt
 * @version 1.0
 * @since September 20, 2022
 */

abstract class Player {
    /**
     * The name of a Player
     */
    protected String name;
    /**
     * The board object of type Board
     */
    protected Board board;
    /**
     * The opponent object of type Player
     */
    protected Player opponent;
    /**
     * The mark of a Player
     */
    protected char mark;
    /**
     * The row of a Player
     */
    protected int row;
    /**
     * The column of a Player
     */
    protected int column;

    /**
     * Constructs a Player object with the specified values for name and mark.
     * 
     * @param name the Player object's name
     * @param mark the Player object's mark
     */
    protected Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    /**
     * sets the value of row to the specified value.
     * 
     * @param row is the new row for Player
     */
    protected void setRow(int row) {
        this.row = row;
    }

    /**
     * sets the value of column to the specified value.
     * 
     * @param column is the new column for Player
     */
    protected void setColumn(int column) {
        this.column = column;
    }

    protected int getRow() {
        return row;
    }

    protected int getColumn() {
        return column;
    }

    /**
     * gets the name of the Player.
     * 
     * @return a String representing the Player's name
     */
    protected String getName() {
        return name;
    }

    /**
     * sets the board of the Player to the specified Board object.
     * 
     * @param board is the new Board for Player
     */
    protected void setBoard(Board board) {
        this.board = board;
    }

    /**
     * sets the opponent of the player to the specified Player object.
     * 
     * @param opponent is the new opponent for Player
     */
    protected void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * gets the mark of the Player.
     * 
     * @return a char representing the Player's mark
     */
    protected char getMark() {
        return mark;
    }

    /**
     * Allows the Player to play the game. Calls the makeMove() method and display
     * method from the Board class. If the XPlayer or OPlayer wins the game, or if
     * the board is full, the game is over. Else the XPlayer and OPlayer keep
     * playing.
     * 
     * @throws IOException
     */
    protected void play() throws IOException {
        while (true) {
            makeMove();
            board.display();
            if (board.xWins() == true) {
                System.out.println("\nTHE GAME IS OVER: " + getName() + " is the winner!.... game ended\n");
                break;
            } else if (board.isFull() == true) {
                System.out.println("\nTHE GAME IS OVER, it has ended in a tie!.... game ended\n");
                break;
            } else {
                opponent.makeMove();
                board.display();
                if (board.oWins() == true) {
                    System.out.println("\nTHE GAME IS OVER: " + opponent.getName() + " is the winner.... game ended\n");
                    break;
                }
                continue;
            }
        }
    }

    /**
     * Allows the Player to make a move on the board. Allows the user to input a
     * number for row or column, only allows integers of 0,1,2 as the input. The
     * Player's column and row get set, and the mark gets added to the board.
     * 
     * @throws NumberFormatException
     * 
     * @throws IOException
     */
    abstract protected void makeMove() throws NumberFormatException, IOException;

}
