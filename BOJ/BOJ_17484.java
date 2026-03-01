package BOJ_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 진우의 달 여행
public class BOJ_17484 {
    static int N, M;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 행렬 크기를 받아
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 행렬을 선언
        int[][] space = new int[N][M];

        // 값을 채워준다.
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 를 이용하여 방향까지 저장, 1: 왼대각 2: 위 3: 오대각 (직전 움직임까지 저장)
        int[][][] dp = new int[N][M][3];

        // 첫번째 행 초기화
        for (int i = 0; i < M; i++){
            for (int d = 0; d < 3; d++){
                dp[0][i][d] = space[0][i];
            }
        }

        int maxValue = Integer.MAX_VALUE;
        // 중간 행 초기화
        for (int i = 1; i < N; i++){
            for (int j = 0; j < M; j++){
                // d 가 0 = 왼쪽 대각선 위에서 내려옴
                if (j > 0){
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + space[i][j];
                } else {
                    // 탐색 범위를 초과하는 경우 최댓값으로 채움
                    dp[i][j][0] = maxValue;
                }

                // d 가 1 = 바로 위에서 내려옴
                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + space[i][j];

                // d 가 2 = 오른쪽 대각선 위에서 내려옴
                if (j < M-1){
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + space[i][j];
                } else {
                    // 탐색 범위를 초과하는 경우 최댓값으로 채움
                    dp[i][j][2] = maxValue;
                }
            }
        }
        int min = maxValue;
        // 저장한 dp 배열 중 가장 최소값을 찾아 출력
        for (int k = 0; k < M; k++){
            for (int d = 0; d < 3; d++){
                min = Math.min(min, dp[N-1][k][d]);
            }
        }
        System.out.println(min);
    }
}
