import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> hash = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (str.equals("ENTER")) {
                answer += hash.size();
                hash.clear();
                continue;
            }

            hash.add(str);
        }

        answer += hash.size();

        System.out.println(answer);
    }
}
