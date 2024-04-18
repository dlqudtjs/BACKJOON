import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = gcd(Math.max(a, b), Math.min(a, b));
        int lcm = a * b / gcd;

        sb.append(gcd).append("\n").append(lcm);

        System.out.println(sb);
    }

    private static int gcd(int bigNum, int smallNum) {
        if (bigNum % smallNum == 0) {
            return smallNum;
        }

        return gcd(smallNum, bigNum % smallNum);
    }
}
