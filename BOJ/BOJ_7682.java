package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 틱택토
public class BOJ_7682 {
    private static char[][] arr; // 3X3 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line; // 한 줄이 한 판

        arr = new char[3][3];
        // 다음 줄이 end 가 될 때까지 반복
        while (!(line = br.readLine()).equals("end")) {
            // O, X 카운트 변수
            int oCnt = 0;
            int xCnt = 0;

            // 문자열을 쪼개 3X3 에 맞게 담아줌
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = line.charAt(i * 3 + j);
                    if (arr[i][j] == 'O') {
                        oCnt++;
                    } else if (arr[i][j] == 'X') {
                        xCnt++;
                    }
                }
            }

            // 게임 규칙에 따른 유효성 검사
            if (xCnt == oCnt || xCnt == oCnt + 1) {
                boolean xWin = checkWin('X');
                boolean oWin = checkWin('O');

                // x가 이김
                if (xWin && !oWin && oCnt + 1 == xCnt){
                    System.out.println("valid");
                } // o가 이김
                else if (!xWin && oWin && oCnt == xCnt){
                    System.out.println("valid");
                } // 아무도 안 이겼지만 판이 꽉 참
                else if (!xWin && !oWin && xCnt + oCnt == 9){
                    System.out.println("valid");
                } // 그외의 경우엔 invalid
                else System.out.println("invalid");
            } else {
                // 규칙에 어긋남
                System.out.println("invalid");
            }
        }
    }

    // 가로, 세로, 대각선 줄 완성 여부를 판별하는 메서드
    private static boolean checkWin(char c){
        for (int i = 0; i < 3; i++){
            // 가로 줄이 같음
            if (arr[i][0] == c && arr[i][1] == c && arr[i][2] == c) return true;
            if (arr[0][i] == c && arr[1][i] == c && arr[2][i] == c) return true;
        }

        // 대각선이 같음
        if (arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) return true;
        if (arr[2][0] == c && arr[1][1] == c && arr[0][2] == c) return true;

        // 조건에 만족하지 않을 경우 false 반환
        return false;
    }
}
