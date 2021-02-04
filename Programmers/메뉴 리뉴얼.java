import java.util.Arrays;
import java.util.HashMap;
import java.util. ArrayList;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order);
            combination("", orders[i]);
        }

        for(int i = 0; i < course.length; i++) {
            list.clear();
            int max = 2;
            for(String key : map.keySet()) {
                if(key.length() == course[i]) {
                    if(map.get(key) > max) {
                        list.clear();
                        list.add(key);
                        max = map.get(key);
                    }
                    else if(map.get(key) == max) {
                        list.add(key);
                    }
                }
            }
            for(String s : list)
                result.add(s);
        }

        answer = new String[result.size()];

        for(int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        Arrays.sort(answer);

        return answer;
    }

    void combination(String prefix, String order) {
        if(prefix.length() > 1)
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);

        int len = order.length();

        for(int i = 0; i < len; i++) {
            combination(prefix + order.substring(i, i + 1), order.substring(i + 1));
        }
    }
}
