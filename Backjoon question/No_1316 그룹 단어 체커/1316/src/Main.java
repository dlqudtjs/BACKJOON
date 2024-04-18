import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            char prev = '0';

            for (char c : str.toCharArray()) {
                if (prev == c) {
                    continue;
                }

                if (sb.toString().contains(c + "")) {
                    count++;
                    break;
                }

                prev = c;
                sb.append(c);
            }
        }

        System.out.println(n - count);
    }
}
