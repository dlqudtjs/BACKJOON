import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int low = 0;
        int max = arr[arr.length - 1];
        int mid = max / 2;

        while (true) {
            if (low >= mid) {
                break;
            }

            long count = getCutCount(arr, mid);
            if (count == m) {
                break;
            }

            // 필요한 나무보다 많을 때 높이를 올림
            if (count > m) {
                low = mid;
                mid = (max + mid) / 2;
                continue;
            }

            // 나무가 부족할 때 높이를 내림
            max = mid;
            mid = (low + mid) / 2;
        }

        System.out.println(mid);
    }

    private static long getCutCount(int[] arr, int mid) {
        long count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= mid) {
                break;
            }

            count += arr[i] - mid;
        }

        return count;
    }
}
