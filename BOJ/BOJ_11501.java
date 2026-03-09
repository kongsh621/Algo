package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주식
public class BOJ_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){
            // 날의 수
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cost = new int[N];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            long total = 0;
            int currentMax = 0;

            for (int i = N-1; i >=0; i--){
                // 고점에서 갱신
                if (cost[i] > currentMax){
                    currentMax = cost[i];
                }
                // 낮으면 합
                else { 
                    // 차액만큼 가져감
                    total += currentMax - cost[i];
                }
            }
            System.out.println(total);
        }
    }
}
