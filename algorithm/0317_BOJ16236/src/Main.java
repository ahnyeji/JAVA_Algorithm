import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, sr, sc, fr, fc;
    static int[][] map; // fish space status
    static int[][] moving; // distance from baby shark
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // 4 direction (up, left, down, right)
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){ // shark position
                    sr = i;
                    sc = j;
                }
            }
        }
        int t = 0; // time
        int size = 2; // size of baby shark
        int cnt = size; // eat count (update when baby shark grow)
        while(true){
            bfs(sr, sc, size);
            if(fr == N) break; // no fish able to eat
            t += moving[fr][fc] - 1;
            // moving shark
            map[sr][sc] = 0;
            sr = fr;
            sc = fc;
            map[sr][sc] = 9;
            cnt--;
            if(cnt == 0){ // baby shark grow
                size++;
                cnt = size;
            }
        }
        System.out.println(t);
    }

    static void bfs(int r, int c, int size){ // find fish to eat (min distance, upper left fish)
        moving = new int[N][N];
        moving[r][c] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        int len = 400;
        fr = N;
        fc = N;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){ // 4 direction (up, left, down, right)
                int y = cur[0] + dir[i][0];
                int x = cur[1] + dir[i][1];
                if((y > -1 && y < N) && (x > -1 && x < N) && moving[y][x] == 0){ // can move to (y, x)
                    if(map[y][x] > size) continue; // already visited
                    moving[y][x] = moving[cur[0]][cur[1]] + 1;
                    if(map[y][x] > 0 && map[y][x] < size) { // fish exist & can eat this fish
                        if(len > moving[y][x]){ // find nearest fish
                            len = moving[y][x];
                            fr = y;
                            fc = x;
                        }
                        else if(len == moving[y][x]){ // same distance, eat upper left fish
                            if(fr > y){
                                fr = y;
                                fc = x;
                            }
                            else if(fr == y){
                                fc = Math.min(fc, x);
                            }
                        }
                    }
                    q.offer(new int[]{y, x});
                }
            }
        }
    }
}
