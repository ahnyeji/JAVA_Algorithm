/*  BOJ - 10989 : 수 정렬하기 3
    02.February.2021
 */
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] digits = new int[10001]; // number range : 1 ~ 10000
        for(int i = 0; i < N; i++){
            digits[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 10001; i++){
            int now = digits[i];
            if(now > 0){
                while(now > 0){
                    sb.append(i).append("\n");
                    now--;
                    N--;
                }
            }
            if(N < 1) break; // checking after all elements done is useless
        }
        System.out.println(sb.toString());
    }
}
