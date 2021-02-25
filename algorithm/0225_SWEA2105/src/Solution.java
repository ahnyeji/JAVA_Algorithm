import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] cafe;
    static int[][] dir = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    static boolean[] visit = new boolean[101];

    static int startR, startC;
    static int maxCnt = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(in.readLine());
            cafe = new int[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(in.readLine());
                for(int j = 0; j < N; j++){
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < N - 2; i++){ // rectangle's start point row
                for(int j = 1; j < N - 1; j++){ // rectangle's start point column
                    startR = i;
                    startC = j;
                    visit[cafe[i][j]] = true;
                    if(!visit[cafe[i + 1][j + 1]]) { // should go right under at first
                        visit[cafe[i + 1][j + 1]] = true;
                        goCafe(0, i + 1, j + 1, 1);
                        visit[cafe[i + 1][j + 1]] = false;
                    }
                    visit[cafe[i][j]] = false;
                }
            }
            sb.append("#").append(t).append(" ").append(maxCnt).append("\n");
            maxCnt = -1;
        }
        System.out.println(sb);
    }

    static void goCafe(int d, int r, int c, int cnt){
        cnt++;
        // go straight
        int y = r + dir[d][0];
        int x = c + dir[d][1];
        if(y == startR && x == startC){ // arrive at start cafe
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }

        if(y > -1 && y < N && x > -1 && x < N && !visit[cafe[y][x]]){ // can go straight
            visit[cafe[y][x]] = true;
            goCafe(d, y, x, cnt);
            visit[cafe[y][x]] = false;
        }

        // turn right
        if(d < 3) { // if d == 3 -> not turn (just go stragith to arrive at start cafe)
            y = r + dir[++d][0];
            x = c + dir[d][1];
            if(y < 0 || y >= N || x < 0 || x >= N) return;
            if(y == startR && x == startC){ // arrive at start cafe
                maxCnt = Math.max(maxCnt, cnt);
                return;
            }
            // if d == 3 -> need to arrive start cafe when go straight
            if(d == 3 && y - startR != startC - x) return; // gradient != 1 -> cannot arrive at start cafe

            if (!visit[cafe[y][x]]) { // can turn right and go
                visit[cafe[y][x]] = true;
                goCafe(d, y, x, cnt);
                visit[cafe[y][x]] = false;
            }
        }
    }
}
