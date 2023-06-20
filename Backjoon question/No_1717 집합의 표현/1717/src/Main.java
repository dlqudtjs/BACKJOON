import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (input == 0) {
                union(from, to);
                continue;
            }

            if (input == 1) {
                sb.append(check(from, to) ? "YES" : "NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean check(int from, int to) {
        if (find(from) == find(to)) {
            return true;
        }

        return false;
    }

    private static void union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);

        if (fromParent == toParent) {
            return;
        }

        parent[toParent] = fromParent;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        // 기존 return find(parent[x])에서 다음과 같이 변경하여 경로압축을 하였다.
        // 따라서, 기존 1 -> 2 -> 3 -> 4로 연결되어 재귀적으로 find하던 작업이 반복 되었지만
        // 한 번 그 작업을 수행하면 1, 2, 3, 4는 모두 같은 부모를 가리키고 있어, 예를 들어 6 -> 1을 한 번만 해도 된다.
        return parent[x] = find(parent[x]);
    }
}
