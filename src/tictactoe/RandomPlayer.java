package tictactoe;

public class RandomPlayer extends Player {

    private RandomGenerator random;

    public RandomPlayer(String name, char mark, RandomGenerator random) {
        super(name, mark);
        this.random = random;
    }

    @Override
    protected void makeMove() {
        setRow(random.discrete(0, 2));
        setColumn(random.discrete(0, 2));
        if (board.getMark(getRow(), getColumn()) == opponent.getMark()
                || board.getMark(getRow(), getColumn()) == getMark()) {
            System.out.print("\nInvalid selection there is already a mark there \n");
            makeMove();
        } else {
            board.addMark(getRow(), getColumn(), getMark());
        }

    }

}
