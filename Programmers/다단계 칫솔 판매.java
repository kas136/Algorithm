import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, String> tree = new HashMap<>();
        HashMap<String, Integer> price = new HashMap<>();

        for(int i = 0; i < enroll.length; i++) {
            tree.put(enroll[i], referral[i]);
            price.put(enroll[i], 0);
        }

        for(int i = 0; i < seller.length; i++) {
            int total = amount[i] * 100;
            recursive(total, seller[i], tree, price);
        }

        for(int i = 0; i < enroll.length; i++)
            answer[i] = price.get(enroll[i]);

        return answer;
    }

    void recursive(int income, String name, HashMap<String, String> tree, HashMap<String, Integer> price) {
        int yours = income / 10;
        int mine = income - yours;
        price.put(name, price.get(name) + mine);

        if(tree.get(name).equals("-"))
            return;

        recursive(yours, tree.get(name), tree, price);
    }
}
