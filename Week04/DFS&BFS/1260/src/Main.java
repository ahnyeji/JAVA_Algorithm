import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visit;
    static ArrayList<Integer>[] g;
    static boolean[][] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1]; // undirected graph (make smaller number comes first)
        visit = new boolean[N + 1];

        int l, r;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            graph[l][r] = true;
            graph[r][l] = true;
        }

        dfs(V);
        sb.append("\n");
        visit = new boolean[N + 1]; // initialize visit to check bfs
        bfs(V);
        System.out.println(sb);
    }
    static void dfs(int node){
        visit[node] = true;
        sb.append(node).append(" ");
        for(int i = 1; i <= N; i++){ // dfs : check child first (smaller child first in this problem)
            if(graph[node][i] && !visit[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        visit[node] = true;
        q.offer(node);
        int now;
        while(!q.isEmpty()){
            now = q.poll();
            sb.append(node).append(" ");
            for(int i = 1; i <= N; i++){ // bfs : check same level first (root -> height)
                if(graph[now][i] && !visit[i]) {
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
