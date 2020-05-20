package test;

import main.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game testGame;

    @BeforeEach
    void setUp(){
        testGame = new Game();
    }


    @Test
    void createBoard() {
        int boardSize = testGame.getBoard().length;
        Assertions.assertEquals(9, boardSize);
    }

    @Test
    void boardPopulatedInitiallyWithNumbers() {
        String[] expected = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Assertions.assertArrayEquals(expected, testGame.getBoard());
    }

    @Test
    void playerCanPlaceAMark() {
        testGame.placeMove("1");
        String[] expected = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        Assertions.assertArrayEquals(expected, testGame.getBoard());
    }

    @Test
    void playerCanPlaceMultipleMarks() {
        testGame.placeMove("1");
        testGame.placeMove("3");
        String[] expected = {"X", "2", "X", "4", "5", "6", "7", "8", "9"};
        Assertions.assertArrayEquals(expected, testGame.getBoard());
    }

    @Test
    void playersTakeTurns() {
        testGame.switchPlayer();
        Assertions.assertEquals("O", testGame.getPlayer());
    }

    @Test
    void playersHaveDifferentMarks() {
        testGame.placeMove("1");
        testGame.switchPlayer();
        testGame.placeMove("3");
        String[] expected = {"X", "2", "O", "4", "5", "6", "7", "8", "9"};
        Assertions.assertArrayEquals(expected, testGame.getBoard());
    }

    @Test
    void thereIsAWinner() {
        String winner = testGame.getWinner();
        Assertions.assertEquals(null, winner);
    }

    @Test
    void checksWhoWon() {
        testGame.placeMove("1");
        testGame.placeMove("2");
        testGame.placeMove("3");
        testGame.checkWinner();
        String testWinner = testGame.getWinner();
        Assertions.assertEquals("X", testWinner);
    }

    @Test
    void checksADraw() {
        testGame.placeMove("1");
        testGame.placeMove("3");
        testGame.placeMove("5");
        testGame.placeMove("8");
        testGame.switchPlayer();
        testGame.placeMove("2");
        testGame.placeMove("4");
        testGame.placeMove("6");
        testGame.placeMove("7");
        testGame.placeMove("9");
        testGame.checkWinner();
        String testWinner = testGame.getWinner();
        Assertions.assertEquals("draw", testWinner);
    }
}


