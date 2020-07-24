import setandmap.FileOp;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        FileOp.readFile("a-tale-of-two-cities.txt",words);
        System.out.println(words.size());
    }
}
