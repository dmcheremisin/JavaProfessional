package $07Concurrency.forkJoin;

/**
 * Created by Dmitrii on 12.06.2018.
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ComplicatedAction extends RecursiveAction {
    int[] ia;
    int from;
    int to;

    public ComplicatedAction(int[] ia, int from, int to) {
        this.ia = ia;
        this.from = from;
        this.to = to;
    }

    protected void compute() {
        if (from == to) {
            //Update the value using logic implemented somewhere else. 
            ia[from] = ++ia[from];
        } else {
            int mid = (from + to) / 2;
            ComplicatedAction newtask1 = new ComplicatedAction(ia, from, mid);
            ComplicatedAction newtask2 = new ComplicatedAction(ia, mid + 1, to);

            newtask2.fork();
            newtask1.compute();
            newtask2.join();
        }
    }

    public static void main(String[] args) {
        int ia[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        ForkJoinPool fjp = new ForkJoinPool();
        ComplicatedAction st = new ComplicatedAction(ia, 0, 6);
        fjp.invoke(st);
        System.out.print("New Array Values = ");
        for (int i : ia)
            System.out.print(i + " ");
        // New Array Values = 2 3 4 5 6 7 8
    }
}