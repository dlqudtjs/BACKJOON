import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> partys = new ArrayList<>();

        // parent 초기화
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            partys.add(new ArrayList<>());
        }

        // 진실을 아는 사람은 parent 0으로 설정
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++) {
            int x = Integer.parseInt(st.nextToken());
            parent[x] = 0;
        }

        // 파티 오는 사람들 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                int x = Integer.parseInt(st.nextToken());
                partys.get(i).add(x);
            }
        }

        // union 과정
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < partys.get(i).size() - 1; j++) {
                List<Integer> party = partys.get(i);
                union(party.get(j), party.get(j + 1));
            }
        }

        // 자신이 연결된 그룹이 다른 그룹과 만났을 수도 있기 때문에 갱신
        for (int i = 1; i <= n; i++) {
            parent[i] = find(i);
        }

        // parent가 0이 전혀 없는 그룹은 갈 수 있으므로 answer++;
        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = false;

            for (int j = 0; j < partys.get(i).size(); j++) {
                List<Integer> party = partys.get(i);

                if (parent[party.get(j)] == 0) {
                    flag = true;
                    break;
                }
            }

            answer = flag ? answer : ++answer;
        }

        System.out.println(answer);
    }

    private static boolean union(int person1, int person2) {
        int person1Parent = find(person1);
        int person2Parent = find(person2);

        if (person1Parent == person2Parent) {
            return false;
        }

        if (person1Parent > person2Parent) {
            parent[person1Parent] = person2Parent;
        } else {
            parent[person2Parent] = person1Parent;
        }

        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }
}
