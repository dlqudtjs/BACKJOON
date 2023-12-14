import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> poketmonMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            poketmonMap.put(name, String.valueOf(i + 1));
            poketmonMap.put(String.valueOf(i + 1), name);
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();

            sb.append(poketmonMap.get(input)).append("\n");
        }

        System.out.println(sb);
    }
}
