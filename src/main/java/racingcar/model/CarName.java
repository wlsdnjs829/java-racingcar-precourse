package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.utils.ValidationUtils;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        this.name = getValidName(name);
    }

    public String getName() {
        return name;
    }

    private String getValidName(String name) {
        ValidationUtils.validStringThrowIfEmpty(name, ErrorMessage.NAME_IS_REQUIRED);

        boolean overMaxLength = name.length() > MAX_LENGTH;
        ValidationUtils.validConditionThrowIfTrue(overMaxLength, ErrorMessage.NAME_MUST_BE_FIVE_CHAR_OR_LESS);
        return name;
    }

}
