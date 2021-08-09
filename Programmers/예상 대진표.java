class Solution
{
    public int solution(int n, int a, int b) {
        int answer = 1;
        int temp = Math.max(a, b);
        a = Math.min(a, b);
        b = temp;
        boolean check = true;

        while(check) {
            if(a % 2 == 1 && a + 1 == b)
                check = false;
            else {
                answer++;
                a = (a / 2) + (a % 2);
                b = (b / 2) + (b % 2);
            }
        }
        return answer;
    }
}
