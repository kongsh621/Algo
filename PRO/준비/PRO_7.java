package Programmers;

public class PRO_7 {
    public int solution(String s) {
        /*
        int len = s.length();

        // 숫자 영단어 대치
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                sb.append(c);
            } else {
                word.append(c);
                if (map.containsKey(word.toString())){
                    sb.append(map.get(word.toString()));
                    word.setLength(0); // 초기화
                }
            }
        }

        return Integer.parseInt(sb.toString());
        */

        // 이 방식이 훨씬 간단하다.
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < words.length; i++){
            s = s.replace(words[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
