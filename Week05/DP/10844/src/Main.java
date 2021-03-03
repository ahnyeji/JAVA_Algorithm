/*  [DP]
    # 기저사례
      - stair[1][0] = 0 (0은 계단 수가 아님 & 0으로 시작하는 계단 수는 없음)
      - stair[1][1] ~ stair[1][9] : 1
    # 점화식
      - stair[i][0] : i번째 자리가 0이 되는 경우 -> stair[i - 1][1] (이전 자리 숫자가 1인 경우 -> 낮아짐)
      - stair[i][9] : i번째 자리가 9가 되는 경우 -> stair[i - 1][8] (이전 자리 숫자가 8인 경우 -> 높아짐)
      - stair[i][j] : i번째 자리가 j가 되는 경우 -> stair[i - 1][j - 1] + stair[i - 1][j + 1] 
        (이전 자리 숫자가 j - 1인 경우 -> 높아짐 & 이전 자리 숫자가 j + 1인 경우 -> 낮아짐)
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] stair = new int[N + 1][10];
        for(int i = 1; i < 10; i++){
            stair[1][i] = 1;
        }
        for(int i = 2; i <= N; i++){ // count digits
            for(int j = 1; j < 9; j++){ // last number
                stair[i][j] = (stair[i - 1][j - 1] + stair[i - 1][j + 1]) % 1000000000; // e.g.) _____45 + _____65
            }
            stair[i][0] = stair[i - 1][1]; // _____10
            stair[i][9] = stair[i - 1][8]; // _____89
        }
        int ans = 0;
        for(int i = 0; i < 10; i++){
            ans = (ans + stair[N][i]) % 1000000000;
        }
        System.out.print(ans);
    }
}
