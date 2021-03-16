import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int L, C;
    static char[] alphabet;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = in.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(alphabet);

        sb = new StringBuilder();
        comb(0, 0, 0, 0, "");
        System.out.print(sb);
    }

    static void comb(int cnt, int vcnt, int ccnt, int idx, String ans){
        if(cnt == L){
            if(vcnt > 0 && ccnt > 1){ // at least 1 vowel & at least 2 consonants
                sb.append(ans).append("\n");
            }
            return;
        }
        for(int i = idx; i < C; i++){
            switch (alphabet[i]){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    // vowel
                    comb(cnt + 1, vcnt + 1, ccnt, i + 1, ans + alphabet[i]);
                    break;
                default:
                    // consonant
                    comb(cnt + 1, vcnt, ccnt + 1, i + 1, ans + alphabet[i]);
                    break;
            }
        }
    }
}
