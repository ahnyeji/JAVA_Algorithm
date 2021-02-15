import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] S;
    static int[] B;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        S = new int[N];
        B = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        mixing(0, 1, 0);
        System.out.println(minDiff);
    }

    static void mixing(int idx, int sour, int bitter){
        if(idx == N) return;
        for(int i = idx; i < N; i++){
            sour *= S[i];
            bitter += B[i];
            minDiff = Math.min(minDiff, Math.abs(sour - bitter));
            mixing(i + 1, sour, bitter);
            sour /= S[i];
            bitter -= B[i];
        }
    }
}
