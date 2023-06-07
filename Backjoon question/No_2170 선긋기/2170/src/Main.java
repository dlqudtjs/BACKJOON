import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Line> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            queue.add(new Line(start, end));
        }

        int x = -1_000_000_001;
        int y = -1_000_000_001;
        int result = 0;

        for (int i = 0; i < N; i++) {
            Line line = queue.poll();

            if (y >= line.start && y >= line.end) {
                continue;
            }

            if (y >= line.start && y < line.end) {
                y = line.end;
                continue;
            }

            result += y - x;
            x = line.start;
            y = line.end;
        }
        /*
         * x 기준으로 오름차순했기 때문에 x > start 경우는 존재하지 않음
         * 1. y >= start && y >= end = 갱신 x
         * 2. y >= start && y < end = y 갱신
         * 3. y < start = 기존 y - x 값 구하고, x, y 갱신
         */

        // 마지막에 남은 선(y - x)를 해줘야한다.
        System.out.println(result + (y - x));

    }

    static class Line implements Comparable<Line> {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o1) {
            if (this.start == o1.start) {
                return this.end - o1.end; // start가 같으면 end를 기준으로 정렬
            } else {
                return this.start - o1.start; // start를 기준으로 정렬
            }
        }
    }
}