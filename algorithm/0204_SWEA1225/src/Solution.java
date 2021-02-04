import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 8; i++) {
                int n = Integer.parseInt(st.nextToken());
                q.add(n);
                min = n < min ? n : min;
            }

            // 8cycles -> all element decreased 15
            int minimizing = min / 15;
            if(min % 15 == 0) minimizing--; // element should not be 0 initially
            minimizing *= 15;
            for(int i = 0; i < 8; i++) {
                q.add(q.poll() - minimizing);
            }

            while(true) {
                boolean check = false;
                for(int i = 1; i < 6; i++) {
                    int n = q.poll();
                    n -= i;
                    if(n <= 0) {
                        q.add(0);
                        check = true;
                        break;
                    }
                    q.add(n);
                }
                if(check) break;
            }

            sb.append("#").append(t);
            while(!q.isEmpty()) {
                sb.append(" ").append(q.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}