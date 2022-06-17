import java.util.concurrent.Callable;

public class Divisor implements Callable<Divisor>, Comparable<Divisor> {
    private final int number;
    public int divisors;


    public Divisor(int number) {
        this.number = number;
        divisors=0;
    }

    public Divisor numberOfDivisors() {
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (number / i == i)
                    divisors++;
                else
                    divisors = divisors + 2;
            }
        }
        return this;
    }


    @Override
    public Divisor call() {
        return numberOfDivisors();
    }

    public Divisor runfunc() {
        return numberOfDivisors();
    }


    @Override
    public String toString() {
        return "Divisor{" +
                "number=" + number +
                ", divisors=" + divisors +
                '}';
    }

    @Override
    public int compareTo(Divisor o) {
        return this.divisors - o.divisors;
    }
}
