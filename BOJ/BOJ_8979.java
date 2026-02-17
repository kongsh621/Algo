package BOJ_Silver;

import java.util.Arrays;
import java.util.Scanner;

// 올림픽
public class BOJ_8979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int scoreK = -1;

        // 1부터 N까지
        int[][] score = new int[N+1][3];
        for (int i = 1; i <= N; i++){
            int num = sc.nextInt(); // 국가 번호
            // 금은동 저장
            for (int j = 0; j < 3; j++){
               score[num][j] = sc.nextInt();
            }
        }

        // K 보다 앞선 나라의 수
        int count = 0; 
        for (int i = 1; i <= N; i++){
            if (i == K) continue;
            // 금메달이 더 많음
            if (score[i][0] > score[K][0]) count++;
            // 금 동일 은메달이 더 많음
            else if (score[i][0] == score[K][0] && score[i][1] > score[K][1]) count++;
            // 금은 동일 동메달이 더 많음
            else if (score[i][0] == score[K][0] && score[i][1] == score[K][1]
                && score[i][2] > score[K][2]) count++;
        }

        // K 국가의 등수
        int rankK = count+1;

        System.out.println(rankK);
    }
}
