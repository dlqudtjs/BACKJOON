import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V, E, visitNum; // visitNum : 방문 순서
    static ArrayList<Integer>[] arr; // 정점 간선 연결
    static int[] visitCnt; // 정점의 방문 순서
    static boolean[] isVisit; // 정점 방문 여부
    static boolean[] isCut; // 단결점 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new ArrayList[V + 1];
        isVisit = new boolean[V + 1];
        isCut = new boolean[V + 1];
        visitCnt = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            arr[i] = new ArrayList<>(); // 장점의 수 만큼 ArrayList 배열 생성
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= V; i++) {
            if (!isVisit[i]) {
                dfs(i, true); // 첫 시작점은 root
            }
        }

        StringBuilder sb = new StringBuilder();
        int cutCnt = 0;

        for (int i = 1; i <= V; i++) {
            if (isCut[i]) {
                cutCnt++; // 단절점 개수
            }
        }

        sb.append(cutCnt).append('\n');

        for (int i = 1; i <= V; i++) {
            if (isCut[i]) {
                cutCnt++;
                sb.append(i).append(" "); // 단절점 정점
            }
        }

        System.out.println(sb);
    }

    public static int dfs(int now, boolean isRoot) {
        isVisit[now] = true; // 방문 여부 체크
        visitCnt[now] = ++visitNum; // 방문 순서 체크

        // num은 갈 수 있는 노드 중에 가장 발견 시간이 빠른 노드를 저장한 후 리턴한다.
        // (가장 빠른 발견시간을 통해 우회로의 여부를 확인한다.)
        // 빠른 발견시간을 찾기 위해 초기값은 현재 자신의 발견 시간으로 한다.
        int num = visitNum;
        int child = 0; // root의 단절점을 확인하기 위해 자식 수를 저장(2 이상일 시 단절점)

        for (int next : arr[now]) { // now정점과 연결되어 있는 간선을 꺼내어 반복한다.
            if (!isVisit[next]) {
                child++;

                // 자식 노드의 num 값 즉, 자식 노드가 갈 수 있는 가장 낮은 번호를 찾는다.
                int nextNum = dfs(next, false);

                // 현재 노드의 빠른 발견 시간과 자식의 빠른 발견시간을 비교하여 더 빠른 발견시간으로 바꾼다.
                // (자식이 갈 수 있으면 자신도 갈 수 있기 때문)
                num = num > nextNum ? nextNum : num;

                // root는 자식이 두 개 이상이어야 단절점이 될 수 있다. 아래 조건문은 하나여도 충족될 수 있다.
                // 자식 정점이 갈 수 있는 가장 빠른시간(nextNum)이 자신의(now) 발견시간과 같거나 더욱 크다면
                // 자식 정점은 자신을 통하지 않고 더욱 빠른 시간을 갈 수 없기 때문에 현재 정점이 단절점이 된다.
                if (!isRoot && visitCnt[now] <= nextNum) {
                    isCut[now] = true;
                }

            } else {
                // 더 작은 수가 num
                num = num > visitCnt[next] ? visitCnt[next] : num;
            }
        }

        if (isRoot && child >= 2) { // root는 자식이 두 개 이상이면 단절점이 된다.
            isCut[now] = true;
        }

        //
        return num;
    }
}

/*
 * 간단하게 정리
 * 현재 정점이 단절점인지 검사하기 위해 자신과 연결되어 있는 노드에 접근하여(dfs)
 * 그 노드가 갈 수 있는 가장 빠른 발견시간과 자신의 발견시간(빠른 발견시간 x)을 비교하여
 * 노드가 현재 노드의 발견 시간보다 더 빠른 곳을 갈 수 있다면 현재 노드는 단절점이 아니다.
 * (89번 줄 if문에서 <= 이 아니라 == 로 하여도 상관 없을 거 같음. 만약 자신이 단절점이라면
 * 인접한 노드가(자신이 없다면 우회로가 없는 노드일 경우) dfs를 수행하고 가장 빠른 발견시간은 자신이 될테니까.)
 */
