# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
* 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, 
  "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 제약조건
* 자바 코드 컨벤션 지키며 프로그래밍한다.
    * 자바 클래스 열 제한은 120
    * 들여쓰기는 4 스페이스
    * 들여쓰기 지속은 최소 8 스페이스 (1 depth)
* 인덴트 depth 2를 넘지 않도록 한다.
* 자바 8에 추가된 stream api를 사용하지 않고 구현한다. (람다 허용)
* else 예약어를 사용하지 않는다.
* 메소드의 길이가 10라인을 넘어가지 않도록 한다.
* 일급 컬렉션을 활용해 구현한다.
* 모든 원시값과 문자열을 포장한다.

## 기능 구현순서
* 이름은 5자 이하만 가능하다. (문자열 포장)
  * 이름은 빈 값 및 중복에 대한 제한은 없지만 명확한 우승자를 구분하기 위해 조건을 추가한다.
* 각 자동차에게 이름을 부여하며, 자동차 이름은 쉼표를 기준으로 구분한다. 
* 사용자는 몇 번 이동 할 것인지 입력할 수 있어야 한다. (원시값 포장)
    * 사용자가 입력하는 이동 횟수는 숫자여야만 한다. 숫자가 아닐 시 IllegalArgumentException를 발생시키며 다시 입력 받는다.
* 0 ~ 9 사이에 random 값을 구한 후 random 값이 4이상일 경우 전진하고, 3 이하의 값이면 멈춘다. (원시값 포장)
* 각 차수별 실행 결과를 출력한다. 각 전진한 횟수만큼 대시(-)를 출력한다. (일급 컬렉션, 문자열 포장)
* 시도할 횟수를 초과한 경우 우승자 문구를 출력하며, 공동 우승자인 경우 쉼표로 구분 지어 출력한다.