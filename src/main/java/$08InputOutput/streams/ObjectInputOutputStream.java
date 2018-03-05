package $08InputOutput.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 05.03.2018.
 */
public class ObjectInputOutputStream {
    private static String DIR = "src\\main\\resources\\";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<SerializableAnimal> animals = new ArrayList<>();
        animals.add(new SerializableAnimal("Tiger", 1, "T"));
        animals.add(new SerializableAnimal("Koala", 2, "K"));
        animals.add(new SerializableAnimal("Cat", 3, "C"));

        File file = new File(DIR + "animal.data");
        writeAnimals(file, animals);
        List<SerializableAnimal> newAnimals = readAnimals(file);
        newAnimals.forEach(System.out::println);
        // SerializableAnimal{name='Tiger', age=0, type='T'}
        // SerializableAnimal{name='Koala', age=0, type='K'}
        // SerializableAnimal{name='Cat', age=0, type='C'}
    }

    private static List<SerializableAnimal> readAnimals(File file) throws IOException, ClassNotFoundException {
        List<SerializableAnimal> animals = new ArrayList<>();
        try(ObjectInputStream is = new ObjectInputStream(
                                    new BufferedInputStream(new FileInputStream(file)))){
            while(true){
                Object obj = is.readObject();
                if(obj instanceof SerializableAnimal){
                    animals.add((SerializableAnimal) obj);
                }
            }
        } catch (EOFException e) {
            // file end reached
        }
        return animals;
    }

    private static void writeAnimals(File file, List<SerializableAnimal> animals) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                                        new BufferedOutputStream(new FileOutputStream(file)))){
            for(SerializableAnimal animal : animals){
                out.writeObject(animal);
            }
        }
    }

}
