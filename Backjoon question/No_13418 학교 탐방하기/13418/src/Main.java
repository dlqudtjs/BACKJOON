import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Node> ascQ = new PriorityQueue<>();
    static PriorityQueue<Node> descQ = new PriorityQueue<>(Collections.reverseOrder());

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weigth = Integer.parseInt(st.nextToken());

            weigth = weigth == 0 ? 1 : 0;

            ascQ.add(new Node(from, to, weigth));
            descQ.add(new Node(from, to, weigth));
        }

        int[] ascParent = new int[n + 1];
        int[] descParent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ascParent[i] = i;
            descParent[i] = i;
        }

        int size = ascQ.size();

        int maxWeigth = 0;
        int minWeigth = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < size; j++) {
                Node node = (i == 0) ? ascQ.poll() : descQ.poll();

                if (i == 0 && union(node.from, node.to, ascParent)) {
                    minWeigth += node.weigth;
                    continue;
                }

                if (i == 1 && union(node.from, node.to, descParent)) {
                    maxWeigth += node.weigth;
                }
            }
        }

        System.out.println((int) (Math.pow(maxWeigth, 2) - Math.pow(minWeigth, 2)));
    }

    private static boolean union(int from, int to, int[] parent) {
        int fromParent = find(from, parent);
        int toParent = find(to, parent);

        if (fromParent == toParent) {
            return false;
        }

        parent[toParent] = fromParent;

        return true;
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weigth;

        public Node(int from, int to, int weigth) {
            this.from = from;
            this.to = to;
            this.weigth = weigth;
        }

        @Override
        public int compareTo(Node o1) {
            return weigth - o1.weigth;
        }
    }
}
