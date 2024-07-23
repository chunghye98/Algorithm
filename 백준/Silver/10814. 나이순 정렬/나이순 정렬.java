import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            int age = Integer.parseInt(temp[0]);
            String name = temp[1];
            members.add(new Member(age, name, i));
        }

        Collections.sort(members);

        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.println(sb);
    }
}

class Member implements Comparable<Member> {
    int age;
    String name;
    int ordinal;

    Member(int age, String name, int ordinal) {
        this.age = age;
        this.name = name;
        this.ordinal = ordinal;
    }

    @Override
    public int compareTo(Member o) {
        if(this.age == o.age) {
            return Integer.compare(this.ordinal, o.ordinal);
        }
        return Integer.compare(this.age, o.age);
    }
}