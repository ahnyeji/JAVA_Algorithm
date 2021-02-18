import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] restaurant;
    static int[] dir = {-1, 0, 1};
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        restaurant = new char[R][C];

        for(int r = 0; r < R; r++) {
            restaurant[r] = in.readLine().toCharArray();
        }
        // 'x' : cannot go(checked or building), '.' : can go
        for(int i = 0; i < R; i++) {
            // always checked (if this path is wrong, all paths that pass this space are always wrong)
            restaurant[i][0] = 'x';
            find(i, 0);
        }
        System.out.println(cnt);
    }

    static boolean find(int r, int c) {
        if(c == C - 1) { // path completed!
            cnt++;
            return true;
        }
        int y, x = c + 1;
        for(int i = 0; i < 3; i++) {
            y = r + dir[i];
            if(y > -1 && y < R && x < C && restaurant[y][x] == '.') {
                // always checked (if this path is wrong, all paths that pass this space are always wrong)
                restaurant[y][x] = 'x';
                if(find(y, x)) return true; // can make path -> no more path can pass this space from now
            }
        }
        return false; // cannot make completed path from this space
    }
}
