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
            System.out.println(1);

            return;
        }

        // * 2를 하지 않았을 경우 범위가 작아 +좌표에서 오는 경우를 구하지 못한다.
        // 따라서 * 2를 한 범위까지 한다. (+로 최대한 가봤자 * 2이기 때문)
        int[] distance = new int[(Math.max(n, k) * 2) + 1];
        distance[n] = 1;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);

        int cnt = 0;

        loop: while (!queue.isEmpty()) {
            int x = queue.poll();

            int[] arr = new int[] { x + 1, x - 1, x * 2 };

            for (int i = 0; i < 3; i++) {

                // 범위 밖일 때
                if (arr[i] >= distance.length || arr[i] < 0) {
                    continue;
                }

                // 이미 방문 했거나, 현재 자리에서 출발한 시간이 더 클 경우
                // distance[x] + 1 이 지금 가는 곳 distance[arr[i]] 보다 크면 갈 필요가 없다.
                if (distance[arr[i]] != 0 && distance[x] + 1 > distance[arr[i]]) {

                    // bfs의 특성상 자신보다 큰 경우가 올 때는 이미 앞에서 경우의 수를 다 구했음
                    // *최단 경로를 구하는 bfs이기 때문에 가능하다 ^_^
                    // 따라서 자신보다 큰 경우의 수가 온게 k라면 loop를 종료한다.
                    if (arr[i] == k) {
                        break loop;
                    }

                    continue;
                }

                // 중복처리(distance[arr[i] != 0)를 하지 않고 queue에 넣었기 때문에
                // arr[i]가 k라면 앞에서 여러 경우의 수로 왔기 때문에 k를 찾는 경우의 수를 ++해준다.
                if (arr[i] == k) {
                    cnt++;
                }

                distance[arr[i]] = distance[x] + 1;
                queue.add(arr[i]);
            }
        }

        System.out.println(distance[k] - 1);
        System.out.println(cnt);
    }
}