/* BOJ - 2447 : 별 찍기 - 10
   28.January.2021
 */

import java.util.Scanner;

public class Main {
    // input number : 3^1 ~ 3^7 (number < 3 & 8 && multiple of 3s)
    static final int MAX_NUM = (int)Math.pow(3, 7);
    // check for printing (true : "*", false : " ")
    public static boolean[][] stars = new boolean[MAX_NUM][MAX_NUM];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 1. check printing points
        starPattern(N, 0, 0);
        // 2. print
        StringBuilder sb = new StringBuilder(); // using StringBuilder for speed
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(stars[i][j]) sb.append('*');
                else sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString()); // call print method 1 time
    }

    // Method for check printing point -> split into smallest area
    public static void starPattern(int n, int x, int y){
        // n : size, (x, y) : starting point
        if(n == 1){ // base condition (this Method called only when have to print "*")
            stars[x][y] = true;
            return ;
        }
        // split into smaller size (pattern repeat every multiple of 3s)
        int size = n / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i ==1 && j == 1) { // center area never print "*"
                    continue;
                }
                // other areas print "*" -> need to check
                starPattern(size, x + size * i, y + size * j);
            }
        }
    }
}

/*  시간 초과
    : 배열 각 원소마다 print문 호출하여 문자 출력 시 시간 초과 발생
    -> StringBuilder 이용하여 문자열로 만든 후 한 번에 print하면 속도 향상
    (참고 링크 : https://www.acmicpc.net/blog/view/57)
 */