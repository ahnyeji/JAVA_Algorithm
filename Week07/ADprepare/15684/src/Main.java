import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, H;
    static boolean[][] ladder; // [vertical][horizontal] : true - connected, false - disconnected
    static int mini = 4; // maximum count : 3
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[N + 1][H + 1];
        int a, b;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ladder[b][a] = true;
        }
        connect(0, 1);
        if(mini == 4) System.out.println(-1);
        else System.out.println(mini);
    }

    static boolean check(){
        int start;
        for(int i = 1; i <= N; i++){ // check ith vertical line
            start = i;
            for(int j = 1; j <= H; j++){ // moving : horizontal line
                if(ladder[start][j]) start++; // [start] -- [start + 1] connected : go right
                else if(ladder[start - 1][j]) start--; // [start - 1] -- [start] connected : go left
            }
            if(start != i) return false;
        }
        return true;
    }

    static void connect(int cnt, int idx){ // connect maximum 3 more horizontal lines
        if(cnt > 3) return; // more than maximum -> fail
        if(check()){ // success
            mini = Math.min(mini, cnt); // count new horizontal lines & get minimum count
            return;
        }
        for(int i = idx; i <= H; i++){ // check from 1st floor(top) to 6th floor(bottom)
            for(int j = 1; j < N; j++){ // check from left to right
                // check current, left, right horizontal lines connection -> cannot connect new line here
                if(!ladder[j][i] && !ladder[j - 1][i] && !ladder[j + 1][i]){
                    ladder[j][i] = true;
                    connect(cnt + 1, i);
                    ladder[j][i] = false;
                }
            }
        }
    }
}
