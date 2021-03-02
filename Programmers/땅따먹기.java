import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++)
                land[i][j] += findMaxValue(land[i-1], j);
        }

        answer = Arrays.stream(land[land.length-1]).max().getAsInt();
        return answer;
    }

    int findMaxValue(int[] l, int k) {
        int max = 0;
        for(int i = 0; i < 4; i++) {
            if(i != k)
                max = Math.max(max, l[i]);
        }
        return max;
    }
}
