import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Queue<Integer>> scc = new ArrayList<>();
    static ArrayList<Integer>[] nodes;
    static Stack<Integer> stack = new Stack<>();
    static int parent[];
    static boolean[] finished;
    static int V, E, id;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[V + 1];
        finished = new boolean[V + 1];
        parent = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            nodes[from].add(to);
        }

        for (int i = 1; i <= V; i++) {
            if (!finished[i]) {
                dfs(i);
            }
        }

        // Queue의 맨 위 요소를 기준으로 오름차순한다.
        Collections.sort(scc, (o1, o2) -> o1.peek() - o2.peek());
        System.out.println(scc.size()); // 사이즈 출력

        StringBuilder sb = new StringBuilder();
        for (Queue<Integer> queue : scc) {
            while (!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }

            sb.append("-1\n");
        }

        System.out.println(sb); // 순서 출력
    }

    private static int dfs(int node) {
        parent[node] = ++id;
        stack.add(node);

        // 자신의 초기 노드는 자기 자신(id)이 된다.
        int currentParent = parent[node];
        for (int i = 0; i < nodes[node].size(); i++) {
            int nextNode = nodes[node].get(i);

            // 탐색할 노드가 방문되지 않았다면
            if (parent[nextNode] == 0) {
                currentParent = Math.min(currentParent, dfs(nextNode));
            } else if (!finished[nextNode]) {
                // 탐색할 노드가 방문은 되었지만, SCC에 속하지 않았을 때
                // 현재 노드의 부모 노드는 현재 노드의 부모와 탐색 노드의 부모 노드 중 작은 값으로 설정한다.
                currentParent = Math.min(currentParent, parent[nextNode]);
            }
        }

        // 자신의 처음 초기값(parent[node])와 위에 for문에서 탐색하여 가장 수치가 낮은 부모 노드를 탐색하여
        // 자신과 비교 후 같다면 자신이 SCC의 루트 노드로 판단한다.
        if (parent[node] == currentParent) {
            // 오름차순을 위해 priorityQueue를 사용했다.
            Queue<Integer> queue = new PriorityQueue<>();

            while (true) {
                int n = stack.pop();
                finished[n] = true; // stack에서 뽑아서 SCC가 될 때 finish에 체크한다.
                queue.add(n);

                if (node == n) { // stack에서 루트 노드인 자신(node)이 나올 때 까지 뽑는다.
                    break;
                }
            }

            scc.add(queue);
        }

        return currentParent;
    }
}
