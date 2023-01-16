import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int first = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = true;
        }

        bfs(first);

        System.out.println(sb);
    }

    public static void bfs(int node) {
        // Queue 인터페이스 구현을 위해 LinkedList를 통해서 생성한다.
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(node);
        visited[node] = true;

        while (!myQueue.isEmpty()) {
            node = myQueue.poll();
            sb.append(node).append(' ');

            for (int next = 1; next <= N; next++) {
                if (!visited[next] && graph[node][next]) {
                    myQueue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
