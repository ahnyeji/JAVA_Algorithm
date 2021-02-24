import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(in.readLine());

        int[][] points = new int[6][2]; // save direction & length as coordinates(x, y)
        // starting coordinates (0,0)
        points[0][0] = 0; // x
        points[0][1] = 0; // y
        int dir, len;
        int maxX = 0;
        int minX = 0;
        int maxY = 0;
        int minY = 0;
        for(int i = 1; i < 6; i++){ // 6th direction & length go to starting coordinates (0,0)
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            dir = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());

            switch (dir){
                case 1: // east : go left (-)
                    points[i][0] = points[i - 1][0] - len;
                    points[i][1] = points[i - 1][1];
                    break;
                case 2: // west : go right (+)
                    points[i][0] = points[i - 1][0] + len;
                    points[i][1] = points[i - 1][1];
                    break;
                case 3: // south : go under (-)
                    points[i][0] = points[i - 1][0];
                    points[i][1] = points[i - 1][1] - len;
                    break;
                case 4: // north : go up (+)
                    points[i][0] = points[i - 1][0];
                    points[i][1] = points[i - 1][1] + len;
                    break;
            }
            // update maximum X, maximum Y, minimum X, minimum Y -> to compute bigger area
            maxX = Math.max(maxX, points[i][0]);
            maxY = Math.max(maxY, points[i][1]);
            minX = Math.min(minX, points[i][0]);
            minY = Math.min(minY, points[i][1]);
        }
        in.readLine();

        int idx = 0;
        for(int i = 0; i < 6; i++){ // find inner point
            if(points[i][0] != maxX && points[i][0] != minX && points[i][1] != maxY && points[i][1] != minY){
                idx = i;
                break;
            }
        }

        // to compute smaller area to be excluded
        int dx = Math.abs(points[idx][0] - points[(idx - 1 + 6) % 6][0]);
        int dy = Math.abs(points[idx][1] - points[(idx - 1 + 6) % 6][1]);

        if(dx == 0){
            dx = Math.abs(points[idx][0] - points[(idx + 1) % 6][0]);
        } else {
            dy = Math.abs(points[idx][1] - points[(idx + 1) % 6][1]);
        }

        System.out.print(K * ((maxX - minX) * (maxY - minY) - dx * dy));

    }
}
