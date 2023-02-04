import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static char[][] map;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new int[H][W];

        int startX = Integer.MAX_VALUE; // 첫 시작 지점을 찾기위해 max_value로 초기화
        int startY = Integer.MAX_VALUE;
        int endX = 0;
        int endY = 0;

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            Arrays.fill(visited[i], Integer.MAX_VALUE);

            for (int j = 0; j < W; j++) {
                // 시작 지점 찾기
                if (startX == Integer.MAX_VALUE && line.charAt(j) == 'C') {
                    startX = i;
                    startY = j;
                }

                map[i][j] = line.charAt(j);

                // 종료 지점 찾기
                if (startX != Integer.MAX_VALUE && line.charAt(j) == 'C') {
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs(startX, startY, endX, endY);

        System.out.println(visited[endX][endY] - 1); // 거울의 수는 -1
    }

    public static void bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[] { startX, startY });
        visited[startX][startY] = 0;

        while (!myQueue.isEmpty()) {
            int now[] = myQueue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0];
                int y = now[1];

                while (true) {
                    x += dx[i];
                    y += dy[i];

                    if (x < 0 || x >= H || y < 0 || y >= W || map[x][y] == '*') { // 범위를 벗어날 때, 벽일 때
                        break;
                    }

                    if (visited[x][y] == Integer.MAX_VALUE) { // 방문 안 했을 때만
                        visited[x][y] = visited[now[0]][now[1]] + 1;
                        if (x == endX && y == endY) {
                            return;
                        }
                        myQueue.add(new int[] { x, y });
                    } else if (visited[x][y] <= visited[now[0]][now[1]]) {
                        break;
                    }
                }
            }
        }
    }
}

// if (visited[x][y] <= visited[now[0]][now[1]] && visited[x][y] !=
// Integer.MAX_VALUE) {
// break;
// }
// visited[x][y] = visited[now[0]][now[1]] + 1;
// myQueue.add(new int[] { x, y });
// 76 ~ 83 코드 대신 쓴 코드다. 재채점 후 메모리초과가 떴다.
// 그 이유는 원래 코드는 방문을 한 곳과 현재 위치가 갈 위치보다 크거나 같을 때(현재 위치가 더 작을 때만 이동)만 break를
// 하는 로직이기 때문에, 그렇게 되면 현재 위치가 더 작다면 queue에 삽입하여 방문했던 곳을 한번 더 방문하여 4면을 확인하기 때문에
// 메모리 초과가 떴다. 그렇기 때문에 방문을 안 한곳만 queue에 넣고 가는 방향에 방문한 곳이 있더라도 현재 위치보다 같거나 크지만
// 않으면 그 방향으로 x와 y를 증감시켜 그 다음까지 확인한다. (queue에 굳이 넣지 않음)