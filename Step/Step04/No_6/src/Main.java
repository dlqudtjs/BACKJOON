import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            hashSet.add((Integer.parseInt(br.readLine())) % 42);
        }

        System.out.println(hashSet.size());
        br.close();

        // HashSet을 사용하지 않는 알고리즘
        // int[] input = new int[10];
        // int[] result = new int[10];

        // for (int i = 0; i < input.length; i++) {
        // input[i] = Integer.parseInt(br.readLine());
        // }

        // for (int i = 0; i < result.length; i++) {
        // result[i] = input[i] % 42;
        // }

        // int cnt = 1;

        // Arrays.sort(result);
        // for (int i = 0; i < result.length - 1; i++) {
        // cnt = (result[i] != result[i + 1]) ? ++cnt : cnt;
        // }

        // System.out.println(cnt);
        // br.close();
    }
}
