/*  BOJ - 1966 : 프린터 큐
    06.February.2021
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[] importance = (br.readLine().replaceAll(" ", "")).toCharArray();

            ArrayList<int[]> docs = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                docs.add(new int[]{importance[i] - '0', i});
            }

            int cnt = 1;
            while(true){
                int[] doc = docs.get(0);
                int idx = 0;
                int len = docs.size();
                for(int i = 1; i < len; i++){ // find the most important doc
                    int[] toCompare = docs.get(i);
                    if(doc[0] < toCompare[0]){
                        doc = toCompare;
                        idx = i;
                    }
                }
                if(doc[1] == M){ // the most important doc == want to know when to print
                    sb.append(cnt).append("\n");
                    break;
                }
                for(int i = 0; i < idx; i++){ // move less important docs back
                    docs.add(docs.get(0));
                    docs.remove(0);
                }
                docs.remove(0); // remove(print) the most important doc
                cnt++;
            }
        }
        System.out.println(sb);
    }
}
