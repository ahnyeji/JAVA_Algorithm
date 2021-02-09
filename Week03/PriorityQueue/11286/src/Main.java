import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> { // smaller num has higher priority
            int abs = o1[0] - o2[0]; // 1. compare abs
            return abs == 0 ? o1[1] - o2[1] : abs; // 2. if abs is same, compare real value
        });
        while(N-- > 0){
            int op = Integer.parseInt(in.readLine());
            if(op == 0){
                if(pq.isEmpty()) sb.append("0\n"); // nothing to poll
                else sb.append(pq.poll()[1]).append("\n");
            }
            else{
                pq.offer(new int[]{Math.abs(op), op});
            }
        }
        System.out.println(sb);
    }
}
