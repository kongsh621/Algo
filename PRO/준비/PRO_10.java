package Programmers;

import java.util.HashMap;
import java.util.Map;

public class PRO_10 {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> type = new HashMap<>(); // 종류별로 옷 저장
        for (String[] c : clothes){
            type.put(c[1], type.getOrDefault(c[1], 0) + 1);
        }

        int total = 1;
        for (int i : type.values()){
            total *= i+1; // 선택 안 하는 것까지해서 +1의 경우의수
        }

        return total-1; // 아예 안 고른 거 하나 뺌
    }
}
