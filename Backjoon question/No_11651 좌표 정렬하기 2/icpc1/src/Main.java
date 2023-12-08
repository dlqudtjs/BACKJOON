import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = 0;

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (value == 0 || value > 0) {
                value -= a;
                continue;
            }

            if (value < 0) {
                value += a;
                continue;
            }
        }

        int arr[] = new int[] { 100, 50, 20, 10, 5, 2, 1 };

        int count = 0;
        value = Math.abs(value);

        for (int i = 0; i < 7; i++) {
            count += value / arr[i];
            value = value % arr[i];
        }

        System.out.println(count);
    }
}
