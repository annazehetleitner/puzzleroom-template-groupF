package at.edu.c02.puzzleroom;

import at.edu.c02.puzzleroom.commands.CommandFastmove;
import at.edu.c02.puzzleroom.commands.CommandLoad;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomInvalidMoveException;

import org.junit.Test;

public class CommandFastmoveTest {

    @Test
    public void fastmovePositiveTest() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        new CommandLoad(new String[]{"src/test/resources/fastmove_positive.maze"}).execute(gameBoard);

        // Beispielmaze:
        // #######
        // #o   x#
        // #######
        //
        // Spieler muss 4x nach rechts

        new CommandFastmove(new String[]{"r", "r", "r", "r"}).execute(gameBoard);

        // Keine Exception = Test bestanden
    }

    @Test(expected = PuzzleRoomInvalidMoveException.class)
    public void fastmoveNegativeTest() throws Exception {
        GameBoard gameBoard = new GameBoardImpl();
        new CommandLoad(new String[]{"src/test/resources/fastmove_negative.maze"}).execute(gameBoard);

        // Beispielmaze:
        // #######
        // #o # x#
        // #######
        //
        // 2. Schritt nach rechts geht gegen Wand → Exception erwartet

        new CommandFastmove( new String[]{"r", "r", "r"}).execute(gameBoard);
    }
}