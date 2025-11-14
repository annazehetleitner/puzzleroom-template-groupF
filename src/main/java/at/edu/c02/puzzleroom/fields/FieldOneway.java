package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;

    public class FieldOneway extends BaseField {
        public FieldOneway(GameBoard gameBoard, char name, int row, int col) {
            super(gameBoard, name, row, col);
        }

        @Override
        public void initialize() {
        }

        @Override
        public boolean enterField(Direction direction) {
            gameBoard.getPlayer().walkStep();
            setPlayerPositionToField();
            return true;
        }
        @Override
        public boolean leaveField(Direction direction) {

            if (name == '^' && direction != Direction.Up) {
                return false;
            }
            if (name == 'v' && direction != Direction.Down) {
                return false;
            }
            if (name == '<' && direction != Direction.Left) {
                return false;
            }
            if (name == '>' && direction != Direction.Right) {
                return false;
            }

             return true;
        }
}
