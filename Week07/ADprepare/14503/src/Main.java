import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] place = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++){
                place[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; // cleaning count
        int dir, y, x;  // next direction, next row, next column
        while(true){
            place[r][c] = 2; // 0 : not cleaned, 1 : wall, 2 : cleaned
            cnt++;

            boolean move = false; // true : can clean new point, false : cannot clean new point (go back or end)
            for(int i = 1; i <= 4; i++){ // 4 direction check
                dir = (d - i + 4) % 4; // next direction

                switch(dir){
                    case 0: // north (go up)
                        y = r - 1;
                        x = c;
                        if(y > 0 && y < N - 1 && place[y][x] == 0){ // border always wall & not cleaned yet
                            r = y;
                            c = x;
                            move = true;
                        }
                        break;
                    case 1: // east (go right)
                        y = r;
                        x = c + 1;
                        if(x > 0 && x < M - 1 && place[y][x] == 0){ // border always wall & not cleaned yet
                            r = y;
                            c = x;
                            move = true;
                        }
                        break;
                    case 2: // south (go down)
                        y = r + 1;
                        x = c;
                        if(y > 0 && y < N - 1 && place[y][x] == 0){ // border always wall & not cleaned yet
                            r = y;
                            c = x;
                            move = true;
                        }
                        break;
                    case 3: // west (go left)
                        y = r;
                        x = c - 1;
                        if(x > 0 && x < M - 1 && place[y][x] == 0){ // border always wall & not cleaned yet
                            r = y;
                            c = x;
                            move = true;
                        }
                        break;
                }

                if(move){
                    d = dir; // d : last direction
                    break;
                }
            }
            if(move) continue; // can clean new point
            // cannot clean new point
            switch (d){ // check last direction to go back
                case 0: // north -> should go south (go back)
                    y = r + 1;
                    x = c;
                    if(y > 0 && y < N - 1 && place[y][x] == 2){ // border always wall & already cleaned
                        r = y;
                        c = x;
                        cnt--; // not new point -> should exclude this moving from count
                        move = true;
                    }
                    break;
                case 1: // east -> should go west (go back)
                    y = r;
                    x = c - 1;
                    if(x > 0 && x < M - 1 && place[y][x] == 2){ // border always wall & already cleaned
                        r = y;
                        c = x;
                        cnt--; // not new point -> should exclude this moving from count
                        move = true;
                    }
                    break;
                case 2: // south -> should go north (go back)
                    y = r - 1;
                    x = c;
                    if(y > 0 && y < N - 1 && place[y][x] == 2){ // border always wall & already cleaned
                        r = y;
                        c = x;
                        cnt--; // not new point -> should exclude this moving from count
                        move = true;
                    }
                    break;
                case 3: // west -> should go east (go back)
                    y = r;
                    x = c + 1;
                    if(x > 0 && x < M - 1 && place[y][x] == 2){ // border always wall & already cleaned
                        r = y;
                        c = x;
                        cnt--; // not new point -> should exclude this moving from count
                        move = true;
                    }
                    break;
            }
            if(!move){ // cannot go back because of wall -> end
                break;
            }
        }
        System.out.print(cnt);
    }
}
