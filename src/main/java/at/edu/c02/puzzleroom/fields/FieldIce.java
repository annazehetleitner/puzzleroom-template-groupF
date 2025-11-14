package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;


public class FieldIce extends BaseField {
    protected FieldIce(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
    }

    @Override
    public void initialize() {
    }

    @Override
    public boolean enterField(Direction direction) {

        Field nextField;
        switch (direction) {
            case Up -> nextField = gameBoard.getField(row - 1, col);
            case Down -> nextField = gameBoard.getField(row + 1, col);
            case Left -> nextField = gameBoard.getField(row, col - 1);
            default -> nextField = gameBoard.getField(row, col + 1);
        }

        boolean successful = nextField.enterField(direction);
        if (!successful) {
            gameBoard.getPlayer().walkStep();
            setPlayerPositionToField();
        }

        return true;
    }

    @Override
    public boolean leaveField(Direction direction) {
        return true;
    }
}
