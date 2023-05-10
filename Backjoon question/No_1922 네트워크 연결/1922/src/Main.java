import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 초기 설정은 자기 자신이 부모 노드이다. (모두 이어져 있기 않기 때문)
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new Node(v1, v2, weight));
        }

        int weightSum = 0;
        for (int i = 0; i < M; i++) {
            Node node = pq.poll();

            // 각자 찾은 부모 노드가 다르다면 연결(union) 해준다.
            if (find(node.v1) != find(node.v2)) {
                union(node.v1, node.v2, node.weight);
                weightSum += node.weight;
            }
        }

        System.out.println(weightSum);
    }

    private static void union(int v1, int v2, int weight) {
        int v1Parent = find(v1);
        int v2Parent = find(v2);

        // 합칠 땐 부모 노드 값이 작은 곳에 합친다.
        if (v1Parent > v2Parent) {
            parent[v1Parent] = v2Parent;
        } else {
            parent[v2Parent] = v1Parent;
        }
    }

    // x의 부모 노드를 찾는다.
    private static int find(int x) {
        /*
         * parent[x] == x를 하는 이유
         * 처음 설정 그대로라면 parent[x] == x, 즉 자기 자신이기 때문에 부모노드를 찾고 끝낸다.
         * 하지만, union 시 자신의 부모노드(parent[x])는 상대 부모노드와 비교 후 작다면 상대의 부모 노드값을 따라가기 때문에
         * 값이 변경된다. 이때, 같은 값인 parent[x] == x를 했을 땐, 이미 변경 됐기 때문에 자신의 부모 노드를 찾아야한다.
         * (parent[x]가 자신의 부모노드라고 생각할 수 있지만, 부모노드를 찾는 것이 아닌 연결된 루트노드를 찾아야 하기 때문에
         * find(parent[x])로 자신의 부모노드의 부모노드를 한 번더 검색한다. 이때, 루트노드는 parent[1] = 1 처럼 자기 자신의
         * 값을 가지고 있기 때문에 parent[x]와 x값이 같다면 재귀함수를 멈춘다.)
         */
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }
}

class Node implements Comparable<Node> {
    int v1 = 0;
    int v2 = 0;
    int weight = 0;

    public Node(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return weight - node.weight;
    }
}