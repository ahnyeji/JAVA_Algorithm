import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nge = new int[N]; // save NGE(k)
        Stack<int[]> ready = new Stack<>(); // keep numbers not find NGE(K) yet (top -> bottom : ascending)

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            while(!ready.empty()){ // calculate NGE of ready numbers
                int[] last = ready.peek();
                if(last[0] >= n){
                    break;
                }
                nge[last[1]] = n;
                ready.pop();
            }
            ready.push(new int[]{n, i});
        }
        while(!ready.empty()){ // numbers that have no bigger number after all number input
            nge[ready.peek()[1]] = -1;
            ready.pop();
        }

        String ans = Arrays.toString(nge).replaceAll(",", "");
        System.out.println(ans.substring(1, ans.length() - 1));
    }
}
