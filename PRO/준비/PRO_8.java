package Programmers;

public class PRO_8 {
    public int solution(String dartResult) {
        int answer = 0;
        int len = dartResult.length();
        int[] scores = new int[3]; // 3회차 점수 저장
        int idx = -1;

        for (int i = 0; i < len; i++){
            char curr = dartResult.charAt(i);
            // 숫자일 경우
            if (Character.isDigit(curr)){
                idx++; // 1회 증가. 숫자가 총 3번 나오니깐
                // 1글자씩 확인하지만 10인 경우도 있음
                if (curr == '1' && dartResult.charAt(i+1) == '0'){
                    scores[idx] = 10;
                    i++; // 0까지 확인했으니
                } else {
                    scores[idx] = curr - '0';
                }
            } // 영어일 경우
            else if (curr == 'D'){
                scores[idx] = (int)Math.pow(scores[idx], 2);
            } else if (curr == 'T'){
                scores[idx] = (int)Math.pow(scores[idx], 3);
            } // 특수문자일 경우
            else if (curr == '*'){
                scores[idx] *= 2;
                if (idx > 0){
                    // 이전 회차가 있으면
                    scores[idx-1] *= 2;
                }
            } else if (curr == '#'){
                scores[idx] *= -1;
            }
        }

        for (int i : scores){
            answer += i;
        }

        return answer;
    }
}
