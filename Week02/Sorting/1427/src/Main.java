import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digits = new int[10]; // digits are 0 ~ 9
        String num = br.readLine();
        int l = num.length();
        for(int i = 0; i < l; i++){
            digits[num.charAt(i) - '0']++; // count the digits
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){ // bigger number comes first
            while(digits[i]-- > 0){
                sb.append(i);
            }
        }
        System.out.println(sb.toString());
    }
}
