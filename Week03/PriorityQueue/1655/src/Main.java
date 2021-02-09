/*  BOJ - 1655 : 가운데를 말해요
    09.February.2021
 */

/*  [Priority Queue]
    (시간 제한 0.1초 -> 정렬해서 중앙값 뽑으려면 시간초과)
    - 작은 수(small; priority_queue / max) & 중앙 값(mid; int) & 큰 수(big; priority_queue / min)
        0. 자료구조
            - 작은 수 : 작은 수 중 가장 큰 수를 뽑아야 하므로 Max Heap -> reverseOrder
            - 큰 수 : 큰 수 중 가장 작은 수를 뽑아야 하므로 Min Heap
        1. 수의 개수
            - 중앙 값은 무조건 한 개
            - 홀수 개의 수가 저장되어 있을 때
                : cnt(small) == cnt(big)
            - 짝수 개의 수가 저장되어 있을 때
                : cnt(small) == cnt(big) - 1
                 (중앙 값은 더 작은 수이기 때문)
            - 저장되어 있는 수의 전체 개수 == 인덱스(i)
        2. 중앙 값(mid) vs 새로운 수(now)
            - mid > now -> small.offer(now) & mid < now -> big.offer(now)
            - mid == now -> 저장되어 있는 수의 개수에 따라 다름
            - 새로운 수 넣기 전 홀수 개의 수가 저장되어 있을 때
                a. 현재 중앙 값보다 작은 수 넣으면 (mid > now)
                    : cnt(small) > cnt(big)  !!조정 필요!!
                      => (mid -> big) && (small -> mid) 이동
                b. 현재 중앙 값과 같거나 큰 수 넣으면 (mid <= now)
                    : cnt(small) == cnt(big) - 1 (짝수 개 저장 개수!)
            - 새로운 수 넣기 전 짝수 개의 수가 저장되어 있을 때
                a. 현재 중앙 값보다 큰 수 넣으면 (mid < now)
                    : now -> 큰 수
                      => cnt(small) < cnt(big) - 1  !!조정 필요!!
                      => (mid -> small) && (big -> mid) 이동
                b. 현재 중앙 값과 같거나 작은 수 넣으면 (mid >= now)
                    : cnt(small) == cnt(big) (홀수 개 저장 개수!)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        // smaller than mid -> bigger number has higher priority
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        // bigger than mid -> smaller number has higher priority
        PriorityQueue<Integer> big = new PriorityQueue<>();

        int mid = Integer.parseInt(in.readLine()); // first input become mid (no previous comparison)
        sb.append(mid).append("\n");

        for(int i = 1; i < N; i++){ // i == count of numbers in small + big + mid
            int now = Integer.parseInt(in.readLine());
            // Existing numbers are balanced
            if(i % 2 == 0){ //count before insert "now" -> small : i/2 - 1, mid : 1, big : i/2
                if(now <= mid) small.offer(now); // nothing to balance -> small : i/2, mid : 1, big : i/2
                else{ // need balance -> small : i/2 - 1, mid : 1, big : i/2 + 1
                    big.offer(now);
                    // small <- mid <- big
                    small.offer(mid);
                    mid = big.poll();
                }

            } else { //count before insert "now" -> small : i/2, mid : 1, big : i/2
                if(now >= mid) big.offer(now); // nothing to balance -> small : i/2, mid : 1, big : i/2 + 1
                else { // need balance -> small : i/2 + 1, mid : 1, big : i/2
                    small.offer(now);
                    // small -> mid -> big
                    big.offer(mid);
                    mid = small.poll();
                }
            }
            sb.append(mid).append("\n");
        }
        System.out.println(sb);
    }
}
