package Programmers;

public class PRO_14 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : number.toCharArray()){
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length()-1) < c){
                sb.deleteCharAt(sb.length()-1);
                k--; // 하나 지움
            }
            sb.append(c);
        }

        // 다 돌았지만 k!=0 -> 뒤에서부터 k개 잘라줌
        sb.setLength(sb.length()-k);
        return sb.toString();
    }
}
