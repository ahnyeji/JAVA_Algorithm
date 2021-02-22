import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] seq = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());

        // base case : first element -> nothing to compare
        seq[0] = Integer.parseInt(st.nextToken());
        int maxVal = seq[0];

        // recurrence relation
        // -> continuous sum : just compare with 1 previous element
        // -> bigger value : add only previous element > 0 (else, become smaller when add)
        for(int i = 1; i < n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
            if(seq[i - 1] > 0) seq[i] += seq[i - 1];
            maxVal = Math.max(maxVal, seq[i]);
        }
        System.out.println(maxVal);
    }
}
