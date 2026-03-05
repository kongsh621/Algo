package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// KCPC
public class BOJ_3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 데이터의 수
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 팀의 수
            int numT = Integer.parseInt(st.nextToken());
            // 문제 개수
            int numQ = Integer.parseInt(st.nextToken());
            // 로그 엔트리 수
            int entries = Integer.parseInt(st.nextToken());
            // 나의 팀 ID
            int myTeamId = Integer.parseInt(st.nextToken());

            for (int i = 0; i < entries; i++){
                st = new StringTokenizer(br.readLine());
                // 팀 ID
                int teamId = Integer.parseInt(st.nextToken());
                // 문제 번호
                int questionNum = Integer.parseInt(st.nextToken());
                // 획득 점수
                int score = Integer.parseInt(st.nextToken());


            }

        }

    }
}
