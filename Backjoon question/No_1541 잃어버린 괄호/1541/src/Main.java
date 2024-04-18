import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minusSplit = new StringTokenizer(br.readLine(), "-");
        int answer = Integer.MAX_VALUE;

        while (minusSplit.hasMoreTokens()) {
            StringTokenizer plusSplit = new StringTokenizer(minusSplit.nextToken(), "+");
            int total = 0;

            while (plusSplit.hasMoreTokens()) {
                total += Integer.parseInt(plusSplit.nextToken());
            }

            if (answer == Integer.MAX_VALUE) {
                answer = total;
            } else {
                answer -= total;
            }
        }

        System.out.println(answer);
    }
}
