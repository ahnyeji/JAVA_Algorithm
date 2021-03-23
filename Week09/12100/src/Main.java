import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int maxi = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        int[][] board = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        game(0, board);
        System.out.println(maxi);
    }

    static void game(int cnt, int[][] board) { // 최대 5번까지 상하좌우 이동하는 함수
        if(cnt == 5) { // 5번이 채워졌다면 더이상 이동 불가 -> 최대값 찾기
            int maxB = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    maxB = Math.max(maxB, board[i][j]);
                }
            }
            maxi = Math.max(maxi, maxB);
            return;
        }
        int[][] moved = new int[N][N];
        for(int i = 0; i < 4; i++){ // 상하좌우 이동
            switch (i) {
                case 0: // 상
                    moved = up(board);
                    break;
                case 1: // 하
                    moved = down(board);
                    break;
                case 2: // 좌
                    moved = left(board);
                    break;
                case 3: // 우
                    moved = right(board);
                    break;
            }
            // 기존 상태와 같다면 더이상 이동할 필요 없음
            if(!Arrays.equals(board, moved)) game(cnt + 1, moved);
        }
    }
    static int[][] up(int[][] board) { // 상 이동
        int[][] ans = new int[N][N];
        for(int c = 0; c < N; c++){
            int b1 = 0; // 위쪽 블록
            int b2; // 아래쪽 블록
            int idx = 0; // 블록을 놓기 위한 위치
            for(int r = 0; r < N; r++){
                if(board[r][c] != 0) {
                    if(b1 == 0) b1 = board[r][c];
                    else{
                        b2 = board[r][c];
                        if(b1 == b2){
                            ans[idx++][c] = b1 * 2;
                            b1 = 0; // 한 번 합쳐진 블록은 다시 합쳐질 수 없음
                        } else {
                            ans[idx++][c] = b1;
                            b1 = b2;
                        }
                    }
                }
            }
            if(b1 != 0) ans[idx][c] = b1;
        }
        return ans;
    }
    static int[][] down(int[][] board) { // 하 이동
        int[][] ans = new int[N][N];
        for(int c = 0; c < N; c++){
            int b1 = 0; // 아래쪽 블록
            int b2; // 위쪽 블록
            int idx = N - 1; // 블록을 놓기 위한 위치
            for(int r = N - 1; r > -1; r--){
                if(board[r][c] != 0) {
                    if(b1 == 0) b1 = board[r][c];
                    else{
                        b2 = board[r][c];
                        if(b1 == b2){
                            ans[idx--][c] = b1 * 2;
                            b1 = 0; // 한 번 합쳐진 블록은 다시 합쳐질 수 없음
                        } else {
                            ans[idx--][c] = b1;
                            b1 = b2;
                        }
                    }
                }
            }
            if(b1 != 0) ans[idx][c] = b1;
        }
        return ans;
    }
    static int[][] left(int[][] board) { // 좌 이동
        int[][] ans = new int[N][N];
        for(int r = 0; r < N; r++){
            int b1 = 0; // 왼쪽 블록
            int b2; // 오른쪽 블록
            int idx = 0; // 블록을 놓기 위한 위치
            for(int c = 0; c < N; c++){
                if(board[r][c] != 0) {
                    if(b1 == 0) b1 = board[r][c];
                    else{
                        b2 = board[r][c];
                        if(b1 == b2){
                            ans[r][idx++] = b1 * 2;
                            b1 = 0; // 한 번 합쳐진 블록은 다시 합쳐질 수 없음
                        } else {
                            ans[r][idx++] = b1;
                            b1 = b2;
                        }
                    }
                }
            }
            if(b1 != 0) ans[r][idx] = b1;
        }
        return ans;
    }
    static int[][] right(int[][] board) { // 우 이동
        int[][] ans = new int[N][N];
        for(int r = 0; r < N; r++){
            int b1 = 0; // 오른쪽 블록
            int b2; // 왼쪽 블록
            int idx = N - 1; // 블록을 놓기 위한 위치
            for(int c = N - 1; c > -1; c--){
                if(board[r][c] != 0) {
                    if(b1 == 0) b1 = board[r][c];
                    else{
                        b2 = board[r][c];
                        if(b1 == b2){
                            ans[r][idx--] = b1 * 2;
                            b1 = 0; // 한 번 합쳐진 블록은 다시 합쳐질 수 없음
                        } else {
                            ans[r][idx--] = b1;
                            b1 = b2;
                        }
                    }
                }
            }
            if(b1 != 0) ans[r][idx] = b1;
        }
        return ans;
    }
}
