package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 빗물
public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[] buildings = new int[width+1];
        st = new StringTokenizer(br.readLine());

        // 높이 배열 초기화
        for (int i = 0; i < width; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        // 빗물 고이는 총량 저장
        int sum = 0;
        for (int i = 1; i < width-1; i++){ // i는 현재 인덱스
            int left = 0;
            int right = 0;

            // 왼
            for (int j = 0; j < i; j++){
                left = Math.max(left, buildings[j]);
            }

            // 오
            for (int j = i+1; j < width; j++){
                right = Math.max(right, buildings[j]);
            }

            if (left > buildings[i] && right > buildings[i]){
                sum += Math.min(left, right) - buildings[i];
            }
        }
        System.out.println(sum);
    }
}
