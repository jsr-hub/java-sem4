//print event and odd numbers till 100 with synchronized

public class NumberGenerator {

    public int MAX = 100;

    private volatile boolean evenNumberPrinted = true;

    public NumberGenerator(int max) {
        this.MAX = max;
    }

    public void printEvenNumber(int i) throws InterruptedException {
        synchronized (this) {
            if (evenNumberPrinted) {
                wait();
            }
            System.out.println("e = \t" + i);
            evenNumberPrinted = !evenNumberPrinted;
            notify();
        }
    }

    public void printOddNumber(int i) throws InterruptedException {
        synchronized (this) {
            if (!evenNumberPrinted) {
                wait();
            }
            System.out.println("o = \t" + i);
            evenNumberPrinted = !evenNumberPrinted;
            notify();
        }
    }



private static class EvenNumberGenerator implements Runnable {

    private NumberGenerator numberGenerator;

    public EvenNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void run() {
        for(int i = 2; i <= numberGenerator.MAX; i+=2)
            try {
                numberGenerator.printEvenNumber(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

private static class OddNumberGenerator implements Runnable {

    private NumberGenerator numberGenerator;

    public OddNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void run() {
        for(int i = 1; i <= numberGenerator.MAX; i+=2) {
            try {
                numberGenerator.printOddNumber(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public static void main(String[] args) {
    NumberGenerator numberGenerator = new NumberGenerator(100);
    EvenNumberGenerator evenNumberGenerator = new EvenNumberGenerator(numberGenerator);
    OddNumberGenerator oddNumberGenerator = new OddNumberGenerator(numberGenerator);
    new Thread(oddNumberGenerator).start();
    new Thread(evenNumberGenerator).start();

}
}