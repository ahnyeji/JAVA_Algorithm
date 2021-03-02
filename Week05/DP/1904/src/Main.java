/*  [DP]
    # 기저사례
      - tiles[0] = 1 (tiles[2]에서 00을 포함하도록 하기 위함)
      - tiles[1] = 1 (1; 00은 두자리이므로 사용 불가)
    # 점화식
      - tiles[i] = tiles[i - 1] + tiles[i - 2]
        => tiles[i - 1] : tiles[i - 1] 뒤에 1을 덧붙임
        => tiles[i - 2] : tiles[i - 2] 뒤에 00을 덧붙임
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] tiles = new int[N + 1];
        tiles[0] = 1;
        tiles[1] = 1;
        for(int i = 2; i <= N; i++){
            tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 15746;
        }
        System.out.print(tiles[N]);
    }
}
