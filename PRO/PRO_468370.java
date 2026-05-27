package Programmers;

import java.util.*;

// 중요한 단어를 스포 방지
public class PRO_468370 {
    public static void main(String[] args) {
        int[][] spoiler_ranges = {{0, 3}, {23, 28}};
        String message = "here is muzi here is a secret message";
        System.out.println(solution(message, spoiler_ranges));
    }

    public static int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        // 공백 기준으로 단어 잘라 저장
        String[] words = message.split(" ");
        int total = words.length; // 단어 개수

        // 각 단어의 시작 인덱스를 저장할 배열
        int[] starts = new int[total];
        int curr = 0; // 인덱스
        for (int i = 0; i < total; i++){
            starts[i] = curr;
            curr += words[i].length() + 1;
        }

        // 스포 방지 구간과 걸리는지 확인
        Set<String> non = new HashSet<>(); // 스포일러 아닌 구간의 단어 저장
        Set<String> spo = new HashSet<>(); // 스포일러 구간의 단어 저장

        for (int i = 0; i < words.length; i++){
            // 단어 시작과 끝 인덱스 저장
            int start = starts[i];
            int end = start + words[i].length() - 1;

            // 스포일러 범위와 비교하여 검사
            boolean isSpo = false;
            for (int[] sp : spoiler_ranges){
                // 포함되면
                if (start <= sp[1] && end >= sp[0]) {
                    isSpo = true; // 플래그 꽂고
                    break; // 넘어간다
                }
            }
            // 조건 확인하여 단어를 저장
            if (!isSpo) {
                non.add(words[i]);
            }
        }

        // 중요한 단어 필터링
        for (int i = 0; i < words.length; i++){
            int start = starts[i];
            int end = start + words[i].length() - 1;

            // 스포일러 범위와 비교하여 검사
            boolean isSpo = false;
            for (int[] sp : spoiler_ranges){
                // 겹치면
                if (start <= sp[1] && end >= sp[0]) {
                    isSpo = true; // 플래그 꽂고
                    break; // 넘어간다
                }
            }

            // 스포일러 구간이고 스포X 구간에 나온 적 없고 중복되지 않는 단어인지 확인
            if (isSpo && !non.contains(words[i]) && !spo.contains(words[i])){
                answer++; // 중요 단어로 카운트
                spo.add(words[i]);
            }
        }
        return answer;
    }
}
