import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
        ExecutorService es = Executors.newFixedThreadPool(10);
        Divisor result = new Divisor(0);
        for (int i = 1; i < 100000; i++) {
            try {
                Divisor divisor = new Divisor(i);
                Future<Divisor> future = es.submit(divisor);
                if(future.get().compareTo(result)>=0)
                    result=future.get();
            }
            catch (Exception e){}
        }
        es.shutdown();
        System.out.println(result);
        long end = System.nanoTime();
        System.out.println("Location: " + (end - start));
    }
}
