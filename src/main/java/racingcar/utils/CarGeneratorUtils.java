package racingcar.utils;

import racingcar.constants.ErrorMessage;
import racingcar.model.CarName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarGeneratorUtils {

    private static final String REST = ",";

    private CarGeneratorUtils() {
        throw new ClassCastException();
    }

    public static List<CarName> getCarNames(String name) {
        ValidationUtils.validObjectThrowIfNull(name, ErrorMessage.NAME_IS_REQUIRED);
        final Set<String> uniqueNames = getUniqueNamesThrowIfDuplicate(name);
        final List<CarName> carNames = new ArrayList<>();

        for (String uniqueName : uniqueNames) {
            carNames.add(new CarName(uniqueName));
        }

        return carNames;
    }

    private static Set<String> getUniqueNamesThrowIfDuplicate(String name) {
        final String[] names = name.split(REST);
        final Set<String> uniqueNames = new HashSet<>();
        Collections.addAll(uniqueNames, names);

        boolean isUnique = names.length != uniqueNames.size();
        ValidationUtils.validConditionThrowIfTrue(isUnique, ErrorMessage.NAME_MUST_BE_UNIQUE);
        return uniqueNames;
    }

}
