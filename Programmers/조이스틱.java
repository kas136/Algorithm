class Solution {
    public int solution(String name){
        int answer = 0;
        int n = name.length();
        int move = name.length() - 1;

        for(int i = 0; i < n; i++){
            int next = i + 1;
            char target = name.charAt(i);

            if(target != 'A')
                answer += Math.min(target - 'A', 'A' - target + 26);

            while(next < n && name.charAt(next) == 'A')
                next++;

            move = Math.min(move, i + n - next + Math.min(i, n - next));
        }
        answer += move;
        return answer;
    }
}
