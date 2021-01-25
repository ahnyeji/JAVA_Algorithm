/* BOJ - 2908 : 상수
   25.January.2021
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a, b;
        a = sc.next();
        b = sc.next();
        int aa = 0;
        int bb = 0;
        for (int i = 2; i >= 0; i--) {
            aa *= 10;
            bb *= 10;
            aa += (a.charAt(i) - '0');
            bb += (b.charAt(i) - '0');
        }
        System.out.println(aa > bb ? aa : bb);
        sc.close();
    }
}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a, b;
//        a = sc.nextInt();
//        b = sc.nextInt();
//        int aa = 0;
//        int bb = 0;
//        for(int i = 0; i < 3; i++){
//            aa = aa * 10 + a % 10;
//            bb = bb * 10 + b % 10;
//            a /= 10;
//            b /= 10;
//        }
//        System.out.println(aa > bb ? aa : bb);
//        sc.close();
//    }
//}