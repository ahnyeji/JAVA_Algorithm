import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph; // add both
    static boolean[] visit; // check visited node or not
    static int cnt = 0; // count of connected component

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){ // make instances (without this part, nullpointer exception)
            graph[i] = new ArrayList<>();
        }
        visit = new boolean[N + 1];

        int u, v;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine(), " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            // undirected graph
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++){
            if(!visit[i]){
                bfs(i);
            }
        }
        System.out.println(cnt);
    }

    static void bfs(int idx){ // find connected component using bfs
        visit[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);

        int node;
        while(!q.isEmpty()){
            node = q.poll();
            for(int n : graph[node]){
                if(!visit[n]){
                    visit[n] = true;
                    q.offer(n);
                }
            }
        }
        cnt++;
    }
}
