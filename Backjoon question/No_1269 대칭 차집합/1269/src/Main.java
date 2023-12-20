import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int value = Integer.parseInt(st.nextToken());
            map.put(value, value);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (map.containsKey(value)) {
                count++;
            }
        }

        System.out.println((a - count) + (b - count));
    }
}
