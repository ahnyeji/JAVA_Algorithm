import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            if(N == 1) {
                sb.append("#").append(tc).append(" ").append(br.readLine().charAt(0) - '0').append("\n");
                continue;
            }
            int[][] farm = new int[N][N];

            int half = N / 2;
            for(int i = 0; i < N; i++) {
                String vals = br.readLine();
                for(int j = 0; j < N; j++) {
                    farm[i][j] = vals.charAt(j) - '0';
                }
            }

            int total = 0;
            for(int i = 0; i < half; i++) {
                int start = half - i;
                int end = half + i;
                int bottom = N - i - 1;
                for(int j = start; j <= end; j++) {
                    total += farm[i][j];
                    total += farm[bottom][j];
                }
            }
            for(int i = 0; i < N; i++) {
                total += farm[half][i];
            }
            sb.append("#").append(tc).append(" ").append(total).append("\n");
        }
        System.out.println(sb.toString());
    }
}