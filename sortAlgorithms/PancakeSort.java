package sortAlgorithms;

import java.util.Arrays;

public class PancakeSort {


    public static void main(String[] args) {

        int array[] = {12, 32, 43, -21, 100, 3};
        System.out.println(Arrays.toString(array));
        pancakeSort(array, array.length);
        System.out.println(Arrays.toString(array));

    }

    public static int findIndexOfMax(int[] array, int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    public static void flip(int[] array, int n) {
        int start = 0;
        while ((start < n)) {
            array[start] += array[n];
            array[n] = array[start] - array[n];
            array[start++] -= array[n--];
        }
    }

    public static void pancakeSort(int[] array, int n) {

        for (int current_size = n; current_size > 1; --current_size) {
            int max = findIndexOfMax(array, current_size);
            if (max != current_size - 1) {
                flip(array, max);
                System.out.println(Arrays.toString(array));
                flip(array, current_size - 1);
                System.out.println(Arrays.toString(array));
            }

        }
    }
}
