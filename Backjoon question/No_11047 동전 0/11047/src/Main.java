import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int index = n - 1;
        while (k != 0) {
            if (arr[index] > k) {
                index--;
                continue;
            }

            cnt += k / arr[index];
            k = k % arr[index];
        }

        System.out.println(cnt);
    }
}
