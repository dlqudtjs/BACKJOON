import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈
        int k = Integer.parseInt(st.nextToken()); // 동생

        // 수빈이보다 동생이 뒤에 있다면 -1로 가는 방법밖에 없다.
        if (n >= k) {
            System.out.println(n - k);

            return;
        }

        // * 2를 하지 않았을 경우 범위가 작아 +좌표에서 오는 경우를 구하지 못한다.
        // 따라서 * 2를 한 범위까지 한다. (+로 최대한 가봤자 * 2이기 때문)
        int[] distance = new int[(Math.max(n, k) * 2) + 1];
        distance[n] = 1;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int x = queue.poll();

            int[] arr = new int[] { x + 1, x - 1, x * 2 };

            for (int i = 0; i < 3; i++) {
                if (arr[i] >= distance.length || arr[i] < 0 || distance[arr[i]] != 0) {
                    continue;
                }

                distance[arr[i]] = distance[x] + 1;
                queue.add(arr[i]);

                if (distance[k] != 0) {
                    break;
                }
            }
        }

        System.out.println(distance[k] - 1);
    }
}