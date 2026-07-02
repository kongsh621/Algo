package Programmers.Lv1;

import java.util.Arrays;

// 바탕화면 정리
public class P_161990 {
    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int row = wallpaper.length;
        int col = wallpaper[0].length();

        int minC = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;
        int minR = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++){
            String currR = wallpaper[i];
            boolean isChanged = false;
            for (int j = 0; j < col; j++){
                // 최대, 최소 C 찾기
                char curr = currR.charAt(j);
                if (curr == '#'){
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                    isChanged = true;
                }
            }
            // 최대, 최소 R 찾기
            if (isChanged) { // 값이 변경이 되었으면 R도 처리해줌
                minR = Math.min(minR, i);
                maxR = Math.max(maxR, i);
            }
        }
        answer[0] = minR;
        answer[1] = minC;
        // 경계선 좌표를 구해야해서 max 값은 +1 해줌
        answer[2] = maxR+1;
        answer[3] = maxC+1;

        return answer;
    }
}
