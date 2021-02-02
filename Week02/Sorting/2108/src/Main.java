/*  BOJ - 2108 : 통계학
    03.February.2021
 */
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        // 1. average
        sb.append(Math.round((double)sum / N)).append("\n");

        // 2. median : middle of ascending sorted data
        Arrays.sort(nums);
        if(N % 2 == 0){ // even numbers : 2 middles -> average
            sb.append((nums[N / 2] + nums[N / 2 + 1]) / 2).append("\n");
        } else{
            sb.append(nums[N / 2]).append("\n");
        }

        // 3. mode : biggest count number
        PriorityQueue<int[]> mode = new PriorityQueue<>(new Comparator<int[]>() {
            // {count, number} -> count : descending, number : ascending
            @Override
            public int compare(int[] o1, int[] o2) {
                int cntDiff = o2[0] - o1[0];
                return cntDiff == 0 ? o1[1] - o2[1] : cntDiff;
            }
        });
        int cnt = 0;
        for(int i = 1; i < N; i++){
            cnt++;
            if(nums[i - 1] != nums[i]){
                mode.add(new int[]{cnt, nums[i - 1]});
                cnt = 0;
            }
        }
        mode.add(new int[]{cnt + 1, nums[N - 1]}); // count of last number

        if(mode.size() > 1){
            int[] mode1st = mode.poll();
            int[] mode2nd = mode.poll();
            if(mode1st[0] == mode2nd[0]) sb.append(mode2nd[1]).append("\n");
            else sb.append(mode1st[1]).append("\n");
        }
        else sb.append(mode.poll()[1]).append("\n");
        sb.append(nums[N - 1] - nums[0]);

        System.out.println(sb.toString());
    }
}
