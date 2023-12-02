import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        int count = 1;

        for (int i = 0; i < n; i++, count += 2) {
            sb = new StringBuilder();

            for (int j = 0; j < n - (i + 1); j++) {
                sb.append(" ");
            }

            for (int j = 0; j < count; j++) {
                sb.append("*");
            }

            sb.append("\n");
            str[i] = sb.toString();
        }

        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            sb.append(str[i]);
        }

        System.out.println(sb);
    }
}
