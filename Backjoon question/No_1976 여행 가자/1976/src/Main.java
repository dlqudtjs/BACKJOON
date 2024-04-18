import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    continue;
                }

                // i, j가 연결되어 있다면
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = find(i);
        }

        st = new StringTokenizer(br.readLine());
        int previous = parent[Integer.parseInt(st.nextToken())];
        boolean flag = false;
        for (int i = 0; i < m - 1; i++) {
            if (previous != parent[Integer.parseInt(st.nextToken())]) {
                flag = true;
                break;
            }
        }

        System.out.println(flag ? "NO" : "YES");
    }

    private static boolean union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);

        if (fromParent == toParent) {
            return false;
        }

        if (fromParent > toParent) {
            parent[fromParent] = toParent;
        } else {
            parent[toParent] = fromParent;
        }

        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }
}

/*
 * n 과 m 이 헷갈리는 경우가 있는 문제이므로 잘 주의해서 풀어야한다.
 * 마지막 m 만큼 여행 계획에 속한 도시들이 순서대로 주어지는데 이때,
 * 1 2 3 으로 주어지면 1 -> 2 -> 3 순서대로 여행한다. 따라서 1이 시작점이 되고
 * 1 1 이 주어지면 1에서 1로 가만히 있기 때문에 무조건 연결되는 상황이 나온다.
 * 이런 점을 유의해서 풀어야 한당.
 */