import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int square = 0;
        int answer = 0;

        for (int i = n.length() - 1; i >= 0; i--) {
            answer += convertBinary(n.charAt(i)) * Math.pow(b, square++);
        }

        System.out.println(answer);
    }

    private static int convertBinary(char n) {
        if (Character.isDigit(n)) {
            return n - '0';
        }

        // "A는 65 이므로, 55를 빼면 10을 반환함."
        return n - 55;
    }
}
