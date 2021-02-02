/*
 * Square Loop
 *  : Make square border per loop & the number of loops is N / 2
 *  - each loop has 4 small loops & each small loop has same endgth
 *  	1. go right
 *  		1  2  3  4  0		1  2  3  4  5	|	1  2  3  0		1  2  3  4
 *  		0  0  0  0  0		16 17 18 19 6	|	0  0  0  0		12 13 0  5
 *  		0  0  0  0  0		15 0  0	 0  7	|	0  0  0  0		11 0  0  6
 *  		0  0  0  0  0		14 0  0	 0  8	|	0  0  0  0		10 9  8  7
 *  		0  0  0  0  0		13 12 11 10 9	|
 *  	2. go down
 *  		1  2  3  4  5       1  2  3	 4  5	|	1  2  3  4		1  2  3  4
 *  		0  0  0  0  6       16 17 18 19 6	|	0  0  0  5		12 13 14 5
 *  		0  0  0  0  7       15 0  0	 20 7	|	0  0  0  6		11 0  0  6
 *  		0  0  0  0  8		14 0  0	 21 8	|	0  0  0  0		10 9  8  7
 *  		0  0  0  0  0		13 12 11 10 9	|
 *  	3. go left
 *  		1  2  3  4  5		1  2  3	 4  5	|	1  2  3  4		1  2  3  4
 *  		0  0  0	 0  6		16 17 18 19 6	|	0  0  0  5		12 13 14 5
 *  		0  0  0	 0  7		15 0  0	 20 7	|	0  0  0  6		11 0  15 6
 *  		0  0  0	 0  8		14 0  22 21 8	|	0  9  8  7		10 9  8  7
 *  		0  12 11 10 9		13 12 11 10 9	|
 *  	4. go up
 *  		1  2  3	 4  5		1  2  3	 4  5	|	1  2  3  4		1  2  3  4
 *  		16 0  0	 0  6		16 17 18 19 6	|	12 0  0  5		12 13 14 5
 *  		15 0  0	 0  7		15 24 0	 20 7	|	11 0  0  6		11 16 15 6
 *  		14 0  0	 0  8		14 23 22 21 8	|	10 9  8  7		10 9  8  7
 *  		13 12 11 10	9		13 12 11 10 9	|
 *
 *   - if N is odd number, then center of square is N^2
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append("\n");

            int N = Integer.parseInt(br.readLine());

            int[][] snail = new int[N][N];

            int repeat = N / 2;
            int num = 1;

            // Draw 1 square border per loop
            for(int i = 0; i < repeat; i++) {

                int end = N - i - 1;

                // 1. go right
                for(int j = i; j < end; j++) {
                    snail[i][j] = num++;
                }

                // 2. go down
                for(int j = i; j < end; j++) {
                    snail[j][end] = num++;
                }

                // 3. go left
                for(int j = end; j > i; j--) {
                    snail[end][j] = num++;
                }

                // 4. go up
                for(int j = end; j > i; j--) {
                    snail[j][i] = num++;
                }
            }

            // if N is odd number, add center point
            if(N % 2 == 1) snail[N / 2][N / 2] = num;


            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
