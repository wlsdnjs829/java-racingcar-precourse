package racingcar.constants;

public final class ErrorMessage {

    private ErrorMessage() {
        throw new ClassCastException();
    }

    public static final String NAME_IS_REQUIRED = "[ERROR] 이름은 필수 값입니다.";
    public static final String NAME_MUST_BE_UNIQUE = "[ERROR] 이름은 고유 값이어야 합니다.";
    public static final String NAME_MUST_BE_FIVE_CHAR_OR_LESS = "[ERROR] 이름은 5글자 이하여야 합니다.";

}
