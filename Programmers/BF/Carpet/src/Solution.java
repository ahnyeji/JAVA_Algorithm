class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int tot = brown + yellow;
        for(int h = 1; h * h <= yellow; h++) {
            if(yellow % h > 0) continue;
            int w = yellow / h;
            if(w < h) continue;
            if((w + 2) * (h + 2) == tot) { // 테두리 1줄만 갈색이라서 위아래, 좌우 2줄씩만 더하면 됨
                answer = new int[]{w + 2, h + 2};
                break;
            }
        }
        return answer;
    }
}