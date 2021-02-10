import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N, M, R;
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // get array
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // get operations
        int[] orders = new int[R];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < R; i++){
            orders[i] = Integer.parseInt(st.nextToken());
        }

        // do operations
        for(int o = 0; o < R; o++){
            int halfR = N / 2; // half of row
            int halfC = M / 2; // half of column
            switch (orders[o]){
                case 1: // up down reverse
                    int[] tempR;
                    for(int i = 0; i < halfR; i++){
                        tempR = arr[i];
                        arr[i] = arr[N - i - 1];
                        arr[N - i - 1] = tempR;
                    }
                    break;
                case 2: // left right reverse
                    int tempC;
                    for(int j = 0; j < halfC; j++){
                        for(int i = 0; i < N; i++){
                            tempC = arr[i][j];
                            arr[i][j] = arr[i][M - j - 1];
                            arr[i][M - j - 1] = tempC;
                        }
                    }
                    break;
                case 3: // rotate degree -90 (clockwise) -> first column become first row
                    int[][] rotate = new int[M][N];
                    for(int i = N - 1; i >= 0; i--){
                        for(int j = 0; j < M; j++){
                            rotate[j][N - i - 1] = arr[i][j];
                        }
                    }
                    arr = rotate;
                    int tempN = N;
                    N = M;
                    M = tempN;
                    break;
                case 4: // rotate degree 90 (anti-clockwise) -> last column become first row
                    int[][] antirotate = new int[M][N];
                    for(int i = 0; i < N; i++){
                        for(int j = M - 1; j >= 0; j--){
                            antirotate[M - j - 1][i] = arr[i][j];
                        }
                    }
                    arr = antirotate;
                    int tempM = M;
                    M = N;
                    N = tempM;
                    break;
                case 5: // moving subarray clockwise
                    int[][] clock = new int[N][M];
                    for(int i = 0; i < halfR; i++){
                        // moving upper left part to upper right
                        System.arraycopy(arr[i], 0, clock[i], halfC, halfC);
                        // moving upper right part to lower right
                        System.arraycopy(arr[i], halfC, clock[i + halfR], halfC, halfC);
                    }
                    for(int i = halfR; i < N; i++){
                        // moving lower right part to lower left
                        System.arraycopy(arr[i], halfC, clock[i], 0, halfC);
                        // moving lower left part to upper left
                        System.arraycopy(arr[i], 0, clock[i - halfR], 0, halfC);
                    }
                    arr = clock;
                    break;
                case 6: // moving subarray anti-clockwise
                    int[][] anticlock = new int[N][M];
                    for(int i = 0; i < halfR; i++){
                        // moving upper left part to lower left
                        System.arraycopy(arr[i], 0, anticlock[i + halfR], 0, halfC);
                        // moving upper right part to upper left
                        System.arraycopy(arr[i], halfC, anticlock[i], 0, halfC);
                    }
                    for(int i = halfR; i < N; i++){
                        // moving lower right part to upper right
                        System.arraycopy(arr[i], halfC, anticlock[i - halfR], halfC, halfC);
                        // moving lower left part to lower right
                        System.arraycopy(arr[i], 0, anticlock[i], halfC, halfC);
                    }
                    arr = anticlock;
                    break;
            }

        }
        for(int[] row : arr){
            sb.append(Arrays.toString(row).replace("[", "").replace("]", "").replaceAll(",", "")).append("\n");
        }
        System.out.println(sb);
    }
}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N, M, R;
//        StringTokenizer st = new StringTokenizer(in.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        R = Integer.parseInt(st.nextToken());
//
//        int[][] arr = new int[N][M];
//        for(int i = 0; i < N; i++){
//            st = new StringTokenizer(in.readLine());
//            for(int j = 0; j < M; j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int[] orders = new int[R];
//        st = new StringTokenizer(in.readLine());
//        for(int i = 0; i < R; i++){
//            orders[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for(int o = 0; o < R; o++){
//            int halfR = N / 2;
//            int halfC = M / 2;
//            switch (orders[o]){
//                case 1:
//                    int[] tempR;
//                    for(int i = 0; i < halfR; i++){
//                        tempR = arr[i];
//                        arr[i] = arr[N - i - 1];
//                        arr[N - i - 1] = tempR;
//                    }
//                    break;
//                case 2:
//                    int tempC;
//                    for(int j = 0; j < halfC; j++){
//                        for(int i = 0; i < N; i++){
//                            tempC = arr[i][j];
//                            arr[i][j] = arr[i][M - j - 1];
//                            arr[i][M - j - 1] = tempC;
//                        }
//                    }
//                    break;
//                case 3:
//                    int[][] rotate = new int[M][N];
//                    for(int i = N - 1; i >= 0; i--){
//                        for(int j = 0; j < M; j++){
//                            rotate[j][N - i - 1] = arr[i][j];
//                        }
//                    }
//                    arr = rotate;
//                    int tempN = N;
//                    N = M;
//                    M = tempN;
//                    break;
//                case 4:
//                    int[][] antirotate = new int[M][N];
//                    for(int i = 0; i < N; i++){
//                        for(int j = M - 1; j >= 0; j--){
//                            antirotate[M - j - 1][i] = arr[i][j];
//                        }
//                    }
//                    arr = antirotate;
//                    int tempM = M;
//                    M = N;
//                    N = tempM;
//                    break;
//                case 5:
//                    int[][] clock = new int[N][M];
//                    for(int i = 0; i < halfR; i++){
//                        for(int j = 0; j < halfC; j++){
//                            clock[i][j + halfC] = arr[i][j];
//                        }
//                    }
//                    for(int i = 0; i < halfR; i++){
//                        for(int j = halfC; j < M; j++){
//                            clock[i + halfR][j] = arr[i][j];
//                        }
//                    }
//                    for(int i = halfR; i < N; i++){
//                        for(int j = halfC; j < M; j++){
//                            clock[i][j - halfC] = arr[i][j];
//                        }
//                    }
//                    for(int i = halfR; i < N; i++){
//                        for(int j = 0; j < halfC; j++){
//                            clock[i - halfR][j] = arr[i][j];
//                        }
//                    }
//                    arr = clock;
//                    break;
//                case 6:
//                    int[][] anticlock = new int[N][M];
//                    for(int i = 0; i < halfR; i++){
//                        for(int j = 0; j < halfC; j++){
//                            anticlock[i + halfR][j] = arr[i][j];
//                        }
//                    }
//                    for(int i = 0; i < halfR; i++){
//                        for(int j = halfC; j < M; j++){
//                            anticlock[i][j - halfC] = arr[i][j];
//                        }
//                    }
//                    for(int i = halfR; i < N; i++){
//                        for(int j = halfC; j < M; j++){
//                            anticlock[i - halfR][j] = arr[i][j];
//                        }
//                    }
//                    for(int i = halfR; i < N; i++){
//                        for(int j = 0; j < halfC; j++){
//                            anticlock[i][j + halfC] = arr[i][j];
//                        }
//                    }
//                    arr = anticlock;
//                    break;
//            }
//
//        }
//        int len = arr.length;
//        for(int i = 0; i < len; i++){
//            sb.append(Arrays.toString(arr[i]).replace("[", "").replace("]", "").replaceAll(",", "")).append("\n");
//        }
//        System.out.println(sb);
//    }
//}