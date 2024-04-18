import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int findNumber = Integer.parseInt(st.nextToken());

                sb.append(binarySearch(arr, findNumber) ? "1" : "0").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean binarySearch(int[] arr, int findNumber) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > findNumber) {
                high = mid - 1;
                continue;
            }

            if (arr[mid] < findNumber) {
                low = mid + 1;
                continue;
            }

            return true;
        }

        return false;
    }
}
