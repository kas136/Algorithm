class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] time = new int[truck_weights.length];

        int cur_weight = 0;
        int truck_index = 0;
        boolean check = false;

        while(!check) {
            for(int i = 0; i < time.length; i++) {
                if(time[i] <= bridge_length) {
                    check = false;
                    break;
                }
                if(time[i] == bridge_length+1) {
                    cur_weight-= truck_weights[i];
                }
                check = true;
            }

            answer++;
            if(truck_index < truck_weights.length) {
                if(cur_weight + truck_weights[truck_index] <= weight) {
                    cur_weight+= truck_weights[truck_index];
                    time[truck_index]++;
                    truck_index++;
                }
            }
            for(int i = 0; i < truck_index; i++)
                time[i]++;
        }
        return answer;
    }
}
