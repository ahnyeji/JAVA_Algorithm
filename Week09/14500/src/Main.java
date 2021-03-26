import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Tetromino {
    ArrayList<int[][]> shapes;
    ArrayList<int[][]> syms;
    Tetromino(int h, int w, int[][] shape, boolean symmetry, int rot) {
        shapes = new ArrayList<>();
        shapes.add(shape);
        if(symmetry) {
            syms = new ArrayList<>();
            int[][] sym = new int[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    sym[i][j] = shape[i][w - j - 1];
                }
            }
            syms.add(sym);
            int sh = h;
            int sw = w;
            for(int r = 0; r < rot; r++) {
                int change = sh;
                sh = sw;
                sw = change;
                int[][] temp = new int[sh][sw];
                for(int i = 0; i < sh; i++) {
                    for(int j = 0; j < sw; j++) {
                        temp[i][j] = sym[sw - j - 1][i];
                    }
                }
                syms.add(temp);
                sym = temp;
            }
        }
        for(int r = 0; r < rot; r++) {
            int change = h;
            h = w;
            w = change;
            int[][] temp = new int[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    temp[i][j] = shape[w - j - 1][i];
                }
            }
            shapes.add(temp);
            shape = temp;
        }

    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Tetromino[] tetro = new Tetromino[5];
        tetro[0] = new Tetromino(2, 2, new int[][]{{1, 1}, {1, 1}}, false, 0);
        tetro[1] = new Tetromino(1, 4, new int[][]{{1,1,1,1}}, false, 1);
        tetro[2] = new Tetromino(3, 2, new int[][]{{1, 0}, {1, 1}, {1, 0}}, true, 1);
        tetro[3] = new Tetromino(3, 2, new int[][]{{1, 0}, {1, 1}, {0, 1}}, true, 1);
        tetro[4] = new Tetromino(3, 2, new int[][]{{1, 0}, {1, 0}, {1, 1}}, true, 3);

        int maxi = 0;
        for(int i = 0; i < 5; i++) {
            for(int[][] sh : tetro[i].shapes){
                int h = sh.length;
                int w = sh[0].length;
                for(int r = 0; r <= N - h; r++) {
                    for(int c = 0; c <= M - w; c++) {
                        int sum = 0;
                        for(int y = 0; y < h; y++) {
                            for(int x = 0; x < w; x++) {
                                sum += sh[y][x] * map[r + y][c + x];
                            }
                        }
                        maxi = Math.max(maxi, sum);
                    }
                }
            }
            if(tetro[i].syms == null) continue;
            for(int[][] sh : tetro[i].syms){
                int h = sh.length;
                int w = sh[0].length;
                for(int r = 0; r <= N - h; r++) {
                    for(int c = 0; c <= M - w; c++) {
                        int sum = 0;
                        for(int y = 0; y < h; y++) {
                            for(int x = 0; x < w; x++) {
                                sum += sh[y][x] * map[r + y][c + x];
                            }
                        }
                        maxi = Math.max(maxi, sum);
                    }
                }
            }

        }
        System.out.println(maxi);
    }

}
