import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int i : set) {
            for (int j : set) {
                if (map.containsKey(i - j)) {
                    if (i == j && map.get(j) < 3) {
                        continue;
                    }
                    if ((i - j) == j && map.get(j) < 2) {
                        continue;
                    }

                    count += 1 * map.get(i);
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
