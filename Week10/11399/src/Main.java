/*  [Greedy]
    # 먼저 온 사람의 시간이 반복해서 더해짐 -> 가장 적은 시간을 필요로 하는 사람이 가장 앞에 와야함 -> 오름차순 정렬
    # 총 시간 : atm[i] * (n - i)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] atm = new int[N];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            atm[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(atm); // sort by ascending

        int ans = 0; // total time
        for(int i = 0; i < N; i++) {
            ans += atm[i] * (N - i); // atm[i] should be added (N - i) times -> add atm[i] * (N - i)
        }
        System.out.println(ans);
    }
}
