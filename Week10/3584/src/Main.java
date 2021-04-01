import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        int N, p, c;
        while(T-- > 0){
            N = Integer.parseInt(in.readLine()) - 1;

            int[] reverseTree = new int[N + 2];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(in.readLine());
                p = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                reverseTree[c] = p;
            }

            StringTokenizer st = new StringTokenizer(in.readLine());
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            ArrayList<Integer> pp = new ArrayList<>();
            ArrayList<Integer> cp = new ArrayList<>();
            while(p > 0){
                pp.add(p);
                p = reverseTree[p];
            }
            while(c > 0){
                cp.add(c);
                c = reverseTree[c];
            }
            boolean found = false;
            for(int ppi : pp){
                for(int cpi : cp){
                    if(ppi == cpi){
                        sb.append(ppi).append("\n");
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }
        }
        System.out.println(sb);
    }
}

