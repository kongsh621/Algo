package Programmers;

import java.util.ArrayList;
import java.util.List;

// 네트워크
public class PRO_43162 {
    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(3, computers));
    }

    static boolean[] visited;
    static List<List<Integer>> adj;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                recursive(i, computers);
                answer++;
            }
        }
        return answer;
    }

    static void recursive(int curr, int[][] computers){
        visited[curr] = true;

        for (int i = 0; i < computers[0].length; i++){
            if (!visited[i] && computers[curr][i] == 1){
                // 방문 전이고 연결된 상태일 경우
                recursive(i, computers);
            }
        }
    }
}
