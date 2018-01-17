package $03GenericsAndCollections.generics;

class Pair<T, U> {
    T first;
    U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

class Box<T> {
    T content;
    Box(T content) {
        this.content = content;
    }
}

class SizeBox<T, U> extends Box<T> {
    U size;

    SizeBox(T content, U size) {
        super(content);
        this.size = size;
    }
}

public class GenericClassTwoParams {
    public static void main(String[] args) {
        Pair<Integer, String> worldCup = new Pair<>(2018, "Russia");

        SizeBox<String, Integer> crate = new SizeBox<>("Elephant", 20);
        System.out.println(crate.content);
        System.out.println(crate.size);
    }
}
