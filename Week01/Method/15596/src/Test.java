/* BOJ - 15596 : 정수 N개의 합
   22.January.2021
 */

public class Test {
    long sum(int[] a){
        long s = 0;
        for(int n : a) {
            s += n;
        }
        return s;
    }
}
