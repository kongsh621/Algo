package Programmers;

// 노란불 신호
public class PRO_468371 {
    public static void main(String[] args) {
        int[][] signals = {{2, 1, 2}, {5, 1, 1}};
        System.out.println(solution(signals));
    }

    public static int solution(int[][] signals) {
        int answer = Integer.MAX_VALUE;
        int max = 1;
        int cnt = signals.length;

        for (int i = 0; i < signals.length; i++){
            int total = signals[i][0] + signals[i][1] + signals[i][2];
            max = lcm(max, total);
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < signals.length; i++){
            int total = signals[i][0] + signals[i][1] + signals[i][2];
            for (int j = signals[i][0] + 1; j <= max; j+=total){
                for (int k = 0; k < signals[i][1] && j + k <= max; k++){
                    count[j+k]++;
                }
            }
        }

        // 카운트 배열 앞부터 검사하여 cnt 와 같은 최소값을 구함
        for (int i = 0; i <= max; i++){
            if (count[i] == cnt){
                answer = i;
                break;
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    // 최대공약수
    static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    // 최소공배수
    static int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }
}
