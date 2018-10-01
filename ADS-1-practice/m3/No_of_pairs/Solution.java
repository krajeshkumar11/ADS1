import java.util.Arrays;

public class Solution {

    public static void quadratic(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                    System.out.println(arr[i] + " " + count);
                }
            }
        }
        System.out.println("Final count: " + count);
    }

    public static void linearithmic(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int count = 0;
        int check = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                System.out.println("i: " + i);
                count++;
            } else {
                // if(i - check > 1) {
                //     for (int j = check; j < i; j++) {
                //         if(arr[j] == arr[i]) {
                //             System.out.println("j: " + j);
                //             count++;
                //         }
                //     }
                // }

                check = i + 1;
            }
        }
        System.out.println("Final Count: " + count);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 4, 4, 5, 6};
        // int[] arr = {1, 2, 2, 2, 2, 3};
        // quadratic(arr);
        linearithmic(arr);
    }
}
