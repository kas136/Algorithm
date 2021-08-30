import java.util.Arrays;

class Solution {
    public int solution(String word) {
        int answer = word.length();
        Character[] alphabet = {'A', 'E', 'I', 'O', 'U'};

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == alphabet[0])
                continue;

            int sum = 0;
            for(int j = 0; j <= 4 - i; j++)
                sum += Math.pow(5, j);

            answer += sum * Arrays.asList(alphabet).indexOf(word.charAt(i));
        }

        return answer;
    }
}
