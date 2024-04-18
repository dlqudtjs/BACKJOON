import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str);

            String a = st.nextToken();
            String b = st.nextToken();

            int index = 0;
            boolean flag = false;

            for (int i = 0; i < a.length(); i++) {
                flag = false;

                for (int j = index; j < b.length(); j++) {
                    index++;

                    if (a.charAt(i) == b.charAt(j)) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    sb.append("No").append("\n");
                    break;
                }
            }

            if (flag) {
                sb.append("Yes").append("\n");
            }
        }

        System.out.println(sb);
    }
}
