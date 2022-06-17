import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainWithoutThreads {
    public static void main(String[] args) {
        long start = System.nanoTime();
        Divisor result = new Divisor(0);
        for (int i = 1; i < 100000; i++) {
            try {
                Divisor divisor = new Divisor(i);
                Divisor temp = divisor.runfunc();
                if(temp.compareTo(result)>=0)
                    result=temp;
            }
            catch (Exception e){}


        }
        System.out.println(result);
        long end = System.nanoTime();
        System.out.println("Location: " + (end - start));
    }
}
