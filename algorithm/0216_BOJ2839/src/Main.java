/*  Found Pattern
    1. N % 5 == 0 : N / 5
    2. N < 8
        1) N % 3 == 0 : N / 3
        2) N % 3 != 0 : -1
    3. N >= 8
        1) N % 5 == odd : N / 5 + 1
        2) N % 5 == even : N / 5 + 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int mod = N % 5;
        int ans;
        if(mod == 0) {
            ans = N / 5;
        }

        else if(N < 8) {
            if(N % 3 == 0) {
                ans = N / 3;
            }
            else {
                ans = -1;
            }
        }

        else {
            if(mod % 2 == 1) {
                ans = N / 5 + 1;
            }
            else {
                ans = N / 5 + 2;
            }
        }

        System.out.println(ans);
    }
}
