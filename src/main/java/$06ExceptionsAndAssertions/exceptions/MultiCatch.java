package $06ExceptionsAndAssertions.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

/**
 * Created by Dmitrii on 21.02.2018.
 */

public class MultiCatch {
    private static void mightThrow() throws DateTimeParseException, IOException {}
    public static void main(String[] args) {
        try {
            mightThrow();
        }
        catch(DateTimeParseException | IllegalArgumentException e) {} // - both unchecked
        catch(FileNotFoundException | IllegalStateException e) {} // - checked and unchecked
        catch (IOException e) {} // - checked
        // catch(SQLException e) {} - it is checked exception and it is never thrown
        // catch(FileNotFoundException | IllegalStateException e) {} FileNotFound extends IOException, so it can't be lower
        catch (Exception e){}
    }
}
