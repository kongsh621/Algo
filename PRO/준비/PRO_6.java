package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_6 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 키패드 좌표 미리 생성
        int[][] pos = {
                {3, 1},
                {0, 0},
                {0, 1},
                {0, 2},
                {1, 0},
                {1, 1},
                {1, 2},
                {2, 0},
                {2, 1},
                {2, 2},
                {3, 0}, // * 10
                {3, 2}, // # 11
        };

        StringBuilder sb = new StringBuilder();
        // 시작점에서의 손의 위치
        int[] left = pos[10];
        int[] right = pos[11];

        for (int num : numbers) {
            int[] curr = pos[num];

            if (num == 1 || num == 4 || num == 7) {
                sb.append('L');
                left = curr; // 왼손 이동
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append('R');
                right = curr; // 오른손 이동
            } else {
                // 각 손의 거리 구하기
                int distL = Math.abs(curr[0] - left[0]) + Math.abs(curr[1] - left[1]);
                int distR = Math.abs(curr[0] - right[0]) + Math.abs(curr[1] - right[1]);

                if (distL > distR) {
                    sb.append('R');
                    right = curr;
                } else if (distL < distR) {
                    sb.append('L');
                    left = curr;
                } else {
                    // 어느손잡이인지
                    if (hand.equals("left")) {
                        sb.append('L');
                        left = curr;
                    } else {
                        sb.append('R');
                        right = curr;
                    }
                }
            }
        }
        return sb.toString();
    }
}
