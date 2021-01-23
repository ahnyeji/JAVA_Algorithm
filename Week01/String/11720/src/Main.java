/* BOJ - 11720 : 숫자의 합
   22.January.2021
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        String nums;
        nums = sc.next();
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += (nums.charAt(i) - '0');
        }
        System.out.println(sum);
    }
}
