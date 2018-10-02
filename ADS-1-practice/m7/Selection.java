import java.util.*;
public class Selection {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if(compareTo(a[j], a[i]) < 0) {
                    exchange(a, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static int compareTo(int a, int b) {
        if(a == b) {
            return 0;
        } else if(a < b) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void exchange(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void main(String[] args) {
        int[] a = {5, 7, -1, -3, 0, 2, 1};
        sort(a);
    }
}
