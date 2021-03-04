import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int[] dp = new int[n + 1];
        int wine, before;
        dp[1] = Integer.parseInt(in.readLine());
        before = dp[1];
        if(n == 1){
            System.out.print(dp[1]);
            return;
        }
        wine = Integer.parseInt(in.readLine());
        dp[2] = wine + dp[1];
        if(n == 2){
            System.out.print(dp[2]);
            return;
        }
        before = wine;
        for(int i = 3; i <= n; i++){
            wine = Integer.parseInt(in.readLine());
            dp[i] = wine + Math.max(dp[i - 2], dp[i - 3] + before);
            dp[i] = Math.max(dp[i - 1], dp[i]);
            before = wine;
        }
        System.out.print(dp[n]);
    }
}
