package Programmers;

import java.util.HashMap;
import java.util.Map;

// 성격 유형 검사하기
public class PRO_118666 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }

    static Map<Character, Integer> count;
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        int n = survey.length; // 질문 개수

        // 유형을 카운트할 배열
        count =  new HashMap<>();
        // R, T, C, F, J, M, A, N 순서
//        int[][] count = new int[4][2];
        for (int i = 0; i < n; i++){
            int diff = choices[i]-4;
            int diff_abs = Math.abs(diff);
            // 첫 번째, 두 번째 글자
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            // 점수에 따라 점수 배정
            if (diff_abs > 0){ // 0인 경우 제외하고 나머지
                // 점수 반영
                if (diff > 0){
                    // 뒷 글자에 카운트
                    count.put(second, count.getOrDefault(second, 0)+ diff_abs);
                } else {
                    count.put(first, count.getOrDefault(first, 0)+ diff_abs);
                }
            }

        }
        // 한 줄로 정렬
        StringBuilder sb = new StringBuilder();
        // RT / CF / JM / AN 비교해서 하나씩 선택
        appendChar('R', 'T', sb);
        appendChar('C', 'F', sb);
        appendChar('J', 'M', sb);
        appendChar('A', 'N', sb);

        return sb.toString();
    }

    static void appendChar(char a, char b, StringBuilder sb){
        int countA = count.getOrDefault(a, 0);
        int countB = count.getOrDefault(b, 0);

        // 카운트 더 높은 것을 선택, 같을 경우 사전순
        if (countA < countB){
            sb.append(b);
        }
        else if (countA > countB){
            sb.append(a);
        } else {
            // 같으면 사전순
            sb.append(a > b ? b : a);
        }
    }
}
