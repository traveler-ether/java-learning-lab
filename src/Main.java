import  java.util.HashSet;
import  java.util.Set;
public class Main {
    public static void main(String[] args) {
        Set<String> students = new HashSet<>();

        boolean s1 = students.add("001");
        boolean s2 = students.add("002");
        boolean s3 = students.add("003");
        System.out.println("当前已报名人数："+students.size());
        System.out.println("001是否已报名"+students.size());




    }
}

