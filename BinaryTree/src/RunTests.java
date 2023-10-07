import extra.PerformanceTest;
import extra.Callback;

import java.util.Random;

public class RunTests {
    private static final long seed = 123456789;
    private static final int MAX = 999999;
    public static Random random;
    public static void main(String[] args) {

        BinaryTree BT = new BinaryTree();
        AVLTree AVL = new AVLTree();
        random = new Random(seed);

        System.out.println("\n\nMeasuring performance for:");
        System.out.println("[ Normal BinaryTree ]\n");
        System.out.println("Method: insert, Iterations: " + 100);
        new PerformanceTest().measure(()-> {insert(100, BT, random);});

        System.out.println("Method: insert, Iterations: " + 500);
        new PerformanceTest().measure(()-> {insert(500, BT, random);});

        System.out.println("Method: insert, Iterations: " + 1000);
        new PerformanceTest().measure(()-> {insert(1000, BT, random);});

        System.out.println("Method: insert, Iterations: " + 10000);
        new PerformanceTest().measure(()-> {insert(10000, BT, random);});

        System.out.println("Method: insert, Iterations: " + 20000);
        new PerformanceTest().measure(()-> {insert(20000, BT, random);});

        //DELETE TESTS
        System.out.println("Method: delete, Iterations: " + 100);
        new PerformanceTest().measure(()-> {remove(100, BT, random);});

        System.out.println("Method: delete, Iterations: " + 500);
        new PerformanceTest().measure(()-> {remove(500, BT, random);});

        System.out.println("Method: delete, Iterations: " + 1000);
        new PerformanceTest().measure(()-> {remove(1000, BT, random);});

        System.out.println("Method: delete, Iterations: " + 10000);
        new PerformanceTest().measure(()-> {remove(10000, BT, random);});

        System.out.println("Method: delete, Iterations: " + 20000);
        new PerformanceTest().measure(()-> {remove(20000, BT, random);});

        //SEARCH TESTS

        System.out.println("Method: search, Iterations: " + 100);
        new PerformanceTest().measure(()-> {remove(100, BT, random);});

        System.out.println("Method: search, Iterations: " + 500);
        new PerformanceTest().measure(()-> {remove(500, BT, random);});

        System.out.println("Method: search, Iterations: " + 1000);
        new PerformanceTest().measure(()-> {remove(1000, BT, random);});

        System.out.println("Method: search, Iterations: " + 10000);
        new PerformanceTest().measure(()-> {remove(10000, BT, random);});

        System.out.println("Method: search, Iterations: " + 20000);
        new PerformanceTest().measure(()-> {remove(20000, BT, random);});

        //AVL TESTS
        System.out.println("\n\nMeasuring performance for:");
        System.out.println("[ AVLTree ]\n");
        System.out.println("Method: insert, Iterations: " + 100);
        new PerformanceTest().measure(()-> {insert(100, AVL, random);});

        System.out.println("Method: insert, Iterations: " + 500);
        new PerformanceTest().measure(()-> {insert(500, AVL, random);});

        System.out.println("Method: insert, Iterations: " + 1000);
        new PerformanceTest().measure(()-> {insert(1000, AVL, random);});

        System.out.println("Method: insert, Iterations: " + 10000);
        new PerformanceTest().measure(()-> {insert(10000, AVL, random);});

        System.out.println("Method: insert, Iterations: " + 20000);
        new PerformanceTest().measure(()-> {insert(20000, AVL, random);});

        //AVL REMOVE TESTS
        System.out.println("Method: delete, Iterations: " + 100);
        new PerformanceTest().measure(()-> {remove(100, AVL, random);});

        System.out.println("Method: delete, Iterations: " + 500);
        new PerformanceTest().measure(()-> {remove(500, AVL, random);});

        System.out.println("Method: delete, Iterations: " + 1000);
        new PerformanceTest().measure(()-> {remove(1000, AVL, random);});

        System.out.println("Method: delete, Iterations: " + 10000);
        new PerformanceTest().measure(()-> {remove(10000, AVL, random);});

        System.out.println("Method: delete, Iterations: " + 20000);
        new PerformanceTest().measure(()-> {remove(20000, AVL, random);});

        //AVL SEARCH TESTS
        System.out.println("Method: search, Iterations: " + 100);
        new PerformanceTest().measure(()-> {remove(100, AVL, random);});

        System.out.println("Method: search, Iterations: " + 500);
        new PerformanceTest().measure(()-> {remove(500, AVL, random);});

        System.out.println("Method: search, Iterations: " + 1000);
        new PerformanceTest().measure(()-> {remove(1000, AVL, random);});

        System.out.println("Method: search, Iterations: " + 10000);
        new PerformanceTest().measure(()-> {remove(10000, AVL, random);});

        System.out.println("Method: search, Iterations: " + 20000);
        new PerformanceTest().measure(()-> {remove(20000, AVL, random);});
    }

    public static void insert(int size, BinaryTree BT, Random random) {
        for(int x = 0; x < size; x++) BT.insert(random.nextInt(MAX));
    }

    public static void insert(int size, AVLTree AVL, Random random) {
        for(int x = 0; x < size; x++) AVL.insert(random.nextInt(MAX));
    }

    public static void remove(int size, BinaryTree BT, Random random) {
        for(int x = 0; x < size; x++) BT.remove(random.nextInt(MAX));
    }

    public static void remove(int size, AVLTree AVL, Random random) {
        for(int x = 0; x < size; x++) AVL.remove(random.nextInt(MAX));
    }

    public static void search(int size, BinaryTree BT, Random random) {
        for(int x = 0; x < size; x++) BT.search(random.nextInt(MAX));
    }

    public static void search(int size, AVLTree AVL, Random random) {
        for(int x = 0; x < size; x++) AVL.search(random.nextInt(MAX));
    }
}
