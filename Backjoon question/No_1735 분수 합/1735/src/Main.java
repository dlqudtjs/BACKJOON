import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int numerator = (a1 * b2) + (a2 * b1);
        int denominator = b1 * b2;
        int gcd = gcd(numerator, denominator);

        System.out.println(numerator / gcd + " " + denominator / gcd);
    }

    private static int gcd(int bigNum, int smallNum) {
        if (bigNum % smallNum == 0) {
            return smallNum;
        }

        return gcd(smallNum, bigNum % smallNum);
    }
}
