import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        HashSet<Integer> set = new HashSet<>();

        for(int num : win_nums)
            set.add(num);

        int count = 0;
        int sum = 0;
        for(int lotto : lottos) {
            if(lotto == 0)
                count++;
            else if(set.contains(lotto))
                sum++;
        }
        answer[0] = rank[sum + count];
        answer[1] = rank[sum];
        return answer;
    }
}
