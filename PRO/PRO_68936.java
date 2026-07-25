package Programmers.Lv2;

import java.util.Arrays;

// 쿼드압축 후 개수 세기
public class PRO_68936 {
    public static void main(String[] args) {
        int[][] ans = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        System.out.println(Arrays.toString(solution(ans)));
    }
    static int[] answer = new int[2]; // 0의 개수, 1의 개수

    public static int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    // 쿼드 압축
    private static void compress(int[][] arr, int row, int col, int size){
        // 모든 값이 같으면 카운트
        if (check(arr, row, col, size)){
            answer[arr[row][col]]++;
            return;
        }

        // 같지 않다면 4분할 후 다시 압축
        int half = size / 2;
        compress(arr, row, col, half); // 왼위
        compress(arr, row, col + half, half); // 오위
        compress(arr, row + half, col, half); // 왼아
        compress(arr, row + half, col + half, half); // 오아
    }

    // 구역 내 모든 값이 해당 값과 같은지 검사
    private static boolean check(int[][] ans, int row, int col, int size){
        int first = ans[row][col];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (ans[row+i][col+j] != first){
                    return false;
                }
            }
        }
        return true;
    }
}
