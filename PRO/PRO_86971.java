package Programmers.Lv2;

import java.util.ArrayList;
import java.util.List;

// 전력망을 둘로 나누기
public class PRO_86971 {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n, wires));
    }

    private static List<List<Integer>> adj;
    private static int minTowers = Integer.MAX_VALUE;
    private static int total;
    public static int solution(int n, int[][] wires) {
        total = n;
        // 인접 리스트
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        // 전력망 정보 저장
        for (int i = 0; i < wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        // 하나씩 전선을 끊어가며 최소값 탐색
        for (int i = 0; i < wires.length; i++){
            // 방문 체크 배열은 매번 초기화
            boolean[] visited = new boolean[n+1];
            // 첫번째 송전탑 탐색
            int left = dfs(wires[i][0], wires[i][1], visited);

            // 두 전력망의 송전탑 개수 차이의 절댓값을 계산, 둘의 합은 n으로 고정
            int diff = Math.abs(left-(n-left));
            // 최소값을 갱신
            minTowers = Math.min(diff, minTowers);
        }

        return minTowers;
    }

    private static int dfs(int idx, int extra, boolean[] visited){
        visited[idx] = true;
        int count = 1;
        // 연결된 송전탑 개수를 세어줌
        for (int curr : adj.get(idx)){
            // 잘린 송전탑이거나 이미 체크한 송전탑은 패스
            if (curr == extra || visited[curr]) continue;

            count += dfs(curr, extra, visited);
        }
        return count;
    }
}
