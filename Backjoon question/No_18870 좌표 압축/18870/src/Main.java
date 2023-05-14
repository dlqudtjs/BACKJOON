import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = new int[N];

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        int rank = 0;
        for (int n : sortedArray) {
            if (!map.containsKey(n)) {
                map.put(n, rank);
                rank++;
            }
        }

        // arr의 값의 압축 순서 출력
        StringBuilder sb = new StringBuilder();
        for (int n : array) {
            sb.append(map.get(n)).append(" ");
        }

        System.out.println(sb);
    }
}

/*
 * 이분탐색 문제집에 있길래 풀었더니 시간초과가 난다.
 * 그냥 HashMap문제였던 걸로
 */