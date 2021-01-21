import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int cycle = 0;
        int before = n;
        int after;
        while(true) {
            after = (before % 10) * 10 + (before / 10 + before % 10) % 10;
            cycle++;
            if(n == after) {
                break;
            }
            before = after;
        }
        System.out.println(cycle);
        sc.close();
    }
}
