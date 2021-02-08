import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        while(T-- > 0){
            String p = in.readLine();
            int n = Integer.parseInt(in.readLine());
            String[] numbers = in.readLine().substring(1).split(",");
            if(n > 0) numbers[n - 1] = numbers[n - 1].substring(0, numbers[n - 1].length() - 1); // remove "]"

            Deque<Integer> dq = new LinkedList<>();
            for(int i = 0; i < n; i++){
                dq.offer(Integer.parseInt(numbers[i]));
            }
            boolean err = false;
            int dir = 1; // remove first : 1, remove last : -1
            int len = p.length();
            for(int i = 0; i < len; i++){
                if(p.charAt(i) == 'R') dir *= -1; // reverse
                else{
                    if(dq.isEmpty()){ // remove from empty deque -> error
                        err = true;
                        sb.append("error\n");
                        break;
                    }
                     else if(dir == 1){
                        dq.removeFirst();
                    } else {
                        dq.removeLast();
                    }
                }
            }
            if(err) continue;
            sb.append("[");
            if(dq.isEmpty()) sb.append("]");
            while(!dq.isEmpty()){
                if(dir == 1) sb.append(dq.poll());
                else sb.append(dq.pollLast());
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}
