import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;

        System.out.print(king - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(queen - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(rook - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(bishop - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(knight - Integer.parseInt(st.nextToken()) + " ");
        System.out.print(pawn - Integer.parseInt(st.nextToken()));
    }
}
