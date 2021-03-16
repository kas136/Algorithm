import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();

        int x = 5;
        int y = 5;

        for(int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int new_x = x;
            int new_y = y;

            if(dir == 'U')
                new_y++;

            else if(dir == 'D')
                new_y--;

            else if(dir == 'L')
                new_x--;

            else if(dir == 'R')
                new_x++;

            if(new_x < 0 || new_y < 0 || new_x > 10 || new_y > 10)
                continue;
            else {
                String check1 = Integer.toString(x) + Integer.toString(y) + Integer.toString(new_x) + Integer.toString(new_y);
                String check2 = Integer.toString(new_x) + Integer.toString(new_y) + Integer.toString(x) + Integer.toString(y);
                if(!set.contains(check1) && !set.contains(check2)) {
                    set.add(check1);
                    set.add(check2);
                    answer++;
                }
                x = new_x;
                y = new_y;
            }

        }
        return answer;
    }
}
