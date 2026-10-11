package Programmers;

public class PRO_12 {
    private int num;
    private int target;
    private int count;
    private int[] numbers;
    public int solution(int[] numbers, int target) {
        num = numbers.length;
        this.target = target;
        count = 0;
        this.numbers = numbers;

        recursive(0, 0);
        return count;
    }
    private void recursive(int index, int sum){
        if (index == num){
            if (sum == target){
                count++;
            }
            return;
        }

        recursive(index+1, sum+numbers[index]);
        recursive(index+1, sum-numbers[index]);
    }
}
