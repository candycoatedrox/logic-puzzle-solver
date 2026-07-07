

public class UtilsTest {

    public static void testArraysAreEqual() {
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        int[] c = {1,2,3,4};
        int[] d = {1,0,3};

        System.out.println();
        System.out.println("--- NOW TESTING: 1D arraysAreEqual ---");

        System.out.println(Utils.arrayToString(a) + " = " + Utils.arrayToString(b) + ": " + (Utils.arraysAreEqual(a, b)));
        System.out.println(Utils.arrayToString(a) + " = " + Utils.arrayToString(c) + ": " + (Utils.arraysAreEqual(a, c)));
        System.out.println(Utils.arrayToString(a) + " = " + Utils.arrayToString(d) + ": " + (Utils.arraysAreEqual(a, d)));
    }

    public static void test2DArraysAreEqual() {
        int[][] a = {{1,2},{3,4}};
        int[][] b = {{1,2},{3,4}};
        int[][] c = {{3,4},{1,2}};
        int[][] d = {{1,2},{3,4},{5,6}};
        int[][] e = {{1,2},{3,4,5}};
        int[][] f = {{1,2},{0,4}};

        System.out.println();
        System.out.println("--- NOW TESTING: 2D arraysAreEqual ---");

        System.out.println(Utils.arrayToString(a) + " = " + Utils.arrayToString(b) + ": " + (Utils.arraysAreEqual(a, b)));
        System.out.println(Utils.arrayToString(a) + " = " + Utils.arrayToString(c) + ": " + (Utils.arraysAreEqual(a, c)));
        System.out.println(Utils.arrayToString(a) + " = " + Utils.arrayToString(d) + ": " + (Utils.arraysAreEqual(a, d)));
        System.out.println(Utils.arrayToString(a) + " = " + Utils.arrayToString(e) + ": " + (Utils.arraysAreEqual(a, e)));
        System.out.println(Utils.arrayToString(a) + " = " + Utils.arrayToString(f) + ": " + (Utils.arraysAreEqual(a, f)));
    }

    public static void testNumWithCommasInt() {
        int a = 300;
        int b = 3000;
        int c = 300000;
        int d = 3000000;
        int e = -300;
        int f = -3000;

        System.out.println();
        System.out.println("--- NOW TESTING: int numWithCommas ---");

        System.out.println(a + " -> " + Utils.numWithCommas(a));
        System.out.println(b + " -> " + Utils.numWithCommas(b));
        System.out.println(c + " -> " + Utils.numWithCommas(c));
        System.out.println(d + " -> " + Utils.numWithCommas(d));
        System.out.println(e + " -> " + Utils.numWithCommas(e));
        System.out.println(f + " -> " + Utils.numWithCommas(f));
    }

    public static void testNumWithCommasDouble() {
        double a = 300.05;
        double b = 3000.05;
        double c = 300000.00005;
        double d = 3000000.0005;
        double e = -300.005;
        double f = -3000.005;

        System.out.println();
        System.out.println("--- NOW TESTING: double numWithCommas ---");

        System.out.println(a + " -> " + Utils.numWithCommas(a));
        System.out.println(b + " -> " + Utils.numWithCommas(b));
        System.out.println(c + " -> " + Utils.numWithCommas(c));
        System.out.println(d + " -> " + Utils.numWithCommas(d));
        System.out.println(e + " -> " + Utils.numWithCommas(e));
        System.out.println(f + " -> " + Utils.numWithCommas(f));
    }

    public static void testToSentenceCase() {
        String a = "hello world";
        String b = "test. test.  test! test? test!! test.test";
        String c = "-hello there. how are you?";

        System.out.println();
        System.out.println("--- NOW TESTING: toSentenceCase ---");
        
        System.out.println(a + " -> " + Utils.toSentenceCase(a));
        System.out.println(b + " -> " + Utils.toSentenceCase(b));
        System.out.println(c + " -> " + Utils.toSentenceCase(c));
    }
    
    public static void main(String[] args) {
        testArraysAreEqual();
        test2DArraysAreEqual();
        testNumWithCommasInt();
        testNumWithCommasDouble();
        testToSentenceCase();
    }

}
