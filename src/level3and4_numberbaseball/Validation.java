package level3and4_numberbaseball;

import java.util.regex.Pattern;

public class Validation {
    private static final String NUMBER_REG = "^[0-9]*$";  //정수 정규화식 변수

    protected void validateInput(String inputNum, int length) throws Exception {
        //문자를 입력했을때 오류
        for (String c : inputNum.split("")) {
            if (!Pattern.matches(NUMBER_REG, c)) {
                throw new BadInputException();
            }
        }

        //자리수가 다를때 오류
        if (inputNum.length() != length) {
            throw new BadInputException();
        }

        //0이 포함되어 있을때 오류
        if (inputNum.contains("0")) {
            throw new BadInputException();
        }

        //중복값이 있을때 오류
        StringBuilder str = new StringBuilder(inputNum);
        for (String c : inputNum.split("")) {
            str.deleteCharAt(str.indexOf(c));  //첫 문자를 삭제한 후 삭제한 문자와 같은 값이 있는지 비교
            if (str.indexOf(c) != -1) {
                throw new BadInputException();
            }
        }
    }
}
