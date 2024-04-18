import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < n - i; j++) {
                sb.append(" ");
            }

            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
