import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int DISTANCE = 20 * 50;
    static Point house, festival;
    static Point[] store;
    static boolean[] visited;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int taseCase = 0; taseCase < t; taseCase++) {
            flag = false; // flag은 페스티벌에 갔는 지 유무를 확인한다.
            int n = Integer.parseInt(br.readLine()); // 편의점 개수
            visited = new boolean[n]; // 방문 노드 확인
            store = new Point[n]; // 편의점 노드를 저장한다.

            // 처음 나오는 좌표는 집 좌표이다.
            st = new StringTokenizer(br.readLine());
            house = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                store[i] = new Point(x, y);
            }

            // 마지막에 나오는 좌표는 페스티벌 좌표이다.
            st = new StringTokenizer(br.readLine());
            festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // dfs
            sloution(house.x, house.y);

            if (flag) {
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }
        }

        System.out.println(sb);
    }

    public static void sloution(int curX, int curY) {
        if (flag) { // flag가 ture 일 경우는 festival에 갈 수 있을때이다.
            return;
        }

        // 맨해튼 거리가 1000 이하일 때는 페스티벌에 갈 수 있다.
        if (Math.abs(curX - festival.x) + Math.abs(curY - festival.y) <= DISTANCE) {
            flag = true;
            return;
        }

        // 편의점
        for (int i = 0; i < store.length; i++) {
            if (visited[i]) {
                continue;
            }

            // 현재 위치에서 편의점을 갈 수 없으면 continue
            if (Math.abs(curX - store[i].x) + Math.abs(curY - store[i].y) > DISTANCE) {
                continue;
            }

            // 현재 위치에서 편의점을 갈 수 있다면 visited 체크 후 탐색한다.
            // dfs이기 때문에 어디부터 방문하든 상관없다.
            visited[i] = true;
            sloution(store[i].x, store[i].y);
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// 참고 블로그 : https://brightmango.tistory.com/332
// 해당 코드는 dfs로 풀었다.
// house 좌표부터 닿는 편의점을 queue에 넣고, 탐색하여 페스티벌에 닿았다면 return하는 bfs도 가능할 것 같다.