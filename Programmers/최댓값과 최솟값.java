class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");

        String max = numbers[0];
        String min = numbers[0];
        for(String number : numbers) {
            max = Integer.parseInt(max) > Integer.parseInt(number) ? max : number;
            min = Integer.parseInt(min) < Integer.parseInt(number) ? min : number;
        }
        answer = min + " " + max;
        return answer;
    }
}
