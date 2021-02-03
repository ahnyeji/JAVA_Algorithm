/*  BOJ - 4949 : 균형잡힌 세상
    03.February.2021
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String inp;
        while(!(inp = br.readLine()).equals(".")){ // "." : end of input
            Stack<Character> parenthesis = new Stack<Character>();
            int len = inp.length();
            boolean broken = false;
            for(int i = 0; i < len; i++){
                char now = inp.charAt(i);
                if(now == '[' || now == '(') parenthesis.push(now);
                else if(now == ']'){
                    if(parenthesis.empty()){
                        broken = true;
                        break;
                    }
                    if(parenthesis.peek() == '[') parenthesis.pop();
                    else{
                        broken = true;
                        break;
                    }
                }
                else if(now == ')'){
                    if(parenthesis.empty()){
                        broken = true;
                        break;
                    }
                    if(parenthesis.peek() == '(') parenthesis.pop();
                    else{
                        broken = true;
                        break;
                    }
                }
            }
            if(parenthesis.empty() && !broken){
                sb.append("yes\n");
            }
            else sb.append("no\n");
        }
        System.out.println(sb.toString());
    }
}
