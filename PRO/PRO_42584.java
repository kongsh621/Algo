package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 주식가격
public class PRO_42584 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        // 가격이 떨어지지 않은 인덱스를 저장할 스택
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++){
            // 스택이 비어있지 않고 주식 가격이 스택 맨 위보다 떨어짐
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop(); // 해당 인덱스 꺼내서
                answer[idx] = i-idx; // 얼마나 안 떨어졌는지 기록
            }
            stack.add(i);
        }

        // 스택 빌 때까지 확인
        // 마지막까지 남았으면 떨어지지 않았다는 뜻이므로 len-1 에서 빼줌
        while (!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = len - 1 - idx;
        }

        return answer;
    }
}
