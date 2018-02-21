package $06ExceptionsAndAssertions.exceptions;

// checked exception:
class CannotSwimException extends Exception{
    public CannotSwimException() {
    }

    public CannotSwimException(String message) {
        super(message);
    }

    public CannotSwimException(Throwable cause) {
        super(cause);
    }
}

// unchecked exceptions:
class DangerInTheWater extends RuntimeException{}
class SharkInTheWater extends DangerInTheWater{
    public SharkInTheWater() {
    }
}

public class CreateCustom {
    public static void main(String[] args) throws CannotSwimException {
        // throw new CannotSwimException();
        // Exception in thread "main" $06ExceptionsAndAssertions.exceptions.CannotSwimException

        // throw new CannotSwimException(new RuntimeException());
        // Exception in thread "main" $06ExceptionsAndAssertions.exceptions.CannotSwimException: java.lang.RuntimeException
        //	at $06ExceptionsAndAssertions.exceptions.CreateCustom.main(CreateCustom.java:29)
        //Caused by: java.lang.RuntimeException
        //	... 1 more

        throw new CannotSwimException("broken fin");
        // Exception in thread "main" $06ExceptionsAndAssertions.exceptions.CannotSwimException: broken fin
        //	at $06ExceptionsAndAssertions.exceptions.CreateCustom.main(CreateCustom.java:35)
    }
}
