import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dice {
    int x, y; // 주사위 위치 좌표
    int top, bottom; // 주사위 윗면, 아랫면 값
    int left, right; // 주사위 왼쪽 면, 오른쪽 면 값
    int front, behind; // 주사위 앞면, 뒷면 값

    public Dice(){}

    public Dice(int x, int y){ // 주사위 모든 면 초기 값은 0
        this.x = x;
        this.y = y;
        top = 0; bottom = 0;
        left = 0; right = 0;
        front = 0; behind = 0;
    }

    public void rollNorth(){ // 왼쪽, 오른쪽 변화 없음
        int temp = top;
        top = front;
        front = bottom;
        bottom = behind;
        behind = temp;
    }
    public void rollSouth(){ // 왼쪽, 오른쪽 변화 없음
        int temp = top;
        top = behind;
        behind = bottom;
        bottom = front;
        front = temp;
    }
    public void rollEast(){ // 앞쪽, 뒷쪽 변화 없음
        int temp = top;
        top = left;
        left = bottom;
        bottom = right;
        right = temp;
    }
    public void rollWest(){ // 앞쪽, 뒷쪽 변화 없음
        int temp = top;
        top = right;
        right = bottom;
        bottom = left;
        left = temp;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Dice dice = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dir = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 1 : 동, 2 : 서, 3 : 북, 4 : 남
        st = new StringTokenizer(in.readLine());
        for(int k = 0; k < K; k++) {
            int d = Integer.parseInt(st.nextToken());
            int x = dice.x + dir[d][0];
            int y = dice.y + dir[d][1];
            if(x < 0 || x >= N || y < 0 || y >= M) continue;

            dice.x = x;
            dice.y = y;
            switch (d) {
                case 1: // 동
                    dice.rollEast();
                    break;
                case 2: // 서
                    dice.rollWest();
                    break;
                case 3: // 북
                    dice.rollNorth();
                    break;
                case 4: // 남
                    dice.rollSouth();
                    break;
            }
            sb.append(dice.top).append("\n");
            if(map[x][y] == 0) map[x][y] = dice.bottom; // 이동한 칸에 쓰인 수가 0이면 주사위 바닥면 숫자가 칸에 복사
            else { // 이동한 칸에 쓰인 수가 0이 아니면
                dice.bottom = map[x][y]; // 칸에 쓰인 수가 주사위 바닥면에 복사
                map[x][y] = 0; // 칸에 쓰인 수는 0
            }
        }
        System.out.println(sb);
    }
}
