import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] paper = new boolean[100][100]; // white drawing paper (white : false, black : true)

        int N = Integer.parseInt(in.readLine());

        while(N-- > 0) {
            int x, y;
            StringTokenizer st = new StringTokenizer(in.readLine());
            x = Integer.parseInt(st.nextToken()); // x : think as row (rotate 90 degree)
            y = Integer.parseInt(st.nextToken()); // y : think as col (rotate 90 degree)

            // size of colored paper : 10 * 10
            int row = x + 10;
            int col = y + 10;
            // coloring
            for(int i = x; i < row; i++) {
                for(int j = y; j < col; j++) {
                    paper[i][j] = true;
                }
            }
        }
        // count colored area
        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j]) cnt++; // black : true
            }
        }
        System.out.println(cnt);
    }
}
