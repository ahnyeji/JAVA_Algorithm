/*  BOJ - 10971 : 외판원 순회 2
    15.February.2021
 */

/*  [Backtracking]
    - 최소 비용 문제 : 비용이 최소값보다 커지면 이후 경로 확인할 필요 없음 -> Backtracking
    - 갈 수 없는 경로 존재 : W[i][j] == 0 -> 시작점으로 돌아갈 경우도 마찬가지임에 유의
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] W;
    static boolean[] visited; // check for visited node
    static int minC = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){ // set start node
            visited[i] = true;
            visit(1, i, i, 0);
            visited[i] = false;
        }
        System.out.println(minC);
    }

    static void visit(int cnt, int start, int last, int cost){
        if(cnt == N){ // visited all nodes
            if(W[last][start] != 0){ // go back to start node (if cost 0, cannot go)
                minC = Math.min(minC, cost + W[last][start]);
            }
            return;
        }
        if(cost >= minC) return; // Backtracking (no need to check higher cost routes)
        for(int i = 0; i < N; i++){
            if(!visited[i] && W[last][i] != 0){ // cannot go visited node & 0 cost edge
                visited[i] = true;
                visit(cnt + 1, start, i, cost + W[last][i]);
                visited[i] = false;
            }
        }
    }
}
