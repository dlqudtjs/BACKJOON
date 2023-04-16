import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // * 2를 하지 않았을 경우 범위가 작아 +좌표에서 오는 경우를 구하지 못한다.
        // 따라서 * 2를 한 범위까지 한다. (+로 최대한 가봤자 * 2이기 때문)
        int[] distance = new int[(Math.max(n, k) * 2) + 1];
        distance[n] = 1;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int x = queue.poll();

            // x + 1 값이 범위이면서, 방문하지 않았다면
            if (x + 1 < distance.length && distance[x + 1] == 0) {
                distance[x + 1] = distance[x] + 1;
                queue.add(x + 1);
            }

            // x + -1 값이 범위이면서, 방문하지 않았다면
            if (x - 1 >= 0 && distance[x - 1] == 0) {
                distance[x - 1] = distance[x] + 1;
                queue.add(x - 1);
            }

            // x + -1 값이 범위이면서, 방문하지 않았다면
            if (x * 2 < distance.length && distance[x * 2] == 0) {
                distance[x * 2] = distance[x] + 1;
                queue.add(x * 2);
            }
        }

        System.out.println(distance[k] - 1);
    }
}