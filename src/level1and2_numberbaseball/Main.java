package level1and2_numberbaseball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;  //프로그램 실행 시 번호 선택 변수


        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            choice = sc.nextInt();

            //게임 시작
            if (choice == 1) {
                BaseballGame game = new BaseballGame();  //게임을 시작할 때 객체 새로 생성
                game.play();
            }
            //게임 기록 출력
            else if (choice == 2) {
                System.out.println();
            }
            //게임 종료
            else if (choice == 3) {
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
                break;
            }
            //입력 오류
            else {
                System.out.println("올바른 숫자를 입력해주세요!");
            }
        }
    }
}
