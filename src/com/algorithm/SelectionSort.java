package com.algorithm;

import java.util.Arrays;

/**
 * Сортировка выбором является эффективнее за пузырьковую сортировку
 * Но такая сортировка считается неустойчивой
 * В худшем случае такая сортировка имеет квадратичную сложность — O(n^2)
 *
 * @see https://robotdreams.cc/blog/244-kakie-algoritmy-sortirovki-dolzhen-znat-junior-java-developer
 * ***
 * Итак, <сортировка выборкой> также имеет больше недостутков чем приимуществ.
 *
 * - это уже не совсем слепая сортировка, в ней уже <присутствует некий алгоритм>, который повышает ее еффективность,
 *      а именно, игнорируются крайние уже отсортированные элементы
 * - <чуть более сложный механизм ее реализации>
 * - а в остальном, такая сортировка выборкой похожа на пузырьковую сортировку, но работает чуть более эффективнее
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {7, 8, 9, 1, 2, 3, 0, 6, 5, 4};

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            int minVal = array[i];
            for (int j = i + 1; j < array.length; j++) {
                /*
                 * Здесь, за один проход, минимальный элемент сдвигается в крайнюю позицию
                 * и поэтому каждый следующий раз размер проверяемых элементов массива уменьшается
                 */
                if (array[j] < minVal) {
                    minVal = array[j];
                    array[j] = array[i];
                    array[i] = minVal;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
