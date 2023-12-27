import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        for (int i = 0; i < 5; i++) {
            int value = Integer.parseInt(st.nextToken());

            total += value * value;
        }

        System.out.println(total % 10);
    }
}
