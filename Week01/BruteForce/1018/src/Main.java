/* BOJ - 1018 : 체스판 다시 칠하기
   29.January.2021
 */

import java.util.Scanner;

public class Main {
    static char[][] chess = {   {'W','B','W','B','W','B','W','B'},
                                {'B','W','B','W','B','W','B','W'},
                                {'W','B','W','B','W','B','W','B'},
                                {'B','W','B','W','B','W','B','W'},
                                {'W','B','W','B','W','B','W','B'},
                                {'B','W','B','W','B','W','B','W'},
                                {'W','B','W','B','W','B','W','B'},
                                {'B','W','B','W','B','W','B','W'}   };
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        board = new char[N][M];
        for(int i = 0; i < N; i++){
            String line = sc.next();
            board[i] = line.toCharArray();
        }

        int min = 64; // 8 * 8 board coloring -> maximum 64;
        int nCnt = N - 7; // cases to get 8 rows
        int mCnt = M - 7; // cases to get 8 cols
        for(int i = 0; i < nCnt; i++){
            for(int j = 0; j < mCnt; j++){
                min = Math.min(min, coloring(i, j));
            }
        }
        System.out.println(min);
    }
    public static int coloring(int x, int y){
        int wStart = 0; // first square : W -> should be same with chess (if not same, need to change -> count)
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(chess[i][j] != board[x + i][y + j]){
                    wStart++;
                }
            }
        }
        return Math.min(wStart, 64 - wStart); // 64 - wStart == first square : B
    }
}

/*  Time Complexity : O(N^2)
    - maximum N : 50
    - maximum M : 50
    - T(coloring) : 64
    => T(N,M) = 64*N*M = 64*N^2
    # Double loop -> O(N^2)
 */
