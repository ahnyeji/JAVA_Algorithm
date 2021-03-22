import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 구슬의 좌표와 이동 횟수를 저장하기 위한 객체
class Ball {
    int y;
    int x;
    int moving = 0;
    Ball() {}
    Ball(int y, int x, int moving) {
        this.y = y;
        this.x = x;
        this.moving = moving;
    }
}

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visit; // [redY][redX][blueY][blueX] - 빨강이 redY, redX & 파랑이 blueY, blueX에 위치했었는지 여부
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우 4방향 탐색

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M][N][M];
        Ball red = new Ball(); // 빨간 구슬
        Ball blue = new Ball(); // 파란 구슬
        for(int i = 0; i < N; i++){
            String row = in.readLine();
            int idx = row.indexOf('R');
            if(idx > -1) { // 해당하는 문자가 없으면 -1 return하므로 -1보다 크다면 문자 존재 & 해당 위치 나타냄
                red = new Ball(i, idx, 0);
            }
            idx = row.indexOf('B');
            if(idx > -1) {
                blue = new Ball(i, idx, 0);
            }
            map[i] = row.toCharArray();
        }
        System.out.println(bfs(red, blue));
    }

    static int bfs(Ball red, Ball blue) { // 두 구슬이 이미 방문했던 위치에 다시 방문한다면 해당 경로는 최단 경로가 아님
        Queue<Ball> redQ = new LinkedList<>();
        Queue<Ball> blueQ = new LinkedList<>();
        redQ.offer(red);
        blueQ.offer(blue);

        visit[red.y][red.x][blue.y][blue.x] = true;
        while(!redQ.isEmpty()){
            Ball r = redQ.poll();
            Ball b = blueQ.poll();

            if(r.moving > 9) return -1; // 지금 이미 10번 이상 움직인 상태라면 최대 횟수를 넘음

            for(int i = 0; i < 4; i++){ // 4방 탐색
                int ry = r.y;
                int rx = r.x;
                int by = b.y;
                int bx = b.x;
                int dy = dir[i][0];
                int dx = dir[i][1];

                // 파란 구슬 이동
                while((by > 0 && by < N) && (bx > 0 && bx < M)) { // 상하좌우 끝이 모두 벽이므로 0인 index는 제외 가능
                    if(map[by + dy][bx + dx] == '#') break; // 벽
                    by += dy;
                    bx += dx;
                    if(map[by][bx] == 'O'){ // 파란 구슬이 구멍에 빠지면 실패이므로 확인
                        by = -1;
                        bx = -1;
                        break;
                    }
                }
                if(by == -1 && bx == -1) continue; // 파란 구슬이 구멍에 빠지면 실패

                // 빨간 구슬 이동
                while((ry > 0 && ry < N) && (rx > 0 && rx < M)) {
                    if(map[ry + dy][rx + dx] == 'O') return r.moving + 1; // 구멍에 빠지면 성공
                    if(map[ry + dy][rx + dx] == '#') break; // 벽
                    ry += dy;
                    rx += dx;
                }

                // 두 구슬이 겹친 경우 이전 위치를 토대로 조정 필요
                if(ry == by && rx == bx) {
                    switch (i) { // 움직인 방향에 따라 위치 달라짐
                        case 0: // 위
                            if(r.y < b.y) by++; // 원래 파란 구슬이 아래에 위치
                            else ry++; // 원래 빨간 구슬이 아래에 위치
                            break;
                        case 1: // 아래
                            if(r.y < b.y) ry--; // 원래 빨간 구슬이 위에 위치
                            else by--; // 원래 파란 구슬이 위에 위치
                            break;
                        case 2: // 왼쪽
                            if(r.x < b.x) bx++; // 원래 파란 구슬이 오른쪽에 위치
                            else rx++; // 원래 빨간 구슬이 오른쪽에 위치
                            break;
                        case 3: // 오른쪽
                            if(r.x < b.x) rx--; // 원래 빨간 구슬이 왼쪽에 위치
                            else bx--; // 원래 파란 구슬이 왼쪽에 위치
                            break;
                    }
                }
                if(visit[ry][rx][by][bx]) continue; // 이미 현재 위치대로 구슬이 배치된 적 있다면 최단 경로 아님
                visit[ry][rx][by][bx] = true; // 방문 처리
                redQ.offer(new Ball(ry, rx, r.moving + 1));
                blueQ.offer(new Ball(by, bx, b.moving + 1));
            }
        }
        return -1;
    }
}