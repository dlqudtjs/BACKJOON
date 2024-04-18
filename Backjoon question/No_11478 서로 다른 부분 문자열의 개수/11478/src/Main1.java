import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();

		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.toArray();

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; (j + i) < str.length(); j++) {
				String subString = str.substring(j, (j + i) + 1);

				set.add(subString);
			}
		}

		System.out.println(set.size());
	}
}
