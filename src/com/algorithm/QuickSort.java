package com.algorithm;

import java.util.Arrays;

/**
 * Быстрая сортировка является самой эффективной сортировкой
 * В лучшем случае такая сортировка имеет линейную сложность — O(n log n)
 *
 * @see https://robotdreams.cc/blog/244-kakie-algoritmy-sortirovki-dolzhen-znat-junior-java-developer
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {7, 8, 9, 1, 2, 3, 0, 6, 5, 4};

        System.out.println(Arrays.toString(array));

        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);

        System.out.println(Arrays.toString(array));
    }

    static void quickSort(int[] array, int low, int high) {
        if (low >= high) return;
        int pivot = array[low + (high - low) / 2];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(array, low, j);
        if (high > i) quickSort(array, i, high);
    }
}
