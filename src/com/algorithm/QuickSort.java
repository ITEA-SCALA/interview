package com.algorithm;

import java.util.Arrays;

/**
 * Быстрая сортировка (Quick Sort) имеет алгоритмическую сложность — O(n log n)
 * Он выбирает один элемент массива в качестве точки поворота и сортирует все остальные элементы вокруг него.
 * Например: меньшие элементы слева и большие справа, это гарантирует, что ось будет на своем месте после процесса.
 * Затем алгоритм рекурсивно делает то же самое для левой и правой частей массива.
 *
 * @see https://javarush.ru/groups/posts/1997-algoritmih-sortirovki-v-teorii-i-na-praktike
 *
 * Этот алгоритм более сложный, чем простая сортировка, поэтому его лучше зарисовать: 4 2 6 7 3
 * а Pivot по центру, т.е. число '6'
 * под '4' напишем L
 * а под '3' напишем R
 * и двигаем указатель L:
 * '4' меньше чем '6', и '2' меньше чем '6', итого, L переместился на положение pivot (L = '6')
 *
 * Напишем снова 4 2 6 7 3
 * сейчас '6' это уже будет L
 * А теперь двигаем указатель R:
 * '3' меньше чем '6', поэтому ставим маркер R на цифру '3', так как '3' меньше чем (pivot) '6', тогда выполняем обмен
 * Запишем результат: 4 2 3 7 6
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Было\n" + Arrays.toString(array));

        int low = 0;
        int high = array.length - 1;

        quickSort(array, low, high);
        System.out.println("Стало\n" + Arrays.toString(array));
    }

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];

        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
}
