package $03GenericsAndCollections.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 18.01.2018.
 */
class Person {
    public String toString() {
        return this.getClass().getSimpleName() + "";
    }
}
class Student extends Person {}
class Professor extends Student {}

public class LowerBoundHierarchy {
    public static void main(String[] args) {
        // List<? super Student> students = new ArrayList<Professor>(); compilation error
        List<? super Student> students = new ArrayList<Person>();
        List<? super Student> studentsOther = new ArrayList<Student>(); // also OK

        students.add(new Student());
        // students.add(new Person()); is not allowed
        students.add(new Professor()); // is ALLOWED
        System.out.println(students);
        // [Student, Professor]

        List<? extends Student> list1 = new ArrayList<Professor>(){{
            add(new Professor());
            // add(new Student()); is not allowed
            // add(new Person()); is not allowed
        }};
        System.out.println(list1);
        // [Professor]

        List<? super Student> list2 = new ArrayList<Person>(){{
            add(new Professor());
            add(new Student());
            add(new Person());
        }};
        System.out.println(list2);
        // [Professor, Student, Person]

        List<? super Student> list3 = new ArrayList<Student>(){{
            add(new Professor());
            add(new Student());
            // add(new Person()); error
        }};
        System.out.println(list3);
        // [Professor, Student]
    }
}
