import java.util.Scanner;

public class Main {
    static int N;
    static int[] row;
    static boolean[] col;
    static int cases = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        row = new int[N];
        col = new boolean[N];

        queen(0);
        System.out.println(cases);
    }

    static void queen(int cnt){
        if(cnt == N){ // all queens on board
            cases++;
            return;
        }
        if(cnt == 0){ // not need to check cross
            for(int i = 0; i < N; i++){ // check columns already used or not
                row[cnt] = i;
                col[i] = true;
                queen(cnt + 1);
                col[i] = false;
                row[cnt] = 0;
            }
        }
        else{
            for(int i = 0; i < N; i++){ // check columns already used or not
                if(!col[i]){
                    boolean cross = false; // check queens on cross
                    for(int j = 0, x, y; j < cnt; j++){
                        x = i - row[j]; // dx
                        y = cnt - j; // dy
                        if(x == y || x == -y){ // cross : gradient 1 or -1 (-> dx == dy or dx == -dy)
                            cross = true;
                            break;
                        }
                    }
                    if(!cross){ // no queens on cross line
                        row[cnt] = i;
                        col[i] = true;
                        queen(cnt + 1);
                        col[i] = false;
                        row[cnt] = 0;
                    }
                }
            }
        }
    }
}
