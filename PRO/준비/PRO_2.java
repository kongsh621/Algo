package Programmers;

import java.util.HashMap;
import java.util.Map;

public class PRO_2 {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 카운트
        for (int num : nums){
            int curr = map.getOrDefault(num, 0);
            map.put(num, curr+1);
        }

        int choose = nums.length/2;
        int cnt = map.size();

        return Math.min(choose, cnt);
    }
}
