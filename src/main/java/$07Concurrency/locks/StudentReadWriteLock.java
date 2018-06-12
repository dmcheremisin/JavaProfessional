package $07Concurrency.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Dmitrii on 12.06.2018.
 */
public class StudentReadWriteLock {
    private Map<String, Integer> marksObtained = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public void setMarksInSubject(String subject, Integer marks){
        lock.writeLock().lock(); //1
        try{
            marksObtained.put(subject, marks);
        }finally{
            lock.writeLock().unlock(); //2
        }
    }
    public double getAverageMarks(){
        lock.readLock().lock(); //3
        double sum = 0.0;
        try{
            for(Integer mark : marksObtained.values()){
                sum = sum + mark;
            }
            return sum/marksObtained.size();
        }finally{
            lock.readLock().unlock();//4
        }
    }
    public static void main(String[] args) {

        final StudentReadWriteLock s = new StudentReadWriteLock();

        //create one thread that keeps adding marks
        new Thread(() -> {
            int x = 0;
            while(x++ < 10){
                int m = (int)(Math.random()*100);
                s.setMarksInSubject("Sub "+x, m);
            }
        }).start();

        //create 5 threads that get average marks
        for(int i=0; i<3; i++){
            new Thread(() -> {
                int x = 0;
                while(++x < 10){
                    double av = s.getAverageMarks();
                    System.out.println(av);
                }
            }).start();
        }
        //NaN
        //NaN
        //NaN
        //NaN
        //NaN
        //NaN
        //NaN
        //NaN
        //NaN
        //NaN
        //NaN
        //NaN
        //27.0
        //40.5
        //40.5
        //27.0
        //40.5
        //40.5
        //40.5
        //40.5
        //40.5
        //27.0
        //40.5
        //40.5
        //40.5
        //40.5
        //40.5
    }
}
