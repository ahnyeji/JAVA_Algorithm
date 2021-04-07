class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n + 1][n + 1];
        for(int[] r : results) {
            win[r[0]][r[1]] = true;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                if(i == k) continue;
                for(int j = 1; j <= n; j++) {
                    if(j == k) continue;
                    if(win[i][k] && win[k][j]) win[i][j] = true;
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int cnt = 1;
            for(int j = 1; j<= n; j++) {
                if(win[i][j] || win[j][i]) cnt++;
            }
            if(cnt == n) answer++;
        }

        return answer;
    }
}