package $06ExceptionsAndAssertions.exceptions;

/**
 * Created by Dmitrii on 22.02.2018.
 */
class Cage implements AutoCloseable {
    int num;
    public Cage(int num) {
        this.num = num;
    }
    public void close() throws Exception {
        System.out.println("Close: " + num);
        throw new Exception("Autocloseable exception from: " + num);
    }
}
public class SuppressedExceptions {
    public static void main(String[] args) {
        try (Cage cage1 = new Cage(1);
             Cage cage2 = new Cage(2)) {
            System.out.println("INSIDE TRY");
            throw new IllegalArgumentException("Exception form try");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppresed " + t.getMessage());
            }
            throw new IllegalStateException("Exception from catch");
        } finally {
            throw new RuntimeException("Exception from finally");
        }
        // INSIDE TRY
        //Exception in thread "main" java.lang.RuntimeException: Exception from finally
        //Close: 2
        //	at $06ExceptionsAndAssertions.exceptions.SuppressedExceptions.main(SuppressedExceptions.java:29)
        //Close: 1
        //Exception form try
        //Suppresed Autocloseable exception from: 2
        //Suppresed Autocloseable exception from: 1
    }
}
