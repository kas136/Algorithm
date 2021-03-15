import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < info.length; i++)
            setInfo("", 0, info[i].split(" "));

        for(String s : map.keySet()) {
            ArrayList<Integer> list = map.get(s);
            Collections.sort(list, (a, b) -> {
                if(a < b)
                    return -1;
                else if(a == b)
                    return 0;
                else
                    return 1;
            });
        }

        for(int i = 0; i < query.length; i++) {
            String[] q = query[i].replaceAll(" and ", "").split(" ");
            if(map.containsKey(q[0]) == false)
                ans.add(0);
            else {
                ArrayList<Integer> list = map.get(q[0]);
                int score = Integer.parseInt(q[1]);
                ans.add(binarySearch(score, list));
            }
        }

        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);

        return answer;
    }

    void setInfo(String str, int depth, String[] info) {
        if(depth == 4) {
            if(map.containsKey(str) == false) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(str, list);
            }
            else
                map.get(str).add(Integer.parseInt(info[4]));
            return;
        }

        setInfo(str + "-", depth + 1, info);
        setInfo(str + info[depth], depth + 1, info);
    }

    int binarySearch(int score, ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        int mid = 0;

        while(left <= right) {
            mid = (left + right) / 2;
            if(list.get(mid) < score)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return list.size() - left;
    }
}
