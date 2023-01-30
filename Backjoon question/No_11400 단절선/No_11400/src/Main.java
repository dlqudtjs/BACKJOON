import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int V, E, visitNum;
    static int[] visitCnt; // 방문 순서
    static boolean[] isVisit; // 방문 여부
    static ArrayList<Integer>[] arr;
    static ArrayList<int[]> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new ArrayList[V + 1];
        isVisit = new boolean[V + 1];
        visitCnt = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        dfs(1, 0); // 조건이 항상 연결리스트기 때문에 방문 여부를 살필 이유가 없다.

        Collections.sort(ans, (a1, a2) -> (a1[0] == a2[0]) ? a1[1] - a2[1] : a1[0] - a2[0]);
        sb.append(ans.size()).append('\n');

        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)[0]).append(' ').append(ans.get(i)[1]).append('\n');
        }

        System.out.println(sb);
    }

    public static int dfs(int now, int parent) {
        isVisit[now] = true;
        visitCnt[now] = ++visitNum;
        int num = visitCnt[now]; // 현재 방문 순서로 초기화 (=visitNum)

        for (int next : arr[now]) {
            if (next == parent) {
                // 부모 정점은 발견 시간 갱신 대상이 아님. (부모 정점은 현재 노드가 부모 정점을 제외한
                // 가장 빠른 발견 시간과 비교함)
                continue;
            }

            if (!isVisit[next]) {
                // 자식이 자신을 제외하고 가장 빠른 발견 시간을 갱신한다. (제외는 위에 continue 조건을 해서 가능함)
                int low = dfs(next, now);

                // num을 갱신하는 이유는 자식 노드가 가장 빠른 발견시간을 갱신 할 수도 있기 때문이다.
                num = num < low ? num : low;

                // 자식 노드의 가장 빠른 발견시간과 자신의 발견시간(빠른 발견시간x)과 비교하여 자식의 빠른 발견시간이 더 늦다면 그 간선은 단절선이 된다.
                // (자식은 자신을 지나치지 않고는 더 빠른 곳을 갈 수 없기 때문이다.)
                // (now와 num이 비교해선 안 된다, num은 현재 정점이 갈 수 있는 가장 빠른 발견시간)
                if (visitCnt[now] < low) {
                    ans.add(new int[] { Math.min(now, next), Math.max(now, next) });
                }

            } else {
                // 이미 방문한 정점이라면 갈 수 있는 정점이기에 비교만 한다.
                num = num < visitCnt[next] ? num : visitCnt[next];
            }
        }

        // 부모 정점을 제외한 자신이 갈 수 있는 가장 빠른 발견시간을 리턴한다.
        return num;
    }
}
