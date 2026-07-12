package Programmers.Lv1;

// 신규 아이디 추천
public class PRO_72410 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
//        System.out.println(solution(new_id));
        System.out.println(solution("z-+.^."));
    }
    public static String solution(String new_id) {
        // 문자열의 길이
        int len = new_id.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++){
            // 한 글자를 추출해 검사
            char asc = new_id.charAt(i);
            int currIdx = sb.length()-1;
            // 33 !부터 126 ~ 까지
            if (asc - '!' >= 0 && '~' - asc >= 0) {
                // 대문자인 경우 소문자로 변환
                if (asc- 'A' >= 0 && 'Z' - asc >= 0) {
                    sb.append(Character.toLowerCase(asc));
                    continue;
                }
                // 특수문자(-, _, .), 숫자, 소문자인 경우 문자열에 추가
                if (asc == '-' || asc == '_'
                    || (asc - 'a' >= 0 && 'z' - asc >= 0)
                    || (asc - '0' >= 0 && '9' - asc >= 0)){
                    sb.append(asc);
                }
                // 문자열의 첫과 끝이 .이면 안 됨, 연속 저장도 안 됨
                if (asc == '.' && !sb.isEmpty() && sb.charAt(currIdx) != '.') {
                    sb.append(asc);
                }
            }
        }


        // 생성한 문자열의 끝이 .이면 삭제
        int lastIdx = sb.length()-1;
        if (!sb.isEmpty() && sb.charAt(lastIdx) == '.'){
            sb.deleteCharAt(lastIdx--);
        }
        // 빈 문자열인 경우 a를 대입
        if (sb.isEmpty()){
            sb.append('a');
        }

        // 길이는 3~15 사이, 초과하는 경우 앞부분부터 시작해 잘라줌
        // 3 미만은 마지막 글자를 늘여 3에 맞춰줌
        int afterLen = sb.length();
        lastIdx = sb.length()-1;
//        StringBuilder newSb;
        if (afterLen > 15){
            // 방법1. 반복문으로 15글자까지 잘라줌
//            for (int i = 0; i < 15; i++){
//                newSb.append(sb.charAt(i));
//            }

            // 방법2. 이렇게 자르는 게 더 효율적
//            newSb = new StringBuilder(sb.substring(0, 15));
            
            // 방법3. 기존의 sb를 재활용하는 게 가장 깔끔하고 메모리를 아낄 수 있다.
            sb.setLength(15);
            
            // 글자수를 줄였으니 마지막으로 .로 끝나는지 체크 후 정리
            if (sb.charAt(14) == '.'){
                sb.deleteCharAt(14);
            }
        } else if (afterLen < 3){
            while (afterLen++ < 3){
                // 길이가 3이 될 때까지 마지막 문자로 채움
                sb.append(sb.charAt(lastIdx));
            }
        }
        return sb.toString();
    }
}
