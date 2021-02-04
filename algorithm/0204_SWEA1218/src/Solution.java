import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++) {
            int len = Integer.parseInt(br.readLine());
            String s = br.readLine();

            Stack<Character> par = new Stack<>();
            boolean check = true;

            for(int i = 0; i < len; i++) {
                char c = s.charAt(i);

                if(c == '(' || c == '[' || c == '{' || c == '<') {
                    par.push(c);
                }
                else {
                    if(par.empty()) {
                        check = false;
                        break;
                    }
                    else {
                        char top = par.peek();
                        if((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{') || (c == '>' && top == '<')) {
                            par.pop();
                        } else {
                            check = false;
                            break;
                        }
                    }
                }
            }

            if(check) {
                if(!par.empty()) {
                    check = false;
                }
            }
            sb.append("#").append(t).append(" ").append(check ? 1 : 0).append("\n");
        }
        System.out.println(sb.toString());
    }
}
