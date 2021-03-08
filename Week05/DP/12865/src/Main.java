/*  [DP]
    # 점화식
      - knapsack[i][j] = max(knapsack[i-1][j], knapsack[i-1][j-w[i]] + v[i])
      => i번째 물건까지 확인했을 때 무게 합이 j가 되게하는 물건 가치의 최대 합
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] knapsack = new int[N][K + 1];
        int W, V;

        st = new StringTokenizer(in.readLine());
        W = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= K; i++){ // first item (not have knapsack[i-1][j])
            if(W <= i){
                knapsack[0][i] = V;
            }
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(in.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            for(int j = 1; j <= K; j++){
                if(W <= j){ // can put item in knapsack
                    knapsack[i][j] = Math.max(knapsack[i - 1][j], knapsack[i - 1][j - W] + V);
                }
                else{
                    knapsack[i][j] = knapsack[i - 1][j];
                }
            }
        }

        System.out.print(knapsack[N - 1][K]);
    }
}
