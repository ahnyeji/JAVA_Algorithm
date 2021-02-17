import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, edges;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        visit = new boolean[n + 1]; // check visited for dfs
        graph = new ArrayList[n + 1]; // undirected graph -> add both
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        edges = Integer.parseInt(in.readLine());

        int l, r;
        for(int i = 0; i < edges; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            graph[l].add(r); // add r to l (can go from l to r)
            graph[r].add(l); // add l as r (can go from l to r)
        }

        dfs(1); // spreading virus
        int ans = 0;
        for(int i = 2; i <= n; i++){ // check visited node (if true, virus spread)
            if(visit[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int num){
        visit[num] = true;
        for(int computer : graph[num]){
            if(!visit[computer]) dfs(computer); // if visited, already checked -> not need to check again
        }
    }
}
