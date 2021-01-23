/* BOJ - 1152 : 단어의 개수
   23.January.2021
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.nextLine();
        s = s.trim();
        int cnt = 0;
        if(s.length() > 0){
            String[] words = s.split(" ");
            cnt += words.length;
        }
        System.out.println(cnt);
    }
}
