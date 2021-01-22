import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int cnt;
        if(N < 100){
            cnt = N;
        }
        else {
            cnt = 99;
            for(int i = 100; i <= N; i++){
                if(isAP(i)){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean isAP(int n) {
        int mid = n / 10 % 10;
        if(n % 10 - mid == mid - n / 100) {
            return true;
        }
        return false;
    }
}
