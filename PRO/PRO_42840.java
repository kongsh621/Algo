package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 모의고사
public class PRO_42840 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        int len = answers.length;
        int[][] nArr = {
                { 1, 2, 3, 4, 5 },
                { 2, 1, 2, 3, 2, 4, 2, 5 },
                { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
        };

        int[] countArr = new int[nArr.length];
        int max = Integer.MIN_VALUE;
        // 누가 가장 정답률이 높은지 확인
        for (int i = 0; i < nArr.length; i++){
            for (int j = 0; j < answers.length; j++){
                if (nArr[i][j % nArr[i].length] == answers[j]){
                    countArr[i]++;
                }
            }
            max = Math.max(max, countArr[i]);
        }

        // 정답 저장할 리스트
        List<Integer> list = new ArrayList<>();
        // 미리 구해둔 최댓값을 이용해 배열 생성
        for (int i = 0; i < countArr.length; i++){
            if (countArr[i] == max) list.add(i+1); // 정답 배열에 추가
        }

        // 배열로 출력
        System.out.println(
                Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
    }
}
