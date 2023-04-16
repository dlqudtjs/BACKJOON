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

                // 범위 밖일 때
                if (arr[i] >= distance.length || arr[i] < 0) {
                    continue;
                }

                if (i == 2) {
                    if (distance[arr[i]] != 0 && distance[x] >= distance[arr[i]]) {
                        continue;
                    }

                    distance[arr[i]] = distance[x];
                    queue.add(arr[i]);
                } else {
                    if (distance[arr[i]] != 0 && distance[x] + 1 >= distance[arr[i]]) {
                        continue;
                    }

                    distance[arr[i]] = distance[x] + 1;
                    queue.add(arr[i]);
                }

            }
        }

        System.out.println(distance[k] - 1);
    }
}