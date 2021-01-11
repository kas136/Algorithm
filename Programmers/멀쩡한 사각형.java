class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * (long)h - (w + h - getGcd(Math.max(w, h), Math.min(w, h)));
        return answer;
    }

    int getGcd(int max, int min) {
        while(min > 0) {
            int temp = max;
            max = min;
            min = temp % min;
        }
        return max;
    }
}
