import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] permutation;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        permutation = new int[m];

        permutation(1, 0);

        System.out.println(sb);
    }

    private static void permutation(int at, int depth) {
        if (depth == m) {
            for (int value : permutation) {
                sb.append(value).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = at; i <= n; i++) {
            permutation[depth] = i;
            permutation(i + 1, depth + 1);
        }
    }
}
