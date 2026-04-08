package Programmers;

// 타겟 넘버
public class PRO_43165 {
    private static int total;
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        System.out.println(solution(numbers, 3));
    }

    static int solution(int[] numbers, int target) {
        total = 0;

        recursive(0, numbers, 0, target);

        return total;
    }

    static void recursive(int current, int[] numbers, int cnt, int target){ // 합계, 배열, 개수 카운트
        if (cnt == numbers.length){
            // 다 계산했을 경우, target 이 됐는지 확인 후 카운트
            if (current == target){
                total++;
            }
            return;
        }
        recursive(current + numbers[cnt], numbers, cnt+1, target);
        recursive(current - numbers[cnt], numbers, cnt+1, target);
    }
}
