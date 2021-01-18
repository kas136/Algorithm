import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        char[] answer = new char[number.length() - k];
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < number.length(); i++) {
            while(!s.empty() && s.peek() < number.charAt(i) && k > 0) {
                s.pop();
                k--;
            }
            s.push(number.charAt(i));
        }

        for(int i = 0; i < answer.length; i++)
            answer[i] = s.get(i);

        return new String(answer);
    }
}
