import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] stick = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stick[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(stick);

        int result = 0;
        int start = 1;
        int end = stick[n - 1];

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;

            for (int i : stick) {
                count += i / mid;
            }

            if (count >= m) {
                if (result < mid) {
                    result = mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
