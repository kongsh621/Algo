package Programmers;

import java.util.*;

public class PRO_16 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        // 맵핑을 위해 terms를 map으로 구성
        for (String t : terms){
            String name = t.split(" ")[0];
            Integer mon = Integer.parseInt(t.split(" ")[1]);
            map.put(name, mon);
        }

        String[] d = today.split("\\.");
        int year = Integer.parseInt(d[0]);
        int mon = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= privacies.length; i++){
            String privacy = privacies[i-1];
            if (!isValid(privacy, year, mon, day, map)){
                list.add(i);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private boolean isValid(String privacy, int year, int month, int day, Map<String, Integer> map){
        String alpha = privacy.split(" ")[1];
        String due = privacy.split(" ")[0];

        String[] d = due.split("\\.");
        int pY = Integer.parseInt(d[0]);
        int pM = Integer.parseInt(d[1]);
        int pD = Integer.parseInt(d[2]);

        int m = map.get(alpha);
        int newMonth = pM + m;
        int newYear = pY;
        while (newMonth > 12){
            newYear++;
            newMonth -= 12;
        }

        return newYear > year ||
                (newYear == year && newMonth > month) ||
                (newYear == year && newMonth == month && pD > day);
    }
}
