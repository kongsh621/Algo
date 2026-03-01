package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 숨바꼭질 3
public class BOJ_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈의 위치
        int N = Integer.parseInt(st.nextToken());
        // 동생의 위치
        int K = Integer.parseInt(st.nextToken());
        // 범위
        int max = 100000;
        // 위치별 소요 시간
        int[] time = new int[max+1];
        // 방문 표시
        boolean[] visited = new boolean[max+1];

        // 위치를 저장할 덱
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(N);
        visited[N] = true;

        // 수빈이보다 동생이 왼쪽 또는 같은 위치 -> 걸어서만 이동
        if (K <= N){
            System.out.println(N-K);
            return; // 밑 로직 거칠 필요 X
        }

        while (!deque.isEmpty()){
            // 현재 위치
            int curr = deque.poll();

            // 목표 지점 도달 시, 소요시간 출력
            if (curr == K){
                System.out.println(time[curr]);
                break;
            }

            // 0초 소요 먼저 처리
            if (curr * 2 <= max && !visited[curr*2]){
                visited[curr*2] = true;
                time[curr*2] = time[curr]; // 0초라서
                deque.offerFirst(curr*2); // 0초의 동작은 우선순위가 높으므로 앞으로 추가
            }

            if (curr - 1 >= 0 && !visited[curr-1]){
                // 1초 소요, 왼쪽으로 이동
                visited[curr-1] = true;
                time[curr-1] = time[curr]+1;
                deque.offerLast(curr-1); // 1초 동작은 우선순위 낮으니 뒤에 추가
            }

            if (curr + 1 <= max && !visited[curr+1]){
                visited[curr+1] = true;
                time[curr+1] = time[curr] + 1;
                deque.offerLast(curr+1);
            }
        }
    }
}
