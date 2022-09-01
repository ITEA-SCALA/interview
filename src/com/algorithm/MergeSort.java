package com.algorithm;

import java.util.Arrays;

/**
 * Cортировка слиянием (merge sort) — имеет более эффективный алгоритм и имеет логарифмическую сложность — O(n log n)
 *
 * Сортировка слиянием использует рекурсию для решения проблемы сортировки более эффективно, чем ранее представленные алгоритмы
 * Сортировать левую половину массива (рекурсивно)
 * Сортировать правую половину массива (рекурсивно)
 * Объедините решения
 *
 * @see https://robotdreams.cc/blog/244-kakie-algoritmy-sortirovki-dolzhen-znat-junior-java-developer
 *      https://rukovodstvo.net/posts/id_798
 *      https://javarush.ru/groups/posts/1997-algoritmih-sortirovki-v-teorii-i-na-praktike
 *    ( https://habr.com/ru/post/204968 )
 *    ( https://habr.com/ru/post/204600 )
 *
 * Приимущества:
 * 1. отсутствуют операции выполняемые в области <Heap памяти>
 *      а это значит что <GC не будет чаще срабатывать>
 * 2. разбить большой сортируемый список на маленькие подсписки, что позволит уменьшить общее количество проходов по списку согласно его размеру
 *     4*4 = 16  ||  (2*2) + (2*2) = 8
 * 3. такой способ использует специальный алгоритм проверки, в итоге, который уже уменьшает количество обращений к списку
 *      для работы с большими списками такая сортировка будет продуктивна, потому-что количество обращений к списку намного меньше

 * Недостатки:
 * 1.  больше используется выделенных ресурсов для выполнения сортировки
 * 2. но для работаты со связанным списокм такой механизм не подходит,
 *      потому-что он заставляет повторно перебирать элементы связанного списка до нужной позиции
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {7, 8, 9, 1, 2, 3, 0, 6, 5, 4};

        System.out.println(Arrays.toString(array));

//        mergeSort1(array, 0, array.length-1);
        mergeSort2(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    //TODO: https://javarush.ru/groups/posts/1997-algoritmih-sortirovki-v-teorii-i-na-praktike
    public static void mergeSort1(int[] source, int left, int right) {
        // Выберем разделитель, т.е. разделим пополам входной массив
        int delimiter = left + ((right - left) / 2) + 1;
        // Выполним рекурсивно данную функцию для двух половинок (если сможем разбить(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort1(source, left, delimiter - 1);
            mergeSort1(source, delimiter, right);
        }

        // Создаём временный массив с нужным размером
        int[] buffer = new int[right - left + 1];
        // Начиная от указанной левой границы идём по каждому элементу
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            // Мы используем delimeter чтобы указывать на элемент из правой части
            // Если delimeter > right, значит в правой части не осталось недобавленных элементов
            if (delimiter > right || source[cursor] > source[delimiter]) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }

    // https://rukovodstvo.net/posts/id_798
    public static void mergeSort2(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort2(array, left, mid);
        mergeSort2(array, mid+1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        // calculating lengths
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // creating temporary subarrays
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];

        // copying our sorted subarrays into temporaries
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // copying from leftArray and rightArray back into array
        for (int i = left; i < right + 1; i++) {
            // if there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // if all the elements have been copied from rightArray, copy the rest of leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // if all the elements have been copied from leftArray, copy the rest of rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
