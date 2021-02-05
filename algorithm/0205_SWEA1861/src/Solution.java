import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] room;
    static boolean[][] check;
    static int[][] cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            check = new boolean[N][N];
            cnt = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    roomCheck(i, j);
                }
            }
            int max = 0;
            int num = -1;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    int n = cnt[i][j];
                    if(max < n) {
                        max = n;
                        num = room[i][j];
                    }
                    else if(max == n) num = Math.min(num, room[i][j]);
                }
            }
            sb.append("#").append(t).append(" ").append(num).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static int roomCheck(int x, int y) {
        if(check[x][y]) return cnt[x][y];
        check[x][y] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int max = 0;
        for(int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if((xx > -1 && xx < N) && (yy > -1 && yy < N) && room[xx][yy] == room[x][y] + 1) {
                max = Math.max(max, roomCheck(xx, yy));
            }
        }
        cnt[x][y] = max + 1;
        return cnt[x][y];
    }
}