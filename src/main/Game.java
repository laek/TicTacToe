package main;


import java.util.Arrays;

public class Game {
    private String[] board;
    private String player;
    private String winner;

    public Game() {
        this.board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        this.player = "X";
        this.winner = null;
    }

    public void placeMove(String move) {
        this.board[Integer.parseInt(move) - 1] = this.player;
    }

    public void switchPlayer() {
        if (this.player.equals("X")) {
            this.player = "O";
        } else {
            this.player = "X";
        }
    }

    public void checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            if (line.equals("XXX")) {
                this.winner = "X";
            } else if (line.equals("OOO")) {
                this.winner = "O";
            }
        }

        // checking for a draw
        String draw = null;
        for (int a = 1; a < 10; a++) {
            if (Arrays.asList(board).contains(Integer.toString(a))) {
                draw = "board not full";
            }
        }

        if (draw == null) {
            this.winner = "draw";
        }

    }

    public String[] getBoard() {
        return this.board;
    }

    public String getPlayer() {
        return this.player;
    }

    public String getWinner() {
        return this.winner;
    }
}
