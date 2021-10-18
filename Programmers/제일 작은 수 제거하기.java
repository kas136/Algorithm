import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};

        if(arr.length == 1)
            return new int[]{-1};
        ArrayList<Integer> list = new ArrayList<>();
        int min = arr[0];

        for(int i : arr)
            min = Math.min(min, i);

        for(int i : arr) {
            if(i != min)
                list.add(i);
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
