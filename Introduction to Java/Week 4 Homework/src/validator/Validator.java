package validator;

import messages.ErrorMessages;
import models.board.Board;
import models.player.Player;

public final class Validator {
    private static StringBuilder sb;

    private Validator() {

    }

    public static boolean isValid(Board board, Player currentPlayer, int currentRow, int currentCol, int desiredRow, int desiredCol) {

        String currentPosition = board.getBoard()[currentRow][currentCol].replaceAll("[\\\\| ]+", "");
        String desiredPosition = board.getBoard()[desiredRow][desiredCol].replaceAll("[\\\\| ]+", "");

        sb = init();

        boolean result = true;
        if (currentPosition.charAt(0) != currentPlayer.getColor()) {
            sb.append(ErrorMessages.CONTROL_ERROR_MESSAGE).append(System.lineSeparator());
            result = false;
        }

        if (currentRow == desiredRow && currentCol == desiredCol) {
            sb.append(ErrorMessages.SAME_POSITION_ERROR_MESSAGE).append(System.lineSeparator());
            result = false;

        }

        if (desiredPosition.charAt(0) == currentPlayer.getColor()) {
            sb.append(ErrorMessages.INVALID_DESIRED_POSITION_MESSAGE).append(System.lineSeparator());
            result = false;

        }

        return result;
    }

    public static String getMessages() {
        String message = sb.toString();
        destroy();
        return message;
    }


    private static StringBuilder init() {
        return new StringBuilder();
    }

    private static void destroy() {
        sb = null;
    }
}
