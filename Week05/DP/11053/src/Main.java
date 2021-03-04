/*  [DP]
    # 기저사례
      - dp[0] : 1 (이 원소부터 시작하는 증가 수열)
    # 점화식
      - dp[i] = max(dp[j]) + 1 (dp[j] : seq[i] > seq[j]인 원소)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] seq = new int[N]; // save sequence
        int[] dp = new int[N]; // save result of dynamic programming

        StringTokenizer st = new StringTokenizer(in.readLine());
        // base case
        seq[0] = Integer.parseInt(st.nextToken());
        dp[0] = 1;

        int maxi = 1; // should be 1 (not 0) because of N == 1 case
        for(int i = 1; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken()); // sequence input
            for(int j = i - 1; j > -1; j--){ // check ascending maximum length contain this element
                if(seq[i] > seq[j]) // ascending
                    dp[i] = Math.max(dp[i], dp[j]); // update maximum length
            }
            dp[i]++; // contain this element to length
            maxi = Math.max(maxi, dp[i]); // maximum length of entire
        }
        System.out.println(maxi);
    }
}
