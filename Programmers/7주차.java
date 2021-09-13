import java.util.HashSet;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        HashSet<Integer> set = new HashSet<>();
        int enter_index = 0;
        int leave_index = 0;

        while(leave_index < leave.length) {
            int cur = leave[leave_index];
            if(set.contains(cur)) {
                set.remove(cur);
                answer[cur - 1] += set.size();
                for(int i : set)
                    answer[i - 1]++;
                set.remove(cur);
                leave_index++;
            }
            else
                set.add(enter[enter_index++]);
        }
        return answer;
    }
}
