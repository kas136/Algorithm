import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> set = new HashSet<>();
        char start = words[0].charAt(0);

        int turn = 1;
        int cycle = 1;
        for(String word : words) {
            if(turn > n) {
                turn = 1;
                cycle++;
            }

            if(start != word.charAt(0) || set.contains(word))
                break;

            set.add(word);
            turn++;
            start = word.charAt(word.length() - 1);
        }

        answer = set.size() == words.length ? new int[]{0, 0} : new int[]{turn, cycle};

        return answer;
    }
}
