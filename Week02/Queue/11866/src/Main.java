/*  BOJ - 11866 : 요세푸스 문제 0
    05.February.2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        sb.append("<");

        ArrayList<Integer> seq = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            seq.add(i);
        }

        int end = -1;
        int idx;
        while(N > 1){
            idx = (end + K) % N--; // index of number to remove
            end = idx - 1; // end of queue;
            sb.append(seq.get(idx)).append(", ");
            seq.remove(idx); // remove -> index change
        }
        sb.append(seq.get(0)).append(">"); // no "," & yes ">" after last number
        System.out.println(sb);
    }
}
