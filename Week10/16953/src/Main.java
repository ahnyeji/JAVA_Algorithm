import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int ans = 0;
        while(a < b) {
            if(b % 2 == 0) b /= 2;
            else if(b % 10 == 1) b /= 10;
            else break;
            ans++;
        }
        if(a != b) ans = -2;
        System.out.println(ans + 1);
    }
}
