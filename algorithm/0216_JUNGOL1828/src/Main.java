/*  [Greedy]
    - sort by maximum temperature (ascending)
    - initial frige's temperature : lowest maximum temperature of C
    - Check all Cs in sorted order
        # if minimum temperature of C > current frige's temperature
            => need new frige (maximum temperature)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        ArrayList<int[]> chemi = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            chemi.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(chemi, Comparator.comparingInt(o -> o[1]));

        int friges = 1; // count friges
        int maxi = chemi.get(0)[1];
        chemi.remove(0);
        while(!chemi.isEmpty()){
            if(chemi.get(0)[0] > maxi){ // need more frige
                maxi = chemi.get(0)[1];
                friges++;
            }
            chemi.remove(0); // remove checked c
        }

        System.out.println(friges);

    }
}
