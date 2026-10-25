package Programmers;

import java.util.HashMap;
import java.util.Map;

public class PRO_19 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>(); // 카운트
        for (String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion){
            map.put(c, map.get(c) - 1);
        }

        for (String key : map.keySet()){
            if (map.get(key) != 0) answer = key;
        }
        return answer;
    }
}
