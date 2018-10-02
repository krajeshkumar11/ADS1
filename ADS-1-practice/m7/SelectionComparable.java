import java.util.*;
public class SelectionComparable {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo(a[i]) < 0) {
                    exchange(a, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void exchange(Comparable[] a, int index1, int index2) {
        Comparable temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void main(String[] args) {
        Comparable[] a = {5, 7, -1, -3, 0, 2, 1};
        sort(a);
    }
}
