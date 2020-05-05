package models.board;

import java.util.Arrays;


public class Board {
    private final String[][] board;

    public Board() {
        this.board = new String[][]{{"|wDwL|", "| wD |", "| wQ |", "| wK |", "| wM |", "|wDwR|", " A"}, {"| x  |", "| x  |", "| x  |", "| x  |", "| x  |", "| x  |", " B"}, {"| x  |", "| x  |", "| x  |", "| x  |", "| x  |", "| x  |", " C"},
                {"| x  |", "| x  |", "| x  |", "| x  |", "| x  |", "| x  |", " D"}, {"| x  |", "| x  |", "| x  |", "| x  |", "| x  |", "| x  |", " E"}, {"|bDwL|", "| bM |", "| bK |", "| bQ |", "| bD |", "|bDwR|", " F"}, {"  A  ", "   B  ", "   C  ", "   D  ", "   E  ", "   F  "}};
    }

    public String[][] getBoard() {
        return Arrays.copyOf(this.board, this.board.length);
    }

    public void changeFigurePosition(int oldPositionRow, int oldPositionCol, int desiredRow, int desiredCol, String figure) {
        this.board[desiredRow][desiredCol] = figure;
        this.board[oldPositionRow][oldPositionCol] = "| x  |";
    }

    public void printTheBoard() {

        for (String[] strings : this.board) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        System.out.println();
    }


}
