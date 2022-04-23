package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.utils.ValidationUtils;

public class Move {

    private static final String NUMBER_PATTERN = "[+-]?\\d*(\\.\\d+)?";

    private final int moves;

    public Move(String moves) {
        ValidationUtils.validStringThrowIfEmpty(moves, ErrorMessage.MOVE_IS_REQUIRED);

        final boolean notNumber = !moves.matches(NUMBER_PATTERN);
        ValidationUtils.validConditionThrowIfTrue(notNumber, ErrorMessage.MOVE_MUST_BE_NUMBER);

        try {
            this.moves = getParseMovesThrowIfNotAllowedInt(moves);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_MUST_BE_ALLOWED_INT);
        }
    }

    private int getParseMovesThrowIfNotAllowedInt(String moves) {
        int parseMoves = Integer.parseInt(moves);
        ValidationUtils.validConditionThrowIfTrue(parseMoves < 0, ErrorMessage.MOVE_MUST_BE_ALLOWED_INT);
        return parseMoves;
    }

    public int remainMoves() {
        return moves;
    }

}
