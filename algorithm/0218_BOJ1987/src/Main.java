import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[] alp = new boolean[26];
    static int R, C;
    static char[][] board;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for(int i = 0; i < R; i++){
            board[i] = in.readLine().toCharArray();
        }

        moving(0, 0, 1);
        System.out.println(max);

    }

    static void moving(int r, int c, int cnt){
        alp[board[r][c] - 'A'] = true;
        int x, y;
        for(int i = 0; i < 4; i++){
            y = r + dir[i][0];
            x = c + dir[i][1];

            if(x > -1 && x < C && y > -1 && y < R && !alp[board[y][x] - 'A']){
                max = Math.max(max, cnt + 1);
                moving(y, x, cnt + 1);
            }
        }
        max = Math.max(max, cnt);
        alp[board[r][c] - 'A'] = false;
    }
}
