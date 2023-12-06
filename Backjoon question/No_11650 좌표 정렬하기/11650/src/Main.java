import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Point> points = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            points.add(new Point(a, b));
        }

        Collections.sort(points, new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getA() == o2.getA()) {
                    return o1.getB() - o2.getB();
                }

                return o1.getA() - o2.getA();
            }
        });

        for (Point point : points) {
            sb.append(point.getA()).append(" ").append(point.getB()).append("\n");
        }

        System.out.println(sb);
    }

    public static class Point {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
