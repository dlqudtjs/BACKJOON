import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        map = createMap();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            sb.append(convertString(str)).append("\n");
        }

        System.out.println(sb);
    }

    private static String convertString(String str) {
        for(String key : map.keySet()) {
            if(str.endsWith(key)) {
                str.replace(key, str)
            }
        }

        return s;
    }

    private static Map<String, String> createMap() {
        map.put("a", "as");
        map.put("i", "ios");
        map.put("y", "ios");
        map.put("l", "les");
        map.put("n", "anes");
        map.put("ne", "anes");
        map.put("o", "os");
        map.put("r", "res");
        map.put("t", "tas");
        map.put("y", "us");
        map.put("v", "ves");
        map.put("w", "was");

        return map;
    }
}
