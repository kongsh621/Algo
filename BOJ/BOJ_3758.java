package BOJ_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// KCPC
public class BOJ_3758 {
    static class Score implements Comparable<Score>{
        private int id, score, count, lastTime;

        public Score(int id, int score, int count, int lastTime) {
            this.id = id;
            this.score = score;
            this.count = count;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(Score o) {
            if (o.score != this.score) return o.score - this.score; // 점수 내림차
            if (o.count != this.count) return this.count - o.count; // 횟수 오름차
            return this.lastTime - o.lastTime; // 시간 오름차
        }
    }
    
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
            // 나의 팀 ID
            int myTeamId = Integer.parseInt(st.nextToken());
            // 로그 엔트리 수
            int entries = Integer.parseInt(st.nextToken());

            // 점수를 저장할 배열
            int[][] scores = new int[numT+1][numQ+1];
            // 제출 횟수
            int[] submit = new int[numT+1];
            // 제출 시간
            int[] submitTime = new int[numT+1];

            // 기록 저장
            for (int i = 0; i < entries; i++){
                st = new StringTokenizer(br.readLine());
                // 팀 ID
                int teamId = Integer.parseInt(st.nextToken());
                // 문제 번호
                int questionNum = Integer.parseInt(st.nextToken());
                // 획득 점수
                int score = Integer.parseInt(st.nextToken());

                // 이전 기록보다 높으면 갱신 (없어도 추가)
                if (scores[teamId][questionNum] < score){
                    // 점수 갱신
                    scores[teamId][questionNum] = score;
                }
                submit[teamId]++;
                submitTime[teamId] = i;
            }

            // Score 클래스 객체 리스트 사용
            List<Score> list = new ArrayList<>();
            for (int i = 1; i <= numT; i++){
                int total = 0;
                for (int j = 1; j <= numQ; j++){
                    total += scores[i][j];
                }
                list.add(new Score(i, total, submit[i], submitTime[i]));
            }

            // 정렬, 클래스 내부에 만든 compateTo 메서드로 정렬
            Collections.sort(list);

            // 내 팀 순위 찾기
            int idx = 1;
            for (Score l : list){
                if (l.id == myTeamId){
                    System.out.println(idx);
                    break;
                }
                idx++;
            }
        }
    }
}
