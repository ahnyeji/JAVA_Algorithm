import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String t = in.readLine();

        int slen = s.length();
        int tlen = t.length();

        int ans = 1;
        if(slen == tlen) {
            if(!s.equals(t)) ans = 0;
        }
        else {
            if(slen > tlen) {
                String tmp = s;
                s = t;
                t = tmp;
                slen = tlen;
                tlen = t.length();
            }
            if(tlen % slen == 0) {
                int rep = tlen / slen;
                String newS = "";
                while(rep-- > 0) {
                    newS += s;
                }
                if(!newS.equals(t)) ans = 0;
            }
            else {
                int g = gcd(slen, tlen);
                int srep = tlen / g;
                int trep = slen / g;

                String newS = "";
                String newT = "";
                for(int i = 0; i < srep; i++) {
                    newS += s;
                }
                for(int i = 0; i < trep; i++) {
                    newT += t;
                }
                if(!newS.equals(newT)) ans = 0;
            }
        }
        System.out.println(ans);
    }

    static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
