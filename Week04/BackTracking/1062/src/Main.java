import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static HashMap[] wordAlphas; // alphabets in words
    static int maxW = 0;
    static int maxKey = 19; // last alphabet of alphabets in all words
    static int[] alphabet = new int[26]; // 0 : never used, 1 : used in words but not checked, 2 : checked

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        wordAlphas = new HashMap[N];
        char[] s;
        int len, key;
        for(int i = 0; i < N; i++){
            s = in.readLine().toCharArray();
            len = s.length;
            wordAlphas[i] = new HashMap<>();
            for(int j = 0; j < len; j++){
                key = s[j] - 'a'; // alphabet to number(index)
                maxKey = Math.max(maxKey, key); // to know last(largest index) alphabet
                switch (key){ // set "anta" & "tica" learned (to make not to check again)
                    case 0: // 'a'
                    case 2: // 'c'
                    case 8: // 'i'
                    case 13: // 'r'
                    case 19: // 't'
                        wordAlphas[i].put(key, true);
                        alphabet[key] = 2;
                        break;
                    default:
                        wordAlphas[i].put(key, false);
                        alphabet[key] = 1;
                        break;
                }

            }
        }
        maxKey++;

        if(K < 5){ // cannot learn "anta" & "tica" -> cannot learn any word
            System.out.println(0);
            return;
        }

        int tolearn = 0; // count of alphabets to learn to read all words
        for(int i = 0; i < 26; i++){
            if(alphabet[i] > 0) tolearn++;
        }
        if(K >= tolearn){ // can learn every alphabet to read all words
            System.out.println(N);
            return;
        }
        teaching(5, 1); // 5 : already learned 5 alphabet, 1 : start from 'b'
        System.out.println(maxW);
    }

    static void teaching(int cnt, int idx){ // cnt : count of alphabet learned, idx : starting point of new alphabet
        if(cnt == K){
            int cntW = 0;

            for(int i = 0; i < N; i++){
                if(!wordAlphas[i].containsValue(false)){ // can read this word
                    cntW++;
                }
            }
            maxW = Math.max(maxW, cntW);
            return;
        }
        if(maxW == N) return; // no need to learn more
        for(int i = idx; i < maxKey; i++){
            if(alphabet[i] == 1){ // used but not checked
                alphabet[i] = 2;

                for(int j = 0; j < N; j++){
                    if(wordAlphas[j].containsKey(i)){
                        wordAlphas[j].put(i, true); // true : can read (learned)
                    }
                }

                teaching(cnt + 1, i + 1);

                for(int j = 0; j < N; j++){
                    if(wordAlphas[j].containsKey(i)){
                        wordAlphas[j].put(i, false); // false : cannot read (not learned)
                    }
                }

                alphabet[i] = 1;
            }
        }
    }
}