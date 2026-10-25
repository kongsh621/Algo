package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_21 {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> deq = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (c == '('){
                deq.push(c);
            } else {
                if (deq.isEmpty()) return false;
                deq.pop();
            }
        }
        return deq.isEmpty();
    }
}
