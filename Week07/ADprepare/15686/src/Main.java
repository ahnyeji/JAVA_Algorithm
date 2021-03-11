import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, clen, hlen;
    static ArrayList<int[]> chickens;
    static ArrayList<int[]> houses;
    static boolean[] visit;
    static int mini = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        int n;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++){
                n = Integer.parseInt(st.nextToken());
                if(n == 1){ // make houses list
                    houses.add(new int[]{i, j});
                }
                else if(n == 2){ // make chicken restaurants list
                    chickens.add(new int[]{i, j});
                }
            }
        }
        hlen = houses.size();
        clen = chickens.size();
        visit = new boolean[clen];
        selectChicken(0, 0);
        System.out.println(mini);
    }

    // use combination
    static void selectChicken(int cnt, int idx){
        if(cnt == M){ // calculate chicken distance (selected all chicken restaurants)
            int dist = 0;
            int[] c, h;
            for(int i = 0; i < hlen; i++){
                h = houses.get(i);
                int minc = Integer.MAX_VALUE; // to find minimum distance restaurant from current house
                for(int j = 0; j < clen; j++) {
                    if(!visit[j]) continue; // not selected this restaurant
                    c = chickens.get(j);
                    minc = Math.min(minc, Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1])); // 1 : 1 distance
                }
                dist += minc;
            }
            mini = Math.min(mini, dist);
            return;
        }
        for(int i = idx; i < clen; i++){ // find chicken restaurant to select
            if(!visit[i]){ // select this chicken restaurant
                visit[i] = true;
                selectChicken(cnt + 1, i + 1); // next idx : i + 1 (not idx + 1,,,)
                visit[i] = false;
            }
        }
    }
}
