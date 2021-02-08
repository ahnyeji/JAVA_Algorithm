import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Deque<Integer> circularQ = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            circularQ.offer(i);
        }

        st = new StringTokenizer(in.readLine());
        int ans = 0;
        for(int i = 0; i < M; i++){
            int toRemove = Integer.parseInt(st.nextToken());
            int len = circularQ.size();
            int cnt = 0; // count of moving left
            int now; // front of circularQ
            while((now = circularQ.pollFirst()) != toRemove){ // Input guarantees not empty & element exists
                circularQ.offer(now); // moving left
                cnt++;
            }
            cnt = Math.min(cnt, len - cnt); // moving right : circularQ length - moving left
            ans += cnt;
        }
        System.out.println(ans);
    }
}
