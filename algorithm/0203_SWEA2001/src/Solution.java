import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int toCheck = N - M + 1;
            int[][] flies = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    flies[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for(int i = 0; i < toCheck; i++) {
                for(int j = 0; j < toCheck; j++) {

                    int endR = i + M;
                    int endC = j + M;
                    int fly = 0;

                    for(int r = i; r < endR; r++) {
                        for(int c = j; c < endC; c++) {
                            fly += flies[r][c];
                        }
                    }
                    max = max < fly ? fly : max;
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}
