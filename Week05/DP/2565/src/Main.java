/*  [DP]
    # 전깃줄 시작점 기준 오름차순 정렬
    # 전깃줄 끝점 기준으로 가장 긴 증가하는 부분 수열 적용
      - 해당 전깃줄을 남길 때 다른 전깃줄을 남길 수 있는 최대 개수
    # 점화식
      - dp[i] = max(dp[j]) + 1 (dp[j] : seq[i] > seq[j]인 원소)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] lines = new int[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        // sort by start point in ascending
        Arrays.sort(lines, (o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[n];
        int maxi = 1;
        for(int i = 0; i < n; i++){ // find maximum count that can contain this element
            for(int j = i - 1; j > -1; j--){
                if(lines[i][1] > lines[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            maxi = Math.max(maxi, dp[i]);
        }
        System.out.print(n - maxi); // minimum count = total line count - maximum count
    }
}
