import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int computerCnt, computerLine, cnt;
    static boolean[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerCnt = Integer.parseInt(br.readLine());
        computerLine = Integer.parseInt(br.readLine());

        map = new boolean[computerCnt + 1][computerCnt + 1];
        visited = new boolean[computerCnt + 1];

        for (int i = 0; i < computerLine; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = true;
        }

        bfs(1);

        System.out.println(cnt);
    }

    public static void bfs(int node) {
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(node);
        visited[node] = true;

        while (!myQueue.isEmpty()) {
            node = myQueue.poll();

            for (int next = 1; next <= computerCnt; next++) {
                if (!visited[next] && map[node][next]) {
                    myQueue.add(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
    }
}
