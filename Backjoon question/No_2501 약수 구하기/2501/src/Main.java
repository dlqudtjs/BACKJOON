import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            if (n % i == 0) {
                arr.add(n / i);
            }
        }

        System.out.println(arr.size() >= k ? arr.get(k - 1) : 0);
    }
}
