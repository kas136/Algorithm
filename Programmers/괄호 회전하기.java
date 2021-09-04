import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String newS = s.substring(i) + s.substring(0, i);
            if(checkBracket(newS))
                answer++;
        }
        return answer;
    }

    boolean checkBracket(String s) {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                brackets.push(s.charAt(i));
            else {
                if(brackets.isEmpty())
                    return false;
                if(s.charAt(i) == ')' && brackets.pop() == '(')
                    continue;
                if(s.charAt(i) == ']' && brackets.pop() == '[')
                    continue;
                if(s.charAt(i) == '}' && brackets.pop() == '{')
                    continue;
                return false;
            }
        }
        return brackets.isEmpty();
    }
}
