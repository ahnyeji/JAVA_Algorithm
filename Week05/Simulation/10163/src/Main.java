import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int[][] board = new int[101][101];

        int r, c, w, h;
        for(int idx = 1; idx <= N; idx++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for(int i = r, er = r + w , ec = c + h; i < er; i++){ // put paper
                for(int j = c; j < ec; j++) {
                    board[i][j] = idx;
                }
            }
        }

        int[] cnt = new int[N + 1];
        for(int i = 0; i < 101; i++){ // get paper area
            for(int j = 0; j < 101; j++){
                cnt[board[i][j]]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(cnt[i]).append("\n");
        }
        System.out.println(sb);
    }
}
