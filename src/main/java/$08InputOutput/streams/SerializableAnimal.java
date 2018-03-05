package $08InputOutput.streams;

import java.io.Serializable;

/**
 * Created by Dmitrii on 05.03.2018.
 */
public class SerializableAnimal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient int age;
    private String type;

    public SerializableAnimal(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "SerializableAnimal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }
}







