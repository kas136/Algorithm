import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i : scoville)
        	q.offer(i);
        
        while(q.peek() < K) {
        	if(q.size() == 1)
        		return -1;
        	
    		int a = q.poll();
    		int b = q.poll();
    		q.offer(a + (b*2));
    		answer++;
        }
        
        return answer;
    }
}
