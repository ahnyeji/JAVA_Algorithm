/* BOJ - 11729 : 하노이 탑 이동 순서
   28.January.2021
 */

import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder(); // for speed
    static int K; // count moving
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        hanoi(N, 1, 3);
        System.out.println(K + "\n" + sb.toString());
    }
    // Method for moving whole n disks (entire tower)
    public static void hanoi(int n, int from, int to){
        // n == 1 : there is 1 disk to move -> just move!
        if(n == 1){
            sb.append(from).append(' ').append(to).append('\n');
            K++;
            return;
        }
        int middle = 6 - from - to; // disks smaller than n should move to the other pillar
        // 1. move smaller tower (1 ~ n-1) to middle pillar (temporary destination)
        hanoi(n - 1, from, middle);
        // 2. move disk N
        sb.append(from).append(' ').append(to).append('\n');
        K++;
        // 3. move smaller tower (1 ~ n-1) to original destination
        hanoi(n - 1, middle, to);
    }
}

/* !! better idea !! - if pass middle as parameter, can reduce operations */
