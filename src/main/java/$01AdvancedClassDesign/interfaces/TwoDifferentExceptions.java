package $01AdvancedClassDesign.interfaces;

import java.io.*;
import java.sql.*;

/**
 * Created by Dmitrii on 22.05.2018.
 */

interface I1{
    void m1() throws IOException;
    void m2() throws IOException;
}
interface I2{
    void m1() throws SQLException;
    void m2() throws FileNotFoundException;// extends IOException
}

public class TwoDifferentExceptions implements I1, I2{
    public static void main(String args[])  throws Exception
    {
        TwoDifferentExceptions tc = new TwoDifferentExceptions();
        I1 i1 = (I1) tc; //This is valid.
        i1.m1();

        I2 i2 = (I2) tc; //This is valid too.
        i2.m1();
    }
    public void m1()
    {
        System.out.println("Hi there");
    }

    // we can not declare IOException here, or Exception
    // we can ommit exception or declare exception that is compatible with both methods of I1 and I2
    public void m2() throws FileNotFoundException {
        System.out.println("Hi there");
    }
}
