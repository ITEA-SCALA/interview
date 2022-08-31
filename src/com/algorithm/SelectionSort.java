package com.algorithm;

import java.util.Arrays;

/**
 * Сортировка выбором (Selection Sort) — работает шустрее по сравнению с пузырьковой и имеет квадратичную сложность — O(n^2)
 *
 * Делит массив на отсортированный и несортированный под-массив.
 * На каждой итерации мы предполагаем, что первый несортированный элемент является минимальным и перебираем остальные.
 * Каждый проход выбирать самый минимальный элемент и смещать его в начало.
 * При этом каждый новый проход начинать сдвигаясь вправо, то есть первый проход — с первого элемента, второй проход — со второго.
 * Данная сортировка неустойчива, т.к. одинаковые элементы могут изменить своё положение.
 *
 * @see https://robotdreams.cc/blog/244-kakie-algoritmy-sortirovki-dolzhen-znat-junior-java-developer
 *      https://rukovodstvo.net/posts/id_798
 *      https://javarush.ru/groups/posts/1997-algoritmih-sortirovki-v-teorii-i-na-praktike
 *    ( https://habr.com/ru/post/204968 )
 *    ( https://habr.com/ru/post/204600 )
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
