package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_4 {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        int move = moves.length;

        int cnt = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int m : moves) {
            for (int i = 0; i < N; i++) {
                int curr = board[i][m - 1];
                // 현재 탐색 중인 위치에 인형이 있으면 집어서 스택으로 이동
                if (curr != 0) {
                    board[i][m - 1] = 0;
                    if (!stack.isEmpty() && stack.peek() == curr) {
                        stack.pop();
                        cnt += 2;
                    } else stack.push(curr);
                    break;
                }
            }
        }
        return cnt;
    }
}
