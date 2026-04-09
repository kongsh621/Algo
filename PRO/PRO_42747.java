package Programmers;

import java.util.Arrays;

// H-Index
public class PRO_42747 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;

        Arrays.sort(citations); // 오름차순 정렬
        // 뒤에서부터 확인
        for (int i = 0; i < len; i++){
            // 인용된 횟수와 이상인 논문수를 비교
            if (citations[i] >= (len-i)){
                answer = len-i;
                break; // 최대 H-Index 찾았으니 종료
            }
        }
        return answer;
    }
}
