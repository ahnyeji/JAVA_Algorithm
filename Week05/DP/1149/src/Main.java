/*  [DP]
    # 기저사례
      - rgb[0][0] = 0 : 아직 아무 집도 칠하지 않음 (빨간색)
      - rgb[0][1] = 0 : 아직 아무 집도 칠하지 않음 (초록색)
      - rgb[0][2] = 0 : 아직 아무 집도 칠하지 않음 (파란색)
    # 점화식
      - rgb[i][0] = Input + min(rgb[i - 1][1], rgb[i - 1][2]) : i번째 집을 빨간색으로 칠할 경우의 최소비용
        => 이전 집을 초록색으로 칠했거나 파란색으로 칠했을 경우에만 가능
      - rgb[i][1] = Input + min(rgb[i - 1][0], rgb[i - 1][2]) : i번째 집을 초록색으로 칠할 경우의 최소비용
        => 이전 집을 빨간색으로 칠했거나 파란색으로 칠했을 경우에만 가능
      - rgb[i][2] = Input + min(rgb[i - 1][0], rgb[i - 1][2]) : i번째 집을 파란색으로 칠할 경우의 최소비용
        => 이전 집을 빨간색으로 칠했거나 초록색으로 칠했을 경우에만 가능
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int[][] rgb = new int[N + 1][3];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken()) + Math.min(rgb[i - 1][1], rgb[i - 1][2]);

            rgb[i][1] = Integer.parseInt(st.nextToken()) + Math.min(rgb[i - 1][0], rgb[i - 1][2]);

            rgb[i][2] = Integer.parseInt(st.nextToken()) + Math.min(rgb[i - 1][0], rgb[i - 1][1]);

        }

        System.out.print(Math.min(Math.min(rgb[N][0], rgb[N][1]), rgb[N][2]));
    }
}
