import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Set<Integer>[] set = new HashSet[3];

            for (int j = 0; j < 3; j++) {
                set[j] = new HashSet<>();

                int size = Integer.parseInt(br.readLine());

                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < size; k++) {
                    set[j].add(Integer.parseInt(st.nextToken()));
                }
            }

            sb.append(calculate(set)).append("\n");
        }

        System.out.println(sb);
    }

    private static int calculate(Set<Integer>[] set) {
        Set<String> answer = new HashSet<>();

        for (int i : set[0]) {
            for (int j : set[1]) {
                for (int k : set[2]) {
                    String str = Integer.toString(i + j + k);
                    boolean flag = false;

                    for (char c : str.toCharArray()) {
                        if (c != '5' && c != '8') {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        answer.add(str);
                    }
                }
            }
        }

        return answer.size();
    }
}
