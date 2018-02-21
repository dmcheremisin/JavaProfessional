package $06ExceptionsAndAssertions.exceptions;

/**
 * Created by Dmitrii on 21.02.2018.
 */
class TurkeyCage implements AutoCloseable {
    public void close(){
        System.out.println("Close cage");
    }
}
class AnotherCage implements AutoCloseable{
    public void close() throws Exception {
        throw new IllegalStateException("Cage is not closed!");
    }
}
public class AutoCloseableExample {
    public static void main(String[] args) {
        try(TurkeyCage cage = new TurkeyCage()){ }
        // Close cage

        try(AnotherCage cage = new AnotherCage()){
        } catch (Exception e) { // catch close should be added in order to handle Exception
            System.out.println(e.getMessage());
        }
        // Cage is not closed!

    }
}
