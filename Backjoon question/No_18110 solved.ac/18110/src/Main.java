import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
16
        int average = (int) Math.round(n * 15.0 / 100.0);

        Arrays.sort(arr);

        int total = 0;
        for (int i = average; i < n - average; i++) {
            total += arr[i];
        }

        System.out.println(Math.round((double) total / (n - (average + average))));
    }
}
