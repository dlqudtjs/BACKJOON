import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }

            return o1.length() - o2.length();
        });

        sb.append(arr[0]).append("\n");
        for (int i = 1; i < n; i++) {
            if (arr[i].equals(arr[i - 1])) {
                continue;
            }

            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
