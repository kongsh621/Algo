package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

// 랭킹전 대기열
public class BOJ_20006 {
    // 플레이어 정보를 저장할 클래스
    static class Player implements Comparable<Player> {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name); // 사전순
        }
    }
    // 랭킹전 방 정보를 저장할 클래스
    static class Room {
        int levelLimit; // 기준이 되는 레벨
        int m; // 정원
        List<Player> players = new ArrayList<>();

        Room(Player p, int m) {
            this.levelLimit = p.level;
            this.m = m;
            players.add(p);
        }

        // 플레이어 입장 가능 여부
        boolean canJoin(Player p) {
            // 방이 다 안 찼고 차이가 10을 넘지 않으면 true
            return players.size() < m && Math.abs(p.level - levelLimit) <= 10;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pCount = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방 정원

        // 방 정보 담을 리스트
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < pCount; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Player player = new Player(level, name); // 레벨과 이름을 저장

            // 방에 들어갔는지 여부
            boolean joined = false;
            for (Room room : rooms) {
                if (room.canJoin(player)) {
                    // 들어갈 수 있으면 추가해줌
                    room.players.add(player);
                    joined = true; // 상태 변경
                    break;
                }
            }

            // 들어갈 방이 없으면 방을 생성
            if (!joined) {
                rooms.add(new Room(player, m));
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            // 정원이 찼으면 Started!
            if (room.players.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            // 정렬하여 이름 기준 사전순 출력
            Collections.sort(room.players);
            for (Player p : room.players) {
                sb.append(p.level).append(" ").append(p.name).append("\n");
            }
        }
        System.out.print(sb);
    }
}
