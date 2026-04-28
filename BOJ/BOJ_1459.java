package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 걷기
public class BOJ_1459 {
    private static long X, Y;
    private static int time_st, time_nst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        time_st = Integer.parseInt(st.nextToken()); // 직선으로 한 블록 시간
        time_nst = Integer.parseInt(st.nextToken()); // 대각선으로 한 블록 시간

        // 경우 1 : 직선 이동
        long straight = (X+Y)*time_st;

        // 경우 2 : 대각선 후 직선 이동
        long diff = Math.abs(X-Y);
        long mix = time_nst*Math.min(X,Y) + diff*time_st;

        // 경우 3 : 대각선으로만 이동
        long cross;
        if ((X+Y)%2 == 0){ // 짝수면 긴 길이만큼 이동함
            cross = time_nst * Math.max(X, Y);
        } else {
            // 홀수면 대각선 이동 후 직선 이동 추가
            cross = time_nst * (Math.max(X, Y) - 1) + time_st;
        }
        System.out.println(Math.min(straight, Math.min(mix, cross)));
    }
}
