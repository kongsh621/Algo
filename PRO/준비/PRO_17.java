package Programmers;

import java.util.*;

public class PRO_17 {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        List<String[]> action = new ArrayList<>();
        Map<String, String> map = new HashMap<>(); // 아이디-닉네임
        for (String r : record){
            String[] rec = r.split(" ");
            String command = rec[0];
            String userId = rec[1];

            if (command.equals("Enter")){
                String nickname = rec[2];
                map.put(userId, nickname);
                action.add(new String[]{"Enter", userId});
            } else if (command.equals("Leave")){
                action.add(new String[]{"Leave", userId});
            } else {
                String nickname = rec[2];
                map.put(userId, nickname);
            }
        }

        for (String[] a : action){
            String act = a[0];
            String id = a[1];
            if (act.equals("Enter")){
                String s = map.get(id) + "님이 들어왔습니다.";
                answer.add(s);
            } else if (act.equals("Leave")){
                String s = map.get(id) + "님이 나갔습니다.";
                answer.add(s);
            }
        }

        return answer.toArray(new String[0]); // 타입을 알려줌
    }
}
