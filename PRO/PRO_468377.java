package Programmers;

// 힌트 스테이지
public class PRO_468377_recursive {
    static int[][] cost = {
            {160, 140, 120, 110, 60},
            {290, 270, 260, 120, 10},
            {160, 130, 120, 60, 20},
            {160, 120, 80, 70, 20},
            {110, 70, 60, 30, 20}
    };
    static int[][] hint = {
            {40, 2, 3},
            {40, 5, 3},
            {20, 5, 4},
            {50, 5, 5}
    };
    public static void main(String[] args) {
        System.out.println(solution(cost, hint));
    }

    public static int solution(int[][] cost, int[][] hint) {
        int[] count = new int[cost.length + 1];
        return recursive(0, count);
    }

    // 재귀
    static int recursive(int curr,  int[] count){ // 몇 번째 스테이지인지
        // 마지막 스테이지는 그냥 반환
        if (curr == cost.length-1){
            int idx = Math.min(count[curr+1], cost[0].length-1);
            return cost[curr][idx];
        }

        // 현재 스테이지 비용
        int idx = Math.min(count[curr+1], cost[0].length-1);
        int stageCost = cost[curr][idx];

        // 번들 안 샀을 경우의 비용
        int notBuy = stageCost + recursive(curr+1, count);

        // 번들 사는 경우의 비용
        int[] newCount = count.clone();
        newCount[0] += hint[curr][0]; // 번들 비용 임시 저장
        for (int j = 1; j < hint[curr].length; j++) {
            newCount[hint[curr][j]]++;
        }
        int buy = hint[curr][0] + stageCost + recursive(curr + 1,  newCount);

        return Math.min(notBuy, buy);
    }
}
