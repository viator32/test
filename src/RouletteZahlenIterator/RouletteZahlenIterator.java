package RouletteZahlenIterator;

import java.util.Iterator;
import java.util.Random;

public class RouletteZahlenIterator implements Iterator<Integer> {
    private int zeroCounter = 0;
    private Random random = new Random();
    @Override

    public boolean hasNext() {
        return zeroCounter < 3;
    }

    @Override
    public Integer next() {
        int next = random.nextInt(37);
       if(next==0){
           zeroCounter++;
       }
       return next;
    }
    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    };
}
