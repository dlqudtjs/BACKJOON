import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 1;

        while (true) {
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            boolean[] check = new boolean[n];
            String[] names = new String[n];

            for (int i = 0; i < n; i++) {
                names[i] = br.readLine();
            }

            for (int i = 0; i < (n * 2) - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(st.nextToken()) - 1;

                check[number] = !check[number];
            }

            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    sb.append(count).append(" ").append(names[i]).append("\n");
                }
            }

            count++;
        }

        System.out.println(sb);
    }
}
