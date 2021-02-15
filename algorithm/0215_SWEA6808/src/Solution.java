import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] a = new int[9]; // Kyuyoung card
    static boolean[] b; // Inyoung card (0 ~ 18 card; true - Kyuyoung's | selected Inyoung card & false - Inyoung card)
    static int win = 0;
    static int lose = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t);

            // initialize win, lose and Inyoung card (Kyuyoung card will be overwritten -> not need to initialize)
            win = 0; lose = 0;
            b = new boolean[19];

            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i = 0; i < 9; i++) { // set Kyuyoung card
                a[i] = Integer.parseInt(st.nextToken());
                b[a[i]] = true; // check Kyuyoung card at Inyoung card
            }

            comb(0, 0, 0); // start game
            sb.append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    // cnt : round count, ascore : Kyuyoung score, bscore : Inyoung score
    static void comb(int cnt, int ascore, int bscore) {
        if(cnt == 9) { // round done
            if(ascore < bscore) lose++; // Kyuyoung lose this game
            else if(ascore > bscore) win++; // Kyuyoung win this game
            return;
        }
        for(int i = 1; i < 19; i++) {
            if(!b[i]) { // not selected card of Inyoung card
                b[i] = true;
                if(a[cnt] < i) { // Kyuyoung lose this round
                    comb(cnt + 1, ascore, bscore + a[cnt] + i);
                }
                else { // Kyuyoung win this round (card never be same)
                    comb(cnt + 1, ascore + a[cnt] + i, bscore);
                }
                b[i] = false;
            }
        }
    }
}
