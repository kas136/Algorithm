import java.util.HashSet;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        permutation("", numbers, set);

        for(Integer number : set) {
            if(isPrime(number))
                answer++;
        }
        return answer;
    }

    void permutation(String prefix, String number, HashSet<Integer> set) {
        if(!prefix.equals(""))
            set.add(Integer.valueOf(prefix));

        int len = number.length();
        for(int i = 0; i < len; i++)
            permutation(prefix + number.substring(i, i+1), number.substring(0, i) + number.substring(i+1, len), set);
    }

    boolean isPrime(int number) {
        if(number <= 1)
            return false;

        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
}
