import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] array = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = new ArrayList<>();

            int count = st.countTokens();
            for (int j = 0; j < count - 1; j++) {
                array[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int k = 1;
        while (true) {
            if (check(array, k)) {
                break;
            }

            // 아래 k++을 대비해서 k와 같다면 0을 추가한다,
            for (int i = 0; i < n; i++) {
                if (array[i].size() == k) {
                    array[i].add(0);
                }
            }

            k++;
        }

        System.out.println(k);
    }

    private static boolean check(List<Integer>[] array, int k) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int x : array[i].subList(0, k)) {
                sb.append(x).append(" ");
            }

            set.add(sb.toString());
        }

        return set.size() == array.length;
    }
}

// 2
// 10 1 2 -1
// 10 1 2 3 -1