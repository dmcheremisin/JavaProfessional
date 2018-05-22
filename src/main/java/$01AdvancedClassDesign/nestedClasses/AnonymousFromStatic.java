package $01AdvancedClassDesign.nestedClasses;

/**
 * Created by Dmitrii on 22.05.2018.
 */

import java.awt.*;
import java.awt.event.*;

class AnonymousFromStatic extends Frame {
    String s = "Message";

    public static void main(String args[]) {
        AnonymousFromStatic t = new AnonymousFromStatic();
        Button b = new Button("press me");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Message is " + s);
                // Error:(18, 52) java: non-static variable s cannot be referenced from a static context
                System.out.println("Message is " + t.s); // -> OK
            }
        });
        t.add(b);
    }
}