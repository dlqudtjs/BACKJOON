import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()); // 총 층수
        int S = Integer.parseInt(st.nextToken()); // 강호가 현재 있는 위치
        int G = Integer.parseInt(st.nextToken()); // 도착 층수
        int U = Integer.parseInt(st.nextToken()); // U층 올라가는 버튼
        int D = Integer.parseInt(st.nextToken()); // D층 내려가는 버튼

        int[] elevator = new int[(F * 2) + 1];
        elevator[S] = 1;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(S);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int[] arr = new int[] { current + U, current - D };

            for (int i = 0; i < 2; i++) {
                if (arr[i] <= 0 || arr[i] > F || elevator[arr[i]] != 0) {
                    continue;
                }

                elevator[arr[i]] = elevator[current] + 1;
                queue.add(arr[i]);
            }

            if (elevator[G] != 0) {
                break;
            }
        }

        System.out.println(elevator[G] != 0 ? elevator[G] - 1 : "use the stairs");
    }
}
