import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        int cnt;
        while(N-- > 0){
            int[] A = new int[5]; // save count of A's each card (A[0] : not use)
            int[] B = new int[5]; // save count of B's each card (B[0] : not use)
            StringTokenizer st = new StringTokenizer(in.readLine());
            cnt = Integer.parseInt(st.nextToken());
            while(cnt-- > 0){ // A's card
                A[Integer.parseInt(st.nextToken())]++; // count card
            }

            st = new StringTokenizer(in.readLine());
            cnt = Integer.parseInt(st.nextToken());
            while(cnt-- > 0){ // B's card
                B[Integer.parseInt(st.nextToken())]++; // count card
            }

            char winner = 'D';
            for(int i = 4; i > 0; i--){ // compare A and B
                if(A[i] > B[i]){
                    winner = 'A';
                    break;
                }
                if(B[i] > A[i]){
                    winner = 'B';
                    break;
                }
            }
            sb.append(winner).append("\n");
        }

        System.out.print(sb);
    }
}
