import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startX = 0;
        int startY = 0;
        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == '0') {
                    startY = i;
                    startX = j;
                }
            }
        }

        System.out.println(bfs(map, startY, startX));
    }

    private static int bfs(char[][] map, int startY, int startX) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][64];
        queue.add(new Node(startY, startX, 0, 0));
        visited[startY][startX][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (map[current.y][current.x] == '1') {
                return current.moveCount;
            }

            for (int i = 0; i < 4; i++) {
                int nowY = current.y + dy[i];
                int nowX = current.x + dx[i];

                // 맵 밖일 때
                if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= m) {
                    continue;
                }

                // 현재 키를 갖고 있는 상태에서 방문을 했는지, 벽인지 확인
                if (visited[nowY][nowX][current.key] || map[nowY][nowX] == '#') {
                    continue;
                }

                char c = map[nowY][nowX];
                if (Character.isLowerCase(c)) { // 열쇠
                    // 현재 키와 다음 키를 or연산
                    int key = current.key | (1 << c - 'a');
                    visited[nowY][nowX][key] = true;
                    queue.add(new Node(nowY, nowX, key, current.moveCount + 1));
                } else if (Character.isUpperCase(c)) { // 문
                    if ((current.key & 1 << c - 'A') == 0) {
                        continue;
                    }
                    visited[nowY][nowX][current.key] = true;
                    queue.add(new Node(nowY, nowX, current.key, current.moveCount + 1));
                } else { // . 일 때
                    visited[nowY][nowX][current.key] = true;
                    queue.add(new Node(nowY, nowX, current.key, current.moveCount + 1));
                }
            }
        }

        return -1;
    }

}

class Node {
    int y;
    int x;
    int moveCount;
    int key;

    public Node(int y, int x, int key, int moveCount) {
        this.y = y;
        this.x = x;
        this.key = key;
        this.moveCount = moveCount;
    }
}
