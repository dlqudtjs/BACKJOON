import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        while (true) {
            sb = new StringBuilder();
            int x = Integer.parseInt(br.readLine());

            if (x == -1) {
                break;
            }

            int total = 0;

            for (int i = 1; i <= x / 2; i++) {
                if (x % i == 0) {
                    total += i;
                    sb.append(i).append(" + ");
                }
            }

            if (total != x) {
                System.out.println(x + " is NOT perfect.");
                continue;
            }

            sb.delete(sb.length() - 2, sb.length());
            sb.insert(0, x + " = ");
            System.out.println(sb);
        }
    }
}
