/* BOJ - 2941 : 크로아티아 알파벳
   26.January.2021
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            String word = sc.next();
            int l = word.length();
            int[] alpha = new int[26]; // 0 if never checked
            int j;
            for(j = 0; j < l; j++){
                char c = word.charAt(j);
                if(alpha[c - 'a'] > 0){

                    if(word.charAt(j - 1) != c){ // already used and its not continuous
                        break;
                    }
                } else {
                    alpha[c - 'a']++;
                }
            }
            if(j == l){ // not broken == group word
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
