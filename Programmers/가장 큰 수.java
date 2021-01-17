import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        ArrayList<Integer> list = new ArrayList<>();

        for(int n : numbers)
            list.add(n);

        Collections.sort(list, (a, b) -> {
            String as = a.toString(), bs = b.toString();
            return (bs + as).compareTo(as + bs);
        });

        StringBuilder sb = new StringBuilder();
        for(Integer i : list)
            sb.append(i);

        answer = sb.toString();

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
