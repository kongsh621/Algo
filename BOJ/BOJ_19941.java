package BOJ_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 햄버거 분배
public class BOJ_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 식탁의 길이
        int deskLength = Integer.parseInt(st.nextToken());
        // 접근 가능 최대 길이
        int K = Integer.parseInt(st.nextToken());

        // 햄버거의 인덱스를 담을 덱
        Deque<Integer> ham = new ArrayDeque<>();
        // 사람의 인덱스를 담을 덱
        Deque<Integer> per = new ArrayDeque<>();
        int count = 0; // 몇 명 먹었는지 카운트
        String input = br.readLine().toUpperCase();
        for (int i = 0; i < deskLength; i++){
            char next = input.charAt(i);
            if (next == 'H'){
                // 다음이 햄버거
                // 아직 햄버거 못 먹은 사람이 있는지 확인, 못 먹을 사람 제거
                while (!per.isEmpty() && per.peekFirst() < i - K){
                    per.pollFirst();
                }
                // 못 먹은 사람이 있다면 매칭
                if (!per.isEmpty()){
                    per.pollFirst();
                    count++;
                } else { 
                    // 먹을 사람 없으면 저장
                    ham.offerLast(i);
                }
            } else {
                // 다음이 사람 -> 햄버거 있는지 확인
                // 햄버거 데크 속 못 먹는 햄버거 제거
                while (!ham.isEmpty() && ham.peekFirst() < i - K){
                    ham.pollFirst();
                }
                if (!ham.isEmpty()){
                    ham.pollFirst(); // 햄버거 하나 먹음
                    count++;
                } else {
                    // 햄버거 없으면 사람 저장
                    per.offerLast(i);
                }
            }
        }
        System.out.println(count);


    }
}
