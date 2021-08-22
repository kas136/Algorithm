class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] map = new char[5][5];
        int index = 0;

        for(String[] place : places) {
            for(int i = 0; i < 5; i++)
                map[i] = place[i].toCharArray();

            boolean isBreak = false;

            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(map[j][k] == 'P') {
                        if(!check(map, j, k)) {
                            answer[index] = 0;
                            k = 5;
                            j = 5;
                            isBreak = true;
                        }

                    }
                }
            }
            if(!isBreak)
                answer[index] = 1;
            index++;
        }
        return answer;
    }

    boolean check(char[][] map, int x, int y) {
        if(x + 1 < 5 && map[x + 1][y] == 'P')
            return false;
        if(y + 1 < 5 && map[x][y + 1] == 'P')
            return false;
        if(x + 2 < 5 && map[x + 2][y] == 'P') {
            if(map[x + 1][y] != 'X')
                return false;
        }
        if(y + 2 < 5 && map[x][y + 2] == 'P') {
            if(map[x][y + 1] != 'X')
                return false;
        }
        if(x + 1 < 5 && y + 1 < 5 && map[x + 1][y + 1] == 'P') {
            if(map[x + 1][y] != 'X' || map[x][y + 1] != 'X')
                return false;
        }
        if(x - 1 >= 0 && y + 1 < 5 && map[x - 1][y + 1] == 'P') {
            if(map[x - 1][y] != 'X' || map[x][y + 1] != 'X')
                return false;
        }
        return true;
    }
}
