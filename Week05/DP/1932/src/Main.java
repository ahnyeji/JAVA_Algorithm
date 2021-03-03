/*  [DP]
    # 기저사례
      - tri[0][0] : input (upper 없음)
    # 점화식
      - tri[i][0] = tri[i - 1][0] (upper left 없음)
      - tri[i][i] = tri[i - 1][i - 1] (upper right 없음)
      - tri[i][j] = input + max(tri[i - 1][j - 1], tri[i - 1][j])
        => tri[i - 1][j - 1] : upper left
        => tri[i - 1][j] : upper right
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] tri = new int[n][n];

        int num;
        int maxi = 0;
        tri[0][0] = Integer.parseInt(in.readLine());
        for(int i = 1; i < n; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for(int j = 0; j <= i; j++){
                num = Integer.parseInt(st.nextToken());
                if(j == 0){ // left end -> not have upper left
                    tri[i][j] = num + tri[i - 1][j];
                }
                else if(j == i){ // right end -> not have upper right
                    tri[i][j] = num + tri[i - 1][j - 1];
                }
                else { // compare upper left & upper right -> get bigger
                    tri[i][j] = num + Math.max(tri[i - 1][j - 1], tri[i - 1][j]);
                }
                maxi = Math.max(maxi, tri[i][j]);
            }
        }
        System.out.print(maxi);
    }
}
