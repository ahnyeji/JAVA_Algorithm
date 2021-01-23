/* BOJ - 2675 : 문자열 반복
   22.January.2021
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T; // # of Test Cases
        T = sc.nextInt();
        int R; // # of Repetitions
        String S; // String to repeat
        for(int i = 0; i < T; i++) {
            R = sc.nextInt();
            S = sc.next();
            String P = ""; // Result after Repetition
            for(char s : S.toCharArray()) {
                for(int j = 0; j < R; j++){
                    P += s;
                }
            }
            System.out.println(P);
        }
        sc.close();
    }
}
