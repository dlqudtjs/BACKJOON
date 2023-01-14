import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M; // 노드의 개수 : N, 간선의 개수 : M
    static boolean[][] graph; // 그래프 표현 방식은 인접리스트, 인접행렬이 있음, (여기선 인접행렬 사용)
    static boolean[] visited; // 노드의 방문 여부 확인

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int first = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1]; // 실질적 수를 표현하기 위해 + 1;
        visited = new boolean[N + 1];

        // 인접행렬 구현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 간선이 0, 1 이나 1, 0이나 같은 간선이기 때문에 두개 다 graph 배열에 추가
            graph[x][y] = graph[y][x] = true;
        }

        dfs(first);

        System.out.println(sb);
    }

    public static void dfs(int node) {
        visited[node] = true; // 노드를 방문하는 순간 true 표시
        sb.append(node).append(' ');

        for (int next = 1; next <= N; next++) {
            // 노드가 방문하지 않았고, 현재 노드와 다음 노드가 간선 돼있다면 dfs 재귀 호출을 한다.
            if (!visited[next] && graph[node][next]) {
                dfs(next);
            }
        }
    }
}
