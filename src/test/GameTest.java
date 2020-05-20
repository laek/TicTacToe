package test;

import main.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {


    @Test
    void createBoard() {
        Game testGame = new Game();
        int boardSize = testGame.getBoard().length;
        Assertions.assertEquals(9, boardSize);
    }

    @Test
    void boardPopulatedInitiallyWithNumbers() {
        Game testGame = new Game();
        String[] expected = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Assertions.assertArrayEquals(expected, testGame.getBoard());
    }

    @Test
    void playerCanPlaceAMark() {
        Game testGame = new Game();
        testGame.placeMove("1");
        String[] expected = {"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        Assertions.assertArrayEquals(expected, testGame.getBoard());
    }

    @Test
    void playerCanPlaceMultipleMarks() {
        Game testGame = new Game();
        testGame.placeMove("1");
        testGame.placeMove("3");
        String[] expected = {"X", "2", "X", "4", "5", "6", "7", "8", "9"};
        Assertions.assertArrayEquals(expected, testGame.getBoard());
    }

    @Test
    void playersTakeTurns() {
        Game testGame = new Game();
        testGame.switchPlayer();
        Assertions.assertEquals("O", testGame.getPlayer());
    }

    @Test
    void playersHaveDifferentMarks() {
        Game testGame = new Game();
        testGame.placeMove("1");
        testGame.switchPlayer();
        testGame.placeMove("3");
        String[] expected = {"X", "2", "O", "4", "5", "6", "7", "8", "9"};
        Assertions.assertArrayEquals(expected, testGame.getBoard());
    }

    @Test
    void thereIsAWinner() {
        Game testGame = new Game();
        String winner = testGame.getWinner();
        Assertions.assertEquals(null, winner);
    }

    @Test
    void checksWhoWon() {
        Game testGame = new Game();
        testGame.placeMove("1");
        testGame.placeMove("2");
        testGame.placeMove("3");
        testGame.checkWinner();
        System.out.println("get winner: " + testGame.getWinner());
        String testWinner = testGame.getWinner();
        System.out.println("testwinner:" + testWinner);
        Assertions.assertEquals("X", testWinner);
    }
}


