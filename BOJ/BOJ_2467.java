package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 용액
public class BOJ_2467 {
    private static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 용액의 수
        int N = Integer.parseInt(br.readLine());
        // 용액의 특성값을 담을 배열
        int[] properties = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 특성값을 저장
        for (int i = 0; i < N; i++){
            properties[i] = Integer.parseInt(st.nextToken());
        }

        // 정답이 되는 두 용액을 저장할 배열
        int[] result = new int[2];

        // 짝지을 값이 존재하도록 N-1로 범위 설정
        for (int i = 0; i < N-1; i++){
            // 기준
            int standard = properties[i];

            // 기준값의 다음부터
            int left = i+1; 
            // 제일 끝 값
            int right = N-1;

            while (left <= right){
                int mid = (left + right) / 2;
                int sum = standard + properties[mid];

                // minus 값이 더 작아지면 저장
                if (Math.abs(sum) < minValue){
                    minValue = Math.abs(sum);
                    // 값 오름차로 저장
                    result[0] = standard;
                    result[1] = properties[mid];
                }

                // 0이 된다면 탐색을 멈춤
                if (sum == 0) break;

                // 합이 0보다 작으면 오른쪽으로 탐색
                if (sum < 0) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        for (int i : result){
            System.out.print(i + " ");
        }
    }
}
