import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, name);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();

            if (map.containsKey(name)) {
                names.add(name);
            }
        }

        Collections.sort(names);

        sb.append(names.size()).append("\n");
        for (int i = 0; i < names.size(); i++) {
            sb.append(names.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
