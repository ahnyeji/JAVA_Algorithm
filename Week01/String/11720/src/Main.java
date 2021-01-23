import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        String nums;
        nums = sc.next();
        int sum = 0;
        int len = nums.length();
        for(int i = 0; i < len; i++){
            sum += (int)(nums.charAt(i) - '0');
        }
        System.out.println(sum);
    }
}
