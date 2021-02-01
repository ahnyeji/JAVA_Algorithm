/*  BOJ - 1244 : 스위치 켜고 끄기
    01.February.2021
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boolean[] switches = new boolean[N + 1]; // input numbers for index starts from 1
        for(int i = 1; i <= N; i++) {
            // ! inside part can be simplified like this !
            // switches[i] = !st.nextToken().equals("0");
            if(st.nextToken().equals("0")) {
                switches[i] = false;
            } else {
                switches[i] = true;
            }
        }

        int snum = Integer.parseInt(br.readLine());
        for(int s = 0; s < snum; s++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sex = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if(sex == 1) {
                for(int i = idx; i <= N; i += idx) {
                    // ! this code can be simplified like this !
                    // switches[i] = !switches[i];
                    switches[i] = switches[i] ? false : true;
                }
            } else {
                // ! this code can be simplified like this !
                // switches[idx] = !switches[idx];
                switches[idx] = switches[idx] ? false : true;
                for(int i = 1; i < N; i++) {
                    int l = idx - i;
                    int r = idx + i;
                    if(l < 1 || r > N || switches[l] != switches[r]) {
                        break;
                    }
                    // ! this code can be simplified like this !
                    // switches[l] = !switches[l];
                    switches[l] = switches[l] ? false : true;
                    // ! this code can be simplified like this !
                    // switches[r] = !switches[r];
                    switches[r] = switches[r] ? false : true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(switches[i]) sb.append("1");
            else sb.append("0");
            if(i % 20 == 0) sb.append("\n");
            else sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
