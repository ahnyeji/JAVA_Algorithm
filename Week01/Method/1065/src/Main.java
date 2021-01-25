/* BOJ - 1065 : 한수
   22.January.2021
 */

// Method Version -> 18376KB & 228ms
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int cnt;

        // Single digit & Two digits are always AP(Arithmetic Progression)
        if(N < 100){
            cnt = N;
        }
        else {
            // Single digit & Two digits
            cnt = 99;
            // Three digits (The number is always three digits or less)
            for(int i = 100; i <= N; i++){
                if(isAP(i)){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    // This method only called only for three digits (1000 is not AP)
    static boolean isAP(int n) {
        int mid = n / 10 % 10; // second digit
        // compare first - second & second - third
        return n % 10 - mid == mid - n / 100;
    }
}

/*
// Extended Version -> 18324KB & 228ms
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int cnt;

        // Single digit & Two digits are always AP(Arithmetic Progression)
        if(N < 100){
            cnt = N;
        }
        else {
            cnt = 99;
            for(int i = 100; i <= N; i++){
                int d = (i % 10 - (i / 10) % 10); // difference
                int j = i / 10;
                while(j > 9) { // to get difference, the number should be two digits or more
                    if(d != (j % 10 - (j / 10) % 10)) { // if differences are not same, not AP
                        break;
                    }
                    j /= 10;
                }
                if(j < 10) { // It means not broken in while-loop == AP
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
*/
