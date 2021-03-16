import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Integer>[] graph;
    static int[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t < 11; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            N /= 2; // from & to 2 numbers per 1 loop
            int start = Integer.parseInt(st.nextToken());

            graph = new ArrayList[101]; // to save from-to (graph[from] : to-lists)
            for(int i = 1; i < 101; i++) { // to make not null
                graph[i] = new ArrayList<>();
            }
            st = new StringTokenizer(in.readLine());
            for(int i = 0; i < N; i++) {
                // directed graph
                graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }

            visit = new int[101]; // to save visiting order
            sb.append("#").append(t).append(" ").append(bfs(start)).append("\n");
        }
        System.out.print(sb);
    }
    static int bfs(int start) { // to contact at the same time
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = 1;
        int maxi = 1, idx = start; // maxi : maximum visiting order, idx : maximum vertex index whose order is maximum
        int u, v, len;
        while(!q.isEmpty()) {
            u = q.poll(); // current vertex (contact point)
            len = graph[u].size(); // length of vertices connected from current vertex
            for(int i = 0; i < len; i++) {
                v = graph[u].get(i); // next vertex (contact point)
                if(visit[v] == 0) { // no contact yet
                    visit[v] = visit[u] + 1; // visiting order
                    if(maxi < visit[v]) { // need to update maxi & idx
                        maxi = visit[v];
                        idx = v;
                    }
                    else if(maxi == visit[v] && idx < v) { // need to update idx
                        idx = v;
                    }
                    q.offer(v);
                }
            }
        }
        return idx;
    }
}