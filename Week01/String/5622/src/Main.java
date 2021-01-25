/* BOJ - 5622 : 다이얼
   25.January.2021
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dial = sc.next();
        int l = dial.length();
        int ans = l;
        for (int i = 0; i < l; i++) {
            char c = dial.charAt(i);
            if(c < 'D') {
                ans += 2;
            } else if(c < 'G') {
                ans += 3;
            } else if(c < 'J') {
                ans += 4;
            } else if(c < 'M') {
                ans += 5;
            } else if(c < 'P') {
                ans += 6;
            } else if(c < 'T') {
                ans += 7;
            } else if(c < 'W') {
                ans += 8;
            } else if(c <= 'Z') {
                ans += 9;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String dial = sc.next();
//        int l = dial.length();
//        int ans = 0;
//        for (int i = 0; i < l; i++) {
//            switch (dial.charAt(i)) {
//                case 'A':
//                case 'B':
//                case 'C':
//                    ans += 3;
//                    break;
//                case 'D':
//                case 'E':
//                case 'F':
//                    ans += 4;
//                    break;
//                case 'G':
//                case 'H':
//                case 'I':
//                    ans += 5;
//                    break;
//                case 'J':
//                case 'K':
//                case 'L':
//                    ans += 6;
//                    break;
//                case 'M':
//                case 'N':
//                case 'O':
//                    ans += 7;
//                    break;
//                case 'P':
//                case 'Q':
//                case 'R':
//                case 'S':
//                    ans += 8;
//                    break;
//                case 'T':
//                case 'U':
//                case 'V':
//                    ans += 9;
//                    break;
//                case 'W':
//                case 'X':
//                case 'Y':
//                case 'Z':
//                    ans += 10;
//                    break;
//            }
//        }
//        System.out.println(ans);
//        sc.close();
//    }
//}
