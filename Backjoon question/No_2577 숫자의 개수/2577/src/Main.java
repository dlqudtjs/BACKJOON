import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[10];

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int total = a * b * c;

        while (total != 0) {
            dp[total % 10]++;
            total /= 10;
        }

        for (int i = 0; i <= 9; i++) {
            sb.append(dp[i]).append("\n");
        }

        System.out.println(sb);
    }
}
