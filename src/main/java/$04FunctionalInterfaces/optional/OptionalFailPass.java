package $04FunctionalInterfaces.optional;

import java.util.Optional;

/**
 * Created by Dmitrii on 10.06.2018.
 */
public class OptionalFailPass {
    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");
        }
        return grade;
    }

    public static void main(String[] args) {
        Optional<String> grade1 = getGrade(50);
        System.out.println(grade1); // Optional.empty
        Optional<String> grade2 = getGrade(55);
        System.out.println(grade2); // Optional[PASS]

        System.out.println(grade1.orElse("UNKNOWN")); // UNKNOWN

        if (grade2.isPresent()) {
            grade2.ifPresent(x -> System.out.println(x)); // PASS
        } else {
            System.out.println(grade2.orElse("Empty"));
        }
    }
}
