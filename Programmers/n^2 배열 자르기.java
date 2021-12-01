import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        for(long i = left; i <= right; i++)
            list.add((int) Math.max((i / n) + 1, (i % n) + 1));

        answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
