package $03GenericsAndCollections.generics;

class Crate<T> {
    T content;
    // static T anotherContent; not allowed to use static with generics
    public void packCrate(T content) {
        // T[] a = new T[3]; arrays are not allowed with generics
        // new T(); not allowed with generics
        // if (T instance of String) {} instanceof not allowed with generics
        this.content = content;
    }
    public T emptyCrate() {
        T contentForExit = this.content;
        this.content = null;
        return contentForExit;
    }
}
class Animal{}
class Elephant extends Animal{}
class Zebra extends Animal{}

public class GenericClassOneParam {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Elephant elephant = new Elephant();
        Zebra zebra = new Zebra();

        Crate<Animal> animalCrate = new Crate<>();
        animalCrate.packCrate(animal);
        animalCrate.packCrate(elephant);
        animalCrate.packCrate(zebra);

        Animal animalFromCrate = animalCrate.emptyCrate();
        if (animalFromCrate instanceof Zebra) {
            System.out.println("Zebra returned");
        }

        Crate<Elephant> elephantCrate = new Crate<>();
        elephantCrate.packCrate(elephant);
        // elephantCrate.packCrate(zebra); compilation error
        // elephantCrate.packCrate(animal); compilation error

        // Crate<Animal> newCrate = new Crate<Zebra>(); compilation error
        // incompatible types

        // Crate has Object type = T
        Crate crate = new Crate();
        crate.packCrate(animal);
        crate.packCrate(elephant);
        Object o = crate.emptyCrate();
        crate.packCrate(new Object());
    }
}
