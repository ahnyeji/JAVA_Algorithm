import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.next();
        s = s.toUpperCase(); // Case insensitive && Answer should be UpperCase
        int[] alpha = new int[26]; // counting index of 'A' is 0 && # of alphabet == 26
        int max = 0; // max count of same alphabet
        for(char c : s.toCharArray()) {
            int cnt = ++alpha[c - 'A']; // to compare max & count of current alphabet
            max = (max < cnt ? cnt : max);
        }
        int idx = -1; // to check if max count appears once ()
        int check = 0;
        for(int i = 0; i < 26; i++){
            if(max == alpha[i]){ // find the index of max count
                if(idx != -1){ // same max counts exist, print "?"
                    System.out.println("?");
                    check = 1; // let to know already printed answer
                    break;
                } else { // first meet max count
                    idx = i;
                }
            }
        }
        if(check == 0){
            idx += 'A'; // to know answer ('A' matches with 0 -> after add 'A' to idx, can get answer)
            System.out.println((char)idx);
        }
    }
}
