import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> set = new HashSet<>();
    static int n, k;
    static int[] array;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        array = new int[n];
        result = new int[k];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        a(0, k);

        System.out.println(set.size());
    }

    private static void a(int current, int depth) {
        if (current == k) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < k; i++) {
                sb.append(result[i]);
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            result[current] = array[i];
            visited[i] = true;
            a(current + 1, depth);
            visited[i] = false;
        }
    }
}
