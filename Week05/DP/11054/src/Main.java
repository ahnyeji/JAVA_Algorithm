/*  [DP]
    # 점화식
      - ascending[i] = max(ascending[j]) + 1 (ascending[j] : seq[j] < seq[i]인 원소)
      - descending[i] = max(descending[j]) + 1 (descending[j] : seq[i] > seq[j]인 원소)
      => 둘 합치면 i번째 원소가 가장 큰 수인 바이토닉 수열이 됨 (i번째 원소 2번 count)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] seq = new int[N]; // input sequence
        int[] asc = new int[N]; // ascending sequence length (ascending from head)
        int[] des = new int[N]; // descending sequence length (ascending from tail)

        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
            for(int j = i - 1; j > -1; j--){ // check ascending maximum length can contain this element
                if(seq[i] > seq[j]){ // ascending
                    asc[i] = Math.max(asc[i], asc[j]); // update maximum length
                }
            }
            asc[i]++; // contain this element to length
        }

        des[N - 1] = 1;
        for(int i = N - 2; i > -1; i--){
            for(int j = i + 1; j < N; j++){ // check descending maximum length can contain this element
                if(seq[i] > seq[j]){ // descending
                    des[i] = Math.max(des[i], des[j]); // update maximum length
                }
            }
            des[i]++; // contain this element to length
        }

        int maxi = 2;
        for(int i = 0; i < N; i++){ // find maximum bitonic sequence length
            maxi = Math.max(maxi, asc[i] + des[i]); // update entire maximum length
        }
        System.out.print(maxi - 1); // contain maximum element twice -> should subtract 1
    }
}
