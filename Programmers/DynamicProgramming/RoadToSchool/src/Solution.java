class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for(int[] p : puddles) {
            map[p[1] - 1][p[0] - 1] = -1;
        }
        int idx = 1;
        while(idx < m && map[0][idx] != -1) map[0][idx++] = 1;
        idx = 1;
        while(idx < n && map[idx][0] != -1) map[idx++][0] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(map[i][j] == -1) continue;
                if(map[i - 1][j] != -1) map[i][j] += map[i - 1][j];
                if(map[i][j - 1] != -1) map[i][j] = (map[i][j] + map[i][j - 1]) % 1000000007;
            }
        }
        return map[n - 1][m - 1];
    }
}