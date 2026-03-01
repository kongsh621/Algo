package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

// 어두운 굴다리
public class BOJ_17266 {
    private static int[] pos; // 가로등 위치를 담을 배열
    private static int N; // 굴다리 길이 N
    private static int result; // 최소 높이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 굴다리 길이 N
        N = Integer.parseInt(br.readLine());
        // 설치할 가로등의 개수
        int M = Integer.parseInt(br.readLine());

        // 가로등 위치를 담을 배열
        pos = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로등 개수만큼 위치를 받아온다.
        for (int i = 0; i < M; i++){
            pos[i] = Integer.parseInt(st.nextToken());
        }

        recursion(1, N); // 높이 최소 1부터 N까지
        System.out.println(result);
    }

    // 이분탐색용 재귀함수
    static void recursion(int low, int high){
        // 가로등이 모든 구역을 밝히면 종료
        if (low > high) return;

        // 현재 가로등의 높이
        int mid = (high + low)/2;

        // 전체를 밝히는지 여부
        boolean possible = true;
        // 마지막으로 불이 닿은 지점
        int lastPos = 0; 

        for (int p : pos) {
            // 탐색 중 틈이 생기면 break
            if (p - mid > lastPos) {
                possible = false;
                break;
            }
            // 틈이 없으면 반대쪽 마지막 지점으로 이동
            lastPos = p + mid;
        }
        // 끝까지 불이 안 닿을 경우 실패
        if (lastPos < N){
            possible = false;
        }

        // 재귀로 이어서 검사
        if (possible){
            // 높이 일단 저장
            result = mid;
            // 더 낮아도 가능한지 검사
            recursion(low, mid-1);
        } else {
            // 다 비추지 못하면 mid 의 오른쪽으로 바꿔 재귀
            recursion(mid+1, high);
        }
    }
}
