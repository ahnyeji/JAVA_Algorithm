// 미완성 코드


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static String[] words;
    static ArrayList<HashMap<Character, Boolean>> alphas= new ArrayList<>();
    static boolean[] alphabet = new boolean[26];
    static int maxW = 0;
    static int lastAlpha = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];

        for(int i = 0; i < N; i++){
            words[i] = in.readLine();
            words[i] = words[i].substring(4, words[i].length() - 4);
        }

        if(K < 6){
            System.out.println(0);
            return;
        }

        char[] se = {'a', 'n', 't', 'i', 'c'};
        for(char c : se){
            alphabet[c - 'a'] = true;
        }

        for(String word : words){
            int len = word.length();
            HashMap<Character, Boolean> alphaW = new HashMap<>();
            for(int i = 0; i < len; i++){
                alphaW.put(word.charAt(i), false);
                lastAlpha = Math.max(lastAlpha, word.charAt(i) - 'a');
            }
            alphaW.remove('a');
            alphaW.remove('n');
            alphaW.remove('t');
            alphaW.remove('i');
            alphaW.remove('c');

            alphas.add(alphaW);
        }
        lastAlpha++;

        for(HashMap<Character, Boolean>)

        teaching(5);
        System.out.println(maxW);
    }

    static void teaching(int cnt){
        if(cnt == K){
            int cntW = 0;
            for(HashMap<Character, Boolean> afterCheck : alphas){
                if(!afterCheck.containsValue(false)){
                    cntW++;
                }
            }
            maxW = Math.max(maxW, cntW);
            return;
        }
        if(maxW == N) return;
        for(int i = 0; i < lastAlpha; i++){
            if(!alphabet[i]){
                for(int j = 0; j < N; j++){
                    HashMap<Character, Boolean> word = alphas.get(j);
                    if(word.containsKey('a' + i)){
                        word.put((char) ('a' + i), true);
                    }
                }
                teaching(cnt + 1);
                for(int j = 0; j < N; j++){
                    HashMap<Character, Boolean> word = alphas.get(j);
                    if(word.containsKey('a' + i)){
                        word.put((char) ('a' + i), false);
                    }
                }
            }
        }
    }
}
