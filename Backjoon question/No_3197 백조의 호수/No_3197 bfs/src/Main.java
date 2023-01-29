import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, day, swan1X, swan1Y, swan2X, swan2Y;
    static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        swan1X = Integer.MAX_VALUE;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);

                if (line.charAt(j) == 'L' && swan1X == Integer.MAX_VALUE) { // 첫 번째 백조의 위치
                    swan1X = i;
                    swan1Y = j;
                } else if (line.charAt(j) == 'L') { // 두 번째 백조의 위치
                    swan2X = i;
                    swan2Y = j;
                }

                if (line.charAt(j) != 'X') { // 백조도 물이기 때문에
                    waterQ.add(new int[] { i, j });
                }

            }
        }

        // 백조의 위치를 q에 넣어서 백조의 위치찾는다.
        q.add(new int[] { swan1X, swan1Y });
        visited[swan1X][swan1Y] = true;

        while (true) {
            if (bfs()) {
                break;
            }

            melt();
        }

        System.out.println(day);
    }

    public static boolean bfs() {
        // nextQ는 q에게 다음 날 시작 주소를 넘겨준 후 초기화를 시켜줘야 한다.
        Queue<int[]> nextQ = new LinkedList<>();

        while (!q.isEmpty()) {
            int now[] = q.poll();

            if (visited[swan2X][swan2Y]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dir[i][0];
                int y = now[1] + dir[i][1];

                if (x < 0 || x >= R || y < 0 || y >= C || visited[x][y]) { // 범위 밖일 때
                    continue;
                }

                // 물에 인접한 얼음 즉 'X'일 경우에도 해당 좌표 또한 visited에 넣어서 굳이 다른 좌표에서 한 번 더 방문할 필요가 없도록 한다.
                // (다음 날에 방문할 때 옆 물에서 재방문을 방지하기 위함)
                visited[x][y] = true;

                // 물에 인접한 얼음일 경우 nextQ에 해당 좌표를 넣는다. (다음 날 백조는 여기서 부터 탐색한다.)
                if (map[x][y] == 'X') {
                    nextQ.add(new int[] { x, y });
                    continue;
                }

                // 백조가 갈 수 있는 곳을 탐색한다. (백조를 찾기위해)
                q.add(new int[] { x, y });
            }
        }

        // 다음 날 탐색을 시작할 곳을 물과 인접한 얼음으로 한다. (melt 메소드에서 녹이기 때문에)
        q = nextQ;

        return false;
    }

    public static void melt() {
        int size = waterQ.size(); // Queue 사이즈 만큼 돌릴 때는 처리 과정에서 사이즈가 줄 수 있기 때문에 따로 저장해둔다.

        for (int k = 0; k < size; k++) {
            int now[] = waterQ.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dir[i][0];
                int y = now[1] + dir[i][1];

                if (x < 0 || x >= R || y < 0 || y >= C) {
                    continue;
                }

                if (map[x][y] == 'X') {
                    map[x][y] = '.';
                    waterQ.add(new int[] { x, y });
                }
            }
        }

        day++;
    }
}

// 백조가 갈 수 있는 곳과 얼음이 녹아 퍼지는 곳을 구별하기 위해 Q를 여러개 썼다.