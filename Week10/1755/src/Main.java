import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Numbers implements Comparable<Numbers> { // 숫자와  해당 숫자를 영어로 읽었을 때 문자열을 저장하기 위한 클래스
    int n; // 숫자
    String num; // 영어로 읽었을 때 문자열
    Numbers(int n) { // 생성자
        this.n = n; // 입력받은 숫자를 이 객체의 숫자로 저장
        String temp = Integer.toString(n); // 숫자를 영어로 읽기 위해 문자열 형태로 변환
        num = ""; // 빈 문자열에서 시작
        int len = temp.length(); // 숫자 자리수만큼 읽어야 하므로 자리수(길이) 알아내기
        for(int i = 0; i < len; i++) { // 자리수만큼 읽기
            switch(temp.charAt(i)) { // 현재 자리의 숫자
                case '0': // 0이면 zero
                    num += "zero"; // 결과가 될 문자열 뒤에 더하기
                    break;
                case '1': // 1이면 one
                    num += "one"; // 결과가 될 문자열 뒤에 더하기
                    break;
                case '2': // 2이면 two
                    num += "two"; // 결과가 될 문자열 뒤에 더하기
                    break;
                case '3': // 3이면 three
                    num += "three"; // 결과가 될 문자열 뒤에 더하기
                    break;
                case '4': // 4이면 four
                    num += "four"; // 결과가 될 문자열 뒤에 더하기
                    break;
                case '5': // 5이면 five
                    num += "five"; // 결과가 될 문자열 뒤에 더하기
                    break;
                case '6': // 6이면 six
                    num += "six"; // 결과가 될 문자열 뒤에 더하기
                    break;
                case '7': // 7이면 seven
                    num += "seven"; // 결과가 될 문자열 뒤에 더하기
                    break;
                case '8': // 8이면 eight
                    num += "eight"; // 결과가 될 문자열 뒤에 더하기
                    break;
                case '9': // 9이면 nine
                    num += "nine"; // 결과가 될 문자열 뒤에 더하기
                    break;
            }
        }
        this.num = num; // 영어로 읽은 결과를 이 객체의 문자열로 저장
    }

    @Override
    public int compareTo(Numbers o) { // 정렬을 어떻게 할 지 구현
        return this.num.compareTo(o.num); // String 사전순 정렬
    }
}

public class Main {
    public static void main(String[] args) throws Exception { // Exception 처리
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기위해 BufferedReader 선언
        StringTokenizer st = new StringTokenizer(in.readLine(), " "); // 입력이 한 줄로 들어옴 -> 공백 기준으로 잘라서 사용하기 위해 StringTokenizer 사용
        int M = Integer.parseInt(st.nextToken()); // 숫자 시작
        int N = Integer.parseInt(st.nextToken()); // 숫자 끝

        int len = N - M + 1; // 숫자 개수
        Numbers[] ans = new Numbers[len]; // 숫자를  Numbers 객체화하여 저장하기 위한 배열
        int idx = 0; // Numbers 인덱스
        for(int i = M; i <= N; i++) { // 숫자 시작부터 끝까지
            ans[idx++] = new Numbers(i); // Numbers 객체 생성하여 배열에 저장
        }

        Arrays.sort(ans); // 숫자들 정렬

        StringBuilder sb = new StringBuilder(); // 출력 횟수 감소를 위해 StringBuilder에 저장하여 한 번만 출력하기 위함
        for(int i = 0; i < len; i++) { // 숫자 개수만큼 출력 필요
            sb.append(ans[i].n); // 숫자는 0번 인덱스부터 들어있음
            if(i % 10 == 9) sb.append("\n"); // 10개 출력 후 줄바꿈 필요
            else sb.append(" "); // 줄바꿈 하지 않을 경우 공백으로 구분 필요
        }
        System.out.print(sb); // 결과물 출력
    }
}
