package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_5 {
    public String solution(String new_id) {

        Deque<Character> deq = new ArrayDeque<>();
        int len = new_id.length(); // 글자 길이

        // 대 -> 소
        String upper = new_id.toLowerCase();
        for (int i = 0; i < len; i++) {
            char character = upper.charAt(i);
            if (Character.isDigit(character) ||
                    Character.isLetter(character) ||
                    character == '-' ||
                    character == '_' ||
                    character == '.') {
                if (character == '.' && !deq.isEmpty() && deq.peekLast() == '.') {
                    continue;
                }
                deq.add(character);
            }
        }

        // 맨앞 맨뒤 검사
        while (!deq.isEmpty() && deq.peekFirst() == '.') {
            deq.pollFirst();
        }
        while (!deq.isEmpty() && deq.peekLast() == '.') {
            deq.pollLast();
        }

        // 빈문자열 처리
        if (deq.isEmpty()) {
            deq.add('a');
        }


        // 변환 후 글자수 검사
        if (deq.size() <= 2) {
            // 마지막 글자가 .이 아니면 길이를 늘림
            char last = deq.peekLast();
            int addCnt = 3 - deq.size();
            for (int i = 0; i < addCnt; i++) {
                deq.add(last);
            }
        } else if (deq.size() >= 16) {
            // 15자리까지 뒤에서 잘라냄
            while (deq.size() >= 16) {
                deq.pollLast();
            }
        }

        // 마지막으로 맨뒤 검사
        while (!deq.isEmpty() && deq.peekLast() == '.') {
            deq.pollLast();
        }

        // 추천 아이디 꺼내서 반환
        StringBuilder sb = new StringBuilder();
        while (!deq.isEmpty()) {
            sb.append(deq.poll());
        }
        return sb.toString();
    }
}
