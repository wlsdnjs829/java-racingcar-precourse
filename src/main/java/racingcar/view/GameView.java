package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.System.out;

public final class GameView {

    private static final String CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! ";
    private static final String CHOICE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ENTER_DIGITS = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "게임 종료";

    private GameView() {
        throw new ClassCastException();
    }

    public static String enterMessage() {
        return Console.readLine();
    }

    public static void printEnterDigitsMessage() {
        out.print(ENTER_DIGITS);
    }

    public static void printChoiceMessage() {
        out.println(CHOICE_MESSAGE);
    }

    public static void printClearAndEndMessage() {
        out.println(CLEAR_MESSAGE + GAME_END_MESSAGE);
    }

    public static void printMessage(String message) {
        out.println(message);
    }

}
