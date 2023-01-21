package tictactoe;

public class SmartPlayer extends BlockingPlayer {

    public SmartPlayer(String name, char mark, RandomGenerator random) {
        super(name, mark, random);
    }

    protected boolean testForWinning(int row1, int col1) {
        boolean result = false;
        int row_result = 0;
        int col_result = 0;
        int row = 0;
        int col = 0;

        for (col = 0; col < 3; col++) {
            row = row1;
            if (board.getMark(row, col) == getMark())
                row_result += 1;
        }
        if (row_result == 2 && board.getMark(row1, col1) != opponent.getMark()
                && board.getMark(row1, col1) != getMark())
            result = true;

        for (row = 0; row < 3; row++) {
            col = col1;
            if (board.getMark(row, col) == getMark())
                col_result += 1;
        }
        if (col_result == 2 && board.getMark(row1, col1) != opponent.getMark()
                && board.getMark(row1, col1) != getMark())
            result = true;

        int diag1Result = 0;
        int col2 = 0;
        int row2 = 0;
        if ((result == false) && row1 == 0 && col1 == 0 || row1 == 1 && col1 == 1 || row1 == 2 && col1 == 2)
            while (diag1Result != 2 && row2 < 3 && col2 < 3) {
                if (board.getMark(row2, col2) == getMark()) {
                    diag1Result++;
                    row2++;
                    col2++;
                } else {
                    row2++;
                    col2++;
                }
            }
        if (diag1Result == 2 && board.getMark(row1, col1) != opponent.getMark()
                && board.getMark(row1, col1) != getMark())
            result = true;

        int diag2Result = 0;
        int col3 = 2;
        int row3 = 0;
        if ((result == false) && row1 == 0 && col1 == 2 || row1 == 1 && col1 == 1 || row1 == 2 && col1 == 0)
            while (diag2Result != 2 && row3 < 3 && col3 > -1) {
                if (board.getMark(row3, col3) == getMark()) {
                    diag2Result++;
                    row3++;
                    col3--;
                } else {
                    row3++;
                    col3--;
                }
            }
        if (diag2Result == 2 && board.getMark(row1, col1) != opponent.getMark()
                && board.getMark(row1, col1) != getMark())
            result = true;

        return result;
    }

    @Override
    protected void makeMove() {
        boolean testWinning = false;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (testForWinning(row, col) == true) {
                    testWinning = true;
                    setRow(row);
                    setColumn(col);
                    board.addMark(getRow(), getColumn(), getMark());
                    break;
                }
            }
            if (testWinning == true) {
                break;
            }
        }
        if (testWinning == false) {
            super.makeMove();
        }
    }

}
