import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] box; // days of tomato ripening (inital tomato : 1)
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){ // ripe tomatoes : bfs starting points
                    q.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        int max = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 0){ // this tomato never ripe
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, box[i][j]);
            }
        }
        System.out.println(max - 1); // all values are 1 greater than days (started from 1)
    }

    static void bfs(){
        int[] tomato;
        int x, y;
        while(!q.isEmpty()){
            tomato = q.poll();
            for(int d = 0; d < 4; d++){ // surrounding 4 direction
                y = tomato[0] + dir[d][0];
                x = tomato[1] + dir[d][1];
                if(x > -1 && x < M && y > -1 && y < N && box[y][x] == 0){
                    box[y][x] = box[tomato[0]][tomato[1]] + 1;
                    q.offer(new int[]{y, x});
                }
            }
        }
    }
}
