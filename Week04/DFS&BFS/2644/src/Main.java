import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] people = new int[N + 1]; // index : child, value : parent (1 parent per 1 child)

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(in.readLine());
        int p, c;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            people[c] = p;
        }

        ArrayList<Integer> fromParent = new ArrayList<>(); // ancestor of from (include from)
        ArrayList<Integer> toParent = new ArrayList<>(); // ancestor of to (include to)
        // find from's ancestor
        p = from; // p : parent
        while(p > 0){
            fromParent.add(p);
            p = people[p]; // parent of p
        }
        // find to's ancestor
        p = to;
        while(p > 0){
            toParent.add(p);
            p = people[p];
        }

        int flen = fromParent.size() - 1; // last index of fromParent (highest ancestor)
        int tlen = toParent.size() - 1; // last index of toParent (highest ancestor)
        while(flen > -1 && tlen > -1 && fromParent.get(flen).equals(toParent.get(tlen))){
            flen--; tlen--;
        }
        if(flen == fromParent.size() - 1){ // no same ancestor
            System.out.println(-1);
        }
        else if(flen == -1){ // from is ancestor of to
            System.out.println(tlen + 1);
        }
        else if(tlen == -1){ // to is ancestor of from
            System.out.println(flen + 1);
        }
        else{
            System.out.println(flen + tlen + 2);
        }
    }

}
