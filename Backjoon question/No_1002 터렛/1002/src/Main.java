import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(findPoint(x1, y1, r1, x2, y2, r2)).append("\n");
        }

        System.out.println(sb);
    }

    private static int findPoint(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance = (int) Math.pow(x2 - x1, 2) + (int) Math.pow(y2 - y1, 2);

        if (x2 == x1 && y2 == y1 && r2 == r1) {
            // 두 원이 같은 위치에서 반지름이 같을 때 (접점이 무한)
            return -1;
        } else if (distance > Math.pow(r2 + r1, 2)) {
            // 두 원의 반지름의 합 보다 두 원의 거리가 더 클때 (접점이 없음)
            return 0;
        } else if (distance < Math.pow(r2 - r1, 2)) {
            // 두 원의 거리보다 두 원의 반지름 차가 더 클때 (접점이 없음)
            return 0;
        } else if (distance == Math.pow(r2 - r1, 2)) {
            // 두 원의 거리와 두 원의 반지름 차가 같을 때 (접점이 하나)
            return 1;
        } else if (distance == Math.pow(r2 + r1, 2)) {
            // 두 원의 거리와 두 원의 반지름 합이 같을 때 (접점이 하나)
            return 1;
        } else {
            // 위에 조건들이 맞지 않으면 접점이 두 개다.
            return 2;
        }
    }
}
