import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            persons[i] = new Person(age, name, i);
        }

        Arrays.sort(persons, (o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getIndex() - o2.getIndex();
            }

            return o1.getAge() - o2.getAge();
        });

        for (Person person : persons) {
            sb.append(person.getAge()).append(" ").append(person.getName()).append("\n");
        }

        System.out.println(sb);
    }

    static class Person {
        int age;
        String name;
        int index;

        public Person(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public int getIndex() {
            return index;
        }
    }
}
