package Programmers;

import java.util.HashMap;
import java.util.Map;

public class PRO_1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int total = participant.length;
        int com = total-1; // 완주 못한 선수는 1명뿐

        Map<String, Integer> player = new HashMap<>();

        // 선수 카운트
        for (String part : participant){
            player.put(part, player.getOrDefault(part, 0) + 1);
        }

        for (String comp : completion){
            player.put(comp, player.get(comp) - 1);
        }

        // 카운트 남은 사람이 완주 못한 선수
        for (String key : player.keySet()){
            if (player.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;
    }
}
