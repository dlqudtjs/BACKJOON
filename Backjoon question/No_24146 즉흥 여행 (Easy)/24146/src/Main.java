import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> scc = new ArrayList<>();
    static ArrayList<Integer>[] nodes;
    static Stack<Integer> stack = new Stack<>();
    static boolean[] finished;
    static int[] parent;
    static int N, M, id;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드 수
        M = Integer.parseInt(st.nextToken()); // 간선 수

        nodes = new ArrayList[N + 1];
        finished = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            nodes[from].add(to);
        }

        for (int i = 1; i <= N; i++) {
            if (!finished[i]) {
                dfs(i);
            }
        }

        System.out.println(scc.size() == 1 ? "Yes" : "No");
    }

    private static int dfs(int node) {
        parent[node] = ++id;
        stack.add(node);

        // 현재 노드의 부모 노드를 저장해놓는다.

        int currentParent = parent[node];
        for (int i = 0; i < nodes[node].size(); i++) {
            int nextNode = nodes[node].get(i);

            if (parent[nextNode] == 0) {
                // 탐색하는 노드의 부모 노드와 현재 노드의 부모를 비교하여 작은 값을 현재 부모의 노드로 설정한다.
                // 헷갈렸던 부분 : 작은 값을 부모 노드로 설정하는데, 탐색 순서가 정렬이 되있지 않은 상태일 땐
                // 어떻게 될까? 를 해결한 부분이 현재 노드의 부모 노드를 ++id로 설정했기에 가능하다(방문 순서로 설정)
                currentParent = Math.min(currentParent, dfs(nextNode));
            } else if (!finished[nextNode]) {
                currentParent = Math.min(currentParent, parent[nextNode]);
            }
        }

        // parent[node]는 탐색하기전 초기값이며 currentParent는 위에 for문을 통해 탐색 후 설정된 가장
        // 작은 부모의 값이다. 따라서 초기값과 탐색 후 값이 같다면 자기 자신이 SCC의 루트 노드이다.
        if (parent[node] == currentParent) {
            ArrayList<Integer> array = new ArrayList<>();

            while (true) {
                int n = stack.pop();
                array.add(n);
                finished[n] = true;

                if (node == n) {
                    break;
                }
            }

            scc.add(array);
        }

        return currentParent;
    }
}
