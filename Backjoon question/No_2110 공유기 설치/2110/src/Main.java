import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 0;
        int high = arr[n - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            int position = 0;
            int count = 1;

            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[position] >= mid) {
                    position = i;
                    count++;
                }
            }

            if (count < c) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }
}
