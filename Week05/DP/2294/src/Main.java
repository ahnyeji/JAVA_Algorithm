import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];

        Set<Integer> coins = new HashSet<>(); // to remove duplicate value
        int c;
        int minc = 100000;
        for(int i = 0; i < n; i++){
            c = Integer.parseInt(in.readLine());
            if(c <= k) { // can make c using just 1 coin & coin > k useless
                dp[c] = 1;
                coins.add(c);
            }
            minc = Math.min(minc, c);
        }

        if(minc > k){ // coins' minimum value > k -> cannot make k
            System.out.println(-1);
            return;
        }

        Iterator itr;
        int price;
        for(int i = minc + 1; i <= k; i++){
            itr = coins.iterator();
            while(itr.hasNext()){ // check each coin (find minimum count)
                price = (int) itr.next();
                if(i > price && dp[i - price] > 0){ // if can make i - price, cnt(coins) = dp[i - price] + 1
                    dp[i] = dp[i] == 0 ? dp[i - price] + 1 : Math.min(dp[i], dp[i - price] + 1);
                }
            }
        }
        System.out.println(dp[k] == 0 ? -1 : dp[k]); // dp[k] == 0 : cannot make k
    }
}
