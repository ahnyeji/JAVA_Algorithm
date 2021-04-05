import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int rlen = 3, clen = 3;
    static int[][] A = new int[100][100];
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < rlen; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < clen; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = 0;
        while(t < 100 && A[r][c] != k) {
            if(rlen >= clen) {
                R();
            } else {
                C();
            }
            t++;
        }
        if(A[r][c] != k) t = -1;
        System.out.println(t);
    }
    static void R() { // R연산 : 각 행 정렬
        int maxc = 0;
        for(int i = 0; i < rlen; i++) {
            Map<Integer, Integer> appear = new HashMap<>();
            for(int j = 0; j < clen; j++) {
                if(A[i][j] == 0) continue;
                int cnt = 1;
                if(appear.containsKey(A[i][j])) cnt += appear.get(A[i][j]); // 이미 등장한 원소 -> 횟수 증가
                appear.put(A[i][j], cnt); // 처음 등장한 원소 -> 추가
            }
            ArrayList<int[]> rowSort = new ArrayList<>(); // 정렬을 위함 -> 1. 등장 횟수가 작은 순 & 2. 원소가 작은 순
            for(Map.Entry<Integer, Integer> numcnt : appear.entrySet()) {
                rowSort.add(new int[]{numcnt.getValue(), numcnt.getKey()});
            }
            rowSort.sort(((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

            int[] row = new int[100];
            int idx = 0;
            while(idx < 100 && !rowSort.isEmpty()) {
                int[] ncnt = rowSort.get(0);
                row[idx++] = ncnt[1];
                row[idx++] = ncnt[0];
                rowSort.remove(0);
            }
            A[i] = row;
            maxc = Math.max(maxc, idx);
        }
        clen = maxc;
    }

    static void C() { // C연산 : 각 열 정렬
        int maxr = 0;
        for(int i = 0; i < clen; i++) {
            Map<Integer, Integer> appear = new HashMap<>(); // 원소 & 등장 횟수 저장하기 위함
            for(int j = 0; j < rlen; j++) {
                if(A[j][i] == 0) continue;
                int cnt = 1;
                if(appear.containsKey(A[j][i])) cnt += appear.get(A[j][i]); // 이미 등장한 원소 -> 횟수 증가
                appear.put(A[j][i], cnt); // 처음 등장한 원소 -> 추가
            }
            ArrayList<int[]> colSort = new ArrayList<>(); // 정렬을 위함 -> 1. 등장 횟수가 작은 순 & 2. 원소가 작은 순
            for(Map.Entry<Integer, Integer> numcnt : appear.entrySet()) {
                colSort.add(new int[]{numcnt.getValue(), numcnt.getKey()});
            }
            colSort.sort(((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

            int[] col = new int[100];
            int idx = 0;
            while(idx < 100 && !colSort.isEmpty()) {
                int[] ncnt = colSort.get(0);
                col[idx++] = ncnt[1];
                col[idx++] = ncnt[0];
                colSort.remove(0);
            }
            for(int j = 0; j < 100; j++) { // 행은 배열 전체로 대체 가능하지만 열은 불가 -> 원소 하나씩 대입
                A[j][i] = col[j];
            }
            maxr = Math.max(maxr, idx);
        }
        rlen = maxr;
    }
}
