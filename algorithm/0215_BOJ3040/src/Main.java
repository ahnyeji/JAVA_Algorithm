import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dwarf = new int[9];
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for(int i = 0; i < 9; i++){
            dwarf[i] = Integer.parseInt(in.readLine());
            sum += dwarf[i];
        }

        sum -= 100;
        for(int i = 0; i < 8; i++){
            for(int j = i + 1; j < 9; j++){
                if(sum == dwarf[i] + dwarf[j]){
                    for(int k = 0; k < 9; k++){
                        if(k != i && k != j) System.out.println(dwarf[k]);
                    }
                    return;
                }
            }
        }
    }
}
