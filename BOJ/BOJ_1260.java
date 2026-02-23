package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS 와 BFS
public class BOJ_1260 {
    static boolean[] visited; // 방문 처리
    static List<List<Integer>> adj; // 인근 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점의 번호

        adj = new ArrayList<>();
        // adj 초기화
        for (int i = 0; i <= N; i++){
            adj.add(new ArrayList<>());
        }

        // 간선 기록
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        // 정렬
        for (int i = 1; i <= N; i++){
            Collections.sort(adj.get(i));
        }

        // dfs
        visited = new boolean[N+1];
        dfs(V);


        System.out.println();
        // bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        // 방문 처리
        visited = new boolean[N+1];
        visited[V] = true;

        while (!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");
            for (int w : adj.get(curr)){
                // 방문하지 않았을 경우 큐에 추가
                if (!visited[w]){
                    q.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    // dfs
    static void dfs(int curr){
        visited[curr] = true;
        System.out.print(curr + " ");
        // 재귀
        for (int w : adj.get(curr)){
            if (!visited[w]){
                dfs(w);
            }
        }
    }

String input =
"""
4 5 1
1 2
1 3
1 4
2 4
3 4
""";

//1 2 4 3
//1 2 3 4
}


