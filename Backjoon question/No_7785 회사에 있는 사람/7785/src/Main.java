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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, String> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                map.put(name, state);
                continue;
            }

            map.remove(name);
        }

        List<String> names = new ArrayList<>(map.keySet());

        Collections.sort(names, Collections.reverseOrder());

        for (String name : names) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
