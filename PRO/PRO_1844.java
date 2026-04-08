package Programmers;

import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단거리
public class PRO_1844 {
    private static boolean[][] visited;
    private static int N, M;
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
    public static int solution(int[][] maps) {
        N = maps.length; // 배열 가로
        M = maps[0].length; // 배열 세로
        visited = new boolean[N][M];



        return explore(0, 0, maps);
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int explore(int row, int col, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col, 1});
        visited[row][col] = true;

        while (!q.isEmpty()){
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            int dist = curr[2];

            if (currR == N-1 && currC == M-1){
                // 상대 진영에 도착
                return dist;
            }

            // 4방 탐색
            for (int i = 0; i < 4; i++){
                int nr = currR + dr[i];
                int nc = currC + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && maps[nr][nc] == 1){
                    // 방문하지 않았고 벽이 없는 경우 이동
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, dist+1});
                }

            }
        }
        return -1; // 도달 못하면 -1
    }
}
