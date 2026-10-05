package Programmers;
import java.util.HashSet;
import java.util.Set;

public class PRO_11 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();

        for (String s : phone_book){
            set.add(s);
        }

        // 접두어 검사
        outer:
        for (String s : phone_book){
            for (int i = 0; i < s.length()-1; i++){
                if (set.contains(s.substring(0, i+1))){
                    answer = false;
                    break outer;
                }
            }
        }
        return answer;
    }
}
