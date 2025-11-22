package at.edu.c02.puzzleroom.commands;


import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.Player;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomException;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomInvalidMoveException;

public class CommandFastmove implements Command {

    private final String[] arguments;

    public CommandFastmove( String[] arguments) {
        this.arguments = arguments; // WICHTIG: speichern, kein length-Check
    }


    @Override
    public void execute(GameBoard gameBoard) throws PuzzleRoomException {
        Player player = gameBoard.getPlayer();

        for (String arg : arguments) {
            boolean success;

            switch (arg) {
                case "u":
                    success = player.moveUp();
                    break;
                case "d":
                    success = player.moveDown();
                    break;
                case "l":
                    success = player.moveLeft();
                    break;
                case "r":
                    success = player.moveRight();
                    break;
                default:
                    // Wenn ihr wollt: unbekannte Argumente direkt als ungültigen Move behandeln
                    throw new PuzzleRoomInvalidMoveException();
            }

            if (!success) {
                // sobald eine Bewegung nicht möglich ist -> Exception, keine weiteren Moves
                throw new PuzzleRoomInvalidMoveException();
            }
        }

        // Wenn alles erfolgreich war: genau wie in CommandMove
        // automatisch einmal show ausführen
        Command showCommand = new CommandShow();
        showCommand.execute(gameBoard);
    }
}
