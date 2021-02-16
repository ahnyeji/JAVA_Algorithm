import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(Z(N, r, c));
    }

    static int Z(int n, int row, int col){ // divide into part 0 or 1 or 2 or 3
        if(n == 0) return 0; // cannot divide any more (smallest problem)
        int half = (int) Math.pow(2, n - 1); // half of rows ans cols index
        int num = 0; // record count
        // if row < half, not need to do anything. Just cut off lower rows (lower count not included)
        if(row >= half){ // not need to check upper rows : add upper's counts & make lower row index starts from 0
            num += half * half * 2;
            row -= half;
        }
        // if col < half, not need to do anything. Just cut off right columns (right count not included)
        if(col >= half){ // not need to check left columns : add left's counts & make right column index starts from 0
            num += half * half;
            col -= half;
        }
        return num + Z(n - 1, row, col);
    }
}
