package Programmers;

import java.util.Arrays;

// 행렬 테두리 회전하기
public class PRO_77485 {
    public static void main(String[] args) {
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution(6, 6, queries)));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        // 행렬을 표현할 2차원 배열
        int[][] map = new int[rows][columns];
        int size = queries.length;
        // 정답을 담을 배열
        int[] answer = new int[size];
        int idx = 1;
        // 배열 채우기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = idx++;
            }
        }

        // 가장 작은 값을 담을 변수
        // 주어진 범위만큼 반복문을 돌려 회전시켜 값 구함
        int minValue = 0;
        for (int i = 0; i < size; i++) {
            minValue = Integer.MAX_VALUE;
            int[] query = queries[i];
            // 1, 1 부터 시작하지만 배열 자체 인덱스는 0부터 시작하기 때문에 모양을 맞춰줌
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int temp = map[x1][y1];
            int min = temp;

            // 회전 시작
            // 왼쪽변
            for (int x = x1; x < x2; x++) {
                map[x][y1] = map[x + 1][y1];
                min = Math.min(min, map[x][y1]);
            }

            // 아랫변
            for (int y = y1; y < y2; y++) {
                map[x2][y] = map[x2][y + 1];
                min = Math.min(min, map[x2][y]);
            }

            // 오른쪽변
            for (int x = x2; x > x1; x--) {
                map[x][y2] = map[x - 1][y2];
                min = Math.min(min, map[x][y2]);
            }

            // 윗변
            for (int y = y2; y > y1; y--) {
                map[x1][y] = map[x1][y - 1];
                min = Math.min(min, map[x1][y]);
            }

            // 마지막 빈 위치에 temp 넣어줌
            map[x1][y1 + 1] = temp;
            answer[i] = min;
            // 회전된 배열로 다시 계산 시작
        }

        return answer;
    }
}
