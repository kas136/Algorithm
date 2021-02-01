import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            int min = Math.min(citations[i], citations.length - i);
            if(max < min)
                max = min;
        }

        answer = max;
        return answer;
    }
}
