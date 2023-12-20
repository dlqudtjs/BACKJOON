import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int divideNum = gcd(Math.max(a, b), Math.min(a, b));

            sb.append((a * b) / divideNum).append("\n");
        }

        System.out.println(sb);
    }

    private static int gcd(int bigNum, int smallNum) {
        if (bigNum % smallNum == 0) {
            return smallNum;
        }

        int divideNum = bigNum % smallNum;

        return gcd(smallNum, divideNum);
    }
}
