package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    protected void makeMove() throws NumberFormatException, IOException {
        BufferedReader stdin;
        stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n" + getName() + ", what row should your next " + getMark() + " be placed in? ");
        int row = Integer.parseInt(stdin.readLine());
        while (row > 2) {
            System.out.print("Invalid row, please enter 0, 1 or 2: ");
            row = Integer.parseInt(stdin.readLine());
        }
        setRow(row);
        System.out.print("\n" + getName() + ", what column should your next " + getMark() + " be placed in? ");
        int col = Integer.parseInt(stdin.readLine());
        while (col > 2 && col >= 0) {
            System.out.print("Invalid column, please enter 0, 1 or 2: ");
            col = Integer.parseInt(stdin.readLine());
        }
        setColumn(col);
        if (board.getMark(row, col) == opponent.getMark() || board.getMark(row, col) == getMark()) {
            System.out.print("\nInvalid selection there is already a mark there \n");
            makeMove();
        } else {
            board.addMark(row, column, mark);
        }
    }

}
