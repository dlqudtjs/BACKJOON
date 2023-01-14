import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;

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

        dfs(first);

        System.out.println(sb);
    }

    public static void dfs(int node) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(node); // 첫 노드를 push 후에 while문으로 접근한다.

        while (!myStack.empty()) {
            node = myStack.pop();

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sb.append(node).append(' ');

            // 다음 노드가 방문한 적이 있는 지 확인하고 현재 노드와 다음 노드의 간선이 있는지 확인한다.
            // 작은 수 부터 가기 위해 next : N 으로 순차적으로 내려간다. (FILO 이기 때문에 작은 수는 제일 마지막에 삽입하도록 한다.)
            for (int next = N; next >= 1; next--) {
                if (!visited[next] && graph[node][next]) {
                    myStack.push(next);
                }
            }
        }
    }
}
