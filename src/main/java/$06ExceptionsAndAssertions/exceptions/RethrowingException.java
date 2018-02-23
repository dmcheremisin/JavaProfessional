package $06ExceptionsAndAssertions.exceptions;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Dmitrii on 23.02.2018.
 */
public class RethrowingException {
    public static void parseData() throws IOException, SQLException, ParseException {
        throw new NullPointerException("Some exception");
    }
    public static void multiCatch() throws IOException, SQLException, ParseException {
        try {
            parseData();
        } catch (IOException | SQLException | ParseException e) {
            System.out.println("Multicatch block: " + e.getMessage());
            throw e;
        }
    }
    public static void rethrow() throws IOException, SQLException, ParseException {
        try {
            parseData();
        } catch (Exception e) {
            System.out.println("Rethrow block: " + e.getMessage());
            throw e;
        }
    }
    public static void main(String[] args) throws IOException, SQLException, ParseException {
        // it will handle NPE
        rethrow();
        // Rethrow block: Some exception
        //Exception in thread "main" java.lang.NullPointerException: Some exception
        //	at $06ExceptionsAndAssertions.exceptions.RethrowingException.parseData(RethrowingException.java:12)
        //	at $06ExceptionsAndAssertions.exceptions.RethrowingException.rethrow(RethrowingException.java:24)
        //	at $06ExceptionsAndAssertions.exceptions.RethrowingException.main(RethrowingException.java:31)

        // it will not handle NPE
        multiCatch();
        // Exception in thread "main" java.lang.NullPointerException: Some exception
        //	at $06ExceptionsAndAssertions.exceptions.RethrowingException.parseData(RethrowingException.java:12)
        //	at $06ExceptionsAndAssertions.exceptions.RethrowingException.multiCatch(RethrowingException.java:16)
        //	at $06ExceptionsAndAssertions.exceptions.RethrowingException.main(RethrowingException.java:32)
    }
}
