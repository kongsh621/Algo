package Programmers;

import java.util.HashSet;

// 소수 찾기
public class PRO_42839 {
    private static HashSet<Integer> set;
    private static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>(); // 중복 제거
        visited = new boolean[numbers.length()];

        // 문자열로 받은 숫자를 잘라 담을 배열
        int[] number = new int[numbers.length()];

        // 숫자로 저장
        for (int i = 0; i < numbers.length(); i++){
            number[i] = numbers.charAt(i) - '0';
        }

        // 조합 만들기
        recursive("", numbers);

        // 소수인지 확인
        for (int n : set){
            // 소수이면 카운트
            if (isPrime(n)){
                answer++;
            }
        }

        return answer;
    }

    // 재귀로 숫자 조합을 찾아 Set으로 만드는 메서드
    static void recursive(String current, String target){
        if (!current.equals("")){
            // 빈 문자열이 아니면 추가해줌
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < target.length(); i++){
            if (!visited[i]){
                visited[i] = true;
                recursive(current + target.charAt(i), target);
                visited[i] = false; // 백트래킹
            }
        }
    }

    // 소수인지 확인하는 메서드
    static boolean isPrime(int n){
        if (n < 2) return false; // 1은 소수 아님

        for (int i = 2 ; i * i <= n; i++){
            if (n % i == 0) return false;
        }
        return true;
    }

}
