import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) { return Integer.parseInt(s); }

    static int n;
    static int L;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        L = stoi(st.nextToken());
        map = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++)
                map[i][j] = stoi(st.nextToken());
        }


        for (int i=0; i<n; i++) {
            if (canGo(i, 0, 0))
                count++;

            if (canGo(0, i, 1))
                count++;
        }

        System.out.println(count);
    }


    static boolean canGo(int x, int y, int d) {
        int[] height = new int[n];
        boolean[] visited = new boolean[n];


        for (int i=0; i<n; i++) {
            height[i] = (d == 0) ? map[x][y+i] : map[x+i][y];
        }

        for (int i=0; i<n-1; i++) {

            if (height[i] == height[i+1]) {
                continue;
            }

            if (Math.abs(height[i] - height[i+1]) > 1) {
                return false;
            }


            if (height[i] - 1 == height[i+1]) {
                for (int j=i+1; j<=i+L; j++) {

                    if (j >= n || height[i+1] != height[j] || visited[j] == true) {
                        return false;
                    }
                    visited[j] = true;
                }
            }

            else if (height[i] + 1 == height[i+1]) {
                for (int j=i; j>i-L; j--) {
                    if (j < 0 || height[i] != height[j] || visited[j] == true) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
        }

        return true;
    }
}
