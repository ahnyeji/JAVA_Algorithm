import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] board;
    static boolean[][] rowch;
    static boolean[][] colch;
    static boolean[][] partch;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        board = new int[9][9];
        rowch = new boolean[9][10];
        colch = new boolean[9][10];
        partch = new boolean[9][10];

        for(int i = 0; i < 9; i++) {
            String inp = in.readLine();
            for(int j = 0; j < 9; j++) {
                board[i][j] = inp.charAt(j << 1) - '0';
                if(board[i][j] != 0) {
                    rowch[i][board[i][j]] = true;
                    colch[j][board[i][j]] = true;
                    int ith = (i / 3) * 3 + (j / 3);
                    partch[ith][board[i][j]] = true;
                }
            }
        }

        int r = 0, c = 0;
        while(r < 9 && board[r][c] > 0) {
            c++;
            if(c == 8) {
                r++;
                c = 0;
            }
        }
        if(r < 9) sudoku(r, c);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static boolean sudoku(int r, int c) {
        int part = (r / 3) * 3 + (c / 3);
        for(int i = 1; i <= 9; i++) {
            if(!rowch[r][i] && !colch[c][i] && !partch[part][i]) {
                board[r][c] = i;
                rowch[r][i] = true;
                colch[c][i] = true;
                partch[part][i] = true;
                int y = r;
                int x = c + 1;
                boolean next = false;
                for(; y < 9; y++) {
                    for(; x < 9; x++) {
                        if(board[y][x] == 0) {
                            next = true;
                            break;
                        }
                    }
                    if(next) break;
                    x = 0;
                }

                if(!next) return true;
                if(sudoku(y, x)) return true;

                board[r][c] = 0;
                rowch[r][i] = false;
                colch[c][i] = false;
                partch[part][i] = false;
            }
        }

        return false;
    }
}
