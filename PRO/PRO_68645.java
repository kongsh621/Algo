package Programmers.Lv2;

import java.util.Arrays;

// 삼각 달팽이
public class PRO_68645 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
    }

    public static int[] solution(int n) {
        int top = 1; // 최대 인덱스
        for (int i = n; i > 1; i--){
            top += i;
        }
        int[] answer = new int[top];

        // 달팽이 저장
        int[][] grid = new int[n][n];
        int row = -1, col = 0;
        int dir = 0; // 아래, 옆, 위로 진행, 0 1 2
        int size = n;
        // 방향이 바뀔 때 size 감소

        int num = 1;
        while (size > 0){
            // 반복문 범위를 줄여가며 진행
            for (int j = 0; j < size; j++){
                if (dir == 0){
                    // 행 이동
                    row++;
                } else if (dir == 1){
                    // 열 이동
                    col++;
                } else {
                    // 행 열 이동
                    row--;
                    col--;
                }
                grid[row][col] += num++;
            }
            dir = (dir + 1) % 3;
            size--;
        }

        // answer 에 옮겨줌
        int idx = 0;
        for (int r = 0; r < n; r++){
            for (int c = 0; c <= r; c++){
                answer[idx++] = grid[r][c];
            }
        }
        return answer;
    }
}
