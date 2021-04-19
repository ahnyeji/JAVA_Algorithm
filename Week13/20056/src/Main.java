import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class FireBall {
    int m, s, d;
    public FireBall() {}
    public FireBall(int m, int s, int d) {
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {
    static int N, M, K;
    static Queue<FireBall>[][] map;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Queue[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = new LinkedList<>();
            }
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1].offer(new FireBall(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while(K-- > 0) {
            moving();
        }
        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                while(!map[i][j].isEmpty()) {
                    ans += map[i][j].poll().m;
                }
            }
        }
        System.out.println(ans);
    }

    static void moving() {
        Queue<FireBall>[][] movemap = new Queue[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                movemap[i][j] = new LinkedList<>();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                while(!map[i][j].isEmpty()) {
                    FireBall fb = map[i][j].poll();
                    int y = (i + (fb.s % N) * dy[fb.d] + N) % N;
                    int x = (j + (fb.s % N) * dx[fb.d] + N) % N;

                    movemap[y][x].offer(fb);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(movemap[i][j].size() < 2) continue;
                int cnt = movemap[i][j].size(), totm = 0, tots = 0, dir = 0;
                while(!movemap[i][j].isEmpty()) {
                    FireBall fb = movemap[i][j].poll();
                    if(fb.d % 2 != 0) dir++;
                    totm += fb.m;
                    tots += fb.s;
                }
                totm /= 5;
                if(totm == 0) continue;
                tots /= cnt;
                if(dir == 0 || dir == cnt) dir = 0;
                else dir = 1;
                for(; dir < 8; dir += 2) {
                    movemap[i][j].offer(new FireBall(totm, tots, dir));
                }
            }
        }
        map = movemap;
    }
}