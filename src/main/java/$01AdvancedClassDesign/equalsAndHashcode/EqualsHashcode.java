package $01AdvancedClassDesign.equalsAndHashcode;

/**
 * Created by Dmitrii on 10.01.2018.
 */

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // if ( !(o instanceof Person) ) return false;  <---- this statement will give true for
        // Student("One", 29) == Person("One", 29), because instaseof is true for
        // class inheritance
        if (o == null || getClass() != o.getClass()) return false; // this is right way

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}

class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }
}

public class EqualsHashcode {
    public static void main(String[] args) {
        Person one = new Person("One", 29);
        Person two = new Person("Two", 28);
        Person three = null;
        Student four = new Student("One", 29);
        System.out.println(one.equals(two));
        System.out.println(one.equals(three));
        System.out.println(one.equals(four));
    }
}
