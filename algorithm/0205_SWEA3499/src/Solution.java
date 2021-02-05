import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t);
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String[] words = new String[N];
            for(int i = 0; i < N; i++) {
                words[i] = st.nextToken();
            }
            int half = N / 2;
            if(half * 2 == N) {
                for(int i = 0; i < half; i++) {
                    sb.append(" ").append(words[i]).append(" ").append(words[half + i]);
                }
            }
            else {
                for(int i = 0; i < half; i++) {
                    sb.append(" ").append(words[i]).append(" ").append(words[half + 1 + i]);
                }
                sb.append(" ").append(words[half]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
