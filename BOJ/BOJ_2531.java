package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 회전초밥
public class BOJ_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 초밥 접시의 수
        int N = Integer.parseInt(st.nextToken());
        // 초밥 가짓수
        int d = Integer.parseInt(st.nextToken());
        // 연속해서 먹는 접시수
        int k = Integer.parseInt(st.nextToken());
        // 보너스 번호
        int c = Integer.parseInt(st.nextToken());

        // 초밥 번호
        int[] platesCount = new int[d+1];
        int cnt = 0; // 안 겹치게 몇 접시 선택했는지

        int[] plates = new int[N];
        for (int i = 0; i < N; i++) {
            plates[i] = Integer.parseInt(br.readLine());
        }

        // 1. 초기 슬라이딩 윈도우
        for (int i = 0; i < k; i++){
            if (platesCount[plates[i]] == 0){
                cnt++;
            }
            platesCount[plates[i]]++;
        }

        int answer = cnt;
        if (platesCount[c] == 0){
            answer++;
        }

        // 2. 슬라이딩 윈도우 탐색
        for (int i = 1; i < N; i++){
            // 초밥 나감 (수정됨)
            int remove = plates[i - 1];
            platesCount[remove]--;
            if (platesCount[remove] == 0) cnt--;

            // 초밥 들어옴 (앞뒤 이어진 동그란 배열)
            int add = plates[(i + k - 1) % N];
            if (platesCount[add] == 0) cnt++;
            platesCount[add]++;

            // 쿠폰 적용
            int current = cnt;
            if (platesCount[c] == 0){
                current++;
            }

            // 역대 최고 가짓수 갱신 (수정됨)
            answer = Math.max(answer, current);
        }

        System.out.println(answer);
    }
}