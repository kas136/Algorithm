import java.util.ArrayList;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        String num = "";

        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*'){
                operators.add(Character.toString(expression.charAt(i)));
                numbers.add(Long.parseLong(num));
                num = "";
            }
            else
                num += expression.charAt(i);
        }

        numbers.add(Long.parseLong(num));

        ArrayList<String> orders = new ArrayList<>();

        boolean visited[] = new boolean[6];

        permutation(orders, visited, "*+-", "", 0, 3);

        for(int i = 0; i < orders.size(); i++) {
            ArrayList<Long> n = new ArrayList<>();
            ArrayList<String> o = new ArrayList<>();
            n.addAll(numbers);
            o.addAll(operators);

            long result = calculation(n, o, orders.get(i));
            answer = Math.max(answer, result);
        }

        return answer;
    }

    void permutation(ArrayList<String> orders, boolean visited[], String operator, String order, int depth, int r) {
        if(depth == r) {
            orders.add(order);
            return;
        }

        for(int i = 0; i < operator.length(); i++) {
            if(visited[i] == false) {
                visited[i] = true;
                permutation(orders, visited, operator, order + operator.substring(i, i + 1), depth + 1, r);
                visited[i] = false;
            }
        }
    }

    long calculation(ArrayList<Long> n, ArrayList<String> o, String order) {
        for(int i = 0; i < order.length(); i++) {
            for (int j = 0; j < o.size(); j++) {
                if (o.get(j).equals(order.substring(i, i + 1))) {
                    Long sum = operation(n.get(j), n.get(j + 1), o.get(j));
                    n.set(j, sum);
                    n.remove(j + 1);
                    o.remove(j);
                    j = -1;
                }
            }
        }
        return Math.abs(n.get(0));
    }

    Long operation(Long a, Long b, String op) {
        if(op.equals("*"))
            return a * b;
        else if(op.equals("+"))
            return a + b;
        else
            return a - b;
    }
}
