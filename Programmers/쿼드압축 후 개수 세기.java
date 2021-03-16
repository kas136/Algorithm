class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);

        return answer;
    }

    void quad(int[][] arr, int row, int col, int n) {
        if(checkNum(arr, row, col, n)) {
            int index = 0;
            if(arr[row][col] == 1)
                index = 1;
            answer[index] ++;
        }

        else {
            quad(arr, row, col, n/2);
            quad(arr, row + n/2, col, n/2);
            quad(arr, row, col + n/2, n/2);
            quad(arr, row +n/2, col + n/2, n/2);
        }
    }

    boolean checkNum(int[][] arr, int row, int col, int n) {
        int num = arr[row][col];
        for(int i = row; i < row + n; i++) {
            for(int j = col; j < col + n; j++) {
                if(num != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}
