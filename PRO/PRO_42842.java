package Programmers;

import java.util.Arrays;

// 카펫
public class PRO_42842 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(8,1)));
    }

    static int[] solution(int brown, int yellow){
        // 두 구역의 합
        int total = brown + yellow;

        for (int h = 3; h * h <= total; h++){
            if (total % h == 0){ // 딱 떨어질 때
                int w = total / h;

                if ((w-2) * (h-2) == yellow){
                    return new int[]{w, h};
                }
            }
        }
        return null;
    }
}
