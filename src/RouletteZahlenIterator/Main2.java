package RouletteZahlenIterator;

public class Main2 {
    public static void main(String[] args) {
        RouletteZahlenIterator rouletteZahlenIterator = new RouletteZahlenIterator();

        while(rouletteZahlenIterator.hasNext()){
            System.out.println(rouletteZahlenIterator.next());
        }
    }
}
