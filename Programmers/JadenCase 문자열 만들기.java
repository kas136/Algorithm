class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ");

        String space = "";
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(""))
                space += " ";

            else {
                String first = words[i].substring(0, 1).toUpperCase();
                String rest = words[i].substring(1).toLowerCase();
                answer += " " + space + first + rest;
                space = "";
            }
        }

        answer = answer.substring(1);
        if(s.charAt(s.length()-1) == ' ')
            answer += " ";

        return answer;
    }
}
