import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < 10; tc++) {
            int T = Integer.parseInt(br.readLine());

            int[][] ladder = new int[100][100];
            int endR = 100; int endC = 100;

            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if(ladder[i][j] == 2) {
                        endR = i;
                        endC = j;
                    }
                }
            }

            while(endR > 0) {
                ladder[endR--][endC] = -1;
                while(endC > 0 && ladder[endR][endC - 1] == 1) {
                    ladder[endR][endC--] = -1;
                }
                while(endC < 99 && ladder[endR][endC + 1] == 1) {
                    ladder[endR][endC++] = -1;
                }
            }
            sb.append("#").append(T).append(" ").append(endC).append("\n");
        }
        System.out.println(sb.toString());
    }
}

