package engine;

import enums.Coordinates;
import messages.ErrorMessages;
import models.board.Board;
import models.figures.Dwarf;
import models.player.Player;
import models.figures.base.Figure;
import models.figures.Horse;
import validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game implements Runnable {
    private final List<Player> players;
    private boolean isGameOver;
    private final Board board;
    private final Scanner scanner;
    private Player currentPlayer;

    public Game(Scanner scanner, List<Player> players) {
        this.players = players;
        this.board = new Board();
        this.scanner = scanner;
        this.currentPlayer = players.get(0);

    }

    @Override
    public void run() {
        while (!isGameOver) {
            this.board.printTheBoard();
            this.incrementCurrentPlayerMove();
            System.out.printf("Current player:%s with color: %s and move number: %d \n", this.currentPlayer.getName(), this.currentPlayer.getColor(), this.currentPlayer.getMoveCounter());

            int[] currentCoordinates = null;
            int[] desiredCoordinates = null;

            int currentRow = 0;
            int currentCol = 0;

            int desiredRow = 0;
            int desiredCol = 0;

            do {
                System.out.println("Enter current coordinates(row,col) from A-F");
                currentCoordinates = readTheInput();

                System.out.println("Enter desired coordinates(row,col) from A-F");
                desiredCoordinates = readTheInput();

                if ((currentCoordinates == null || desiredCoordinates == null)) {
                    continue;
                }

                currentRow = currentCoordinates[0];
                currentCol = currentCoordinates[1];
                desiredRow = desiredCoordinates[0];
                desiredCol = desiredCoordinates[1];

            } while ((currentCoordinates == null || desiredCoordinates == null) || !this.isCoordinatesValid(currentRow, currentCol, desiredRow, desiredCol));

            if (this.board.getBoard()[desiredRow][desiredCol].contains("K")) {
                this.isGameOver = true;
                break;

            }

            setNewPositions(currentRow, currentCol, desiredRow, desiredCol);

            this.changePlayers();

        }
        System.out.printf("The winner is %s with color:%s", currentPlayer.getName(), currentPlayer.getColor());
    }

    private int[] readTheInput() {
        int[] result;
        try {
            result = Arrays.stream(scanner.nextLine().split("")).map(e -> Coordinates.valueOf(e).getValue()).mapToInt(Integer::intValue).toArray();
            if (result.length != 2) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input..!");
            return null;
        }
        return result;
    }

    private void changePlayers() {
        this.currentPlayer = this.currentPlayer.getColor() == 'w' ? this.players.get(1) : this.players.get(0);
    }

    private void incrementCurrentPlayerMove() {
        this.currentPlayer.increaseMoveCounter();
    }

    private void setNewPositions(int currentRow, int currentCol, int desiredRow, int desiredCol) {

        String figure = this.board.getBoard()[currentRow][currentCol];
        this.board.changeFigurePosition(currentRow, currentCol, desiredRow, desiredCol, figure);
    }


    private boolean isCoordinatesValid(int currentRow, int currentCol, int desiredRow, int desiredCol) {

        if (!Validator.isValid(this.board, this.currentPlayer, currentRow, currentCol, desiredRow, desiredCol)) {
            System.out.print(Validator.getMessages());
            return false;
        }

        String currentPosition = this.board.getBoard()[currentRow][currentCol].replaceAll("[\\\\| ]+", "");

        int rowDiff = currentRow - desiredRow;
        int colDiff = currentCol - desiredCol;

        Figure figure = this.currentPlayer.getFigures().get(currentPosition);

        if (figure instanceof Horse) {
            ((Horse) figure).setMoveCounter(this.currentPlayer.getMoveCounter());
        } else if (figure instanceof Dwarf) {
            ((Dwarf) figure).setPlayerColor(String.valueOf(this.currentPlayer.getColor()));
        }

        if (figure.isMoveValid(rowDiff, colDiff)) {
            return true;
        } else {
            System.out.println(ErrorMessages.INVALID_FIGURE_MOVE_BY_RULES);
            System.out.printf("%s rules:%s\n", figure.getName(), figure.getDescription());
            return false;
        }

    }

}
