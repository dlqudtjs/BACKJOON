import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        // 산술평균
        int total = 0;

        // 중앙값
        int median = 0;

        // 최빈값
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;

        // 최댓값과 최솟값의 차이
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            total += value;
            map.put(value, map.getOrDefault(value, 0) + 1);

            min = Math.min(min, value);
            max = Math.max(max, value);
            maxCount = Math.max(maxCount, map.get(value));
        }

        Arrays.sort(arr);

        median = arr[n / 2];

        for (Integer i : map.keySet()) {
            if (map.get(i) == maxCount) {
                list.add(i);
            }
        }

        // 최빈값 오름차순
        Collections.sort(list);

        // 산술평균
        System.out.println(Math.round((double) total / n));
        // 중앙값
        System.out.println(median);
        // 최빈값
        System.out.println(list.size() > 1 ? list.get(1) : list.get(0));
        // 최댓값과 최솟값 차이
        System.out.println(max - min);
    }
}
