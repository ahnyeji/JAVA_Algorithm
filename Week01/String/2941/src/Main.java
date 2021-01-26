/* BOJ - 2941 : 크로아티아 알파벳
   26.January.2021
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cro;
        cro = sc.next();
        int len = cro.length();
        int cnt = 0;
        for(int i = 0; i < len; i++){
            cnt++; // count for all character & subtract if croatia character
            char c = cro.charAt(i);
            if(c == '='){
                char before = cro.charAt(i - 1);
                if(before == 'c' || before == 's'){ // 'c=' or 's=' : 2 char to 1 count -> subtract 1
                    cnt--;
                } else{
                    if(i > 1 && cro.charAt(i - 2) == 'd'){ // 'dz=' : 3 char to 1 count -> subtract 2
                        cnt -= 2;
                    } else{ // 'dz=' : 2 char to 1 count -> subtract 1
                        cnt--;
                    }
                }
            } else if(c == '-'){
                cnt--;
            } else if(c == 'j'){
                if(i > 0){ // 'j' can used as single character ('=', '-' cannot) -> can start with 'j'
                    char before = cro.charAt(i - 1);
                    if(before == 'l' || before == 'n'){
                        cnt--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
