import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] rooms = new int[6][2]; // grade 1 ~ 6 (-> 0 ~ 5) & sex male/female

        int S, Y;
        for(int i = 0; i < N; i++){ // seperate students by grade and sex
            st = new StringTokenizer(in.readLine());
            S = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken()) - 1;

            rooms[Y][S]++;
        }

        int cnt = 0;
        for(int i = 0; i < 6; i++){ // seperate students by maximum capacity
            // female
            cnt += rooms[i][0] / K;
            if(rooms[i][0] % K > 0) cnt++;
            // male
            cnt += rooms[i][1] / K;
            if(rooms[i][1] % K > 0) cnt++;
        }

        System.out.println(cnt);
    }
}
