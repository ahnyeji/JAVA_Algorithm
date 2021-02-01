/*  BOJ - 11650 : 좌표 정렬하기
    02.February.2021
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

class Points implements Comparable{ // made class to implement Collections.sort() compareTo()
    int x;
    int y;
    Points(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Object o) {
        Points p = (Points) o;
        int subtract = this.x - p.x;
        // if return 1 (subtract > 0; bigger x came first), then exchange
        // if return 0 (same x), then compare y
        return subtract == 0 ? this.y - p.y : subtract;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Points> xy = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Points point = new Points(x, y);
            xy.add(point);
        }

        Collections.sort(xy); // need to implement compareTo() method

        StringBuilder sb = new StringBuilder();

        Iterator<Points> itr = xy.iterator();
        while(itr.hasNext()){
            Points p = itr.next();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        System.out.println(sb.toString());
    }
}
