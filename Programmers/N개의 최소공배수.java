class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int num = arr[0];
        for(int i = 1; i < arr.length; i++)
            num = lcm(num, arr[i], gcd(num, arr[i]));

        answer = num;
        return answer;
    }

    int gcd(int a, int b) {
        int c = -1;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while(c != 0) {
            c = max % min;
            max = min;
            min = c == 0 ? min : c;
        }
        return min;
    }

    int lcm(int a, int b, int c) {
        return a * b / c;
    }
}
