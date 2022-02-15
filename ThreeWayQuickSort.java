import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeWayQuickSort {


    private static <Key extends Comparable<Key>> void sort(Key[] a, int lo, int hi) {

        // 3 way partitioning
        // base case
        if (hi <= lo) {
            return;
        }
        Key v = a[lo]; //partitioning element
        int lt = lo;
        int gt = hi;
        int i = lo;

        while (i <= gt) {

            int cmp = a[i].compareTo(v);

            // a[i] is less than v
            if (cmp < 0) {

                exch(a, lt++, i++);

                // a[i] is greater than v
            } else if (cmp > 0) {

                exch(a, gt--, i);
            } else {
                i++;
            }
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);


    }

    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }


    // sort helper functions
    private static <Key extends Comparable<Key>> boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Comparable[] arr1 = {2, 4, 7, 5, 6, 4, 3};


        sort(arr1);


        for (int i = 0; i < arr1.length; i++) {
            StdOut.print(arr1[i] + " ");

        }
    }

}
