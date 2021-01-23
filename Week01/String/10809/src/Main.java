import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.next();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        int l = s.length();
        int idx;
        for(int i = 0; i < l; i++){
            idx = s.charAt(i) - 'a';
            if(alphabet[idx] == -1){
                alphabet[idx] = i;
            }
        }
        for(int i = 0; i < 26; i++){
            System.out.print(alphabet[i] + " ");
        }
        sc.close();
    }
}
