import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int low = 0;
        int high = arr[n - 1];

        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;

            for (int i : arr) {
                if (i >= mid) {
                    sum += mid;
                } else {
                    sum += i;
                }
            }

            if (sum > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(high);
    }
}
