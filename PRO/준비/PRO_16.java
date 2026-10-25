package Programmers;

import java.util.*;

public class PRO_16 {
    private static Map<String, Integer> map;
    public int[] solution(String today, String[] terms, String[] privacies) {
        map = new HashMap<>();
        // 맵핑을 위해 terms를 map으로 구성
        for (String t : terms){
            String name = t.split(" ")[0];
            Integer mon = Integer.parseInt(t.split(" ")[1]);
            map.put(name, mon);
        }

        int year = Integer.parseInt(today.split("\\.")[0]);
        int mon = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= privacies.length; i++){
            String privacy = privacies[i-1];
            if (!isValid(privacy, year, mon, day)){
                list.add(i);
            }
        }

        return list.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private boolean isValid(String privacy, int year, int month, int day){
        String alpha = privacy.split(" ")[1];
        String due = privacy.split(" ")[0];

        int pY = Integer.parseInt(due.split("\\.")[0]);
        int pM = Integer.parseInt(due.split("\\.")[1]);
        int pD = Integer.parseInt(due.split("\\.")[2]);

        int m = map.get(alpha);
        int newMonth = pM + m;
        int newYear = pY;
        while (newMonth > 12){
            newYear++;
            newMonth -= 12;
        }

        if (newYear > year ||
                (newYear == year && newMonth > month) ||
                (newYear == year && newMonth == month && pD > day)){
            return true;
        }
        return false;
    }
}
