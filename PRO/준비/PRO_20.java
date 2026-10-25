package Programmers;

public class PRO_20 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int n = park.length;
        int m = park[0].length();
        char[][] map = new char[n][m];
        int r = 0;
        int c = 0;
        for (int i = 0; i < park.length; i++){
            map[i] = park[i].toCharArray();
            int idx = park[i].indexOf('S'); // 없으면 -1

            // 출발지점 저장
            if (idx != -1){
                r = i;
                c = idx;
            }
        }

        for (String rt : routes){
            String[] route = rt.split(" ");
            char dir = route[0].charAt(0);
            int len = Integer.parseInt(route[1]);

            // 장애물 가능성이 있으니 미리 저장해둠
            int nr = r;
            int nc = c;
            boolean isFinished = true;

            if (dir == 'E'){
                while (len > 0){
                    if (c+1 >= m || map[r][c+1] == 'X') {
                        isFinished = false;
                        break;
                    }
                    c += 1;
                    len--;
                }
            } else if (dir == 'W'){
                while (len > 0){
                    if (c-1 < 0 || map[r][c-1] == 'X') {
                        isFinished = false;
                        break;
                    }
                    c -= 1;
                    len--;

                }
            } else if (dir == 'S'){
                while (len > 0){
                    if (r+1 >= n || map[r+1][c] == 'X') {
                        isFinished = false;
                        break;
                    }
                    len--;
                    r += 1;
                }
            } else {
                while (len > 0){
                    if (r-1 < 0 || map[r-1][c] == 'X') {
                        isFinished = false;
                        break;
                    }
                    len--;
                    r -= 1;
                }
            }
            if (!isFinished){
                r = nr;
                c = nc;
            }
        }
        answer[0] = r;
        answer[1] = c;
        return answer;
    }
}
