package $07Concurrency.exchanger;

import java.util.concurrent.Exchanger;

class Duke extends Thread {
    Exchanger<String> message;

    public Duke(Exchanger<String> message){
        this.message = message;
    }
    public void run(){
        String reply = null;
        try {
            reply = message.exchange("Knock knock!");
            System.out.println("CoffeeShop: " + reply);
            reply = message.exchange("Duke");
            System.out.println("CoffeeShop: " + reply);
            reply = message.exchange("The one who was born in this coffee shop!");
        } catch(InterruptedException ie) {
            System.err.println("Got interrupted during my silly talk");
        }
    }
}

class CoffeeShop extends Thread {
    Exchanger<String> message;

    public CoffeeShop(Exchanger<String> message){
        this.message = message;
    }
    public void run(){
        String reply = null;
        try {
            reply = message.exchange("Who's there?");
            System.out.println("Duke: " + reply);
            reply = message.exchange("Duke who?");
            System.out.println("Duke: " + reply);
            reply = message.exchange("");
            System.out.println("Duke: " + reply);
        } catch(InterruptedException ie) {
            System.err.println("Got interrupted during my silly talk");
        }
    }
}

public class SillyTalk {
    public static void main(String[] args) {
        Exchanger<String> message = new Exchanger<>();
        new Duke(message).start();
        new CoffeeShop(message).start();
    }
//    Duke: Knock knock!
//    CoffeeShop: Who's there?
//    CoffeeShop: Duke who?
//    Duke: Duke
//    Duke: The one who was born in this coffee shop!
}
