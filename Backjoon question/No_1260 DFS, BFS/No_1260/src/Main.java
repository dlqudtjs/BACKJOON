import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = true;
        }

        dfs(first);
        System.out.println(sb);

        bfs(first);
        System.out.println(sb);
    }

    public static void dfs(int node) {
        sb = new StringBuilder();
        visited = new boolean[N + 1];
        Stack<Integer> myStack = new Stack<>();

        myStack.push(node);

        while (!myStack.isEmpty()) {
            node = myStack.pop();

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sb.append(node).append(' ');

            for (int next = N; next >= 1; next--) {
                if (!visited[next] && graph[node][next]) {
                    myStack.push(next);
                }
            }
        }
    }

    public static void bfs(int node) {
        sb = new StringBuilder();
        visited = new boolean[N + 1];
        Queue<Integer> myQueue = new LinkedList<>();

        myQueue.add(node);

        while (!myQueue.isEmpty()) {
            node = myQueue.poll();

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sb.append(node).append(' ');

            for (int next = 1; next <= N; next++) {
                if (!visited[next] && graph[node][next]) {
                    myQueue.add(next);
                }
            }
        }
    }
}
