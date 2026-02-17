package BOJ_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 에디터
public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine(); // 입력된 문자열
        int len = words.length(); // 문자열의 길이
        int M = Integer.parseInt(br.readLine()); // 명령어 개수

        // 커서 기준 왼쪽 오른쪽 문자열을 관리할 덱
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        // 초기엔 전부 커서 왼쪽에 위치
        for (int i = 0; i < len; i++){
            left.push(words.charAt(i));
        }

        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0); // 명령어만 읽어옴
            char word; // 입력할 문자
            if (cmd == 'P'){
                // 추가 명령어일 경우 다음 값을 문자열 앞에 추가
                word = st.nextToken().charAt(0);

                // 문자를 왼쪽에 추가
                left.push(word);
            } else if (cmd == 'B' && !left.isEmpty()){
                // 왼쪽 문자 삭제
                left.pop();
            } else if (cmd == 'L' && !left.isEmpty()){
                // 왼쪽 문자 오른쪽으로 이동
                right.push(left.pop());
            } else if (cmd == 'D' && !right.isEmpty()){
                // 오른쪽 문자 왼쪽으로 이동
                left.push(right.pop());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}
