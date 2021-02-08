import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(in.readLine());
        for(int t = 1; t <= TC; t++) {
            int N, M;
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(in.readLine());
            int[] weight = new int[N];

            for(int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(weight);

            sb.append("#").append(t).append(" ");

            int max = -1;
            for(int i = N - 1; i > 0; i--) {
                if(weight[i] >= M) continue;
                for(int j = 0; j < i; j++) {
                    int sum = weight[i] + weight[j];
                    if(sum > M) break;
                    if(sum == M) {
                        max = M;
                        break;
                    }
                    max = Math.max(max, sum);
                }
                if(max == M) break;
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
