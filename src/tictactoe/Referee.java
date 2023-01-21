package tictactoe;

import java.io.IOException;

/**
 * Provides data fields and methods to create a Java data-type, representing a
 * Referee in a tic-tac-toe Java Application.
 *
 * @author Stewart Pratt
 * @version 1.0
 * @since September 20, 2022
 */

public class Referee {

    /**
     * The xPlayer object of type Player
     */
    private Player xPlayer;
    /**
     * The oPlayer object of type Player
     */
    private Player oPlayer;
    /**
     * The board object of type Board
     */
    private Board board;

    /**
     * Constructs a Referee object with the default values.
     */
    public Referee() {
    }

    /**
     * Allows the Referee to run the game. Sets the opponent of each player,
     * displays the board and allows the XPlayer to play first.
     * 
     * @throws IOException
     */
    public void runTheGame() throws IOException {
        oPlayer.setOpponent(xPlayer);
        xPlayer.setOpponent(oPlayer);
        board.display();
        xPlayer.play();
    }

    /**
     * sets the board of the Referee to the specified Board object.
     * 
     * @param board is the new Board for Referee
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * sets the oPlayer of the Referee to the specified Player object.
     * 
     * @param oPlayer is the new Player for Referee
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * sets the xPlayer of the Referee to the specified Player object.
     * 
     * @param xPlayer is the new Player for Referee
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }

}
