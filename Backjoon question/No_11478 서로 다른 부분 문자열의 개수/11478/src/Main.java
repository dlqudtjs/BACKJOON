import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();

        String s = br.readLine();

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; (j + i) <= s.length(); j++) {
                String split = s.substring(j, j + i);

                map.put(split, split);
            }
        }

        System.out.println(map.size());
    }
}
