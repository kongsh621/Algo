package Programmers;

import java.util.HashMap;
import java.util.Map;

public class PRO_9 {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Double> rank = new HashMap<>();
        // 카운트
        for (int s : stages){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int total = stages.length; // 도전 인원
        for (int i = 1; i <= N; i++){
            // 클리어 못한
            int rest = map.getOrDefault(i, 0);
            rank.put(i, total == 0 ? 0.0 : (double)rest/total);
            total -= rest;
        }

        return rank.entrySet().stream()
                .sorted((a, b)-> {
                    int com = Double.compare(b.getValue(), a.getValue());
                    return com != 0 ? com : Integer.compare(a.getKey(), b.getKey());
                })
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
