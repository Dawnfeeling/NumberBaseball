package level3and4_numberbaseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();  //게임 기록을 저장하는 컬렉션
        int choice;  //프로그램 실행 시 번호 선택 변수
        int level = 3;  //난이도(초기값 3)
        int count;  //게임 진행 시 반복한 횟수


        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            choice = sc.nextInt();

            //난이도 변경
            if (choice == 0) {
                System.out.println("설정하고자 하는 자리수를 입력하세요.");
                level = sc.nextInt();
                if (level != 3 && level != 4 && level != 5) {
                    System.out.println("레벨은 3, 4, 5 단계가 존재합니다");
                }
            }
            //게임 시작
            else if (choice == 1) {
                BaseballGame game = new BaseballGame(level);  //게임을 시작할 때 객체 새로 생성
                count = game.play();
                list.add(count);
                System.out.println(count + "번의 시도 끝에 정답을 맞혔습니다!");
            }
            //게임 기록 출력
            else if (choice == 2) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + list.get(i));
                }
                if (list.isEmpty()) {
                    System.out.println("현재 게임 기록이 없습니다.");
                }
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
