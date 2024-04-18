import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m)
                continue;

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, (o1, o2) -> {
            // 나오는 단어 수
            if (map.get(o1) == map.get(o2)) {

                // 단어의 길이 순
                if (o1.length() == o2.length()) {
                    // 사전 순 정렬
                    return o1.compareTo(o2);
                }

                // 길이 순 정렬
                return o2.length() - o1.length();
            }

            // 자주 나오는 단어 순 정렬
            return map.get(o2) - map.get(o1);
        });

        for (String str : words) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
