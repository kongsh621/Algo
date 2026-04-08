package Programmers;

// 피로도
public class PRO_87946 {
    static int maxCnt ;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(80, dungeons));
    }

    static int solution(int k, int[][] dungeons){
        maxCnt = 0;
        visited = new boolean[dungeons.length];
        // 현재 피로도가 던전의 기준에 맞는지 체크
        recursive(k, dungeons, 0);

        return maxCnt;
    }

    // 최대 던전수를 반환하는 메서드
    static void recursive(int current, int[][] dungeons, int depth){ // 현재 체력
        // cnt 갱신
        maxCnt = Math.max(maxCnt, depth);

        for (int i = 0; i < dungeons.length; i++){
            // 방문하지 않았고 요구 체력을 만족할 경우
            if (!visited[i] && current >= dungeons[i][0]){
                visited[i] = true;
                recursive(current-dungeons[i][1], dungeons, depth+1);
                visited[i] = false;
            }
        }
    }
}
