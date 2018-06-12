package $07Concurrency.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RecursiveActionExample {
    static int N = 10000;
    static int NUM_THREADS = 10;
    static int seachKey = 500;
    static int[] arrayToSearch;

    static class SearchTask extends RecursiveAction {
        int from, to;

        public SearchTask(int from, int to) {
            this.from = from;
            this.to = to;
        }
        @Override
        protected void compute() {
            if (to - from < N / NUM_THREADS) {
                for(int i = from; i < to; i ++){
                    if(arrayToSearch[i] == seachKey) {
                        System.out.println("Found at index: " + i);
                    }
                }
            } else {
                int mid = (from + to) /2;
                System.out.printf("Forking computation into two ranges: %d to %d and %d to %d %n", from, mid, mid, to);
                invokeAll(new SearchTask(from, mid), new SearchTask(mid+1, to));
            }
        }
    }

    public static void main(String[] args) {
        arrayToSearch = new int[N];
        for(int i = 0; i < N; i++){
            arrayToSearch[i] = ThreadLocalRandom.current().nextInt(0, 1000);
        }

        ForkJoinPool fjPool = new ForkJoinPool(NUM_THREADS);
        fjPool.invoke(new SearchTask(0, N-1));
    }

    /*
    Forking computation into two ranges: 0 to 4999 and 4999 to 9999
    Forking computation into two ranges: 0 to 2499 and 2499 to 4999
    Forking computation into two ranges: 5000 to 7499 and 7499 to 9999
    Forking computation into two ranges: 2500 to 3749 and 3749 to 4999
    Forking computation into two ranges: 0 to 1249 and 1249 to 2499
    Forking computation into two ranges: 3750 to 4374 and 4374 to 4999
    Forking computation into two ranges: 2500 to 3124 and 3124 to 3749
    Forking computation into two ranges: 7500 to 8749 and 8749 to 9999
    Forking computation into two ranges: 5000 to 6249 and 6249 to 7499
    Forking computation into two ranges: 8750 to 9374 and 9374 to 9999
    Forking computation into two ranges: 7500 to 8124 and 8124 to 8749
    Found at index: 9693
    Found at index: 8275
    Found at index: 7610
    Found at index: 3154
    Forking computation into two ranges: 1250 to 1874 and 1874 to 2499
    Forking computation into two ranges: 0 to 624 and 624 to 1249
    Found at index: 3674
    Found at index: 9354
    Forking computation into two ranges: 6250 to 6874 and 6874 to 7499
    Forking computation into two ranges: 5000 to 5624 and 5624 to 6249
    Found at index: 6803
    Found at index: 5628
    Found at index: 5681
    Found at index: 6139
     */
}
