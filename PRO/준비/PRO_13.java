package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_13 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] dist = new int[n][m];
        Deque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == n-1 && y == m-1) return dist[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0 || dist[nx][ny] != 0) continue;

                dist[nx][ny] = dist[x][y]+1;
                q.offer(new int[]{nx, ny});
            }
        }
        return -1;
    }
}
