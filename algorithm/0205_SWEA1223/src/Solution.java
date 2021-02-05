import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> opVal = new HashMap<>();
        opVal.put('*', 11);
        opVal.put('+', 10);

        for(int t = 1; t <= 10; t++) {
            int len = Integer.parseInt(br.readLine());
            String s = br.readLine();
            char[] mid = s.toCharArray();
            int[] post = new int[len];
            Stack<Integer> op = new Stack<>();

            int end = 0;
            for(int i = 0; i < len; i++) {
                switch(mid[i]) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        post[end++] = mid[i] - '0';
                        break;
                    default:
                        int opV = opVal.get(mid[i]);

                        while(!op.empty() && opV <= op.peek()) {
                            post[end++] = op.peek();
                            op.pop();
                        }
                        op.push(opV);
                        break;
                }
            }
            while(!op.empty()) {
                post[end++] = op.peek();
                op.pop();
            }

            for(int i = 0; i < len; i++) {
                if(post[i] < 10) op.add(post[i]);
                else {
                    int b = op.peek();
                    op.pop();
                    int a = op.peek();
                    op.pop();
                    if(post[i] == 10) {
                        op.push(a + b);
                    } else {
                        op.push(a * b);
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(op.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
