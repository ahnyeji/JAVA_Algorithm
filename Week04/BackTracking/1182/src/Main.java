/*
    부분수열 : 수열의 일부 항을 원래 순서대로 나열하여 얻을 수 있는 수열 -> 순서만 지키면 연속되지 않아도 됨
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] seq;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        seq = new int[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        nextElem(0, 0, 0);
        System.out.println(count);
    }

    // using power set
    static void nextElem(int cnt, int idx, int sum){
        if(sum == S && cnt > 0) count++;
        if(idx == N) return; // checked all elements
        for(int i = idx; i < N; i++){
            nextElem(cnt + 1, i + 1, sum + seq[i]);
        }
    }
}
