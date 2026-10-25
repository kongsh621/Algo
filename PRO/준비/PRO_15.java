package Programmers;

import java.util.*;

public class PRO_15 {
    public int[] solution(String[] id_list, String[] report, int k){
        Map<String, Set<String>> map = new HashMap<>(); // 신고자 목록 저장
        for (String rep : report){
            String from = rep.split(" ")[0];
            String to = rep.split(" ")[1];
            Set<String> set = map.getOrDefault(to, new HashSet<>());
            set.add(from);
            map.put(to, set);
        }

        int total = id_list.length; // id 수
        int[] answer = new int[total]; // 정답으로 반환할 배열

        Map<String, Integer> idx = new HashMap<>();
        // 메일 보낼 사람 인덱스
        for (int i = 0; i < total; i++){
            idx.put(id_list[i], i);
        }

        for (int i = 0; i < total; i++){
            String id = id_list[i];
            Set<String> reporters = map.getOrDefault(id, new HashSet<>());
            if (reporters.size() >= k){
                for (String rep : reporters){
                    answer[idx.get(rep)]++;
                }
            }
        }
        return answer;
    }
}
