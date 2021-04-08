import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        List<Integer> doublypq = new ArrayList<>();
        for(String op : operations) {
            if(op.charAt(0) == 'I') {
                doublypq.add(Integer.parseInt(op.substring(2)));
                Collections.sort(doublypq);
            }
            else {
                if(doublypq.isEmpty()) continue;
                if(op.charAt(2) == '-') doublypq.remove(0);
                else doublypq.remove(doublypq.size() - 1);
            }
        }
        int[] answer = {};
        if(doublypq.isEmpty()) answer = new int[]{0, 0};
        else answer = new int[]{doublypq.get(doublypq.size() - 1), doublypq.get(0)};
        return answer;
    }
}