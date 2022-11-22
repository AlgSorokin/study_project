package sorting;

import java.util.Arrays;

/*Does sorting happen in place in Bubble sort?
Yes, Bubble sort performs the swapping of adjacent pairs without the use of any major data structure.
Hence, Bubble sort algorithm is an in-place algorithm.

Worst and Average Case Time Complexity: O(N^2). The worst case occurs when an array is reverse sorted.
Best Case Time Complexity: O(N). The best case occurs when an array is already sorted.
Auxiliary Space: O(1)

Where is the Bubble sort algorithm used?
Due to its simplicity, bubble sort is often used to introduce the concept of a sorting algorithm.
In computer graphics, it is popular for its capability to detect a tiny error (like a swap of just two elements)
in almost-sorted arrays and fix it with just linear complexity (2n).

Example: It is used in a polygon filling algorithm, where bounding lines are sorted by their x coordinate at a specific
scan line (a line parallel to the x-axis), and with incrementing y their order changes (two elements are swapped)
only at intersections of two lines (Source: Wikipedia)*/
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {24, 9, 87, 12, 32, 46, 11, 3, 99, 78, 64, 1};
        bubbleSortWithWhileLoop(array);
        System.out.println("---------------------------------------------");
        array = new int[] {24, 9, 87, 12, 32, 46, 11, 3, 99, 78, 64, 1};
        bubbleSortWithNestedLoop(array);
        System.out.println("---------------------------------------------");
        array = new int[] {24, 9, 87, 12, 32, 46, 11, 3, 99, 78, 64, 1};
        recursiveBubbleSort(array, array.length);
    }

    private static void bubbleSortWithWhileLoop(int[] array) {
        System.out.println(Arrays.toString(array));
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;
                }
                System.out.println(Arrays.toString(array));
            }
        }
    }

    private static void bubbleSortWithNestedLoop(int[] array) {
        System.out.println(Arrays.toString(array));
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
                System.out.println(Arrays.toString(array));

                if (!swapped) // IF no two elements were  // swapped by inner loop, then break
                    break;
            }
        }
    }

    private static void recursiveBubbleSort(int[] array, int n) {

        // base condition for recursion
        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
            }
        }
        System.out.println(Arrays.toString(array));
        recursiveBubbleSort(array, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
