package SWEA;

import java.util.Scanner;

// Ladder 1
public class SWEA_1210 {
    public static void main(String[] args) {
        // 0 : 공간, 1 : 사다리, 2 : 도착 지점
        // 100 X 100 의 배열
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int i = 1; i <= T; i++){

            int t = sc.nextInt();
            int x = -1, y = -1;
            // 배열 생성
            int N = 100;
            int[][] arr = new int[N][N];
            for (int k = 0; k < N; k++){
                for (int j = 0; j < N; j++){
                    arr[k][j] = sc.nextInt();
                    if (k == 99 && arr[k][j] == 2){
                        // 도착지점 저장
                        x = j;
                    }
                }
            }

            // 도착지점에서 위로 올라오면서 출발지 x 좌표 찾아 출력
            // 위보다 왼/오가 우선
            // 처음은 위로 올라가니 98에서 시작
            int currX = x;
            int currY = 98;
            while (currY > 0){
                if (currX-1 >= 0 && arr[currY][currX-1] == 1){ // 좌
                    while (currX-1 >= 0 && arr[currY][currX-1] == 1){
                        currX--;
                    }
                } else if(currX+1 < 100 && arr[currY][currX+1] == 1) { // 우
                    while (currX+1 < 100 && arr[currY][currX+1] == 1){
                        currX++;
                    }
                }
                currY--;
            }
            System.out.printf("#%d %d%n", t, currX);
        }

    }
}
