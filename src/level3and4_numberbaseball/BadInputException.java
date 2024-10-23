package level3and4_numberbaseball;

public class BadInputException extends Exception {
    public BadInputException() {
        super("올바르지 않은 입력값 입니다.");
    }
}
