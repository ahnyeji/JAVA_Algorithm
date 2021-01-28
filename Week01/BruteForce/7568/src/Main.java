/* BOJ - 7568 : 덩치
   29.January.2021
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        int[][] size = new int[N][2]; // weight, height
        for(int i = 0; i < N; i++){
            size[i][0] = sc.nextInt();
            size[i][1] = sc.nextInt();
        }

        // count bigger people
        for(int i = 0; i < N; i++){
            int weight = size[i][0];
            int height = size[i][1];
            int bigger = 0;
            for(int j = 0; j < N; j++){
                if(i == j) continue; // useless to compare same thing(itself)
                if(size[j][0] > weight && size[j][1] > height) bigger++;
            }
            // rank starts from 1, not 0 -> bigger + 1
            sb.append(bigger + 1).append(' ');
        }
        System.out.println(sb.toString());
    }
}

/*  Time Complexity : O(N^2)
    - maximum N : 50 (N^2 : 2500)
    - time limit : 1 sec (10^8)
 */