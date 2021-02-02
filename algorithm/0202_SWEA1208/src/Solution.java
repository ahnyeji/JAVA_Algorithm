import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc < 11; tc++) {

            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            ArrayList<Integer>boxes = new ArrayList<>();
            for(int i = 0; i < 100; i++) {
                boxes.add(Integer.parseInt(st.nextToken()));
            }

            while(dump-- > 0) {
                Collections.sort(boxes);
                int min = boxes.get(0);
                int max = boxes.get(99);
                if(max - min < 2) break;
                boxes.set(0, min + 1);
                boxes.set(99, max - 1);
            }
            Collections.sort(boxes);
            sb.append("#").append(tc).append(" ").append(boxes.get(99) - boxes.get(0)).append("\n");
        }
        System.out.println(sb.toString());
    }
}