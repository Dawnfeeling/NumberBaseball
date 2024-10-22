package level3and4_numberbaseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    ArrayList<Integer> inputNum = new ArrayList<>();  //사용자부터 입력 받은 수를 저장하는 컬렉션
    ArrayList<Integer> resultNum= new ArrayList<>();  //정답이 들어있는 컬렉션
    private static final String NUMBER_REG = "^[0-9]*$";  //정수 정규화식 변수
    int strike;  //스트라이크 횟수
    int ball;  //볼 횟수
    int count = 0;  //게임 반복 횟수


    //객체 생성시 정답 생성
    public BaseballGame(int level) {
        setresultNum(level);
    }

    //정답을 랜덤하게 생성하는 메소드
    public void setresultNum(int level){
        while(resultNum.size()<level){
            int num = random.nextInt(9) + 1;  //1~9중 랜덤하게 숫자 생성
            if(!resultNum.contains(num)){
                resultNum.add(num);
            }
        }
    }

    //정답을 조회하는 메소드
    public void getresultNum(){
        for(int num : resultNum){
            System.out.print(num);
        }
        System.out.println();
    }

    //사용자부터 입력받은 값을 배열에 담는 메소드
    public void setinputnum(int inputNum){
        //일의자리부터 배열에 추가
        while(inputNum > 0){
            this.inputNum.add(inputNum % 10);
            inputNum /= 10;
        }
        Collections.reverse(this.inputNum);  //일의 자리부터 추가했으므로 배열을 역순으로 뒤집는다.
    }

    //숫자야구 게임을 시작하는 메소드
    public int play(){
        System.out.println("< 게임을 시작합니다 >");

        while (true) {
            inputNum.clear(); //입력값 배열 초기화
            System.out.println("숫자를 입력하세요");
            String str = sc.nextLine();

//            //정답 조회용
//            if(str.equals("root")){
//                getresultNum();
//            }

            // 입력한 값에 대한 예외처리
            if(validateInput(str)){
                int temp = Integer.parseInt(str);  //입력받은 값을 int로 변환 후 컬렉션에 추가
                setinputnum(temp);
            }else{
                System.out.println("올바르지 않은 입력값입니다.");
                continue;
            }

            //스트라이크, 볼, 아웃 판단
            strike = countStrike();
            ball = countBall();
            if(strike==0 && ball==0){
                System.out.println("아웃");
            } else if (strike == resultNum.size()) {
                System.out.println("정답입니다!");
                count++;  //반복 횟수 증가
                break;
            }else{
                System.out.println(strike + "스트라이크 " + ball + "볼");
            }
            count++;  //반복 횟수 증가
        }
        return count;
    }

    //스트라이크 갯수 확인 메소드
    private int countStrike(){
        int strike = 0;
        for(int num=0; num<resultNum.size(); num++){
            //인덱스0부터 비교해서 인덱스가 같고 값도 같으면 스트라이크 추가
            if(resultNum.get(num).equals(inputNum.get(num))){
                strike++;
            }
        }
        return strike;
    }

    //볼 갯수 확인 메소드
    private int countBall(){
        int ball = 0;
        for(int num : inputNum){
            //해당 숫자가 정답에 있으면서 인덱스가 다른 경우 볼 추가
            if(resultNum.contains(num) && resultNum.indexOf(num) != inputNum.indexOf(num)){
                ball++;
            }
        }
        return ball;
    }

    //입력받은 값의 오류를 검사하는 메소드
    protected boolean validateInput(String inputNum){
        //문자를 입력했을때 오류
        for(String c : inputNum.split("")){
            if(!Pattern.matches(NUMBER_REG, c)){
                return false;
            }
        }

        //자리수가 다를때 오류
        if(inputNum.length() != resultNum.size()){
            return false;
        }

        //0이 포함되어 있을때 오류
        if(inputNum.contains("0")){
            return false;
        }

        //중복값이 있을때 오류
        StringBuilder str = new StringBuilder(inputNum);
        for(String c : inputNum.split("")){
            str.deleteCharAt(str.indexOf(c));
            if(str.indexOf(c) != -1){
                return false;
            }
        }
        return true;
    }
}
