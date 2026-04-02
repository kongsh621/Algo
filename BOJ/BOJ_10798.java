package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 세로 읽기
public class BOJ_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자들을 저장할 2차원 배열
        char[][] arr = new char[5][15];
        StringBuilder sb = new StringBuilder();

        // 다섯 줄의 입력을 받아 이차원 배열에 저장
        for (int i = 0; i < 5; i++){
            String line = br.readLine();
            // 입력받은 글자 길이만큼만 반복해서 배열의 각 칸에 직접 꽂아 넣습니다.
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 5; j++){
                // 빈자리가 아니라면 sb에 추가
                if (arr[j][i] != '\0') {
                    sb.append(arr[j][i]);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
