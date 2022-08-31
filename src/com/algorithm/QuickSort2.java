package com.algorithm;

import java.util.Arrays;

/**
 * @see https://rukovodstvo.net/posts/id_798
 *
 * Quicksort - это еще один алгоритм «разделяй и властвуй».
 * Он выбирает один элемент массива в качестве точки поворота и сортирует все остальные элементы вокруг него.
 * Например: меньшие элементы слева и большие справа, это гарантирует, что ось будет на своем месте после процесса.
 * Затем алгоритм рекурсивно делает то же самое для левой и правой частей массива.
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] array = {7, 8, 9, 1, 2, 3, 0, 6, 5, 4};

        System.out.println(Arrays.toString(array));

        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);

        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }
}
