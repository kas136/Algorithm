class Solution {
    public int solution(int n) {
        int answer = 0;

        int n_count = Integer.bitCount(n);
        answer = n + 1;
        
        while(true) {
            if(n_count == Integer.bitCount(answer))
                break;
            answer++;
        }
        return answer;
    }
}
