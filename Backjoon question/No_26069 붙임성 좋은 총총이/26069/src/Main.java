import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Set<String> hashSet = new HashSet<>();

        hashSet.add("ChongChong");

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (hashSet.contains(a) || hashSet.contains(b)) {
                hashSet.add(a);
                hashSet.add(b);
            }
        }

        System.out.println(hashSet.size());
    }
}
