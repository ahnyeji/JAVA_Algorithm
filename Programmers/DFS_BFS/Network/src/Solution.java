/*  Union-Find version */

class Solution {
    int[] p;
    public int solution(int n, int[][] computers) {
        p = new int[n + 1];
        for(int i = 1; i <= n; i++) p[i] = i;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(computers[i][j] == 0) continue;
                if(find(i + 1) == find(j + 1)) continue;
                union(i + 1, j + 1);
            }
        }
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(i == p[i]) answer++;
        }
        return answer;
    }

    public int find(int x) {
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;
        if(x < y) p[y] = x;
        else p[x] = y;
    }
}