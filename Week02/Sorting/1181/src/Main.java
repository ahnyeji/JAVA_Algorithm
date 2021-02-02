/*  BOJ - 1181 : 단어 정렬
    03.February.2021
 */
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for(int i = 0; i < N; i++){
            words[i] = br.readLine();
        }

        // sort by length -> sort by alphabet
        Arrays.sort(words, (o1, o2) -> {
            int lenDiff = o1.length() - o2.length();
            return lenDiff == 0 ? o1.compareTo(o2): lenDiff;
        });

        StringBuilder sb = new StringBuilder(words[0]).append("\n");
        for(int i = 1; i < N; i++){
            if(!words[i].equals(words[i - 1])){ // print if not duplicate
                sb.append(words[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
