/*
    변수 헷갈리지 않게 구분하여 사용하기 (y, yy 사용으로 헷갈려서 틀림)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N, M, F, taxi_r, taxi_c;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Map<Integer, int[]> destination;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        String inp;
        for(int i = 0; i < N; i++) {
            inp = in.readLine();
            for(int j = 0; j < N; j++) {
                if(inp.charAt(j << 1) == '1') map[i][j] = -1;
            }
        }
        st = new StringTokenizer(in.readLine());
        taxi_r = Integer.parseInt(st.nextToken()) - 1;
        taxi_c = Integer.parseInt(st.nextToken()) - 1;
        destination = new HashMap<>();
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(in.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i;
            destination.put(i, new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1});
        }
        while(M-- > 0) {
            int cost = findP(); // 승객을 태우러 이동하는 데 소모한 연료량
            if(cost == -1 || cost >= F) { // -1 : 벽에 의해 이동 불가, >= F : 연료 부족 (한 승객의 출발지와 도착지는 같지 않음)
                F = -1;
                break;
            }
            F -= cost;
            moving(); // 승객 도착지까지 이동
            if(F == -1) break;
        }
        System.out.println(F);
    }
    static int findP() { // 택시에서 가장 가까운 승객 찾기
        if(map[taxi_r][taxi_c] > 0) return 0; // 택시와 승객이 같은 장소에 있는 경우

        int[][] dist = new int[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{taxi_r, taxi_c});
        dist[taxi_r][taxi_c] = 1;

        int passenger_r = -1, passenger_c = -1, cost = 401; // 승객 정보
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            if(cost < dist[y][x]) { // bfs -> dist[y][x]가 cost보다 커지면 현재 cost가 가장 가까울 때의 값
                // 택시를 승객 위치로 이동시키기
                taxi_r = passenger_r;
                taxi_c = passenger_c;
                return cost; // 승객 위치로 이동하는 데 필요한 연료
            }
            for(int i = 0; i < 4; i++) {
                int next_y = y + dy[i];
                int next_x = x + dx[i];
                if(next_y < 0 || next_y >= N || next_x < 0 || next_x >= N || map[next_y][next_x] == -1 || dist[next_y][next_x] > 0) continue;
                if(map[next_y][next_x] > 0) {
                    if(cost > dist[y][x]) { // 초기 cost가 401이므로 처음 승객과 마주치면 cost가 dist보다 큼
                        cost = dist[y][x];
                        passenger_r = next_y;
                        passenger_c = next_x;
                    } else if(cost == dist[y][x]) { // 같은 cost일 경우 y가 작은 승객, y가 같다면 x가 작은 승객 선택
                        if(passenger_r > next_y) {
                            passenger_r = next_y;
                            passenger_c = next_x;
                        } else if(passenger_r == next_y && passenger_c > next_x) passenger_c = next_x;
                    }
                }
                dist[next_y][next_x] = dist[y][x] + 1;
                q.offer(new int[]{next_y, next_x});
            }
        }
        return -1; // 승객을 태우러 갈 수 없는 경우 : 벽에 의해 이동 불가 -> -1
    }
    static void moving() {
        int p = map[taxi_r][taxi_c]; // 승객 번호
        map[taxi_r][taxi_c] = 0; // 이미 태웠으니까 해당 위치에 대기하는 승객은 없음
        int[] dest = destination.get(p); // 탑승한 승객의 도착지

        int[][] dist = new int[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{taxi_r, taxi_c});
        dist[taxi_r][taxi_c] = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];

            for(int i = 0; i < 4; i++) {
                int next_y = y + dy[i];
                int next_x = x + dx[i];
                if(next_y < 0 || next_y >= N || next_x < 0 || next_x >= N || map[next_y][next_x] == -1 || dist[next_y][next_x] > 0) continue;
                if(next_y == dest[0] && next_x == dest[1]) { // 도착지
                    if(dist[y][x] > F) F = -1; // 도착지까지 갈 수 없는 경우 : 연료 부족
                    else { // 이동 성공
                        taxi_r = next_y;
                        taxi_c = next_x;
                        F += dist[y][x];
                    }
                    return;
                }
                dist[next_y][next_x] = dist[y][x] + 1;
                q.offer(new int[]{next_y, next_x});
            }
        }
        F = -1; // 도착지까지 갈 수 없는 경우 : 벽에 의해 이동 불가
    }
}