import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int[][] sudoku = new int[9][9];
            int ans = 1;

            // save input at sudoku & check row
            for(int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                boolean[] check = new boolean[10];
                for(int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                    if(check[sudoku[i][j]]) ans = 0;
                    else check[sudoku[i][j]] = true;
                }
            }

            if(ans == 0) { // row check -> same number exist
                sb.append(ans).append("\n");
                continue; // no more checking
            }

            // check column
            for(int j = 0; j < 9; j++) {
                boolean[] check = new boolean[10];
                for(int i = 0; i < 9; i++) {
                    if(check[sudoku[i][j]]) { // same number exist
                        ans = 0;
                        break;
                    }
                    else check[sudoku[i][j]] = true;
                }
                if(ans == 0) { // same number exist -> column check broken
                    break;
                }
            }

            if(ans == 0) { // column check -> same number exist
                sb.append(ans).append("\n");
                continue; // no more checking
            }

            // check square
            // 0 1 2 -> row 0 (sudoku row 0~2)
            // 3 4 5 -> row 1 (sudoku row 3~5)
            // 6 7 8 -> row 2 (sudoku row 6~8)
            // column
            // 0 1 2
            for(int i = 0; i < 9; i++) {
                boolean[] check = new boolean[10];
                int row = i / 3 * 3 + 2; // [0,1,2] : i/3 == 0, [3,4,5] : i/3 == 1, [6,7,8] : i/3 == 2
                int col = i % 3 * 3 + 2; // [0,3,6] : i%3 == 0, [1,4,7] : i%3 == 1, [2,5,8] : i%3 == 2
                for(int r = row - 2; r <= row; r++) {
                    for(int c = col - 2; c <= col; c++) {
                        if(check[sudoku[r][c]]) { // same number exist
                            ans = 0;
                            break;
                        }
                        else check[sudoku[r][c]] = true;
                    }
                    if(ans == 0) break; // same number exist -> square check broken
                }
                if(ans == 0) break; // same number exist -> square check broken
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
