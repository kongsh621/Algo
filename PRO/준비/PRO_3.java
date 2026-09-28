package Programmers;

import java.util.HashSet;
import java.util.Set;

public class PRO_3 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        int total = numbers.length;
        for (int i = 0; i < total; i++){
            for (int j = i+1; j < total; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }

        return set.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
