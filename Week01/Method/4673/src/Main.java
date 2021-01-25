/* BOJ - 4673 : 셀프 넘버
   22.January.2021
 */

// Method version -> 14896kb & 176ms
public class Main {
    // check self number -> 0 if not self number
    static int[] notSelf = new int[10001];

    public static void main(String[] args) {
        for(int i = 1; i < 10001; i++){
            if(notSelf[i] == 0){
                System.out.println(i);
                d(i);
            }
        }
    }

    // Recursive Method
    public static void d(int n) {
        if(n > 10000){ // out of range
            return;
        }
        int check = n;
        // sum of each digits
        while(n > 0){
            check += n % 10;
            n /= 10;
        }
        if(check < 10001){ // within range
            notSelf[check]++;
            d(check);
        }
    }
}

/*
// Loop version -> 14732KB & 160ms
public class Main {
    // check self number -> 0 if not self number
    static int[] notSelf = new int[10001];

    public static void main(String[] args) {
        for(int i = 1; i < 10001; i++){
            if(notSelf[i] == 0){
                System.out.println(i);
            }
            int n = i;
            int nextN = n;
            while(n > 0) {
                nextN += n % 10;
                n /= 10;
            }
            if(nextN < 10001){
                notSelf[nextN]++;
            }
        }
    }
}
*/
