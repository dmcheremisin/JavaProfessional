package $08InputOutput.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 06.03.2018.
 */
class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient String name;
    private transient int age;
    private static char type = 'C';

    {this.age = 14;}

    public Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal["+"name='" + name + '\'' + ", age=" + age + ", type='" + type + '\'' + ']';
    }
}
public class SerializationObjectCreation {
    private static String DIR = "src\\main\\resources\\";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Tiger", 1, 'T'));
        animals.add(new Animal("Koala", 2, 'E'));

        File file = new File(DIR + "animal.data");
        writeAnimals(file, animals);
        List<Animal> newAnimals = readAnimals(file);
        newAnimals.forEach(System.out::println);
        // Animal[name='null', age=0, type='E']
        // Animal[name='null', age=0, type='E']
    }

    private static List<Animal> readAnimals(File file) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        try(ObjectInputStream is = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)))){
            while(true){
                Object obj = is.readObject();
                if(obj instanceof Animal){
                    animals.add((Animal) obj);
                }
            }
        } catch (EOFException e) {
            // file end reached
        }
        return animals;
    }

    private static void writeAnimals(File file, List<Animal> animals) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))){
            for(Animal animal : animals){
                out.writeObject(animal);
            }
        }
    }

}
