package Programmers;
public class PRO_18 {
    public String solution(String new_id) {
        // 소문자
        String newId = new_id.toLowerCase();
        // 불필요한 특수문자 제거
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        // ... 과 .. 를 .로 변환
        newId = newId.replaceAll("\\.{2,}", ".");
        // 맨앞 맨뒤 .면 제거
        newId = newId.replaceAll("^\\.|\\.$", "");

        // 빈문자열이면 a 대입
        if (newId.length() == 0){
            newId = "a";
        }

        // 16자 이상이면 15자로 줄임
        int len = newId.length();
        if (len >= 16){
            newId = newId.substring(0, 15);
            int minus = 1;
            // 마지막이 .이면 없앰
            newId = newId.replaceAll("\\.$", "");
        }
        // 2자 이하면 3자로 만듦
        StringBuilder sb = new StringBuilder();
        sb.append(newId);
        while (sb.length() <= 2){
            sb.append(newId.charAt(newId.length()-1));
        }
        return sb.toString();
    }
}
