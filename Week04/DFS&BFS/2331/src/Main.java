import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        ArrayList<Integer> seq = new ArrayList<>();
        int next;
        while(true){
            seq.add(A);
            next = 0;
            while(A > 0){ // make next element
                next += Math.pow(A % 10, P);
                A /= 10;
            }

            // use A as index here
            if((A = seq.indexOf(next)) != -1) { // already in sequence -> after this element(include this) all repeated
                System.out.println(A); // element index 0 ~ A - 1 survived -> count : A
                break;
            }

            // use A as element
            A = next;
        }
    }
}
