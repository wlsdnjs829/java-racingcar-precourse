package racingcar.model;

import racingcar.constants.ErrorMessage;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private static final String EMPTY = "";

    private final String name;

    public CarName(String name) {
        this.name = getValidName(name);
    }

    private String getValidName(String name) {
        if (Objects.isNull(name) || EMPTY.equalsIgnoreCase(name)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_REQUIRED);
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MUST_BE_FIVE_CHAR_OR_LESS);
        }

        return name;
    }

}
