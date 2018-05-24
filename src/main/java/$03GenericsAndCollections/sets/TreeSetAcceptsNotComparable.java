package $03GenericsAndCollections.sets;

import java.util.*;

/**
 * Created by Dmitrii on 24.05.2018.
 */

//class Person implements Comparable{
class Person {
    private static int count = 0;
    private String id = "0";
    private String interest;
    public Person(String interest) {
        this.interest = interest;
        this.id = "" + ++count;
    }
    public String getInterest() {
        return interest;
    }
    public void setInterest(String interest) {
        this.interest = interest;
    }
    public String toString() {
        return id;
    }
//    public int compareTo(Object p){
//        return this.id.compareTo(((Person) p).id);
//    }
}

public class TreeSetAcceptsNotComparable {
    String name = "MATH";
    TreeSet<Person> set = new TreeSet<Person>();
    public void add(Person p) {
        if (name.equals(p.getInterest())) set.add(p);
    }
    public static void main(String[] args) {
        TreeSetAcceptsNotComparable mathGroup = new TreeSetAcceptsNotComparable();
        mathGroup.add(new Person("MATH")); // java.lang.ClassCastException: $03GenericsAndCollections.sets.Person cannot be cast to java.lang.Comparable
        System.out.println("A");
        mathGroup.add(new Person("MATH"));
        System.out.println("B");
        System.out.println(mathGroup.set);
    }
}