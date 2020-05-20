package main;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private Game game;

    public UserInterface() {
        this.game = new Game();
        this.scanner = new Scanner(System.in);
    }

    public void playGame() {
        System.out.println("Welcome to TicTacToe! ");

        while (game.getWinner() == null) {
            printGrid();
            System.out.println("Player " + game.getPlayer() + " - choose your move ");
            String move = scanner.nextLine();
            game.placeMove(move);
            game.checkWinner();
            game.switchPlayer();
        }

        printGrid();
        if (game.getWinner().equals("X")) {
            System.out.println("Congrats player X - you won!");
        } else if (game.getWinner().equals("O")) {
            System.out.println("Congrats player O - you won!");
        } else if (game.getWinner().equals("draw")) {
            System.out.println("It's a draw!");
        }

    }

    public void printGrid() {

        System.out.println(" " + game.getBoard()[0] + " | " + game.getBoard()[1] + " | " + game.getBoard()[2]);
        System.out.println("--- --- ---");
        System.out.println(" " + game.getBoard()[3] + " | " + game.getBoard()[4] + " | " + game.getBoard()[5]);
        System.out.println("--- --- ---");
        System.out.println(" " + game.getBoard()[6] + " | " + game.getBoard()[7] + " | " + game.getBoard()[8]);
        System.out.println("--- --- ---");
    }
}
