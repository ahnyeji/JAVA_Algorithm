import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> towers = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= N; i++) { // Tower's number starts from 1
            int[] t = new int[] {Integer.parseInt(st.nextToken()), i}; // {tower height, tower num}

            if(towers.empty()) {
                sb.append(0).append(" ");
            }

            else {
                while(towers.peek()[0] < t[0]) { // smaller cannot receive signals (current tower will receive next)
                    towers.pop();
                    if(towers.empty()) { // no tower received signal
                        sb.append(0).append(" ");
                        break;
                    }
                }

                if(!towers.empty()) { // some tower received signal (taller or same)
                    sb.append(towers.peek()[1]).append(" ");
                }
            }

            towers.push(t);
        }
        System.out.println(sb.toString());
    }
}
